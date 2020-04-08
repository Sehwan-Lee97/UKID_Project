package com.example.ukidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.ukidapp.api.RetrofitSender;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    private void login(){

        JsonObject user = new JsonObject();
        user.addProperty("email", "test@test.com");
        user.addProperty("password", "test12345");



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