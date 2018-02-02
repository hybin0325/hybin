package net.medcrm.yjb.workflow.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.medcrm.yjb.workflow.domain.DelegateHistory;
import net.medcrm.yjb.workflow.domain.DelegateInfo;
import net.medcrm.yjb.workflow.mapper.DelegateHistoryMapper;
import net.medcrm.yjb.workflow.mapper.DelegateInfoMapper;
import net.medcrm.yjb.workflow.service.IDelegateService;

public class DelegateServiceImpl  implements IDelegateService{
	@Autowired
    private DelegateInfoMapper delegateInfoDao;
    @Autowired
    private DelegateHistoryMapper delegateHistoryDao;
    
    
    public DelegateInfo getDelegateInfo(String targetAssignee,String targetProcessDefinitionId) {  
        
         Map<String,Object> map=new HashMap<String, Object>();
         map.put("assignee", targetAssignee);
       
         // List<DelegateInfo> list=delegateInfoDao.find("from DelegateInfo d where d.status=1 and d.assignee=:assignee order by id desc",map);
         List<DelegateInfo> list=delegateInfoDao.selectAll(map);
         for (DelegateInfo delegateInfo : list) {  
            String processDefinitionId = (String) delegateInfo.getProcessDefinitionId();  
            Date startTime = (Date) delegateInfo.getStartTime();  
            Date endTime = (Date) delegateInfo.getEndTime();  
            if (timeNotBetweenNow(startTime, endTime)) {  
                continue;  
            }  
  
            if ((processDefinitionId == null)|| processDefinitionId.equals(targetProcessDefinitionId)) {                  
                return delegateInfo;  
            }  
        }  
  
        return null;  
    }  
  
    public void saveRecord(String assignee, String attorney, String taskId) { 
        DelegateHistory delegateHistory=new DelegateHistory();
        delegateHistory.setAttorney(assignee);
        delegateHistory.setAttorney(attorney);
        delegateHistory.setTaskId(taskId);
        delegateHistory.setDelegateTime(new Date());
        delegateHistory.setStatus(1);
        delegateHistoryDao.updateByPrimaryKeySelective(delegateHistory); 
    }  
  
    public void removeRecord(String id) {  
        delegateInfoDao.delete(id); 
    }  
  
    public void addDelegateInfo(String assignee, String attorney,Date startTime, Date endTime, String processDefinitionId) {       
        DelegateInfo delegateInfo=new DelegateInfo();
        delegateInfo.setAssignee(assignee);
        delegateInfo.setAttorney(attorney);
        delegateInfo.setEndTime(endTime);
        delegateInfo.setStartTime(startTime);
        delegateInfo.setProcessDefinitionId(processDefinitionId);
        delegateInfo.setStatus(1);
        delegateInfoDao.insert(delegateInfo);
    }  
  
    private boolean timeNotBetweenNow(Date startTime, Date endTime) {  
        Date now = new Date(System.currentTimeMillis());  
        if (startTime != null) {  
            return now.before(startTime);  
        }  
        if (endTime != null) {  
            return now.after(endTime);  
        }  
        return false;  
    }   
}
