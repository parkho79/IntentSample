package com.parkho.intentsample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class FirstActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // Explicit(명시적) intent 로 second activity 호출
        OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SecondActivity.class);
                intent.putExtra("bool_data", true);
                intent.putExtra("int_data", 7);
                intent.putExtra("string_data", "parkho");

                Uri uri = Uri.parse("/sdcard/test.png");
                final String strType = "image/png";
                intent.setDataAndType(uri, strType);

                startActivity(intent);
            }
        };
        findViewById(R.id.btn_explicit).setOnClickListener(clickListener);
    }
}
