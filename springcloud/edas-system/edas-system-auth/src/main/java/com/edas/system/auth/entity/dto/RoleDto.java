package com.edas.system.auth.entity.dto;

import java.util.List;

import com.edas.system.auth.entity.Role;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false )
@NoArgsConstructor
public class RoleDto extends Role {

	private static final long serialVersionUID = 4218495592167610193L;

	private List<Long> resourceIds;

	
}
