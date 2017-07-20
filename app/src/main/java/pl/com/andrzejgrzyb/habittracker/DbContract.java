package pl.com.andrzejgrzyb.habittracker;

import android.provider.BaseColumns;

/**
 * Created by Andrzej on 20.07.2017.
 */

public class DbContract {

    public class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DATE = "date";
        public final static String COLUMN_HABIT = "habit";
        public final static String COLUMN_COMMENT = "comment";
    }
}
