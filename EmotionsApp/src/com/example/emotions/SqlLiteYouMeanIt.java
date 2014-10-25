package com.example.emotions;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLiteYouMeanIt extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "EmoDB";
	private static final String TABLE_RESULTS = "Results";
	
	private static final String P_KEY = "id";
	private static final String DAY = "day";
	private static final String INTERVAL = "interval";
	private static final String MOM1 = "mom1";
	private static final String MOM2 = "mom2";
	private static final String MOM3 = "mom3";
	private static final String MOM4 = "mom4";
	private static final String MOM5 = "mom5";
	private static final String MOM0 = "mom0";
	private static final String SF0 = "sf0";
	private static final String SF1 = "sf1";
	private static final String SF2 = "sf2";
	private static final String SF3 = "sf3";
	private static final String SF4 = "sf4";
	private static final String SF5 = "sf5";
	private static final String SF6 = "sf6";
	private static final String SF7 = "sf7";
	private static final String SF8 = "sf8";
	private static final String SF9 = "sf9";
	private static final String ST0 = "st0";
	private static final String ST1 = "st1";
	private static final String ST2 = "st2";
	private static final String DATI = "DateTime";
	
	private static final String[] COLM = {P_KEY,MOM1,MOM2,MOM3,MOM4,MOM5,MOM0,SF0,SF1,SF2,SF3,SF4,SF5 ,SF6 ,SF7, SF8 ,SF9 ,ST0 ,ST1, ST2,DATI};
	
	
	public SqlLiteYouMeanIt(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_RESULTS_TABLE = "Create Table" + TABLE_RESULTS + "(" +
				P_KEY + "INTEGER PRIMARY KEY AUTOINCREMENT" +
				MOM1 + "INTEGER," +
				MOM2 + "INTEGER," +
				MOM3 + "INTEGER," +
				MOM4 + "INTEGER," +
				MOM5 + "INTEGER," +
				MOM0 + "INTEGER," +
				SF0 + "INTEGER," +
				SF1 + "INTEGER," +
				SF2 + "INTEGER," +
				SF3 + "INTEGER," +
				SF4 + "INTEGER," +
				SF5 + "INTEGER," +
				SF6 + "INTEGER," +
				SF7 + "INTEGER," + 
				SF8 + "INTEGER," +
				SF9 + "INTEGER," +
				ST0 + "INTEGER," +
				ST1 + "INTEGER," +
				ST2 + "INTEGER," +
				DATI + "INTEGER," + ")";
		db.execSQL(CREATE_RESULTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_RESULTS);
		this.onCreate(db);
	}
	public void addResult(EmoLog EL)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put(DAY, EL.day);
		values.put(INTERVAL, EL.Interval);
		values.put(MOM1, EL.mom[1]);
		values.put(MOM2, EL.mom[2]);
		values.put(MOM3, EL.mom[3]);
		values.put(MOM4, EL.mom[4]);
		values.put(MOM5, EL.mom[5]);
		values.put(MOM0, EL.mom[0]);
		values.put(SF0, EL.sf[0]);
		values.put(SF1, EL.sf[1]);
		values.put(SF2, EL.sf[2]);
		values.put(SF3, EL.sf[3]);
		values.put(SF4, EL.sf[4]);
		values.put(SF5, EL.sf[5]);
		values.put(SF6, EL.sf[6]);
		values.put(SF7, EL.sf[7]);
		values.put(SF8, EL.sf[8]);
		values.put(SF9, EL.sf[9]);
		values.put(ST0, EL.st[0]);
		values.put(ST1, EL.st[1]);
		values.put(ST2, EL.st[2]);
		values.put(DATI, EL.dati);
		
		db.insert(TABLE_RESULTS, null, values);
		db.close();
	}

}
