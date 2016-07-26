package androidservice.com.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Utente on 26/07/2016.
 */
public class DataHaandler  {

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String TABLE_NAME = "mytable";
    public static final String DATA_BASE_NAME = "mydatabse";
    public static final int DATA_BASE_VERSION = 1;
    public static final String TABLE_CREATE = "create table mytable (name text not null, email text not null);";

    DataBaseHelper dataBaseHelper;
    public static Context ctx;
    SQLiteDatabase sqLiteDatabase;


    public DataHaandler(Context ctx) {

        this.ctx =ctx;
        dataBaseHelper = new DataBaseHelper(ctx);

    }





    private static class DataBaseHelper extends SQLiteOpenHelper {
        public DataBaseHelper(Context context){

            super(ctx, DATA_BASE_NAME,null,DATA_BASE_VERSION);
        }

        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            try {
                sqLiteDatabase.execSQL(TABLE_CREATE);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }


        }




        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS mytable" );
            onCreate(sqLiteDatabase);


        }
    }

    public DataHaandler open(){
        sqLiteDatabase= dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dataBaseHelper.close();

    }

    public long insertData (String name, String email)
    {

        ContentValues contet = new ContentValues();
        contet.put(NAME, name);
        contet.put(EMAIL,email);
        return sqLiteDatabase.insertOrThrow(TABLE_NAME,null, contet);


    }

    public Cursor retunData ()
    {
        return sqLiteDatabase.query(TABLE_NAME,new String[]{NAME,EMAIL},null,null,null,null,null,null);
    }





}
