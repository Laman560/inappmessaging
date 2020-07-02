package com.indiagold.samplemessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(MainActivity.this);
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String deviceToken = instanceIdResult.getToken();
                Log.d("Instance ID ",deviceToken);
            }
        });

        InAppMessageClick inAppMessageClick = new InAppMessageClick();
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(inAppMessageClick);
        FirebaseInAppMessaging.getInstance().addClickListener(inAppMessageClick);
        FirebaseInAppMessaging.getInstance().addClickListener(inAppMessageClick);

        FirebaseInAppMessaging.getInstance().addClickListener(inAppMessageClick, new Executor() {
            @Override
            public void execute(Runnable command) {
                Log.d("MainActivity", "Executor");
            }
        });


    }


}
