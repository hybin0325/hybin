package net.medcrm.yjb.workflow.service.impl;

import java.io.File;
import java.util.*;

import com.his.mybatis.dynamicDataSource.page.PageInfo;
import com.lorne.tx.annotation.TxTransaction;
import net.medcrm.yjb.his.excelutil.excel.ExcelExportSXXSSF;
import net.medcrm.yjb.his.excelutil.excel.ImportExcel;
import net.medcrm.yjb.his.excelutil.excel.beanvalidator.BeanValidators;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.fileutil.Base64Util;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.his.tool.NumberConvert;
import net.medcrm.yjb.workflow.controller.vo.ImportVO;
import net.medcrm.yjb.workflow.dto.HflowCustomTemplateVO;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.workflow.domain.HflowCustomField;
import net.medcrm.yjb.workflow.domain.HflowCustomRealTemplate;
import net.medcrm.yjb.workflow.domain.HflowCustomTable;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import net.medcrm.yjb.workflow.dto.BindFlowFromDto;
import net.medcrm.yjb.workflow.mapper.HflowCustomTemplateMapper;
import net.medcrm.yjb.workflow.service.HflowCustomFieldService;
import net.medcrm.yjb.workflow.service.HflowCustomRealTemplateService;
import net.medcrm.yjb.workflow.service.HflowCustomTableService;
import net.medcrm.yjb.workflow.service.HflowCustomTemplateService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * Created by linsheng on 2017/12/26.
 */
@Service(value = "hflowCustomTemplateService")
@Transactional
public class HflowCustomTemplateServiceImpl implements HflowCustomTemplateService {

    @Autowired
    private HflowCustomTemplateMapper hflowCustomTemplateMapper;

    @Autowired
    private HflowCustomFieldService hflowCustomFieldService;

    @Autowired
    private HflowCustomTableService hflowCustomTableService;

    @Autowired
    private HflowCustomRealTemplateService hflowCustomRealTemplateService;

    @Autowired
    private EmployeeServiceClient employeeServiceClient;
    @Override
    public PageInfo<HflowCustomTemplateVO> select(String type, String name, Integer pageNum, Integer pageSize,Integer status) {
        String userId = null;
        BaseResp<EmployeeVO> baseResp = employeeServiceClient.currentEmp();
        if(baseResp.getCode() == 0 && "success".equals(baseResp.getMessage())){
            EmployeeVO vo = (EmployeeVO)baseResp.getData();
            if(vo != null){
                userId = vo.getId();
            }
        }
        PageInfo<HflowCustomTemplateVO> vos = new PageInfo<>();
        if("".equals(status) || status == null) {
            PageHelper.startPage(pageNum, pageSize);
            List<HflowCustomTemplate> hflowCustomTemplates = hflowCustomTemplateMapper.select(type, name, userId, status);
            PageInfo page =  new PageInfo<>(hflowCustomTemplates);

            vos.setPages(page.getPages());
            vos.setTotal(page.getTotal());
            vos.setPageNum(pageNum);
            vos.setPageSize(pageSize);
            List<HflowCustomTemplateVO> list = new ArrayList<>();
            for(HflowCustomTemplate template :hflowCustomTemplates){

                list.add(new HflowCustomTemplateVO(template));
            }
            vos.setList(list);
            return vos;
        }else{
            PageHelper.startPage(pageNum, pageSize);
            List<HflowCustomTemplate> hflowCustomTemplates = hflowCustomTemplateMapper.selectByStatus(type, name, userId, null);
            PageInfo page =  new PageInfo<>(hflowCustomTemplates);
            vos.setPages(page.getPages());
            vos.setTotal(page.getTotal());
            vos.setPageNum(pageNum);
            vos.setPageSize(pageSize);

            List<HflowCustomTemplateVO> list = new ArrayList<>();
            for(HflowCustomTemplate template :hflowCustomTemplates){

                list.add(new HflowCustomTemplateVO(template));
            }
            vos.setList(list);
            return vos;
        }

    }

    public List<HflowCustomTemplateVO> selectByPid(String pid){
        List<HflowCustomTemplate> hflowCustomTemplates = hflowCustomTemplateMapper.selectByPid(pid,null);
        List<HflowCustomTemplateVO> list = new ArrayList<>();
        for(HflowCustomTemplate template :hflowCustomTemplates){

            list.add(new HflowCustomTemplateVO(template));
        }
        return list;
    }
    @Override
    public HflowCustomTemplate selectByPrimaryKey(String id) {
        return hflowCustomTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean selectByName(String name) {
        return hflowCustomTemplateMapper.selectByName(name).size() > 0 ? false:true;
    }

    @Override
    public int insert(HflowCustomTemplate hflowCustomTemplate) {
        hflowCustomTemplate.setCreateDate(new Date());
        hflowCustomTemplate.setUpdateDate(new Date());
        hflowCustomTemplate.setId(hflowCustomTemplate.getId() == null ? UUID.randomUUID().toString() : hflowCustomTemplate.getId());
        return hflowCustomTemplateMapper.insert(hflowCustomTemplate);
    }

    @Override
    public int update(HflowCustomTemplate hflowCustomTemplate) {
        hflowCustomTemplate.setUpdateDate(new Date());
        return hflowCustomTemplateMapper.update(hflowCustomTemplate);
    }

    @Transactional
    @Override
    public BaseResp copy(String id,String type){
        HflowCustomTemplate template = this.selectByPrimaryKey(id);
        if(template == null){
            return new BaseResp(ResultStatus.error_record_not_found);
        }
        List<HflowCustomField> hflowCustomFields = hflowCustomFieldService.selectByTplId(template.getId());
        template.setId(UUID.randomUUID().toString());
        template.setSort(hflowCustomTemplateMapper.selectMaxSort());
        BaseResp<EmployeeVO> baseResp = employeeServiceClient.currentEmp();
        if(baseResp.getCode() == 0 && "success".equals(baseResp.getMessage())){
            EmployeeVO vo = (EmployeeVO)baseResp.getData();
            template.setUpdateUser(vo.getFullName());
            template.setUpdateUserId(vo.getId());
            template.setUpdateDate(new Date());
        }
        template.setVersion("1.0");
        template.setType(type == null ? template.getType():type);
        template.setStatus(HflowCustomTemplate.INIT_STATUS);
        template.setPublicDate(null);
        template.setName(template.getName() + "_copy");
        for(HflowCustomField hflowCustomField : hflowCustomFields){
            hflowCustomField.setTplId(template.getId());
            hflowCustomFieldService.insert(hflowCustomField);
        }
        hflowCustomTemplateMapper.insert(template);

        return new BaseResp(template);
    }
    @Transactional
    @Override
    public BaseResp delete(String id) {
        HflowCustomTemplate hflowCustomTemplate = hflowCustomTemplateMapper.selectByPrimaryKey(id);
        if(hflowCustomTemplate == null){
            return new BaseResp(ResultStatus.error_record_not_found);
        }
        hflowCustomTemplateMapper.delete(id);/*
        if(hflowCustomTemplate.getId().equals(hflowCustomTemplate.getPid())){
            List<HflowCustomTemplate> list = hflowCustomTemplateMapper.selectByPid(hflowCustomTemplate.getId(),null);
            for(HflowCustomTemplate tpl :list){
                hflowCustomTemplateMapper.delete(tpl.getId());
            }
        }else{

        }*/
        return new BaseResp(id);
    }

    @Transactional
    @Override
    public HflowCustomTemplate saveOrUpdate(HflowCustomTemplate hflowCustomTemplate){

        //id不为空
        HflowCustomTemplate updateHflowCustomTemplate = null;
        if(hflowCustomTemplate.getId() != null && !"".equals(hflowCustomTemplate.getId())){
            updateHflowCustomTemplate = hflowCustomTemplateMapper.selectByPrimaryKey(hflowCustomTemplate.getId());
        }

        BaseResp<EmployeeVO> baseResp = employeeServiceClient.currentEmp();
        if(baseResp.getCode() == 0 && "success".equals(baseResp.getMessage())){
            EmployeeVO vo = (EmployeeVO)baseResp.getData();
            hflowCustomTemplate.setCreateUser(vo.getFullName());
            hflowCustomTemplate.setCreateUserId(vo.getId());
        }
        Date date = new Date();
        hflowCustomTemplate.setCreateDate(date);
        hflowCustomTemplate.setUpdateDate(date);


        if(updateHflowCustomTemplate != null){
            //不为空则修改
            //修改表单信息
            //更新记录，如果旧记录为发布状态，则新生成一个版本记录
            if(updateHflowCustomTemplate.getStatus() == HflowCustomTemplate.PUBLIC_STATUS){
                String uuid = UUID.randomUUID().toString();
                hflowCustomTemplate.setId(uuid);
                hflowCustomTemplate.setPid(updateHflowCustomTemplate.getPid());
                if(hflowCustomTemplate.getVersion() == null || "".equals(hflowCustomTemplate.getVersion())) {
                    if(NumberConvert.isNumeric(updateHflowCustomTemplate.getVersion())){
                        String version = NumberConvert.stringToOneBigDecimalPlace(updateHflowCustomTemplate.getVersion());
                        hflowCustomTemplate.setVersion(Double.parseDouble(version==null?"1.0":version)+ 0.1 + "");
                    }else{
                        hflowCustomTemplate.setVersion(updateHflowCustomTemplate.getVersion());
                    }

                }
                hflowCustomTemplate.setSort(hflowCustomTemplateMapper.selectMaxSort());
                this.insert(hflowCustomTemplate);
            }
            //更新记录，如果旧记录为未发布状态，则把旧记录更新数据
            if(updateHflowCustomTemplate.getStatus() == HflowCustomTemplate.INIT_STATUS){
                this.update(hflowCustomTemplate);
            }

            //hflowCustomFieldService.deleteByTplId(hflowCustomTemplate.getId());
            if(hflowCustomTemplate.getHflowCustomFieldList().size() > 0){
                for(HflowCustomField hflowCustomField : hflowCustomTemplate.getHflowCustomFieldList()){
                    hflowCustomField.setTplId(hflowCustomTemplate.getId());
                    hflowCustomFieldService.insert(hflowCustomField);
                }
            }else{
                List<HflowCustomField> fields = hflowCustomFieldService.selectByTplId(updateHflowCustomTemplate.getId());
                for(HflowCustomField hflowCustomField : fields){
                    hflowCustomField.setTplId(hflowCustomTemplate.getId());
                    hflowCustomField.setId(UUID.randomUUID().toString());
                    hflowCustomFieldService.insert(hflowCustomField);
                }
            }

        }else{

            if(hflowCustomTemplate.getId() == null){
                String uuid = UUID.randomUUID().toString();
                hflowCustomTemplate.setId(uuid);
                hflowCustomTemplate.setPid(uuid);
                if(hflowCustomTemplate.getVersion() == null || "".equals(hflowCustomTemplate.getVersion())) {
                    hflowCustomTemplate.setVersion("1.0");
                }else{
                    if(NumberConvert.isNumeric(updateHflowCustomTemplate.getVersion())){
                        hflowCustomTemplate.setVersion(NumberConvert.stringToOneBigDecimalPlace(hflowCustomTemplate.getVersion()));
                    }
                }
            }
            hflowCustomTemplate.setSort(hflowCustomTemplateMapper.selectMaxSort());
            this.insert(hflowCustomTemplate);
            for(HflowCustomField hflowCustomField : hflowCustomTemplate.getHflowCustomFieldList()){
                hflowCustomField.setTplId(hflowCustomTemplate.getId());
                hflowCustomFieldService.insert(hflowCustomField);
            }
        }

        return hflowCustomTemplate;
    }


    /**
     * 启用停用
     * @param id
     * @return
     */
    @Transactional
    @Override
    public BaseResp startOrStop(String id){
        HflowCustomTemplate updateHflowCustomTemplate = this.selectByPrimaryKey(id);

        if(updateHflowCustomTemplate != null){
            updateHflowCustomTemplate.setStatus(updateHflowCustomTemplate.getStatus() == 0 ? 1 : 0);
            updateHflowCustomTemplate.setUpdateDate(new Date());
            this.update(updateHflowCustomTemplate);

            return new BaseResp(true);
        }else{
            return new BaseResp(ResultStatus.error_record_not_found);
        }
    }

    @Override
    @Transactional
    public BaseResp bind(BindFlowFromDto flowFromDto){
        //hflowCustomTableService   hflowCustomRealTemplateService;
        HflowCustomTemplate template = this.selectByPrimaryKey(flowFromDto.getFormId());
        if(template == null){
            return new BaseResp(ResultStatus.error_record_not_found);
        }
        /**
         * 生成多份还是一份合适？？
         * 保存选择模板数据
         */
        //List<HflowCustomField> hflowCustomFields = hflowCustomFieldService.selectByTplId(template.getId());

        /**
         * 模板对应所有自定义字段
         */
        for(String flowNodeId : flowFromDto.getFlowNodeIds()){
            if(template.getTpl() != null && !"".equals(template.getTpl())) {
                template.setTpl(template.getTpl().replaceAll("\"fieldId\":\"", "\"fieldId\":\"" + flowNodeId));
            }
            HflowCustomRealTemplate realTemplate = new HflowCustomRealTemplate(template);

            realTemplate.setId(UUID.randomUUID().toString());
            realTemplate.setFlowId(flowFromDto.getFlowId());
            realTemplate.setNodeId(flowNodeId);
            hflowCustomRealTemplateService.insert(realTemplate);

           /* List<HflowCustomTable> hflowCustomTables =  hflowCustomTableService.selectByFlowIdAndNodeId(flowFromDto.getFlowId(),flowNodeId);
            for(HflowCustomTable table : hflowCustomTables){
                hflowCustomTableService.delete(table.getId());
            }
            //三个模板
            for(HflowCustomField field : hflowCustomFields){
                HflowCustomTable table  = new HflowCustomTable();
                table.setTplId(realTemplate.getId());
                table.setId(UUID.randomUUID().toString());
                table.setFlowId(flowFromDto.getFlowId());
                table.setComponentKey(field.getComponentKey());
                table.setTitle(field.getTitle());
                table.setContent(field.getContent());
                table.setDefault(field.isDefault());
                table.setMaxlen(field.getMaxlen());
                table.setFieldId(field.getFieldId());
                table.setStatus(1);
                table.setId(UUID.randomUUID().toString());
                table.setFlowNodeId(flowNodeId);
                hflowCustomTableService.insert(table);
            }*/
        }

        return new BaseResp(flowFromDto);
    }


    public BaseResp updateSort(String upId,String downId){
        HflowCustomTemplate upTpl = hflowCustomTemplateMapper.selectByPrimaryKey(upId);
        HflowCustomTemplate downTpl = hflowCustomTemplateMapper.selectByPrimaryKey(downId);
        Integer upSort = upTpl.getSort();
        Integer downSort = downTpl.getSort();
        upTpl.setSort(downSort);
        downTpl.setSort(upSort);
        hflowCustomTemplateMapper.updateSort(upTpl);
        hflowCustomTemplateMapper.updateSort(downTpl);
        return new BaseResp(true);
    }


    @Transactional
    public BaseResp publish(String id){
        HflowCustomTemplate publishTpl = hflowCustomTemplateMapper.selectByPrimaryKey(id);

        List<HflowCustomTemplate> hflowCustomTemplates = hflowCustomTemplateMapper.selectByPid(publishTpl.getPid(),HflowCustomTemplate.PUBLIC_STATUS);
        for(HflowCustomTemplate tpl : hflowCustomTemplates){
            //tpl.setStatus(HflowCustomTemplate.HISTORY_STATUS);
            hflowCustomTemplateMapper.update(tpl);
        }
        publishTpl.setStatus(HflowCustomTemplate.PUBLIC_STATUS);
        publishTpl.setPublicDate(new Date());
        hflowCustomTemplateMapper.update(publishTpl);
        return new BaseResp(publishTpl);
    }

    public BaseResp export(HttpServletRequest request, HttpServletResponse response,String[] ids){
        List<HflowCustomTemplate> tpls = hflowCustomTemplateMapper.selectByKeys(ids);
        try {
            if(tpls.size() > 0) {
                List list = new ArrayList();
                Integer code = 1;
                for (HflowCustomTemplate tpl : tpls) {
                    Map map = new HashMap();
                    map.put("code",code);
                    map.put("name", tpl.getName());
                    map.put("description", tpl.getDescription());
                    map.put("tpl", tpl.getTpl());
                    list.add(map);
                    code ++;
                }
                String columnNames[] = {"编号","表单名称", "描述", "表单模板"};
                String keys[] = {"code","name", "description", "tpl"};
                ExcelExportSXXSSF.generateReport(request, response, "导出表单数据", list, keys, columnNames);
            }else{
                return new BaseResp(ResultStatus.error_record_not_found);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @TxTransaction
    @Transactional
    public BaseResp importTpl(ImportVO importVO){
            try{
            String filePath =  Base64Util.generateFile(importVO.getFileBase64(),null);
            File file = new File(filePath);
            int successNum = 0;
            int failureNum = 0;

            StringBuilder failureMsg = new StringBuilder();
            ImportExcel ei = new ImportExcel(file, 0, 0);
            List<HflowCustomTemplate> list = ei.getDataList(HflowCustomTemplate.class);
            BaseResp<EmployeeVO> baseResp = employeeServiceClient.currentEmp();
            EmployeeVO vo = null;
            if(baseResp.getCode() == 0 && "success".equals(baseResp.getMessage())){
                vo = (EmployeeVO)baseResp.getData();
            }
            Map<String ,List<String>> result = new HashMap<>();
            List<String> existsData = new ArrayList<>();
            List<String> errorData = new ArrayList<>();
            for (HflowCustomTemplate tpl : list){
                try{
                    if (this.selectByName(tpl.getName())){
                        tpl.setStatus(0);
                        tpl.setSort(hflowCustomTemplateMapper.selectMaxSort());
                        tpl.setId(UUID.randomUUID().toString());
                        tpl.setCreateDate(new Date());
                        tpl.setVersion("1.0");
                        tpl.setType(importVO.getType());
                        if(vo != null){
                            tpl.setCreateUser(vo.getFullName());
                            tpl.setCreateUserId(vo.getId());
                        }
                        hflowCustomTemplateMapper.insert(tpl);
                        //保存到数据库。。。
                        successNum++;
                    }else{
                        failureMsg.append("<br/>表单名称 "+tpl.getName()+" 已存在; ");
                        existsData.add(tpl.getName());
                        failureNum++;
                    }
                }catch (ConstraintViolationException ex){
                    List<String> messageList = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
                    for (String message : messageList){
                        failureMsg.append(message+"; ");
                        failureNum++;
                    }
                }catch (Exception ex) {
                    failureMsg.append("<br/>表单名称： "+tpl.getName()+" 导入失败："+ex.getMessage());
                    errorData.add(tpl.getName());

                }

            }
            result.put("existsData", existsData);
            result.put("errorData", errorData);

            if (failureNum>0){
                failureMsg.insert(0, "，失败 "+failureNum+" 条数据，导入信息如下：");
            }


            return new BaseResp(result);

        } catch (Exception e) {
            LoggerUtils.info(getClass(), e.getMessage());
            e.printStackTrace();
        }
        return new BaseResp(true);
    }
}
