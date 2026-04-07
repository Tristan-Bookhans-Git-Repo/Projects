package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class Register extends AppCompatActivity {

    SharedPreferences User;
    SharedPreferences.Editor editor;

    EditText Fname;
    EditText Sname;

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Fname = findViewById(R.id.edtFName);
        Sname = findViewById(R.id.edtSName);
        Fname.setText("");
        Sname.setText("");

        User = getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);
        editor = User.edit();

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void Register(View v) {
        String fName = Fname.getText().toString();
        String sName = Sname.getText().toString();

        fName = fName.replace(" ", "");
        sName = sName.replace(" ", "");

        if (!(fName.equals("")) && !(sName.equals(""))) {
            String user = fName.toUpperCase() + sName.toUpperCase();

            editor.putString("User", user);
            //editor.apply();
            editor.commit();

            RequestBody formbody = new FormBody.Builder()
                    .add("username", user)
                    .add("fname", fName)
                    .add("sname", sName)
                    .build();
            Request request = new Request.Builder()
                    .url(Config.BASE_URL + "Register.php?")
                    .post(formbody)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        final String myResponse = response.body().string();

                        Register.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Register.this, myResponse, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            });


            finish();

        } else {
            Fname.setText("");
            Sname.setText("");
            Toast.makeText(getApplicationContext(), "Please enter a name and surname", Toast.LENGTH_LONG).show();
        }

    }

    public void Login(View v){
        String fName = Fname.getText().toString();
        String sName = Sname.getText().toString();

        fName = fName.replace(" ", "");
        sName = sName.replace(" ", "");

        if (!(fName.equals("")) && !(sName.equals(""))) {
            String user = fName.toUpperCase() + sName.toUpperCase();

            editor.putString("User", user);
            editor.commit();

            finish();

        } else {
            Fname.setText("");
            Sname.setText("");
            Toast.makeText(getApplicationContext(), "Please enter a name and surname", Toast.LENGTH_LONG).show();
        }
    }

}
