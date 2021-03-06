package com.kowalczyk.workouter.model.BO.security;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.ModelObject;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by JK on 2016-12-14.
 */
@Entity
public class Role extends ModelObject {

    private RoleType roleType;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType name) {
        this.roleType = name;
    }
}
