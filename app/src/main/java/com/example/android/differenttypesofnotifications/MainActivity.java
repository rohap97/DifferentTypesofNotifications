package com.example.android.differenttypesofnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_simple, btn_bigtext, btn_bigpicture, btn_inbox, btn_mesaging, btn_actions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_simple = (Button) findViewById(R.id.simpleNot);
        btn_bigtext = (Button) findViewById(R.id.bigtextNot);
        btn_bigpicture = (Button) findViewById(R.id.bigpictureNot);
        btn_inbox = (Button) findViewById(R.id.inboxNot);
        btn_mesaging = (Button) findViewById(R.id.messagingNot);
        btn_actions = (Button) findViewById(R.id.actionNot);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.simpleNot:
            simple_Notification();
            break;

            case R.id.bigtextNot:
                big_textStyle_Notification();
                break;

            case R.id.bigpictureNot:
                big_picturestyle_Notification();
                break;

            case R.id.inboxNot:
                inboxstyle_Notification();
                break;

            case R.id.messagingNot:
                messagingstyle_Notification();
                break;

            case R.id.actionNot:
                notification_Actions();
                break;
        }
    }

    private void simple_Notification() {


        int notificationId = 0;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.midoriya)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.midoriya))
                .setContentTitle("Android Fucking Development Course")
                .setContentText("Become a fucking Android developer")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());
    }

    private void big_textStyle_Notification() {
        int notificationId = 1;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.midoriya)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.midoriya))
                .setContentTitle("Midoriya to himself")
                .setContentText("Dreams can become Reality")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(getResources().getString(R.string.quote)))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());
    }

    private void big_picturestyle_Notification(){
        int notificationId = 2;

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.midoriya);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.midoriya)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.midoriya))
                .setContentTitle("Big Picture Midoriya")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());
    }

    private void inboxstyle_Notification(){

        int notificationId = 3;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.midoriya)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.midoriya))
                .setStyle(new NotificationCompat.InboxStyle().addLine("Hello").addLine("Are you There?").
                        setBigContentTitle("2 New Messages for you").setSummaryText("Inbox"))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());


    }

    private void messagingstyle_Notification(){
        int notificationId = 4;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.midoriya)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.midoriya))
                .setStyle(new NotificationCompat.MessagingStyle("Ali: ").setConversationTitle("Q && A Group")
                .addMessage("This type of notification was introduced in Android N. Right?", 0, "Umar: ")
                .addMessage("Yes", 0, null)
                .addMessage("The constructor is passed with the name of the current user. Right?", 0 , "Billal: ")
                .addMessage("True", 0, null))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());

    }

    private void notification_Actions(){
        int notificationId = 5;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.midoriya)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.midoriya))
                .setContentTitle("Action Buttons")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Click view to visit Google."))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.co.in"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.addAction(R.drawable.midoriya, "View1", pendingIntent);
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());



    }


}
