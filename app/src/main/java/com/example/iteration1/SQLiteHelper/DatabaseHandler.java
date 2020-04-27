package com.example.iteration1.SQLiteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.iteration1.DataModels.AgendaItem;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agendaManager";
    private static final String TABLE_AGENDA = "agenda_table";
    public static List<AgendaItem> agendaList = new ArrayList<AgendaItem>();

    private static final String KEY_ID = "id";
    private static final String KEY_AGENDA_NAME = "agenda_name";
    private static final String KEY_AGENDA_DATE = "agenda_date";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_AGENDA_TABLE = "CREATE TABLE " + TABLE_AGENDA + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_AGENDA_NAME + " TEXT,"
                + KEY_AGENDA_DATE + " TEXT" + ")";
        db.execSQL(CREATE_AGENDA_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AGENDA);

        // Create tables again
        onCreate(db);
    }

    // code to add the new Agenda
    public void addAgenda(AgendaItem agendaItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AGENDA_NAME, agendaItem.getAgendaName()); // Agenda Name
        values.put(KEY_AGENDA_DATE, agendaItem.getAgendaDate()); // Agenda Name
        // Inserting Row
        db.insert(TABLE_AGENDA, null, values);

        db.close(); // Closing database connection


    }



    public List<AgendaItem> getAllAgendaItems() {

        if(agendaList.size()>0){
            agendaList.clear();
        }
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_AGENDA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AgendaItem agendaItem = new AgendaItem();
                agendaItem.set_id(Integer.parseInt(cursor.getString(0)));
                agendaItem.setAgendaName(cursor.getString(1));
                agendaItem.setAgendaDate(cursor.getString(2));

                // Adding contact to list
                agendaList.add(agendaItem);
            } while (cursor.moveToNext());
        }
        return agendaList;
    }



}