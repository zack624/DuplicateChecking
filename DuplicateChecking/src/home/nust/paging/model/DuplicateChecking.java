/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.nust.paging.model;

import java.util.Date;

/**
 *  数据库表映射的实体对象
 * @author zack
 */
public class DuplicateChecking {
    private long id;
    private String name;
    private String major;
    private String className;
    private String paperTitle;
    private String teacher;
    private String reasonOfChecking;
    private Date timeOfDelivery;

    public DuplicateChecking() {
    }

    
    public DuplicateChecking(long id, String name, String major, String className, String paperTitle, String teacher, String reasonOfChecking, Date timeOfDelivery) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.className = className;
        this.paperTitle = paperTitle;
        this.teacher = teacher;
        this.reasonOfChecking = reasonOfChecking;
        this.timeOfDelivery = timeOfDelivery;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getReasonOfChecking() {
        return reasonOfChecking;
    }

    public void setReasonOfChecking(String reasonOfChecking) {
        this.reasonOfChecking = reasonOfChecking;
    }

    public Date getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public void setTimeOfDelivery(Date timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }

    @Override
    public String toString() {
        return "DuplicateChecking{" + "id=" + id + ", name=" + name + ", major=" + major + ", className=" + className + ", paperTitle=" + paperTitle + ", teacher=" + teacher + ", reasonOfChecking=" + reasonOfChecking + ", timeOfDelivery=" + timeOfDelivery + '}';
    }
    
}
