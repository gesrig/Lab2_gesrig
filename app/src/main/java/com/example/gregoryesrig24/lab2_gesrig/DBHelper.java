package com.example.gregoryesrig24.lab2_gesrig;

/**
 * Created by gregoryesrig24 on 4/2/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    public SQLiteDatabase db;
    public static String DATABASE_NAME = "team.db";
    public static int DATABASE_VERSION = 1;
    public static String TABLE_TEAM = "TEAM";
    public static String COL_NAME = "team_name";
    public static String COL_LOGO = "team_logo";
    public static String COL_DATE = "team_date";
    public static String COL_SCORE = "team_score";
    public static String COL_ARENA = "team_arena";
    public static String COL_RECORD = "team_record";
    public static String COL_MASCOT = "team_mascot";

    public static String TABLE_IMAGES = "Game_Images";
    public static String COL_IMAGE_ID = "_id";
    public static String COL_IMAGE = "image";
    public static String COL_GAME_ID = "game_id";
    public static String COL_URI = "uri";
    public static String COL_DATE1 = "date";

    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_TEAM + " ( " + COL_NAME + " TEXT," +
                COL_LOGO + " TEXT," + COL_DATE + " TEXT," + COL_SCORE + " TEXT," + COL_ARENA + " TEXT,"
                + COL_RECORD + " TEXT," + COL_MASCOT + " TEXT )");
        db.execSQL("CREATE TABLE " + TABLE_IMAGES + " ( " + COL_IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_GAME_ID + " INTEGER, " +  COL_IMAGE + " BLOB, " +
                COL_DATE1 + " TEXT," + COL_URI + " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists " + TABLE_TEAM );
        db.execSQL("DROP TABLE if exists " + TABLE_IMAGES );
        onCreate(db);
    }

    public void insertTeamData(Team team) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, team.getTeamName());
        contentValues.put(COL_LOGO, team.getTeamLogo());
        contentValues.put(COL_DATE, team.getGameDate());
        contentValues.put(COL_SCORE, team.getGameScore());
        contentValues.put(COL_ARENA, team.getTeamArena());
        contentValues.put(COL_RECORD, team.getTeamRecord());
        contentValues.put(COL_MASCOT, team.getTeamMascot());
        long ret = db.insert(TABLE_TEAM, null, contentValues );

        if (ret > -1) {
            System.out.println("Successfully inserted");
        } else {
            System.out.println("Insert Unsuccessful");
        }

        db.close();
    }

    public void insertImageData(String tblName, ContentValues contentValues) {
        SQLiteDatabase db = getWritableDatabase();

        long ret = db.insert(tblName, null, contentValues );

        if (ret > 0) {
            System.out.println("Successfully inserted");
        } else {
            System.out.println("Insert Unsuccessful");
        }

        db.close();
    }

    public void deleteData(String TeamName) {
        db = getWritableDatabase();
        // db.execSQL("DELETE FROM " + TABLE_BOOK + " WHERE _id = " + book_id );

//        db.delete(TABLE_TEAM, " COL_NAME = ?", new String[]{Integer.toString(TeamName)});
        db.delete(TABLE_TEAM, " COL_NAME = ?", new String[]{TeamName});
        db.close();
    }

    public ArrayList<Team> createArrList() {
        db = getReadableDatabase();

        ArrayList<Team> gamearray = new ArrayList<Team>();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_TEAM, new String[]{});
        c.moveToFirst();
         do {
            String name = c.getString(c.getColumnIndex(COL_NAME));
            String logo = c.getString(c.getColumnIndex(COL_LOGO));
            String date = c.getString(c.getColumnIndex(COL_DATE));
            String score = c.getString(c.getColumnIndex(COL_SCORE));
            String arena = c.getString(c.getColumnIndex(COL_ARENA));
            String record = c.getString(c.getColumnIndex(COL_RECORD));
            String mascot = c.getString(c.getColumnIndex(COL_MASCOT));
            Team teamobj = new Team(new String[] {logo, name, date, score, arena, record, mascot});
            gamearray.add(teamobj);
        }while (c.moveToNext());

        return gamearray;
    }

    public Cursor getAllEntries(String tblName, String[] columns) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(tblName, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor getSelectEntries(String tblName, String[] columns, String where, String[] args, String orderBy) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(tblName, columns, where, args, null, null, orderBy);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public String[] getTableFields(String tblName) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor dbCursor = db.query(tblName, null, null, null, null, null, null);
        String[] columnNames = dbCursor.getColumnNames();
        return columnNames;
    }



}

