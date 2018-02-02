package net.medcrm.yjb.workflow.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.workflow.domain.HflowProcdef;
import net.medcrm.yjb.workflow.service.IActReModelService;
import net.medcrm.yjb.workflow.service.IActReProcdefService;
import net.medcrm.yjb.workflow.service.IHflowModelProcdefService;
import net.medcrm.yjb.workflow.service.IHflowProcdefService;
import net.medcrm.yjb.workflow.util.StringUtils;

@Service
public class ActReModelServiceImpl implements IActReModelService {
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private IHflowProcdefService procdefService;
	
	@Autowired
	private IActReProcdefService actReProcdefService;
	
	@Autowired
	private IHflowModelProcdefService modelProcdefService;
	
	/**
	 * 保存xml文件
	 */
	@Transactional
	public void saveModelDeployment(Model model, String json_xml, String svg_xml, EmployeeVO user, String dec) {
		String userName="张吵";
		try {
			repositoryService.saveModel(model);
			HflowProcdef procdef= procdefService.saveByActModel(model, userName, dec);
			if(StringUtils.isNotNull(procdef)) {
				modelProcdefService.saveModelProcdef(model.getCategory(), procdef.getId());
			}
			repositoryService.addModelEditorSource(model.getId(), json_xml.getBytes("utf-8"));
			InputStream svgStream = new ByteArrayInputStream(svg_xml.getBytes("utf-8"));
			TranscoderInput input = new TranscoderInput(svgStream);

			PNGTranscoder transcoder = new PNGTranscoder();
			// Setup output
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			TranscoderOutput output = new TranscoderOutput(outStream);

			// Do the transformation
			transcoder.transcode(input, output);
			final byte[] result = outStream.toByteArray();
			repositoryService.addModelEditorSourceExtra(model.getId(), result);
			outStream.close();
			actReProcdefService.saveDeploy(model, userName, dec);
		} catch (Exception e) {
			throw new ActivitiException("Error saving model", e);
		}
	}
}
