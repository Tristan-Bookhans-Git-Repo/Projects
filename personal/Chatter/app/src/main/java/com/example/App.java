package com.example;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANEL_ID = "MessageChannel";

    public static final String channel_ID_2 = "channelID2";

    public static final String GROUP_1_ID = "group1";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANEL_ID,
                    "Chatter messaging servive",
                    NotificationManager.IMPORTANCE_LOW
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);



            NotificationChannelGroup group1 = new NotificationChannelGroup(
                    GROUP_1_ID,
                    "Chats"
            );

            NotificationChannel Channel1 = new NotificationChannel(
                    channel_ID_2,
                    "Chatter messages",
                    NotificationManager.IMPORTANCE_HIGH
            );
            Channel1.setGroup(GROUP_1_ID);
            manager.createNotificationChannelGroup(group1);
            manager.createNotificationChannel(Channel1);
        }

    }

}
