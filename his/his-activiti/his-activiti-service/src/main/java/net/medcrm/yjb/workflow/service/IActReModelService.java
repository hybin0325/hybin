package net.medcrm.yjb.workflow.service;

import org.activiti.engine.repository.Model;

import net.medcrm.yjb.his.feign.EmployeeVO;

public interface IActReModelService {
	void saveModelDeployment(Model model, String json_xml, String svg_xml, EmployeeVO user, String dec);
}
