package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

public final class TodoContract {

    // TODO 1. 定义创建数据库以及升级的操作（完成）
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TodoNote.TABLE_NAME
                    + "(" + TodoNote._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TodoNote.COLUMN_NAME_DATE + " INTEGER, "
                    + TodoNote.COLUMN_NAME_STATE + " INTEGER, "
                    + TodoNote.COLUMN_NAME_CONTENT + " TEXT, "
                    + TodoNote.COLUMN_NAME_PRIORITY + " INTEGER)";

    public static final String SQL_UPGRADE_COLUMN =
            "ALTER TABLE " + TodoNote.TABLE_NAME + " ADD " + TodoNote.COLUMN_NAME_PRIORITY + " INTEGER";

    private TodoContract() {
    }

    public static class TodoNote implements BaseColumns {
        // TODO 2.此处定义表名以及列明（完成）
        public static final String TABLE_NAME = "note";

        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_STATE = "state";
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_PRIORITY = "priority";
    }

}
