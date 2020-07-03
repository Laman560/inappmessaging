package com.indiagold.samplemessage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

class MovementCheck extends LinkMovementMethod {

    private static MovementCheck sInstance;
    private static String toast_data;




    public static MovementCheck getInstance() {
        if (sInstance == null)
            sInstance = new MovementCheck();
        return sInstance;
    }

    @Override
    public boolean onTouchEvent( TextView widget,
                                Spannable buffer, MotionEvent event ) {
        try {
            Log.e("TAG", "touch success");
            return super.onTouchEvent( widget, buffer, event ) ;
        } catch(ActivityNotFoundException ex) {
            Log.e("TAG", "touch failed");
            return true;
        }
    }

}