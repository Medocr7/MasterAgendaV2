package com.example.iteration1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.iteration1.Adapters.AgendaViewAdapter;
import com.example.iteration1.DataModels.AgendaItem;
import com.example.iteration1.SQLiteHelper.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class ViewAllAgendas extends AppCompatActivity {

    DatabaseHandler dbHandler;
    RecyclerView recyclerViewAgendaMaster;
    AgendaViewAdapter adapter;
    public static List<AgendaItem> viewAllDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_data);

        dbHandler = new DatabaseHandler(getApplicationContext());

        if(viewAllDataList.size()>0){
            viewAllDataList.clear();
        }

        //View all entered Agends
        dbHandler.getAllAgendaItems();
        if(DatabaseHandler.agendaList.size()>0){
            for(int i=0;i < DatabaseHandler.agendaList.size(); i++){
                AgendaItem agendaItem = new AgendaItem();
                agendaItem.set_id(DatabaseHandler.agendaList.get(i).get_id());
                agendaItem.setAgendaName(DatabaseHandler.agendaList.get(i).getAgendaName());
                agendaItem.setAgendaDate(DatabaseHandler.agendaList.get(i).getAgendaDate());
                viewAllDataList.add(agendaItem);

                Toast.makeText(ViewAllAgendas.this,"Agenda Name: " + DatabaseHandler.agendaList.get(i).getAgendaName() +
                        "Agenda Date: " + DatabaseHandler.agendaList.get(i).getAgendaDate(),Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(ViewAllAgendas.this,"No Agenda List Found",Toast.LENGTH_LONG).show();
        }



        recyclerViewAgendaMaster = findViewById(R.id.recyclerViewAgendaMaster);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewAgendaMaster.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
        adapter = new AgendaViewAdapter(getApplicationContext());
        recyclerViewAgendaMaster.setAdapter(adapter);


    }
}
