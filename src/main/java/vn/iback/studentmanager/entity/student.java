package vn.iback.studentmanager.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "student")
public class student {
    @Id
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "day_into_school")
    private Date dayIntoSchool;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "diem_tich_luy")
    private double diemTichLuy;
    @Column(name = "diem_tb_hocKy")
    private double diemTbHocKy;
    @ManyToOne
    @JoinColumn(name = "parents_id")
    private parents parents;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private classSchool classSchool;

    public student() {
    }

    public student(String studentId) {
        this.studentId = studentId;
    }

    public student(String studentId, String fullName, Date dayIntoSchool, Date birthday, double diemTichLuy, double diemTbHocKy, vn.iback.studentmanager.entity.parents parents, vn.iback.studentmanager.entity.classSchool classSchool) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dayIntoSchool = dayIntoSchool;
        this.birthday = birthday;
        this.diemTichLuy = diemTichLuy;
        this.diemTbHocKy = diemTbHocKy;
        this.parents = parents;
        this.classSchool = classSchool;
    }

    public double getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(double diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public double getDiemTbHocKy() {
        return diemTbHocKy;
    }

    public void setDiemTbHocKy(double diemTbHocKy) {
        this.diemTbHocKy = diemTbHocKy;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDayIntoSchool() {
        return dayIntoSchool;
    }

    public void setDayIntoSchool(Date dayIntoSchool) {
        this.dayIntoSchool = dayIntoSchool;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public vn.iback.studentmanager.entity.parents getParents() {
        return parents;
    }

    public void setParents(vn.iback.studentmanager.entity.parents parents) {
        this.parents = parents;
    }

    public vn.iback.studentmanager.entity.classSchool getClassSchool() {
        return classSchool;
    }

    public void setClassSchool(vn.iback.studentmanager.entity.classSchool classSchool) {
        this.classSchool = classSchool;
    }
}
