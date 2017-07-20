package pl.com.andrzejgrzyb.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Andrzej on 20.07.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habitDatabase";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_HABITS = "CREATE TABLE " + DbContract.HabitEntry.TABLE_NAME +
                "(" + DbContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DbContract.HabitEntry.COLUMN_DATE + " INTEGER NOT NULL," +
                DbContract.HabitEntry.COLUMN_HABIT + " STRING NOT NULL," +
                DbContract.HabitEntry.COLUMN_COMMENT + " STRING);";
        Log.v("DbHelper", "Creating table: " + CREATE_TABLE_HABITS);
        sqLiteDatabase.execSQL(CREATE_TABLE_HABITS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertEntry(long date, String habit, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbContract.HabitEntry.COLUMN_DATE, date);
        values.put(DbContract.HabitEntry.COLUMN_HABIT, habit);
        values.put(DbContract.HabitEntry.COLUMN_COMMENT, comment);
        db.insert(DbContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor getEntries() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                DbContract.HabitEntry._ID,
                DbContract.HabitEntry.COLUMN_DATE,
                DbContract.HabitEntry.COLUMN_HABIT,
                DbContract.HabitEntry.COLUMN_COMMENT
        };
        Cursor cursor = db.query(
                DbContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}