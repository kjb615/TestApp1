package sss.test.com.mgrmember.person;

import android.content.ContentValues;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-11-06.
 */

public class PersonDefault implements Serializable {
    String idx="0";
    String id="";
    String name="";
    String pwd="";
    String pwd2="";
    String contact="";
    String addr="";
    String memo="";
    String birthday="";
    String bnum="";
    String grade="";
    String feeGrade="";
    String regDate="";

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        /*contentValues.put(PersonHelper.KEY_ID, id);
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
        contentValues.put(PersonHelper.KEY_REGDATE, regDate);*/

        return contentValues;
    }

    public void setContentValues(ContentValues contentValues) {
        /*id = contentValues.getAsString(PersonHelper.KEY_ID);
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
        regDate = contentValues.getAsString(PersonHelper.KEY_REGDATE);*/

    }

}
