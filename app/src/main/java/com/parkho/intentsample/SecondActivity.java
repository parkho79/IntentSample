package com.parkho.intentsample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        final boolean dataBool = intent.getBooleanExtra("bool_data", false);
        final int dataInt = intent.getIntExtra("int_data", 0);
        final String dataString = intent.getStringExtra("string_data");

        StringBuilder extraText = new StringBuilder();
        extraText.append("bool_data = " + dataBool + "\n");
        extraText.append("int_data = " + dataInt + "\n");
        extraText.append("string_data = " + dataString + "\n");

        TextView tvExtra = findViewById(R.id.tv_extra);
        tvExtra.setText(extraText);

        StringBuilder uriText = new StringBuilder();
        Uri uriData = intent.getData();
        uriText.append("path = " + uriData.getPath() + "\n");
        String strType = intent.getType();
        uriText.append("type = " + strType);

        TextView tvUri = findViewById(R.id.tv_uri);
        tvUri.setText(uriText);
    }
}
