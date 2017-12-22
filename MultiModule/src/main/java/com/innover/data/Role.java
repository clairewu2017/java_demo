package com.innover.data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by chunmei on 8/9/2017.
 */
@Entity
public class Role {
    private long id;
    private String name;
    private byte isProtected;
    private byte hideRole;
    private Collection<Permission> permissionsById;
    private Collection<UserRoles> userRolesById;

    @Id
    @Column(name = "Id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "IsProtected", nullable = false)
    public byte getIsProtected() {
        return isProtected;
    }

    public void setIsProtected(byte isProtected) {
        this.isProtected = isProtected;
    }

    @Basic
    @Column(name = "HideRole", nullable = false)
    public byte getHideRole() {
        return hideRole;
    }

    public void setHideRole(byte hideRole) {
        this.hideRole = hideRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        if (isProtected != role.isProtected) return false;
        if (hideRole != role.hideRole) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) isProtected;
        result = 31 * result + (int) hideRole;
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<Permission> getPermissionsById() {
        return permissionsById;
    }

    public void setPermissionsById(Collection<Permission> permissionsById) {
        this.permissionsById = permissionsById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserRoles> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRoles> userRolesById) {
        this.userRolesById = userRolesById;
    }
}
