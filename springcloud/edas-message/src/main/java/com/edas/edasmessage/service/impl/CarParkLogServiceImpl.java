package com.edas.edasmessage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.edascommon.constants.Constants;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.model.CarParkMsg;
import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.model.MqMessage;
import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edasmessage.cache.annotation.RedisLock;
import com.edas.edasmessage.constant.SnowFlake;
import com.edas.edasmessage.dao.CarParkLogMapper;
import com.edas.edasmessage.entity.BrokerMessageLog;
import com.edas.edasmessage.entity.CarParkLog;
import com.edas.edasmessage.entity.MessageConf;
import com.edas.edasmessage.entity.User;
import com.edas.edasmessage.entity.dto.CarInParkDTO;
import com.edas.edasmessage.entity.dto.CarOutParkDTO;
import com.edas.edasmessage.entity.dto.CarParkLogDTO;
import com.edas.edasmessage.feign.UserFeign;
import com.edas.edasmessage.rabbitmq.sender.MQCarParkSender;
import com.edas.edasmessage.redis.BloomFilter;
import com.edas.edasmessage.service.BrokerMessageLogService;
import com.edas.edasmessage.service.CarParkLogService;
import com.edas.edasmessage.service.MessageConfService;
import com.edas.edasmessage.utils.JsonListUtil;
import com.edas.edasmessage.utils.StringUtils;
import com.github.pagehelper.PageHelper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * 车辆记录日志
 * 
 * @author nl
 *
 */
@Slf4j
@Service
public class CarParkLogServiceImpl extends AbstractServices<CarParkLog> implements CarParkLogService {

	@Autowired
	private CarParkLogMapper carParkLogMapper;

	@Autowired
	private UserFeign userFeign;

	@Autowired
	private BrokerMessageLogService brokerMessageLogService;

	@Autowired
	private MessageConfService messageConfService;

	@Autowired
	private MQCarParkSender carParkSender;

	@Autowired
	private BloomFilter<CarParkLog> bloomFilter;

	/**
	 * 远程调用用户
	 * 
	 * @return
	 */
	public User getUserInfo() {
		User user = userFeign.getUserInfo().getData();
		log.info("user: " + user);
		CarInParkDTO dto = new CarInParkDTO();
		dto.setPlateNum("粤A2255555" + new Date().getTime());
		return user;
	}

	/**
	 * 业务数据加入队列
	 * 
	 * @param msg
	 * @throws Exception
	 */
	@Transactional
	public void saveDataMsg(MQDataMsg message) throws Exception {
		String type = message.getType();
		// if(org.apache.commons.lang3.StringUtils.isEmpty(type)) {
		String exchange = Constants.NL_DATA_MSG_FANOUT;
		String routingKey = "";
		saveBaseDataMsg(exchange, routingKey, message);
//		}else if(type.equals("wechat")){
//			String exchange=Constants.NL_CAR_PARK_DATA_MSG_TOPIC;
//			String routingKey=Constants.NL_CAR_PARK_DATA_WECHAT_MSG_RONTINGKEY;
//			saveBaseDataMsg(exchange,routingKey,message);
//		}else if(type.equals("s")){
//			String exchange=Constants.NL_CAR_PARK_DATA_MSG_TOPIC;
//			String routingKey=Constants.NL_CAR_PARK_DATA_DINGTALK_MSG_RONTINGKEY;
//			saveBaseDataMsg(exchange,routingKey,message);
//		}
	}

	/**
	 * 业务数据加入队列
	 */
	@SneakyThrows
	@Async
	private void saveBaseDataMsg(String exchange, String routingKey, MQDataMsg message) {
		SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIdWorkerInstance();
		Long messageId = idWorker.nextId();
		String msg = com.edas.edasmessage.utils.StringUtils.beanToString(message);

		// 入库
		BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
		brokerMessageLog.setMessageId(messageId);
		brokerMessageLog.setMessage(msg);
		brokerMessageLog.setExchange(exchange);
		brokerMessageLog.setRoutingKey(routingKey);
		brokerMessageLogService.save(brokerMessageLog);

		// 入队列
		MqMessage mqMsg = new MqMessage();
		mqMsg.setMessageId(messageId + "");
		mqMsg.setMessage(msg);
		carParkSender.sendDataMsg(exchange, routingKey, mqMsg);
	}

	/**
	 * 车进场、出场消息推送 去重保存DB、发送到队列
	 */
	// @RedisLock(lockPrefix = "carParkLog", lockKey = "save")
	public void saveCarParkLos(List<CarParkLog> list, SnowflakeIdWorker idWorker) {
		if (list != null && list.size() > 0) {
			for (CarParkLog carParkLog : list) {
				log.info(" carParkLog :---------------------" + carParkLog.toString());
				boolean isExist = bloomFilter.contains(carParkLog);
				if (isExist) {
					log.info(isExist + " bloomFilter有值---------------------");
				} else {
					saveDataMessage(carParkLog, idWorker, null);
				}
			}
		}
	}

	public void saveCarParkLos(List<CarParkLog> list, String commKey) {
		SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIdWorkerInstance();
		if (list != null && list.size() > 0) {
			for (CarParkLog carParkLog : list) {
				log.info(" carParkLog :---------------------" + carParkLog);
				boolean isExist = bloomFilter.contains(carParkLog);
				if (isExist) {
					log.info(isExist + " bloomFilter有值---------------------");
				} else {
					saveDataMessage(carParkLog, idWorker, commKey);
				}
			}
		}
	}

	public void saveCarParkLos(List<CarParkLog> list, String commKey, SnowflakeIdWorker idWorker) {
		if (list != null && list.size() > 0) {
			for (CarParkLog carParkLog : list) {
				log.info(" carParkLog :---------------------" + carParkLog);
				boolean isExist = bloomFilter.contains(carParkLog);
				if (isExist) {
					log.info(isExist + " bloomFilter有值---------------------");
				} else {
					saveDataMessage(carParkLog, idWorker, commKey);
				}
			}
		}
	}

	@Async
	public void saveDataMessage(CarParkLog carParkLog, SnowflakeIdWorker idWorker, String commKey) {
		log.info("commKey: "+commKey);
		bloomFilter.add(carParkLog);
		sendDataMsgLog(carParkLog, idWorker);
		carParkLog.setCreateDate(new Date());
		carParkLog.setId(idWorker.nextId());
		if (org.apache.commons.lang3.StringUtils.isNotBlank(commKey)) {
			MessageConf mc = messageConfService.findByCommKey(commKey);
			carParkLog.setDld(mc.getDld());
			carParkLog.setClique(mc.getClique());
		}
		carParkLogMapper.insert(carParkLog);
		log.info("线程 [ " + Thread.currentThread().getName() + " ] 推送消息到MQ成功! " + new Date());
	}

	/**
	 * 发送数据到队列数据封装
	 * 
	 * @param carParkLog
	 */
	@SneakyThrows
	//@RedisLock(lockPrefix = "sendDataMsgLog", lockKey = "save")
	private void sendDataMsgLog(CarParkLog carParkLog, SnowflakeIdWorker idWorker) {
		final long msgId = idWorker.nextId();
		String msg = StringUtils.beanToString(carParkLog);
		// 交换机
		String exchange = Constants.NL_CAR_PARK_MSG_TOPIC;
		// 路由
		String routingKey = Constants.NL_CAR_PARK_MSG_RONTINGKEY;

		BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
		brokerMessageLog.setMessageId(msgId);
		brokerMessageLog.setMessage(msg);
		brokerMessageLog.setExchange(exchange);
		brokerMessageLog.setRoutingKey(routingKey);
		brokerMessageLogService.save(brokerMessageLog);

		MqMessage mqMsg = new MqMessage();
		mqMsg.setMessageId(msgId + "");
		mqMsg.setMessage(msg);
		// 入队列
		log.info("+++++++++++++++++入队列+++++++++++++++++++");
		carParkSender.sendDataMsg(exchange, routingKey, mqMsg);
	}

	/**
	 * 查询分页
	 */
	@Override
	public List<CarParkLog> findCarParkLog(CarParkLogDTO dto) {
		PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
		List<CarParkLog> list = carParkLogMapper.findCarParkLog(dto);
		return list;
	}

}
