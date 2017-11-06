package sss.test.com.mgrmember.person;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-11-06.
 */

public class PersonController {
    private Context context;
    private PersonHelper personHelper;

    public PersonController(Context context) {
        this.context = context;
        this.personHelper = new PersonHelper(context, PersonHelper.DB_NAME, null, 1);
    }

    public ArrayList<Person> searchAll() {
        ArrayList<Person> arrayList = new ArrayList<Person>();
        arrayList = personHelper.search(null);
        int rowCount = arrayList.size();
        Log.d("PersonController","===== searchAll 사이즈 : " + rowCount);
        return arrayList;
    }

    public ArrayList<Person> search(ContentValues contentValues) {
        ArrayList<Person> arrayList = new ArrayList<Person>();
        arrayList = personHelper.search(new Person());

        return arrayList;
    }

    public void insert(Person person) {
        personHelper.insert(person.getContentValues());
    }

    public void removeAll() {
        personHelper.removeAll();
    }

    public void remove(Person person) {
        personHelper.remove(person.getContentValues());
    }
}
