package com.example.iteration1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iteration1.DataModels.AgendaItem;
import com.example.iteration1.SQLiteHelper.DatabaseHandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class AgendaAdd extends FragmentActivity implements DatePickerDialog.OnDateSetListener {


    DatabaseHandler dbHandler;
    EditText add_Item_Name;
    TextView set_Date;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.agenda_adding);
        DisplayMetrics AgendaAddingDM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(AgendaAddingDM);


        dbHandler = new DatabaseHandler(getApplicationContext());
        add_Item_Name = findViewById(R.id.add_Item_Name);
        set_Date = findViewById(R.id.view_Date);



        Button date_Select = findViewById(R.id.date_Select);
        date_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        //Add Agenda
        Button Add_Item = findViewById(R.id.Add_Item);
        Add_Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!TextUtils.isEmpty(add_Item_Name.getText().toString()) && !set_Date.getText().toString().contains("Date")){
                    dbHandler.addAgenda(new AgendaItem(add_Item_Name.getText().toString(),set_Date.getText().toString() ));
                    Toast.makeText(getApplicationContext(),"Agenda Has been added Successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Enter the Agenda Name and also Pick the Date",Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"Enter the Agenda Name and also Pick the Date",Toast.LENGTH_LONG).show();
                }

            }
        });


    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String current_Date_Set = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());


        set_Date.setText(current_Date_Set);
    }
}





