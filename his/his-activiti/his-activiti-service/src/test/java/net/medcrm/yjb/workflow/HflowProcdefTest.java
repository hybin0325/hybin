package net.medcrm.yjb.workflow;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageInfo;

import net.medcrm.yjb.workflow.domain.HflowProcdef;
import net.medcrm.yjb.workflow.service.IHflowProcdefService;
import net.medcrm.yjb.workflow.util.ProcdefType;

@RunWith(SpringRunner.class)
@EnableTransactionManagement 
@SpringBootTest
public class HflowProcdefTest {
	
	@Autowired
	private IHflowProcdefService procdefService;
	
	@Autowired
	private TaskService taskService;
	
	@Test
	public void addTest() throws Exception{
		HflowProcdef pojo=new HflowProcdef();
		pojo.setTitleName("任务计划dd");
		pojo.setDescription("任务计划dd");
		pojo.setType(ProcdefType.PRCDE.getIndex());
		pojo.setpVersion(5);
		pojo.setActProcodefId("notify:2:17504");
		pojo.setCreateUser("李四");
		procdefService.save(pojo);		
	}
	
	//@Test
	public void findAllDeployTest() {
		//List<FlowDeployDto> dto= procdefService.findAllDeploy(ProcdefType.PRCDE.getIndex(),"14");
		List<HflowProcdef> list= procdefService.findAllProcdef("1",0,3,null,null);
		if(!list.isEmpty()) {
			PageInfo<HflowProcdef> page=new PageInfo<HflowProcdef>(list);
			//Page<HflowProcdef> page = (Page<HflowProcdef>) list;
			for (HflowProcdef pojo : list) {
				System.out.println(pojo.getTitleName());
			}
			System.out.println(page.toString());
		}
	}
	
	@Test
	public void findUser() {
		
		// 根据当前人的ID查询
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned("admin");
        List<Task> tasks = taskQuery.list();
        System.out.println(tasks.size()+"  kkkkkkkkkkkkkkkk");
	}

}
