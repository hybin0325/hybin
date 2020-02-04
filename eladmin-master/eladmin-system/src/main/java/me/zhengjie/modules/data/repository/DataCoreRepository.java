package me.zhengjie.modules.data.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.zhengjie.modules.data.domain.DataCore;
import me.zhengjie.modules.data.repository.base.BaseDao;

public interface DataCoreRepository extends BaseDao<DataCore, ObjectId>{
	
	List<DataCore> findByProNameLike(String proName);
	
	Page<DataCore> findByProNameLike(String proName,Pageable page);

}
