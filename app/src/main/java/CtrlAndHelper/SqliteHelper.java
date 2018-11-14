package CtrlAndHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.joakk.aplicacion_test.utilidades.Utilidades;

public class SqliteHelper extends SQLiteOpenHelper{


    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(Utilidades.sqlCreate_Table_Products);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists productos");

        sqLiteDatabase.execSQL(Utilidades.sqlCreate_Table_Products);
    }
}
