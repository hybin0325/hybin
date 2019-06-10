package com.edas.system.auth.entity;

import javax.persistence.Table;

import com.edas.system.auth.entity.po.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false )
@NoArgsConstructor
@Table(name="shopwwi_sys_roles")
public class Role extends BasePo<Long> {
    private String code;
    private String name;
    private String description;
}
