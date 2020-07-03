package com.indiagold.samplemessage;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final InAppMessageClick inAppMessageClick = new InAppMessageClick();
        FirebaseInAppMessaging.getInstance().addClickListener(inAppMessageClick);
        FirebaseInAppMessaging.getInstance().addImpressionListener(inAppMessageClick);
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(inAppMessageClick);

        TextView textView = findViewById(R.id.helloworld);
        textView.setClickable(true);
        textView.setMovementMethod(MovementCheck.getInstance());
        String text = "<a href='http://www.google.com'> Google </a>";
        textView.setText(Html.fromHtml(text));



    }



}
