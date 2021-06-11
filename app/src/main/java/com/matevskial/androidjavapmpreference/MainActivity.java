package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;


/**
 * * This is an activity class since it extends the AppCompatActivity class
 *
 * * An activity is class that is responsible for drawing some user interface,
 * dynamically modify the user interface and handle user interaction
 *
 * * Every activity class is tied to an xml file describing the layout of the user interface
 */
public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "some_channel_id";
    private static final int NOTIFICATION_ID = 0;
    private Button constraintExampleButton;
    private Button listViewExampleButton;
    private Button recyclerViewExampleButton;
    private Button intentExampleButton;
    private Button fragmentExampleButton;
    private Button dialogsExampleButton;
    private Button sqliteExampleButton;
    private Button serviceExampleButton;
    private Button notificationExampleButton;

    /**
     * Predefined methods like this are called for the setup of the activity
     * This method specifies which layout xml file to inflateso it can be displayed and manipulated with
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintExampleButton = findViewById(R.id.constraintExampleButton);
        listViewExampleButton = findViewById(R.id.listViewExampleButton);
        recyclerViewExampleButton = findViewById(R.id.recyclerViewExampleButton);
        intentExampleButton = findViewById(R.id.intentExampleButton);
        fragmentExampleButton = findViewById(R.id.fragmentExampleButton);
        dialogsExampleButton = findViewById(R.id.dialogsExampleButton);
        sqliteExampleButton = findViewById(R.id.sqliteExampleButton);
        serviceExampleButton = findViewById(R.id.serviceExampleButton);
        notificationExampleButton = findViewById(R.id.notificationExampleButton);

        createNotificationChannel();

        constraintExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ConstraintExampleActivity.class);
            startActivity(intent);
        });

        listViewExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListViewExampleActivity.class);
            startActivity(intent);
        });

        recyclerViewExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, RecyclerViewExampleActivity.class);
            startActivity(intent);
        });

        intentExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, IntentExampleActivity.class);
            startActivity(intent);
        });

        fragmentExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, FragmentExampleActivity.class);
            startActivity(intent);
        });

        dialogsExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, DialogsExampleActivity.class);
            startActivity(intent);
        });
        
        sqliteExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, SQLiteExampleActivity.class);
            startActivity(intent);
        });

        serviceExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ServiceExampleActivity.class);
            startActivity(intent);
        });

        notificationExampleButton.setOnClickListener(v -> {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                    .setContentTitle("Example notification")
                    .setContentText("Notification text content")
                    .setChannelId(CHANNEL_ID)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Notification big text content"))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        });
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "some_chanel_name";
            String description = "some_channel_description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if(notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

}