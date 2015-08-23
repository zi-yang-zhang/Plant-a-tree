package com.plantatree.plantatree.util;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by robertzhang on 2015-08-22.
 */
public class ForestDataBase {
	private SQLiteDatabase database;

//	public class DBHelper extends SQLiteOpenHelper {
//
//		public static final String TABLE_AVEREAGE_HEIGHT = "average_height";
//		public static final String COLUMN_ID = "_id";
//		public static final String COLUMN_COMMENT = "height";
//
//		private static final String DATABASE_NAME = "forest.db";
//		private static final int DATABASE_VERSION = 1;
//
//		// Database creation sql statement
//		private static final String DATABASE_CREATE = "create table "
//				+ TABLE_AVEREAGE_HEIGHT + "(" + COLUMN_ID
//				+ " integer primary key autoincrement, " + COLUMN_COMMENT
//				+ " text not null);";
//
//		public DBHelper(Context context) {
//			super(context, DATABASE_NAME, null, DATABASE_VERSION);
//		}
//
//		@Override
//		public void onCreate(SQLiteDatabase database) {
//			database.execSQL(DATABASE_CREATE);
//		}
//
//		@Override
//		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//			Log.w(DBHelper.class.getName(),
//					"Upgrading database from version " + oldVersion + " to "
//							+ newVersion + ", which will destroy all old data");
//			db.execSQL("DROP TABLE IF EXISTS " + TABLE_AVEREAGE_HEIGHT);
//			onCreate(db);
//		}
}
