package com.example.iteration1;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class AgendaViewing extends Activity {

    @Override
protected void onCreate (Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.agenda_viewing);
        DisplayMetrics AgendaViewingDM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(AgendaViewingDM);


    }

}
