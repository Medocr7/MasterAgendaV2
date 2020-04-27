package com.example.iteration1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iteration1.MainActivity;
import com.example.iteration1.R;
import com.example.iteration1.ViewAllAgendas;

public class AgendaViewAdapter extends RecyclerView.Adapter<AgendaViewAdapter.MyViewHolder> {

    Context mContext;

    public AgendaViewAdapter(Context _context){
        mContext = _context;
    }


    @Override
    public AgendaViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaViewAdapter.MyViewHolder holder, int position) {
        holder.agenda_view_id.setText("ID: " + ViewAllAgendas.viewAllDataList.get(position).get_id());
        holder.agenda_view_name.setText("Name: " + ViewAllAgendas.viewAllDataList.get(position).getAgendaName());
        holder.agenda_view_date.setText("Date: " + ViewAllAgendas.viewAllDataList.get(position).getAgendaDate());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView agenda_view_id, agenda_view_name,agenda_view_date;


        MyViewHolder(View view) {
            super(view);
            agenda_view_id = view.findViewById(R.id.agenda_view_id);
            agenda_view_name = view.findViewById(R.id.agenda_view_name);
            agenda_view_date = view.findViewById(R.id.agenda_view_date);

        }
    }



    @Override
    public int getItemCount() {
        return ViewAllAgendas.viewAllDataList.size();
    }
}
