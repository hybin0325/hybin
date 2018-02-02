package net.medcrm.yjb.workflow.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.medcrm.yjb.his.common.model.BaseResp;

@RestController
@RequestMapping(value = "/workflow/processinstance")
public class ProcessInstanceController {

    @Autowired
    private RuntimeService runtimeService;

    @RequestMapping(value = "running")
    public Object running(Model model, HttpServletRequest request) {
        ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
        List<ProcessInstance> list = processInstanceQuery.list();
     
        return new BaseResp<List<ProcessInstance>>(list);
    }

    /**
     * 挂起、激活流程实例
     */
    @RequestMapping(value = "update/{state}/{processInstanceId}")
    public String updateState(@PathVariable("state") String state, @PathVariable("processInstanceId") String processInstanceId,
                              RedirectAttributes redirectAttributes) {
        if (state.equals("active")) {
            redirectAttributes.addFlashAttribute("message", "已激活ID为[" + processInstanceId + "]的流程实例。");
            runtimeService.activateProcessInstanceById(processInstanceId);
        } else if (state.equals("suspend")) {
            runtimeService.suspendProcessInstanceById(processInstanceId);
            redirectAttributes.addFlashAttribute("message", "已挂起ID为[" + processInstanceId + "]的流程实例。");
        }
        return "redirect:/workflow/processinstance/running";
    }
}
