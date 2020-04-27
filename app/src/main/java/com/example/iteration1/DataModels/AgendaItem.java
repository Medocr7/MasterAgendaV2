package com.example.iteration1.DataModels;

public class AgendaItem {

    int id;
    String agendaName;
    String agendaDate;


    public AgendaItem(int _id, String _agendaName, String _agendaDate, String phone_number, String call_duration,String call_event){
        this.id = _id;
        this.agendaName = _agendaName;
        this.agendaDate = _agendaDate;
    }

    public AgendaItem(String _agendaName, String _agendaDate){
        this.agendaName = _agendaName;
        this.agendaDate = _agendaDate;
    }


    public AgendaItem(){   }




    public int get_id() {
        return id;
    }

    public void set_id(int _id) {
        this.id = _id;
    }

    public String getAgendaName() {
        return agendaName;
    }

    public void setAgendaName(String agendaName) {
        this.agendaName = agendaName;
    }

    public String getAgendaDate() {
        return agendaDate;
    }

    public void setAgendaDate(String agendaDate) {
        this.agendaDate = agendaDate;
    }
}
