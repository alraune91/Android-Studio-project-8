package com.example.myapplicationingeron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class detailactivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityditail);
        WebView webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        String resName = "n" + intent.getIntExtra("title", 0);
        Log.i("name", resName);
        Context context = getBaseContext();
        String text = readRawTextFile(context, getResources().getIdentifier(resName, "raw","com.example.myapplicationingeron"));
        webView.loadDataWithBaseURL(null,text, "text/html","en_US", null);
    }
    private String readRawTextFile(Context context, int resId){
        InputStream inputStream = context.getResources().openRawResource(resId);
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        String line;
        StringBuilder builder = new StringBuilder();
        try{
            while((line = bufferedReader.readLine())!=null){
                builder.append(line);
                builder.append("<br>");
            }

        }catch (IOException e){
            return null;
        }
        return builder.toString();
    }
    public void startAct(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void exit(View v){
        finishAffinity();
    }

}
