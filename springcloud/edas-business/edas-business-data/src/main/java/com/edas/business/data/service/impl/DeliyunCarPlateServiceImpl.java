package com.edas.business.data.service.impl;

import javax.annotation.Resource;

import com.edas.business.data.dao.master.ShopwwiZtMesstempMapper;
import com.edas.business.data.dao.master.ZtCarParkCliqueMapMapper;
import com.edas.business.data.entity.*;
import com.edas.business.data.service.*;
import com.edas.edascommon.utils.StringTemplateUtils;
import org.joda.time.Hours;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.edas.business.data.feign.MessageFeign;
import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 德立云门禁接口
 */
@Slf4j
@Service
public class DeliyunCarPlateServiceImpl implements DeliyunCarPlateService {

	@Resource
	ShopwwiZtCarcusService shopwwiZtCarcusService;
	@Resource
	ShopwwiZtMesstempService shopwwiZtMesstempService;
	@Resource
	ShopwwiCxxmService shopwwiCxxmService;

	@Resource
	private MessageFeign messageFeign;
	@Resource
	ShopwwiZtMesstempMapper shopwwiZtMesstempMapper;
	@Resource
	ZtCarParkCliqueMapService ztCarParkCliqueMapService;

//	@Async
	public void sendMsg(String msg) {
		log.info("进来 原始消息内容" + msg);
		DeliyunCarPlate car = com.edas.edascommon.utils.StringUtils.stringToBean(msg, DeliyunCarPlate.class);

		// 这是获取模板id
		// Integer messtempId = 1;
		try {
			String dld ="GS";
			String frame = "";
			String license = car.getPlateNum();


			// 这是获取 选中的  内容
			ShopwwiZtCarcus shopwwiZtCarcus = shopwwiZtCarcusService.getDataByLicense(license);

			String collid = car.getControlId();

//			ZtCarParkCliqueMap ztCarParkCliqueMap = ztCarParkCliqueMapService.findZtCarparkCliqueMap(collid);
//			dld = ztCarParkCliqueMap.getDld();
//

			if(shopwwiZtCarcus==null){
				log.info("进来 车牌号初始化对象失败：" + car.getPlateNum());
				return ;
			}

			String nrong1 = shopwwiZtCarcus.getLicenseData();

			Date jichaTime = car.getInTime();
			String DateFomat="MM-dd hh:mm" ;
			DateFormat format1 = new SimpleDateFormat(DateFomat);
            String snts = format1.format(jichaTime);
            //进场时间


//			List<ShopwwiZtMesstemp> shopwwiZtMesstemps=	shopwwiZtMesstempMapper.findByStatus();

			List<ShopwwiCxxm> shopwwiCxxms = shopwwiCxxmService.getDataByTbname("shopwwi_zt_carcus");

			// 把内容转为对象
			LicenseData licenseData = com.edas.edascommon.utils.StringUtils.stringToBean(nrong1, LicenseData.class);
			String collids = ","+collid+",";
			List<ZtCarParkCliqueMap> ztCarParkCliqueMaps = ztCarParkCliqueMapService.findZtCarparkCliqueMapAll(collids);

			List<CarcusInfo> listCar = licenseData.getCarcusInfo();

			MQDataMsg dataMsg = new MQDataMsg();
			for(ZtCarParkCliqueMap ztCarParkCliqueMap:ztCarParkCliqueMaps){
				dld = ztCarParkCliqueMap.getDld();
				log.info("这里是进厂获取到的dld" + dld);
			List<ShopwwiZtMesstemp> shopwwiZtMesstemps=	shopwwiZtMesstempMapper.findByStatusAndDld(dld);
			for (ShopwwiZtMesstemp shopwwiZtMesstemp:shopwwiZtMesstemps) {
				log.info("消息模板里的dld"+dld);
				log.info("这里是消息模板里"+shopwwiZtMesstemp);
				String yaoThdd = shopwwiZtMesstemp.getMessCon();
				//先替换系统时间
				String yxt= "{系统时间}";
				yaoThdd = yaoThdd.replace(yxt,snts);
				for(ShopwwiCxxm shopwwiCxxm:shopwwiCxxms){
					String yingwen = "{" + shopwwiCxxm.getEnname() + "}";
					String zhongwen = "{" + shopwwiCxxm.getChname() + "}";
					yaoThdd = yaoThdd.replace(zhongwen, yingwen);

				};

				log.info("这是替换后的模板"+yaoThdd);
				String fsdldsj = "";
				// json 转成对象
				// 把英文替换成 内容

					for (CarcusInfo info : listCar) {
						String isFs = "false";
						CarcusInfo ninfo = new CarcusInfo();
						Class carsclass = info.getClass();

						Field[] field = carsclass.getDeclaredFields();

						for (int i = 0; i < field.length; i++) {
							Field f = field[i];
							int size = field.length;// 属性个数
							f.setAccessible(true); // 设置些属性是可以访问的

							String type = f.getType().toString();// 得到此属性的类型
							String key = f.getName();// key:得到属性名
							Object value = null;// 得到此属性的值
							value = f.get(info);
							f.set(ninfo,value);
							String fint_dam = "yyyy-MM-dd";
						for(ShopwwiCxxm shopwwiCxxm:shopwwiCxxms) {
							if(shopwwiCxxm.getColtype().equals("date") && key.equals(shopwwiCxxm.getEnname())){
								if(value == null){


								}else {

									fint_dam = shopwwiCxxm.getDateformat();
									if (fint_dam == null) {
										fint_dam = "yyyy-MM-dd";
									} else if (fint_dam.trim().length() == 0) {
										fint_dam = "yyyy-MM-dd";
									};

//						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									DateFormat sdf = new SimpleDateFormat(fint_dam);
									Date clsj = parseDate(value);
									String sntsn = sdf.format(clsj);
									f.set(ninfo,sntsn);
								}
//						Date stf = sdf.parse(value.toString());
//								log.info("时间"+stf);
//						format1 = new SimpleDateFormat(fint_dam);
//					   String fi_time  = format1.format(stf);
//								f.set(info,fi_time);


//								String string = info.getFinal_time();
							}
//							String string = info.getFinal_time();
//							log.info("最后进场时间" + string);
//						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//						Date stf = sdf.parse(string);
//						//date 转字符串输出
//					;
//					   format1 = new SimpleDateFormat(fint_dam);
//					   String fi_time  = format1.format(stf);
//							info.setFinal_time(string);
						}


						}

					log.info("最终的info "+ninfo);
						frame = ninfo.getFrame();
						license = ninfo.getLicense();

						fsdldsj = StringTemplateUtils.processTemplate(yaoThdd, ninfo);
						//这里是把英文替换
						log.info("这里是把英文替换成中文"+fsdldsj);
						if(ninfo.getDld().equals(dld)){
							isFs = "true";
						}
						if(shopwwiZtMesstemp.getTemName().equals("五年车提醒") && ninfo.getIsFiveYearCar().equals("0")){
							isFs = "false";
						}else if(shopwwiZtMesstemp.getTemName().equals("公务车提醒") && ninfo.getIsOfficialCar().equals("0")){
							isFs = "false";
						}else if(shopwwiZtMesstemp.getTemName().equals("年审年检提醒") && ninfo.getIsAnnual().equals("0")){
							isFs = "false";
						}else if(shopwwiZtMesstemp.getTemName().equals("保险提醒") && ninfo.getIsRenlimit().equals("0")){
							isFs = "false";
						}
						log.info("这是发送消息模板的license"+license);
						log.info("这是发送消息模板的dld"+dld);
						log.info("这是发送消息模板的frame"+frame);
						log.info("要发送的模板"+fsdldsj);
						log.info("判断是否可以发送消息模板"+isFs);

						if(isFs.equals("true")){
							dataMsg.setMessage(fsdldsj);
							dataMsg.setDld(dld);
							dataMsg.setFrame(frame);
							dataMsg.setTemType(shopwwiZtMesstemp.getTemType());
							dataMsg.setTemName(shopwwiZtMesstemp.getTemName());
							dataMsg.setLicense(license);
							dataMsg.setMesstempId(shopwwiZtMesstemp.getId());
							dataMsg.setMesstempType(shopwwiZtMesstemp.getChanTemp());
							dataMsg.setMesstempTypeMessage(shopwwiZtMesstemp.getTypeMessage());
							dataMsg.setTiaozhuanUrl(shopwwiZtMesstemp.getTiaozhuanUrl());
							log.info("处理完成" + fsdldsj);
							log.info("这是消息类型" + shopwwiZtMesstemp.getTemName());
							log.info("处理完成 dataMsg" + dataMsg);
							messageFeign.senderMsg(dataMsg);
						}

					}






			}
			}

		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}

	/**
	 * 解析对象到日期
	 * @param o
	 * @return
	 * @author lsg
	 * @created 2018-11-27 下午4:08:10
	 */
	public static Date parseDate(Object o) {
		log.info("这里是时间obj"+o);
		if (o == null) {
			return null;
		}
		if (o instanceof Date) {
			return (Date) o;
		}
		if (o instanceof java.sql.Date) {
			return (Date) o;
		}
		log.info("这里是时间obj"+o);
		if (o instanceof String) {
			// yyyy-MM-dd HH:mm:ss  /
			String d=(String) o;
			log.info("这是时间"+d);
			StringBuilder format=new StringBuilder("yyyy");
			if (d.charAt(4)=='-') {
				format.append("-MM-dd");
			}else if(d.charAt(4)=='/') {
				format.append("/MM/dd");
			}else if (d.charAt(4)=='_'){
				format.append("_MM_dd");
			}else {
				format.append("MMdd");
			}
			if (d.length()<format.length()) {
				return null;
			}else if (d.length()==format.length()) {
				return parseDate(d, format.toString());
			}
			if (d.charAt(format.length())==' ') {
				format.append(' ');
			}
			if (d.charAt(format.length()+2)==':') {
				format.append("HH:mm:ss");
			}else if (d.charAt(format.length()+2)=='/') {
				format.append("HH/mm/ss");
			}else {
				format.append("HHmmss");
			}
			if (d.length()<format.length()) {
				return null;
			}
			if (d.length()==format.length()) {
				return parseDate(d,format.toString());
			}
			if (d.charAt(format.length())=='.'&&d.length()==(format.length()+4)) {
				format.append(".SSS");
			}else if(d.length()==(format.length()+3)){
				format.append("SSS");
			}else {
				d=d.substring(0, format.length());
			}
			return parseDate(d, format.toString());
		}
		if (o instanceof Long) {
			long l=(long) o;
			if (l<10000000000l) {
				return new Date(l*1000);
			}
			return new Date(l);
		}
		if (o instanceof Integer) {
			long l=(int)o*1000;
			return new Date(l);
		}
		return null;
	}
	/**
	 * 解析字符串日期,不报错  异常返回null
	 * @param d
	 * @param format
	 * @return
	 * @author lsg
	 * @created 2018-11-27 下午4:30:35
	 */
	public static Date parseDate(String d,String format) {
		try {
			return new SimpleDateFormat(format).parse(d);
		} catch (ParseException e) {
			return null;
		}
	}

}
