package sss.test.com.mgrmember.person;

import android.content.ContentValues;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-11-06.
 */

public class Person extends PersonDefault {
    private String idx;
    private String id;
    private String name;
    private String pwd;
    private String pwd2;
    private String contact;
    private String addr;
    private String memo;
    private String birthday;
    private String bnum;
    private String grade;
    private String feeGrade;
    private String regDate;

    public Person() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd2() {
        return pwd2;
    }

    public void setPwd2(String pwd2) {
        this.pwd2 = pwd2;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBnum() {
        return bnum;
    }

    public void setBnum(String bnum) {
        this.bnum = bnum;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFeeGrade() {
        return feeGrade;
    }

    public void setFeeGrade(String feeGrade) {
        this.feeGrade = feeGrade;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonHelper.KEY_ID, id);
        contentValues.put(PersonHelper.KEY_PASSWORD, pwd);
        contentValues.put(PersonHelper.KEY_NAME, name);
        contentValues.put(PersonHelper.KEY_GRADE, grade);
        contentValues.put(PersonHelper.KEY_BNUM, bnum);
        contentValues.put(PersonHelper.KEY_BIRTHDAY, birthday);
        contentValues.put(PersonHelper.KEY_GRADE_FEE, feeGrade);
        contentValues.put(PersonHelper.KEY_MEMO, memo);
        contentValues.put(PersonHelper.KEY_ADDR, addr);
        contentValues.put(PersonHelper.KEY_CONTACT, contact);
        contentValues.put(PersonHelper.KEY_PASSWORD_CONFIRM, pwd2);
        contentValues.put(PersonHelper.KEY_IDX, idx);
        contentValues.put(PersonHelper.KEY_REGDATE, regDate);

        return contentValues;
    }

    @Override
    public void setContentValues(ContentValues contentValues) {
        id = contentValues.getAsString(PersonHelper.KEY_ID);
        pwd = contentValues.getAsString(PersonHelper.KEY_PASSWORD);
        name = contentValues.getAsString(PersonHelper.KEY_NAME);
        grade = contentValues.getAsString(PersonHelper.KEY_GRADE);
        bnum = contentValues.getAsString(PersonHelper.KEY_BNUM);
        birthday = contentValues.getAsString(PersonHelper.KEY_BIRTHDAY);
        feeGrade = contentValues.getAsString(PersonHelper.KEY_GRADE_FEE);
        memo = contentValues.getAsString(PersonHelper.KEY_MEMO);
        addr = contentValues.getAsString(PersonHelper.KEY_ADDR);
        contact = contentValues.getAsString(PersonHelper.KEY_CONTACT);
        pwd2 = contentValues.getAsString(PersonHelper.KEY_PASSWORD_CONFIRM);
        idx = contentValues.getAsString(PersonHelper.KEY_IDX);
        regDate = contentValues.getAsString(PersonHelper.KEY_REGDATE);

    }

}
