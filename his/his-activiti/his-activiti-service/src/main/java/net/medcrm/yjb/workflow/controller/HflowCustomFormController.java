package net.medcrm.yjb.workflow.controller;

import io.swagger.annotations.*;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.AccessTokenLocal;
import net.medcrm.yjb.workflow.controller.vo.ImportVO;
import net.medcrm.yjb.workflow.controller.vo.SortIds;
import net.medcrm.yjb.workflow.domain.HflowCustomRealTemplate;
import net.medcrm.yjb.workflow.domain.HflowCustomTable;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import net.medcrm.yjb.workflow.dto.BindFlowFromDto;
import net.medcrm.yjb.workflow.dto.HflowCustomTemplateVO;
import net.medcrm.yjb.workflow.service.HflowCustomRealTemplateService;
import net.medcrm.yjb.workflow.service.HflowCustomTableService;
import net.medcrm.yjb.workflow.service.HflowCustomTemplateService;
import net.medcrm.yjb.workflow.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 自定义表单
 * Created by linsheng on 2017/12/26.
 */

@RestController
@RequestMapping(value = "/custom/form")
public class HflowCustomFormController {

    @Autowired
    private HflowCustomTableService flowCustomTableService;

    @Autowired
    private HflowCustomTemplateService hflowCustomTemplateService;

    @Autowired
    private HflowCustomRealTemplateService customRealTemplateService;
    /**
     * 查询自定义表单数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询自定义表单数据", notes = "分页查询表单数据", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "所属类型", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "第几条", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "状态，默认为空可以不传，0为未发布状态 1为已发布状态", required = false, dataType = "Integer")
    })
    @GetMapping(value = "/list")
    public BaseResp<Object> findCustomForm(String type,String name,@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                           @RequestParam(name = "pageSize", defaultValue = "25") Integer pageSize, @RequestParam(value = "status", defaultValue = "")Integer status){
        return new BaseResp<>(hflowCustomTemplateService.select(type,name,pageNum,pageSize,status));
    }


    @ApiOperation(value = "添加或修改自定义表单", notes = "添加或修改自定义表单", httpMethod = "POST")
    @ApiImplicitParam(name = "HflowCustomTemplate", value = "HflowCustomTemplate", required = true, dataType = "HflowCustomTemplate")
    @PostMapping(value = "/saveOrUpdate")
    public BaseResp<HflowCustomTemplate> saveOrUpdate(@RequestBody  HflowCustomTemplate hflowCustomTemplate){

        return new BaseResp<>(hflowCustomTemplateService.saveOrUpdate(hflowCustomTemplate));
    }
    @ApiOperation(value = "复制自定义表单", notes = "复制", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "type", required = false, dataType = "String")
    })
    @PostMapping(value = "/copy")
    public BaseResp<HflowCustomTemplate> copy(@RequestParam("id")String id,String type){
        return hflowCustomTemplateService.copy(id,type);
    }

    @ApiOperation(value = "根据Id查找自定义表单模板", notes = "根据Id查找自定义表单模板", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "id")
    @GetMapping(value = "/getById")
    public BaseResp<HflowCustomTemplate> getById(@RequestParam("id") String id){

        return new BaseResp<>(hflowCustomTemplateService.selectByPrimaryKey(id));
    }

   /* @ApiOperation(value = "启用或停用自定义表单", notes = "启用或停用自定义表单", httpMethod = "POST")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "id")
    @PostMapping(value = "/startOrStop")
    public BaseResp<Object> startOrStop(@RequestParam("id") String id){
        return hflowCustomTemplateService.startOrStop(id);
    }*/

    @ApiOperation(value = "流程绑定表单", notes = "流程绑定表单", httpMethod = "POST")
    @ApiImplicitParam(name = "BindFlowFromDto", value = "flowFromDto", required = true, dataType = "BindFlowFromDto")
    @PostMapping(value = "/bind")
    public BaseResp<Object> bind(@RequestBody BindFlowFromDto flowFromDto){

        return hflowCustomTemplateService.bind(flowFromDto);
    }


    @ApiOperation(value = "根据流程表单名称校验", notes = "根据流程表单名称校验", httpMethod = "GET")
    @ApiImplicitParam(name = "name", value = "表单名称", required = true, dataType = "String")
    @GetMapping(value = "/validate")
    public BaseResp<Boolean> validate(@RequestParam String name){
        return new BaseResp<Boolean>(hflowCustomTemplateService.selectByName(name));
    }

    @ApiOperation(value = "查询历史表单数据", notes = "查询历史表单数据", httpMethod = "GET")
    @ApiImplicitParam(name = "pid", value = "表单pid", required = true, dataType = "String")
    @GetMapping(value = "/history")
    public BaseResp<List<HflowCustomTemplateVO>> findCustomForm(@RequestParam(name = "pid") String pid){
        return new BaseResp<>(hflowCustomTemplateService.selectByPid(pid));
    }
    @ApiOperation(value = "向上向下排序", notes = "向上向下排序", httpMethod = "POST")
    @ApiImplicitParam(name = "SortIds", value = "SortIds", required = true, dataType = "SortIds")
    @PostMapping(value = "/updateSort")
    public BaseResp updateSort(@RequestBody SortIds ids){
        return hflowCustomTemplateService.updateSort(ids.getUpId(),ids.getDownId());
    }

    @ApiOperation(value = "表单发布", notes = "表单发布", httpMethod = "POST")
    @ApiImplicitParam(name = "id", value = "表单id", required = true, dataType = "String")
    @PostMapping(value = "/publish")
    public BaseResp publish(@RequestParam("id") String id){
        return hflowCustomTemplateService.publish(id);
    }

    @ApiOperation(value = "删除表单", notes = "删除发布", httpMethod = "POST")
    @ApiImplicitParam(name = "id", value = "表单id", required = true, dataType = "String")
    @PostMapping(value = "/delete")
    public BaseResp delete(@RequestParam("id") String id) {
        return hflowCustomTemplateService.delete(id);
    }

    @ApiOperation(value = "导出表单模板", notes = "导出表单模板", httpMethod = "GET")
    @ApiImplicitParam(name = "ids", value = "表单ids", required = true, dataType = "String")
    @GetMapping(value = "/export")
    public BaseResp export(HttpServletRequest request, HttpServletResponse response,@RequestParam("ids") String[] ids){
        String access_token = request.getParameter("access_token");
        AccessTokenLocal.setCurrentLocalToken("Bearer " + access_token);
        return new BaseResp(hflowCustomTemplateService.export(request,response,ids));
    }

    /**
     * 导入表单模板数据
     * @param fileBase64
     * @return
     */
    @ApiOperation(value = "导入表单模板(existsData名称已存在，errorData错误行)", notes = "(existsData名称已存在，errorData错误行)", httpMethod = "POST")
    @ApiResponse(code = 0,message = "success", response = HashMap.class)
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public BaseResp importFile(@RequestBody ImportVO vo) {


        //返回导入成功相关信息
        return hflowCustomTemplateService.importTpl(vo);
    }
    @ApiOperation(value = "根据流程ID和节点ID查询表单", notes = "根据流程ID和节点ID查询表单", httpMethod = "GET")
    @ApiResponse(code = 0,message = "success", response = HashMap.class)
    @RequestMapping(value = "findTplByFlowIdAndNodeId", method=RequestMethod.GET)
    public BaseResp findTplByFlowIdAndNodeId(@RequestParam("flowId") String flowId, @RequestParam("flowNodeId") String flowNodeId){
        HflowCustomRealTemplate listCT = customRealTemplateService.selectByFlowIdAndNodeId(flowId,
                flowNodeId);
        if (StringUtils.isNotNull(listCT)) {
            return new BaseResp(listCT);
        }else{
            return new BaseResp(ResultStatus.error_record_not_found);
        }
    }

    @ApiOperation(value = "根据流程ID和开始节点ID和当前节点ID查询表单", notes = "根据流程ID和开始节点ID和当前节点ID查询表单", httpMethod = "GET")
    @ApiResponse(code = 0,message = "success", response = HashMap.class)
    @RequestMapping(value = "findTplsByStarNodeAndCurrency", method=RequestMethod.GET)
    public BaseResp findTplsByStarNodeAndCurrency(@RequestParam("flowId") String flowId, @RequestParam("nodeIds") String[] nodeIds){
        Map map = new HashMap();
        for(String nodeId : nodeIds) {
            HflowCustomRealTemplate tpl = customRealTemplateService.selectByFlowIdAndNodeId(flowId,
                    nodeId);
            map.put(nodeId, tpl);
        }

        return new BaseResp(map);
    }
}
