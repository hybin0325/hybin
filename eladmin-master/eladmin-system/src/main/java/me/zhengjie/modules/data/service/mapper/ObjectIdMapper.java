package me.zhengjie.modules.data.service.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class ObjectIdMapper {

	public String asString(ObjectId objectId) {
		return objectId != null ? objectId.toString() : null;
	}

	public ObjectId asObjectId(String objectId) {
		try {
			return objectId != null ? new ObjectId(objectId) : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
