package net.medcrm.yjb.workflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.medcrm.yjb.workflow.domain.HflowModel;
import net.medcrm.yjb.workflow.service.IHflowModelService;

@RunWith(SpringRunner.class)
@EnableTransactionManagement 
@SpringBootTest
public class HflowModelTest {

	@Autowired
	private  IHflowModelService modelService;
	
	//@Test
	public void add() {
		HflowModel model=new HflowModel();
		model.setmName("这是个paixuq662111");
		model.setmCode("2254bggfg");
		model.createPersistentObject();
		modelService.save(model);
	}
	
	@Test
	public void updateDownChangeSortTest() {
		String currentId ="ba3df7dc-2adc-4eef-92c0-1c3892f57632";
		int currentSort=4;
		String downId="c668bc12-1a0a-4667-9db5-b9a1834e827c";
		int downSort=3;
		modelService.updateDownChangeSort(currentId, currentSort, downId, downSort);
	}
	
	
}
