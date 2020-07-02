package com.indiagold.samplemessage;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.CampaignMetadata;
import com.google.firebase.inappmessaging.model.InAppMessage;

public class InAppMessageClick implements FirebaseInAppMessagingClickListener, FirebaseInAppMessagingImpressionListener, FirebaseInAppMessagingDisplay  {
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
    public void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        Log.d(TAG, "displayMessage Action URL : "+inAppMessage.getCampaignMetadata().getCampaignName());
    }
}
