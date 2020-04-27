package com.example.iteration1;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class ViewCalender extends Activity {

    @Override
    protected void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.calender_viewing);
        DisplayMetrics CalenderViewingDM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(CalenderViewingDM);
    }
}
