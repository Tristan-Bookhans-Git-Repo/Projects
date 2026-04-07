package com.example;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.ui.main.PlaceholderFragment;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StartChatDialog extends DialogFragment {

    //private Context context;

    SharedPreferences User;
    String Myusername;

    OkHttpClient client = new OkHttpClient();

    TabLayout tabs;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        //context = getActivity().getApplicationContext();

        tabs = getActivity().findViewById(R.id.tabs);

        User = getContext().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        Myusername = User.getString("User", "");

        Bundle data = getArguments();
        final String name = data.getString("name");
        final String surname = data.getString("surname");
        final String user = data.getString("user");



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Start Chat")
                .setMessage("Are you sure you want to start a chat with " + name + " " + surname)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //tabs.getTabAt(1).select();
                        RequestBody formbody = new FormBody.Builder()
                                .add("username", user)
                                .add("fname", name)
                                .add("sname", surname)
                                .add("me", Myusername)
                                .build();
                        Request request = new Request.Builder()
                                .url(Config.BASE_URL + "StartChat.php?")
                                .post(formbody)
                                .build();

                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                                final String myResponse = response.body().string();

                            }
                        });
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(true);
        return builder.create();

    }
}
