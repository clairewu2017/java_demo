package com.innover.data;

import javax.persistence.*;

/**
 * Created by chunmei on 8/9/2017.
 */
@Entity
public class Permission {
    private long id;
    private long roleId;
    private long permissionDefinitionId;
    private Role roleByRoleId;
    private PermissionDefinition permissionDefinitionByPermissionDefinitionId;

    @Id
    @Column(name = "Id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "RoleId", nullable = false)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "PermissionDefinitionId", nullable = false)
    public long getPermissionDefinitionId() {
        return permissionDefinitionId;
    }

    public void setPermissionDefinitionId(long permissionDefinitionId) {
        this.permissionDefinitionId = permissionDefinitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (id != that.id) return false;
        if (roleId != that.roleId) return false;
        if (permissionDefinitionId != that.permissionDefinitionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (int) (permissionDefinitionId ^ (permissionDefinitionId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "RoleId", referencedColumnName = "Id", nullable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "PermissionDefinitionId", referencedColumnName = "Id", nullable = false)
    public PermissionDefinition getPermissionDefinitionByPermissionDefinitionId() {
        return permissionDefinitionByPermissionDefinitionId;
    }

    public void setPermissionDefinitionByPermissionDefinitionId(PermissionDefinition permissionDefinitionByPermissionDefinitionId) {
        this.permissionDefinitionByPermissionDefinitionId = permissionDefinitionByPermissionDefinitionId;
    }
}
