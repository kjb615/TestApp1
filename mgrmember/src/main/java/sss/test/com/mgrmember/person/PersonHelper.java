package sss.test.com.mgrmember.person;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-11-06.
 */

public class PersonHelper extends SQLiteOpenHelper {
    private Context context;
    private SQLiteDatabase db;
    private final String TABLENAME = "FC_MEMBER";
    public static final String DB_NAME = "FC_MGR_1";
    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "pwd";
    public static final String KEY_PASSWORD_CONFIRM = "pwd2";
    public static final String KEY_IDX = "idx";
    public static final String KEY_NAME = "name";
    public static final String KEY_CONTACT = "contact";
    public static final String KEY_ADDR = "addr";
    public static final String KEY_MEMO = "memo";
    public static final String KEY_BIRTHDAY = "birthday";
    public static final String KEY_BNUM = "bnum";
    public static final String KEY_GRADE = "grade";
    public static final String KEY_GRADE_FEE = "feeGrade";
    public static final String KEY_REGDATE = "regDate";


    public PersonHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //createTable();
        Log.d("PersonHelper","===== 생성 시작");
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLENAME + "("
                + KEY_IDX + " INTEGER PRIMARY KEY, "
                + KEY_ID + " TEXT, "
                + KEY_NAME + " TEXT, "
                + KEY_PASSWORD + " TEXT, "
                + KEY_PASSWORD_CONFIRM + " TEXT, "
                + KEY_ADDR + " TEXT, "
                + KEY_MEMO + " TEXT, "
                + KEY_BIRTHDAY + " TEXT, "
                + KEY_BNUM + " TEXT, "
                + KEY_GRADE + " TEXT, "
                + KEY_GRADE_FEE + " TEXT, "
                + KEY_CONTACT + " TEXT, "
                + KEY_REGDATE + " TEXT "
                + ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("PersonHelper","===== 생성 끝");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("PersonHelper","===== 업그레이드");

        //존재하는 테이블 삭제
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLENAME);

        //테이블 만들기
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Person> search(Person condition) {
        Log.d("PersonHelper","===== 검색 시작");
        SQLiteDatabase db = getReadableDatabase();

        String sql = "";
        SQLiteQueryBuilder sqb = new SQLiteQueryBuilder();
        sqb.setTables(TABLENAME);
        //sqb.buildQuery(반환컬럼, 조건문, 그룹, 그룹조건, 정렬, 최대행갯수);
        if(condition == null) {
            Log.d("PersonHelper","===== 검색 조건 없음");
            sql = sqb.buildQuery(null, null, null, null, null, null);
        } else {
            sqb.appendWhereEscapeString("id = 'abc123'");
            sql = sqb.buildQuery(null, null, null, null, null, null);
        }

        int columnPosition = 0;
        int rowCount = 0;
        String columnValue = "";

        ArrayList<Person> arrayList = new ArrayList<Person>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor == null)
        {
            return null;
        }

        rowCount = cursor.getCount();
        if (rowCount > 0)
        {
            for(int rowPosition=0; rowPosition < rowCount; rowPosition++ ) {
                cursor.moveToNext();

                ContentValues contentValues = new ContentValues();
                for (String key : cursor.getColumnNames()) {
                    columnPosition = cursor.getColumnIndex(key);
                    columnValue = cursor.getString(columnPosition);
                    contentValues.put(key, columnValue);
                }

                Person person = new Person();
                person.setContentValues(contentValues);
                Log.d("PersonHelper","===== id : " + person.getId());
                arrayList.add(person);
            }
        }

        Log.d("PersonHelper","===== 검색 끝 : " + rowCount);

        return arrayList;

    }

    public Person viewInfomation(Person condition) {
        Person person = new Person();

        return person;
    }

    public void insert(ContentValues contentValues) {
        Log.d("PersonHelper","===== 추가");
        db = getWritableDatabase();

        db.insert(TABLENAME, null, contentValues);
    }

    public void removeAll() {
        Log.d("PersonHelper","===== 전체삭제");
        db = getWritableDatabase();
        db.delete(TABLENAME,null,null);
    }

    public void remove(ContentValues contentValues) {
        Log.d("PersonHelper","===== 선택삭제");
        db = getWritableDatabase();

        String[] strWhere = {contentValues.getAsString(KEY_ID)};
        //db.delete(테이블명, 조건컬럼, 조건값);
        db.delete(TABLENAME, KEY_ID + "=?", strWhere);
    }
}
