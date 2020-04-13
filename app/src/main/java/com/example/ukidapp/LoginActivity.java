package com.example.ukidapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ukidapp.api.RetrofitSender;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonObject;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView textView = (TextView)findViewById(R.id.registerText);
        textView.setText(Html.fromHtml("<font color=\"#eeac99\" ><u>회원가입</u></font>"));
    }

    public void login_button(View view){

        TextInputLayout emailLayout = findViewById(R.id.email);
        TextInputLayout passwordLayout = findViewById(R.id.password);
        String email = emailLayout.getEditText().getText().toString();
        String password = passwordLayout.getEditText().getText().toString();

        Log.d("email", email);
        Log.d("password",password);

        /*


        login(email, password);
        SharedPreferences prefs = getSharedPreferences("Auth", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", email);
        editor.putString("jwt", password);

        editor.commit();
        */
        Intent LoginPage = new Intent(this, MainActivity.class);
        startActivity(LoginPage);
        finish();



    }

    private void login(String email, String password){

        JsonObject user = new JsonObject();
        user.addProperty("email", email);
        user.addProperty("password", password);

        /*
            email 형식이 맞는지 검증, password 입력됬는지 검증

            성공 -> 넘어가고
            실패 -> return false



         */


        RetrofitSender.getServer().login(user).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.e("result", response.toString());

                if (response.body() != null) {
                    Log.d("result : ", response.body().toString());
                }else {
                    Log.d("reulst : ", "비어있다.");
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("model", t.getMessage());
            }
        });
    }

}