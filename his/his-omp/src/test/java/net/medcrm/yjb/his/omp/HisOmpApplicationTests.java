package net.medcrm.yjb.his.omp;


import net.medcrm.yjb.his.omp.dao.DivisionMapper;
import net.medcrm.yjb.his.omp.dao.DivisionRePositionMapper;
import net.medcrm.yjb.his.omp.dao.EmployeeMapper;
import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import net.medcrm.yjb.his.omp.domain.Employee;
import net.medcrm.yjb.his.omp.service.Division2Service;
import net.medcrm.yjb.his.omp.service.DivisionRePositionService;
import net.medcrm.yjb.his.omp.service.DivisionService;
import net.medcrm.yjb.his.omp.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HisOmpApplication.class )
public class HisOmpApplicationTests {

	@Autowired
	DivisionService divisionService;
	@Autowired
	Division2Service division2Service;
	@Autowired
	DivisionMapper divisionMapper;
	@Autowired
	DivisionRePositionMapper divisionRePositionMapper;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DivisionRePositionService drpService;
	@Autowired
	EmployeeMapper employeeMapper;
	@Test
	public void contextLoads() {
//		Map<String,Object> map = new HashMap<>();
//		map.put("id","abc123");
//		map.put("fullName","刘德华");
//		map.put("abbr","心胸外科");
//		map.put("phone1","110");
//		map.put("phone2","120");
//		map.put("code","000");
//		map.put("fax","510000");
//		map.put("address","广州");
//		map.put("pid","372739a1ebd6411e9f56da782390a58c");
//		map.put("postCode","0000");
//		map.put("visibleInDiagram","Y");
//		divisionService.insertLegal(map);
//		division2Service.insertDivision(map);
//		divisionService.updateLegal(map);
//		divisionService.selectLeadersById("123,456");
//		divisionService.selectAll();
//		divisionService.deleteByListId("abc");
//		divisionService.selectSuspendAll();
//		divisionRePositionMapper.selectByDivisionId("372739a1ebd6411e9f56da782390a58c");
//		division2Service.selectBaseDivisionById("b0721c8c77844045b83b6d680a18898b");
	}
//	@Test
//	public void employee(){
//		Map<String,Object> map = new HashMap<>();
//		map.put("fullName","刘德华");
//		map.put("sex","M");
//		map.put("accountId","aa");
//		map.put("phone1","11111");
//		map.put("phone2","22222");
//		map.put("tel","020");
//		map.put("wechat","234");
//		map.put("partyMember","Y");
//		map.put("email","163");
//		map.put("jobTitleCode","000");
//		map.put("jobTitleName","教授");
//		map.put("imageUrl","adfa");
//		map.put("createUser","admin");
//		map.put("customText","内科");
//		employeeService.insert(map);
//	}
	@Test
	public void delete(){
		divisionService.selectDivisionChildById("372739a1ebd6411e9f56da782390a58c");
	}

}
