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
        // Determine which URL the user clicked
        String url = action.getActionUrl();
        Log.d(TAG, "Action URL : "+url);
        // Get general information about the campaign
        CampaignMetadata metadata = inAppMessage.getCampaignMetadata();
        Log.d(TAG," Metadata : "+metadata);
    }


    @Override
    public void impressionDetected(InAppMessage inAppMessage) {
        Log.d(TAG, "impressionDetected Action URL : "+inAppMessage.getCampaignMetadata().getCampaignName());
    }

    @Override
    public void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        Log.d(TAG, "displayMessage Action URL : "+inAppMessage.getCampaignMetadata().getCampaignName());

    }
}