package com.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

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

public class ChatScreen extends AppCompatActivity {

    private Handler mHandler = new Handler();

    SharedPreferences User;
    String Username;

    SharedPreferences MessageNum;
    SharedPreferences.Editor Messeditor;

    EditText message1;
    ImageButton send;

    String ChatName;

    LinearLayout layout;
    LinearLayout chat;

    RelativeLayout back;

    ScrollView scroll;

    Toolbar toolBar;

    OkHttpClient client = new OkHttpClient();
    OkHttpClient client1 = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        back = findViewById(R.id.MAinAct);
        back.setBackgroundColor(Color.DKGRAY);

        MessageNum = getSharedPreferences("numMessages", Context.MODE_PRIVATE);
        Messeditor = MessageNum.edit();

        User = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        Username = User.getString("User", "");

        Intent intent = getIntent();
        String title = intent.getStringExtra("fname") + " " + intent.getStringExtra("sname");
        ChatName = intent.getStringExtra("ChatName");

        int NotiNum = intent.getIntExtra("num",-1);

        if (NotiNum!=-1) {
            NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(NotiNum);
        }

        //Toast.makeText(getApplicationContext(),ChatName,Toast.LENGTH_LONG).show();

        if (!MessageNum.contains(ChatName)) {
            Messeditor.putInt(ChatName, 0);
            Messeditor.commit();
        }

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        toolBar = findViewById(R.id.toolBar);
        toolBar.setTitle(title);

        message1 = findViewById(R.id.message);
        message1.setBackgroundResource(R.drawable.back);
        message1.setTextColor(Color.BLACK);

        send = findViewById(R.id.btnSend);
        send.setBackgroundColor(Color.TRANSPARENT);
        send.setImageResource(R.drawable.ic_send);

        layout = findViewById(R.id.Messagelay);
        layout.setBackgroundColor(Color.DKGRAY);

        message1.setBackgroundColor(Color.LTGRAY);

        chat = findViewById(R.id.chat);

        scroll = findViewById(R.id.scroll);

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
                        for (int i = 0; i < all.length(); i++) {
                            JSONObject item = all.getJSONObject(i);
                            final String message = item.getString("MESSAGES");
                            final String sender = item.getString("SENDER");
                            ChatScreen.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (sender.equals(Username)) {
                                        sendMessage(message);
                                    } else {
                                        recieveMessage(message);
                                    }
                                }
                            });

                        }
                        Messeditor.putInt(ChatName, all.length());
                        Messeditor.commit();
                        ;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        mHandler.postDelayed(getMessage,15000);
        scroll.scrollTo(0, chat.getBottom());
    }

    private Runnable getMessage = new Runnable() {
        @Override
        public void run() {
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
                            int Num = MessageNum.getInt(ChatName, 0);
                             if (all.length() > Num) {
                                for (int i = Num; i < all.length(); i++) {
                                    JSONObject item = all.getJSONObject(i);
                                    final String message = item.getString("MESSAGES");
                                    final String sender = item.getString("SENDER");

                                    ChatScreen.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (sender.equals(Username)) {
                                                sendMessage(message);
                                            } else {
                                                recieveMessage(message);
                                            }
                                        }
                                    });

                                }
                            }
                            Messeditor.putInt(ChatName, all.length());
                            Messeditor.commit();
                            ;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });mHandler.postDelayed(getMessage,15000);
        }
    };

    public void Send(View v) {
        String s = message1.getText().toString();
        if (!s.equals("")) {
            message1.setText("");
            sendMessage(s);
            UploadMessage(s);
        }

    }

    @Override
    protected void onStop() {
        mHandler.removeCallbacks(getMessage,15000);
        super.onStop();
    }

    public void recieveMessage(String message) {
        TextView text = new TextView(this);
        text.setPadding(0, 10, 0, 10);
        text.setTextSize(22);
        text.setText(message);
        text.setBackgroundColor(Color.DKGRAY);
        text.setTextColor(Color.WHITE);
        text.setGravity(Gravity.LEFT);
        text.setPadding(20,20,20,20);
        chat.addView(text);
        scroll.scrollTo(0, chat.getBottom());

        int i = MessageNum.getInt(ChatName, 0);
        i = i + 1;
        Messeditor.putInt(ChatName, i);
        Messeditor.commit();

        //updateMessageNumber();

    }

    public void sendMessage(String message) {
        TextView text = new TextView(this);
        text.setPadding(0, 10, 0, 10);
        text.setTextSize(22);
        text.setText(message);
        text.setBackgroundColor(Color.DKGRAY);
        text.setTextColor(Color.WHITE);
        text.setGravity(Gravity.RIGHT);
        text.setPadding(20,20,20,20);
        chat.addView(text);
        scroll.scrollTo(0, chat.getBottom());

        int i = MessageNum.getInt(ChatName, 0);
        i = i + 1;
        Messeditor.putInt(ChatName, i);
        Messeditor.commit();

        //updateMessageNumber();

    }

    public void UploadMessage(String message) {

        RequestBody formbody = new FormBody.Builder()
                .add("chat", ChatName)
                .add("message", message)
                .add("sender", Username)
                .build();
        Request request = new Request.Builder()
                .url(Config.BASE_URL + "Uploadmessage.php?")
                .post(formbody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });

    }

    public void updateMessageNumber() {

        int Num = MessageNum.getInt(ChatName, 0);

        RequestBody formbody = new FormBody.Builder()
                .add("username",Username)
                .add("chat", ChatName)
                .add("num",String.valueOf(Num))
                .build();
        Request request = new Request.Builder()
                .url(Config.BASE_URL + "upDateNum.php?")
                .post(formbody)
                .build();

        client1.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });

    }

    @Override
    public void onBackPressed(){
        ChatScreen.this.finish();
        mHandler.removeCallbacks(getMessage);
        new MainActivity();
    }

}
