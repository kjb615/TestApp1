package sss.test.com.mgrmember.person;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonContent {

    public static final List<Person> ITEMS = new ArrayList<Person>();
    public static final Map<String, Person> ITEM_MAP = new HashMap<String, Person>();
    private static PersonController personController;
    private Context context;

    public PersonContent(Context context) {
        this.context = context;
        personController = new PersonController(context);
        //personController.searchAll();
        //addTestData();
        //searchAll();
    }

    public void addItem(Person item) {
        if(item != null) {
            ITEMS.add(item);
            ITEM_MAP.put(item.getId(), item);
        }
    }

    public void removeItem(Person item) {
        String itemID = item.getId();
        String personID = "";

        for(int i=0; i < ITEMS.size(); i++) {
            personID = ITEMS.get(i).getId();
            if(personID.equals(itemID)) {
                ITEMS.remove(i);
            }
        }

        ITEM_MAP.remove(item);
    }

    public void removeAll() {
        personController.removeAll();
    }

    public void clearAll() {
        int rowCount = ITEMS.size();
        if( rowCount> 0) {
            Log.d("PersonContent","===== clearAll 사이즈 : " + rowCount);
            ITEMS.clear();
            ITEM_MAP.clear();
        }
    }

    public void searchAll() {
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        personArrayList = personController.searchAll();
        if(personArrayList != null) {
            int rowCount = personArrayList.size();
            Log.d("PersonContent","===== searchAll 사이즈 : " + rowCount);
            for (int a = 0; a < personArrayList.size(); a++) {
                addItem(personArrayList.get(a));
            }
        }
    }

    public void insert(Person person) {
        personController.insert(person);
    }

    public void remove(Person person) {
        personController.remove(person);
    }

    public void addTestData() {
        personController.removeAll();
        int testcnt = 25;
        for(int a=0; a < testcnt; a++)
        {
            Log.d("PersonContent","===== TestData " + String.valueOf(a+1));

            Person person = new Person();
            person.setIdx(String.valueOf(a+1));
            person.setId("test_id" + String.valueOf(a+1));
            person.setPwd("test_pwd" + String.valueOf(a+1));
            person.setName("test_name" + String.valueOf(a+1));
            person.setAddr("test_addr" + String.valueOf(a+1));

            insert(person);
        }
    }

}
