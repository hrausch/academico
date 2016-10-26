package br.cefetmg.sqllite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hrausch on 26/10/16.
 */
public class DatabaseConector {

    private static final String DB_NAME = "Enderecos";
    private SQLiteDatabase database;
    private DatabaseOpenHelper dbHelper;

    public DatabaseConector(Context context){

        dbHelper = new DatabaseOpenHelper(context, DB_NAME, null, 1);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        if(database != null) {
            database.close();
            dbHelper.close();
        }
    }

    public void insertEndereco(String rua, String estado, String cidade){

        ContentValues content = new ContentValues();

        content.put("rua", rua);
        content.put("estado", estado);
        content.put("cidade", cidade);

        database.insert("enderecos", null, content);

    }

    public Cursor getAllEnderecos(){
        return database.query("enderecos",null,null,null,null,null,null);
    }

    private class DatabaseOpenHelper extends SQLiteOpenHelper {

        public DatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){

            String create = "CREATE TABLE enderecos" +
                    " (_id integer primary key autoincrement, "+
                    "rua TEXT, estado TEXT, cidade TEXT );";

            db.execSQL(create);

            db.execSQL("INSERT INTO enderecos (rua, estado, cidade) VALUES ('imigrates', 'MG', 'vga')");
            db.execSQL("INSERT INTO enderecos (rua, estado, cidade) VALUES ('imigrates 1000', 'MG', 'vga')");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
