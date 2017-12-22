package com.innover.service;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by chunmei on 8/9/2017.
 */
@Entity
public class User {
    private String userName;
    private String password;
    private String lastName;
    private String firstName;
    private boolean sex;
    private Date birthDay;
    private String origin;
    private String idCard;
    private String address;
    private String tel;
    private String email;
    private Timestamp changed;
    private Timestamp created;
    private byte deleted;
    private long timeout;
    private byte expires;
    private Timestamp expiredate;
    private Timestamp passwdChanged;
    private byte passwordviolations;
    private Timestamp lastSignInDate;
    private Collection<UserOldPassword> userOldPasswordsByUserName;
    private Collection<UserRoles> userRolesByUserName;

    @Id
    @Column(name = "UserName", nullable = false, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "LastName", nullable = false, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "FirstName", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Sex", nullable = false)
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "BirthDay", nullable = true)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Basic
    @Column(name = "Origin", nullable = true, length = 50)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic
    @Column(name = "IdCard", nullable = true, length = 50)
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Tel", nullable = true, length = 50)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Changed", nullable = false)
    public Timestamp getChanged() {
        return changed;
    }

    public void setChanged(Timestamp changed) {
        this.changed = changed;
    }

    @Basic
    @Column(name = "Created", nullable = false)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "Deleted", nullable = false)
    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "Timeout", nullable = false)
    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    @Basic
    @Column(name = "Expires", nullable = false)
    public byte getExpires() {
        return expires;
    }

    public void setExpires(byte expires) {
        this.expires = expires;
    }

    @Basic
    @Column(name = "Expiredate", nullable = true)
    public Timestamp getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Timestamp expiredate) {
        this.expiredate = expiredate;
    }

    @Basic
    @Column(name = "PasswdChanged", nullable = true)
    public Timestamp getPasswdChanged() {
        return passwdChanged;
    }

    public void setPasswdChanged(Timestamp passwdChanged) {
        this.passwdChanged = passwdChanged;
    }

    @Basic
    @Column(name = "Passwordviolations", nullable = false)
    public byte getPasswordviolations() {
        return passwordviolations;
    }

    public void setPasswordviolations(byte passwordviolations) {
        this.passwordviolations = passwordviolations;
    }

    @Basic
    @Column(name = "LastSignInDate", nullable = true)
    public Timestamp getLastSignInDate() {
        return lastSignInDate;
    }

    public void setLastSignInDate(Timestamp lastSignInDate) {
        this.lastSignInDate = lastSignInDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (sex != user.sex) return false;
        if (deleted != user.deleted) return false;
        if (timeout != user.timeout) return false;
        if (expires != user.expires) return false;
        if (passwordviolations != user.passwordviolations) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (birthDay != null ? !birthDay.equals(user.birthDay) : user.birthDay != null) return false;
        if (origin != null ? !origin.equals(user.origin) : user.origin != null) return false;
        if (idCard != null ? !idCard.equals(user.idCard) : user.idCard != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (tel != null ? !tel.equals(user.tel) : user.tel != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (changed != null ? !changed.equals(user.changed) : user.changed != null) return false;
        if (created != null ? !created.equals(user.created) : user.created != null) return false;
        if (expiredate != null ? !expiredate.equals(user.expiredate) : user.expiredate != null) return false;
        if (passwdChanged != null ? !passwdChanged.equals(user.passwdChanged) : user.passwdChanged != null)
            return false;
        if (lastSignInDate != null ? !lastSignInDate.equals(user.lastSignInDate) : user.lastSignInDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (sex ? 1 : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (changed != null ? changed.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (int) deleted;
        result = 31 * result + (int) (timeout ^ (timeout >>> 32));
        result = 31 * result + (int) expires;
        result = 31 * result + (expiredate != null ? expiredate.hashCode() : 0);
        result = 31 * result + (passwdChanged != null ? passwdChanged.hashCode() : 0);
        result = 31 * result + (int) passwordviolations;
        result = 31 * result + (lastSignInDate != null ? lastSignInDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserName")
    public Collection<UserOldPassword> getUserOldPasswordsByUserName() {
        return userOldPasswordsByUserName;
    }

    public void setUserOldPasswordsByUserName(Collection<UserOldPassword> userOldPasswordsByUserName) {
        this.userOldPasswordsByUserName = userOldPasswordsByUserName;
    }

    @OneToMany(mappedBy = "userByUserName")
    public Collection<UserRoles> getUserRolesByUserName() {
        return userRolesByUserName;
    }

    public void setUserRolesByUserName(Collection<UserRoles> userRolesByUserName) {
        this.userRolesByUserName = userRolesByUserName;
    }
}
