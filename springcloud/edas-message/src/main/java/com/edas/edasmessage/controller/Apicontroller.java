package com.edas.edasmessage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.model.Result;
import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.edas.edasmessage.entity.MessageConf;
import com.edas.edasmessage.entity.req.CarParkReq;
import com.edas.edasmessage.enums.KeyTypeEnum;
import com.edas.edasmessage.service.CarParkLogService;
import com.edas.edasmessage.service.DeliyunService;
import com.edas.edasmessage.service.MessageConfService;
import com.edas.edasmessage.utils.CarParkUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
//@Api(value = "/api",tags = "token开放接口")
public class Apicontroller {

	@Autowired
	private CarParkLogService carParkLogService;

	@Autowired
	private DeliyunService deliyunService;

	@Autowired
	private MessageConfService messageConfService;

	@ApiOperation(value = "业务数据发送队列", notes = "业务数据发送队列")
	@ApiImplicitParam(name = "message", value = "消息体message", dataType = "MQDataMsg")
	@PostMapping(value = "/senderMsg")
	public RetResult<String> senderDataMsg(@RequestBody MQDataMsg message) throws Exception {
		log.info("业务数据发送队列消息-----------------：" + message);
		// String msg = com.edas.edasmessage.utils.StringUtils.beanToString(message);
		// carParkLogService.saveDataMsg(msg);
		carParkLogService.saveDataMsg(message);
		return RetResponse.makeOKRsp("OK");
	}

	@ApiOperation(value = "车辆入场记录", notes = "车辆入场记录")
	@ApiImplicitParam(name = "carPark", value = "车辆入场记录实体carPark", required = true, dataType = "CarParkReq")
	@PostMapping(value = "/addCarInPark")
	public Object addCarInPark(@RequestBody CarParkReq req) throws Exception {
		log.info("CarParkReq: " + req);
		SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIdWorkerInstance();
		carParkLogService.saveCarParkLos(req.getData(), idWorker);
		return RetResponse.makeOKRsp();
	}

	/**
	 * 车辆出场定时器
	 */
	@ApiOperation(value = "车辆出场定时器", notes = "车辆出场定时器")
	@PostMapping(value = "/carParkOutLogs")
	public Result getCarParkOutLogs() {
		log.info("----------------调用车辆出场 ----------------");
		List<MessageConf> list = messageConfService.findByType(KeyTypeEnum.DLD.getIndex());
		SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIdWorkerInstance();
		log.info("list:" + list.size() + "  " + list);
		for (MessageConf messageConf : list) {
			log.info("messageConf:  " + messageConf);
			deliyunService.findParkOutLog(CarParkUtils.getCarOutParkDataReq(), messageConf.getCommKey(), idWorker);
		}
		return Result.success();
	}

	/**
	 * 车辆进场 每天8点到21点 每1秒定时取数据
	 */
	@ApiOperation(value = "车辆进场定时器", notes = "车辆进场定时器")
	@PostMapping(value = "/carParkInLogs")
	public Result getCarParkInLogs() {
		log.info("---------------- 调用车辆进场 ----------------");
		List<MessageConf> list = messageConfService.findByType(KeyTypeEnum.DLD.getIndex());
		log.info("list:" + list.size() + "  " + list);
		if (list != null && list.size() > 0) {
			for (MessageConf messageConf : list) {
				deliyunService.findParkInLog(CarParkUtils.getCarInParkDataReq(), messageConf.getCommKey());
			}
		}
		return Result.success();
	}

}
