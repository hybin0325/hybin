package net.medcrm.yjb.workflow;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeploymentTest {
	@Autowired
    RepositoryService repositoryService;
	
	@Test
	public void getList(){
		int rowSize=100;
		int page =1;
		List<Deployment> deployments = repositoryService.createDeploymentQuery()
	                .listPage(rowSize * (page - 1), rowSize);
		for (Deployment deployment : deployments) {
			System.out.println(deployment.getId()+"  "+deployment.getName());
		} 
	}
}
