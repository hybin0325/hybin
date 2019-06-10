package com.edas.business.tripartite.controller.robot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.tripartite.entity.robot.Robot;
import com.edas.business.tripartite.service.robot.RobotService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Description: 话术controller
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "robot-apis", description = "话术-apis")
@RestController
@RequestMapping("robot")
public class RobotController {
	
	@Autowired
    private RobotService robotService;
	
	/**
     * 
     * @Description: 根据公司id查询话术
     *
     * @param companyId
     * @return RetResult
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@ApiOperation(value = "根据公司id查询话术", notes = "根据公司id查询话术")
	@ApiImplicitParam(name = "companyId", value = "公司id", required = true, dataType = "Integer")
    @GetMapping(value = "/get")
    public RetResult<Object> get(@RequestParam(value="companyId", required = true) int companyId) throws Exception {  
        return RetResponse.makeOKRsp(robotService.findByCompanyId(companyId));
    }
	
	/**
     * 
     * @Description 查询
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年5月6日
     * @author zzw
     */
	@ApiOperation(value = "获取话术列表", notes = "获取话术列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "page",  required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "size", value = "size",  required = true, dataType = "Integer")
	})
    @GetMapping(value = "/list")
    public RetResult<Object> list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {
		PageHelper.startPage(page, size);
		List<Robot> list = robotService.selectAll();
		PageInfo<Robot> pageInfo = new PageInfo<Robot>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
	
	/**
     * 
     * @Description: 添加
     *
     * @param robot
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "添加话术", notes = "添加话术")	
	@ApiImplicitParam(name = "robot", value = "实体robot", dataType = "Robot")
	@PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody Robot robot) throws Exception {  		
		robotService.saveRobot(robot);
        return RetResponse.makeOKRsp();
    }
	
	/**
     * 
     * @Description: 删除
     *
     * @param id
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "删除话术", notes = "删除话术")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		robotService.deleteRobot(id);
		return RetResponse.makeOKRsp();
	}
	
	/**
     * 
     * @Description: 更新
     *
     * @param robot
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "更新话术", notes = "更新话术")
	@ApiImplicitParam(name = "robot", value = "实体robot", dataType = "Robot")
	@PostMapping(value = "/update")
	public RetResult<Object> update(@RequestBody Robot robot){
		robotService.updateRobot(robot); 
		return RetResponse.makeOKRsp();
	}
	
}