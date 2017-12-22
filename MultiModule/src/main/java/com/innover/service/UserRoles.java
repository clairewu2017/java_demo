package com.innover.service;

import javax.persistence.*;

/**
 * Created by chunmei on 8/9/2017.
 */
@Entity
public class UserRoles {
    private long id;
    private String userName;
    private long roleId;
    private User userByUserName;
    private Role roleByRoleId;

    @Id
    @Column(name = "Id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserName", nullable = false, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "RoleId", nullable = false)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (id != userRoles.id) return false;
        if (roleId != userRoles.roleId) return false;
        if (userName != null ? !userName.equals(userRoles.userName) : userRoles.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "UserName", referencedColumnName = "UserName", nullable = false)
    public User getUserByUserName() {
        return userByUserName;
    }

    public void setUserByUserName(User userByUserName) {
        this.userByUserName = userByUserName;
    }

    @ManyToOne
    @JoinColumn(name = "RoleId", referencedColumnName = "Id", nullable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
