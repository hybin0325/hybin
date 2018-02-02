package net.medcrm.yjb.workflow.mapper;

import java.util.List;

import net.medcrm.yjb.workflow.domain.Consultation;

public interface ConsultationMapper {
	int deleteByPrimaryKey(String id);

	int insert(Consultation record);

	int insertSelective(Consultation record);

	Consultation selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Consultation record);

	int updateByPrimaryKey(Consultation record);

	List<Consultation> selectAllUser();
}
