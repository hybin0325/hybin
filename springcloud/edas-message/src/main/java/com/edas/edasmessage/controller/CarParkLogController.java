package com.edas.edasmessage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.edas.edasmessage.entity.CarParkLog;
import com.edas.edasmessage.entity.User;
import com.edas.edasmessage.entity.dto.CarParkLogDTO;
import com.edas.edasmessage.entity.req.CarParkReq;
import com.edas.edasmessage.service.CarParkLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 车辆记录
 * 
 * @author nl
 *
 */
@Slf4j
@RestController
@RequestMapping("/msg/carpark")
@Api(value = "车辆记录")
public class CarParkLogController {

	@Autowired
	private CarParkLogService carParkLogService;

	@ApiOperation(value = "车辆入场记录", notes = "车辆入场记录")
	@ApiImplicitParam(name = "carPark", value = "车辆入场记录实体carPark", required = true, dataType = "CarParkReq")
	@PostMapping(value = "/addCarInPark")
	public Object addCarInPark(@RequestBody CarParkReq req) throws Exception {
		SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIdWorkerInstance();
		log.info("CarParkReq: "+req);
		carParkLogService.saveCarParkLos(req.getData(),idWorker);
		return RetResponse.makeOKRsp();
	}

	@ApiOperation(value = "车辆出场记录", notes = "车辆出场记录")
	@ApiImplicitParam(name = "carPark", value = "车辆出场记录实体carPark", required = true, dataType = "CarParkReq")
	@PostMapping(value = "/addCarOutPark")
	public Object addCarOutPark(@RequestBody CarParkReq req) throws Exception {
		SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIdWorkerInstance();
		carParkLogService.saveCarParkLos(req.getData(),idWorker);
		return RetResponse.makeOKRsp();
	}

	

	@ApiOperation(value = "车辆入场记录查询", notes = "车辆入场记录查询")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "分页数", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNo", value = "当前页", required = false, dataType = "Integer") })
	@PostMapping(value = "/list")
	public RetResult<PageInfo<CarParkLog>> list(
			@RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo) throws Exception {
		PageHelper.startPage(pageNo, pageSize);

		List<CarParkLog> list = carParkLogService.selectAll();
		PageInfo<CarParkLog> pageInfo = new PageInfo<CarParkLog>(list);
		return RetResponse.makeOKRsp(pageInfo);
	}
	
	@ApiOperation(value = "车辆入场记录分页查询", notes = "车辆入场记录分页查询")
	@ApiImplicitParam(name = "dto", value = "分页实体dto", dataType = "CarParkLogDTO")
	@PostMapping(value = "/findByPage")
	public RetResult<Object> findByPage(@RequestBody CarParkLogDTO dto) throws Exception {
        List<CarParkLog> list=carParkLogService.findCarParkLog(dto);
		PageInfo<CarParkLog> pageInfo =new PageInfo<CarParkLog>(list);
	    Map<String,Object> map=Maps.newHashMap();
	    map.put("list", pageInfo.getList());
	    map.put("total", pageInfo.getTotal());
		return RetResponse.makeOKRsp(map);
	}

	@ApiOperation(value = "远程调用", notes = "远程调用")
	@PostMapping(value = "/getUser")
	public RetResult<User> getUserInfo() {
		return RetResponse.makeOKRsp(carParkLogService.getUserInfo());
	}

}
