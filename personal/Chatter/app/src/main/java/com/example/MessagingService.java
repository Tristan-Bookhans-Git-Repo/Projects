package com.example;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.material.internal.ContextUtils;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MessagingService extends Service {

    private Context context;

    private Handler mHandler = new Handler();


    OkHttpClient client = new OkHttpClient();
    OkHttpClient client1 = new OkHttpClient();

    SharedPreferences User;
    String myUsername;

    SharedPreferences MessageNum;


    @Override
    public void onCreate() {

        context = this;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        context = this;

        mHandler.postDelayed(checkMessage, 15000);

        User = getSharedPreferences("mypref", MODE_PRIVATE);
        MessageNum = getSharedPreferences("numMessages", MODE_PRIVATE);

        myUsername = User.getString("User", "");



        Notification notification = new NotificationCompat.Builder(this, App.CHANEL_ID)
                .setContentTitle("Chatter")
                .setContentText("Checking for New Messages")
                .setSmallIcon(R.drawable.logo)
                .build();

        startForeground(10000, notification);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mHandler.removeCallbacks(checkMessage);
        super.onDestroy();
    }

    private Runnable checkMessage = new Runnable() {


        @Override
        public void run() {

            RequestBody formbody = new FormBody.Builder()
                    .add("username", myUsername)
                    .build();

            Request request = new Request.Builder()
                    .url(Config.BASE_URL + "getChats.php?")
                    .post(formbody)
                    .build();

            client.newCall(request).enqueue((new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        final String myResponse = response.body().string();
                        try {
                            JSONArray all = new JSONArray(myResponse);
                            for (int i = 0; i < all.length(); i++) {
                                JSONObject item = all.getJSONObject(i);
                                final String ChatName;
                                final String fName;
                                final String sName;
                                final int j = i+1;
                                fName = item.getString("FNAME");
                                sName = item.getString("SNAME");
                                ChatName = item.getString("CHATNAME");
                                final int Num = MessageNum.getInt(ChatName, 0);
                                RequestBody formbody = new FormBody.Builder()
                                        .add("chat", ChatName)
                                        .build();
                                Request request = new Request.Builder()
                                        .url(Config.BASE_URL + "getMessages.php?")
                                        .post(formbody)
                                        .build();

                                client1.newCall(request).enqueue(new Callback() {
                                    @Override
                                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                        e.printStackTrace();
                                    }

                                    @Override
                                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                                        if (response.isSuccessful()) {
                                            final String myResponse = response.body().string();
                                            try {
                                                JSONArray all = new JSONArray(myResponse);
                                                if (all.length() > Num) {

                                                    Intent intent = new Intent(getApplicationContext(), ChatScreen.class);
                                                    intent.putExtra("fname",fName);
                                                    intent.putExtra("sname",sName);
                                                    intent.putExtra("ChatName",ChatName);
                                                    intent.putExtra("num",j);
                                                    //Toast.makeText(getApplicationContext(),ChatName,Toast.LENGTH_LONG).show();

                                                    PendingIntent pendingintent = PendingIntent.getActivity(getApplicationContext(),j,intent,0);

                                                    Notification notification = new NotificationCompat.Builder(MessagingService.this, App.channel_ID_2)
                                                            .setContentTitle("Chatter")
                                                            .setContentText("New Message from "+ fName)
                                                            .setSmallIcon(R.drawable.logo)
                                                            .setOnlyAlertOnce(true)
                                                            .setAutoCancel(true)
                                                            .setContentIntent(pendingintent)
                                                            .build();

                                                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MessagingService.this);
                                                    notificationManager.notify(j, notification);
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                });


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }));
            mHandler.postDelayed(this, 15000);
        }

    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
