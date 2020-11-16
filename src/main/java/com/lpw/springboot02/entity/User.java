package com.lpw.springboot02.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-09-22 15:52:16
 */
public class User implements Serializable {
    private static final long serialVersionUID = -30186747075792927L;

    private Integer id;

    private String name;

    private Integer age;

    private String address;

    private Integer sex;

    private Date createtime;

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public User() {
        super();
    }

    public User(String name, Integer age, String address, Integer sex, Date createtime) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", createtime=" + createtime +
                ", filePath=" + filePath +
                '}';
    }
}