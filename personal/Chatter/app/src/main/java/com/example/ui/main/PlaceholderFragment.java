package com.example.ui.main;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.App;
import com.example.Config;
import com.example.ChatScreen;
import com.example.MainActivity;
import com.example.MessagingService;
import com.example.R;
import com.example.Register;
import com.example.StartChatDialog;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private Handler mHandler = new Handler();

    SharedPreferences User;
    String Username;

    LinearLayout chat;

    SharedPreferences MessageNum;
    OkHttpClient client1 = new OkHttpClient();

    RelativeLayout back;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

        //Toast.makeText(getContext(),Username,Toast.LENGTH_LONG).show();

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        chat = root.findViewById(R.id.chats);
        back = root.findViewById(R.id.constraintLayout);
        back.setBackgroundColor(Color.DKGRAY);
        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (s.equals("1")) {
                    getChats(root, chat);
                } else {
                    getUsers(root, chat);
                }
            }
        });


        return root;
    }

    public void getUsers(final View v, final LinearLayout users) {

        User = getContext().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        Username = User.getString("User", "");

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Config.BASE_URL + "getUsers.php?")
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
                            final String user1;
                            user1 = item.getString("USERNAME");
                            fName = item.getString("FNAME");
                            sName = item.getString("SNAME");
                            if (!user1.equals(Username)) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        TextView text = new TextView(getContext());
                                        text.setText(fName + " " + sName);
                                        text.setTextSize(25);
                                        text.setGravity(Gravity.CENTER);
                                        text.setTextColor(Color.WHITE);
                                        text.setBackgroundColor(Color.DKGRAY);
                                        text.setPadding(20,20, 0, 20);
                                        text.setBackgroundResource(R.drawable.back);
                                        text.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                OpenDialog(fName, sName, user1);
                                            }
                                        });
                                        users.addView(text);
                                    }
                                });
                            }

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }));

    }

    @Override
    public void onStart() {
        mHandler.postDelayed(refresh,15000);

        MessageNum = getContext().getSharedPreferences("numMessages", Context.MODE_PRIVATE);
        super.onStart();
    }

    private Runnable refresh = new Runnable() {
        @Override
        public void run() {
            setUserVisibleHint(true);
            mHandler.postDelayed(this,15000);
        }

    };

    @Override
    public void onStop() {
        mHandler.removeCallbacks(refresh);
        super.onStop();
    }

    public void OpenDialog(String name, String surname, String User12) {
        StartChatDialog Dialog = new StartChatDialog();
        Bundle data = new Bundle();
        data.putString("name", name);
        data.putString("surname", surname);
        data.putString("user", User12);
        Dialog.setArguments(data);
        Dialog.show(getFragmentManager(), "Dialog");
    }

    public void getChats(final View v, final LinearLayout users) {

        User = getContext().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        Username = User.getString("User", "");

        OkHttpClient client = new OkHttpClient();

        RequestBody formbody = new FormBody.Builder()
                .add("username", Username)
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
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        TextView text = new TextView(getContext());
                                                        text.setText(fName + " " + sName);
                                                        text.setTextSize(25);
                                                        text.setTypeface(null, Typeface.BOLD);
                                                        text.setGravity(Gravity.LEFT);
                                                        text.setTextColor(Color.WHITE);
                                                        text.setPadding(20,20,0,20);
                                                        text.setBackgroundResource(R.drawable.back);
                                                        text.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                Intent intent = new Intent(getContext(), ChatScreen.class);
                                                                intent.putExtra("fname",fName);
                                                                intent.putExtra("sname",sName);
                                                                intent.putExtra("ChatName",ChatName);
                                                                startActivity(intent);
                                                                getActivity().finish();
                                                            }
                                                        });
                                                        users.addView(text);
                                                    }
                                                });
                                            }else{
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        TextView text = new TextView(getContext());
                                                        text.setText(fName + " " + sName);
                                                        text.setTextSize(25);
                                                        text.setGravity(Gravity.LEFT);
                                                        text.setTextColor(Color.WHITE);
                                                        text.setBackgroundColor(Color.DKGRAY);
                                                        text.setPadding(20,20, 0, 20);
                                                        text.setBackgroundResource(R.drawable.back);
                                                        text.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                Intent intent = new Intent(getContext(), ChatScreen.class);
                                                                intent.putExtra("fname",fName);
                                                                intent.putExtra("sname",sName);
                                                                intent.putExtra("ChatName",ChatName);
                                                                startActivity(intent);
                                                            }
                                                        });
                                                        users.addView(text);
                                                    }
                                                });
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

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

}