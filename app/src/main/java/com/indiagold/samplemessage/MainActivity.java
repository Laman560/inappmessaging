package com.indiagold.samplemessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity implements FirebaseInAppMessagingClickListener, FirebaseInAppMessagingImpressionListener, FirebaseInAppMessagingDisplay {

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

        final InAppMessageClick inAppMessageClick = new InAppMessageClick();
        FirebaseInAppMessaging.getInstance().addClickListener(inAppMessageClick);

        InAppMessageClick inAppMessageClick2 = new InAppMessageClick();
        FirebaseInAppMessaging.getInstance().addImpressionListener(inAppMessageClick2);

        InAppMessageClick inAppMessageClick3 = new InAppMessageClick();
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(inAppMessageClick3);


        FirebaseInAppMessaging.getInstance().addClickListener(new FirebaseInAppMessagingClickListener() {
            @Override
            public void messageClicked(@NonNull InAppMessage inAppMessage, @NonNull Action action) {
                Log.d("Message Click", "Executor");
            }
        });

        FirebaseInAppMessaging.getInstance().addClickListener(inAppMessageClick2, new Executor() {
            @Override
            public void execute(Runnable command) {
                Log.d("Impression", "Executor");
            }
        });


        FirebaseInAppMessaging.getInstance().addClickListener(inAppMessageClick3, new Executor() {
            @Override
            public void execute(Runnable command) {
                Log.d("Message Display", "Executor");
            }
        });




}

    String TAG = "InAppMessageClick";
    @Override
    public void messageClicked(InAppMessage inAppMessage, Action action) {
        String url = action.getActionUrl();
        Log.d(TAG, "Action URL : "+url);
    }
    @Override
    public void impressionDetected(InAppMessage inAppMessage) {
        Log.d(TAG, "impressionDetected "+inAppMessage.getCampaignMetadata().getCampaignName());
        Log.d(TAG, "metadata "+inAppMessage.getCampaignMetadata());
    }
    @Override
    public void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks
            firebaseInAppMessagingDisplayCallbacks) {
        Log.d(TAG, "displayMessage Action URL : "+inAppMessage.getCampaignMetadata().getCampaignName());
    }


}
