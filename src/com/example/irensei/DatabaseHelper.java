package com.example.irensei;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "game.db";
	private static final int DATABASE_VERSION = 2;
	private static final String TABLE_NAME = "result";
	private static final String ID = "id";
	private static final String WINNER = "winner";
	private static final String LOSER = "loser";
	private static final String DATE = "date";
	
	DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		String query = "create table " + TABLE_NAME + "(" + ID +
				" INTEGER PRIMARY KEY AUTOINCREMENT," + WINNER+ " TEXT," + 
				LOSER + " TEXT," + DATE + " TEXT);";
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("drop table if exists " + TABLE_NAME);
		onCreate(db);
	}
	

}
