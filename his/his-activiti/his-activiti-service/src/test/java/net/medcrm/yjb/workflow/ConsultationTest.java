package net.medcrm.yjb.workflow;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.medcrm.yjb.workflow.domain.Consultation;
import net.medcrm.yjb.workflow.service.IConsultationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsultationTest {
	
	@Autowired
	private IConsultationService consultationService;

	@Test
	public void add(){
		Consultation pojo=new Consultation();
		pojo.setId(UUID.randomUUID().toString());
		pojo.setApplyDate(new Date());
		pojo.setApplyDepartment("内科");
		pojo.setApplyDepartmentId("20");
		pojo.setApplyUser("张三");
		pojo.setApplyUserId("10");
		pojo.setAppointmentDepartment("急诊科");
		pojo.setAppointmentDepartmentId("233");
		pojo.setAppointmentUser("李主任");
		pojo.setAppointmentUserId("1111");
		pojo.setConsultationDate(new Date());
		pojo.setConsultationResults("确认有没有病");
		pojo.setConsultationType("急会诊");
		pojo.setCreateDate(new Date());
		pojo.setIllnessDesc("腹部痛");
		pojo.setPatient("2255555");
		pojo.setPatientName("王小五");
		pojo.setPatientBedNumber(25);
		consultationService.addConsultation(pojo);
	}
	
	@Test
	public void findAll(){
		List<Consultation> list= consultationService.findAllConsultation(0, 20);
		System.out.println(list);
	}
}
