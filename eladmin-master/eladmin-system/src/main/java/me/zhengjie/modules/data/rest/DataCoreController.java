package me.zhengjie.modules.data.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.data.domain.DataCore;
import me.zhengjie.modules.data.service.DataCoreService;
import me.zhengjie.modules.data.service.dto.DataCoreQueryCriteria;

@Api(tags = "数据管理")
@RestController
@RequestMapping("/api/data")
public class DataCoreController {

	@Autowired
	private DataCoreService dataCoreService;

	@Log("新增数据")
	@ApiOperation(value = "新增数据")
	@PostMapping
	@PreAuthorize("@el.check('app:add')")
	public ResponseEntity<Object> create(@Validated @RequestBody DataCore resources) {
		return new ResponseEntity<>(dataCoreService.save(resources), HttpStatus.CREATED);
	}

	@Log("查询数据")
	@ApiOperation(value = "查询数据")
	@GetMapping
	@PreAuthorize("@el.check('app:list')")
	public ResponseEntity<Object> getApps(DataCoreQueryCriteria criteria, Pageable pageable) {
		return new ResponseEntity<>(dataCoreService.queryAll(criteria), HttpStatus.OK);
	}
	
	@Log("查询数据")
	@ApiOperation(value = "查询数据")
	@GetMapping("/findByName")
	@PreAuthorize("@el.check('app:list')")
	public ResponseEntity<Object> findByName(DataCoreQueryCriteria criteria, Pageable pageable) {
		return new ResponseEntity<>(dataCoreService.queryByName(criteria), HttpStatus.OK);
	}
	
	@Log("查询数据")
	@ApiOperation(value = "查询数据")
	@GetMapping("/page")
	@PreAuthorize("@el.check('app:list')")
	public ResponseEntity<Object> findByPage(DataCoreQueryCriteria criteria, int pageNo, int pageSize ) {
		return new ResponseEntity<>(dataCoreService.queryByPage(criteria,pageNo,pageSize), HttpStatus.OK);
	}

}
