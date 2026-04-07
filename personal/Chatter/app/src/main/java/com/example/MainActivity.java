package com.example;

import android.app.AlarmManager;
import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ui.main.SectionsPagerAdapter;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    SharedPreferences User;
    String myUsername;

    SharedPreferences MessageNum;

    //private Handler mHandler = new Handler();


    Intent serviceintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        serviceintent = new Intent(this, MessagingService.class);
        stopService(serviceintent);



        //mHandler.removeCallbacks(checkMessage);

        User = getSharedPreferences("mypref", MODE_PRIVATE);
        MessageNum = getSharedPreferences("numMessages", MODE_PRIVATE);

        if (!User.contains("User")) {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        } else {
            myUsername = User.getString("User", "");
        }

        /*if (this.isDestroyed() && this.isFinishing()) {
            serviceintent = new Intent(this, MessagingService.class);
            startForegroundService(serviceintent);
        }*/

    }

    @Override
    public void onBackPressed(){
        serviceintent = new Intent(this, MessagingService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            startForegroundService(serviceintent);
        }else{
            startService(serviceintent);
        }
        MainActivity.this.finish();
    }

    @Override
    protected void onStart() {

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();

        serviceintent = new Intent(this, MessagingService.class);
        stopService(serviceintent);

        super.onStart();
    }

    @Override
    protected void onStop() {
        serviceintent = new Intent(this, MessagingService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            startForegroundService(serviceintent);
        }else{
            startService(serviceintent);
        }
        super.onStop();
    }

    /*private Runnable checkMessage = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient();

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
                                final String fName;
                                final String sName;
                                final String ChatName;
                                final int numMessages;

                                ChatName = item.getString("CHATNAME");
                                fName = item.getString("FNAME");
                                sName = item.getString("SNAME");
                                numMessages = item.getInt("NUMMESSAGES");

                                int Num = MessageNum.getInt(ChatName, 0);

                                if (numMessages>Num){
                                    AlarmManager alarmmanager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                                    Intent intent = new Intent(MainActivity.this,AlertReciever.class);
                                    PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,1,intent,0);
                                }


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }));
            //mHandler.postDelayed(this,15000);
        }

    };*/

}