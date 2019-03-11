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
        OnClickListener explicitClickListener = new OnClickListener() {
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
        findViewById(R.id.btn_explicit).setOnClickListener(explicitClickListener);

        /*
         * Implicit(암시적) intent 로 third activity 호출
         *  - "com.parkho.action.Image_view" Action 으로 호출
         */
        OnClickListener implicitClickListener1 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.parkho.action.IMAGE_VIEW");
                intent.addCategory("android.intent.category.EDIT");
                startActivity(intent);
            }
        };
        findViewById(R.id.btn_implicit_1).setOnClickListener(implicitClickListener1);

        /*
         * Implicit(암시적) intent 로 해당 action 을 처리할 수 있는 activity 호출
         *  - URL 을 처리할 수 있는 브라우저 실행
         */
        OnClickListener implicitClickListener2 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://parkho79.tistory.com"));
                startActivity(intent);
            }
        };
        findViewById(R.id.btn_implicit_2).setOnClickListener(implicitClickListener2);
    }
}
