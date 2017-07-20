package pl.com.andrzejgrzyb.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper habitDbHelper = new DbHelper(this);
        long date = System.currentTimeMillis();

        habitDbHelper.insertEntry(date, "Coding", "Udacity Habit Tracker App");
        habitDbHelper.insertEntry(date, "Dinner", "Pancakes");
        Cursor cursor = habitDbHelper.getEntries();
        while (cursor.moveToNext()) {
            Log.v("MainActivity", "Habit: " +
                    cursor.getLong(0) + ", " +
                    cursor.getLong(1) + ", " +
                    cursor.getString(2) + ", " +
                    cursor.getString(3));
        }
    }
}
