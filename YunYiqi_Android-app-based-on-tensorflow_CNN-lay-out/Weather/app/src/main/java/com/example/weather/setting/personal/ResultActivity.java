package com.example.weather.setting.personal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.weather.MainActivity;
import com.example.weather.R;

public class ResultActivity extends Activity {

    private Button back;
    private TextView result;
    private static String s = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        back = findViewById(R.id.back);
        result = findViewById(R.id.result);
        Intent intent = getIntent();
        s = intent.getStringExtra("result");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到主界面
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        if(s.equals("A")){
            result.setText("优");
        }
        else if(s.equals("B")){
            result.setText("良");
        }
        else if(s.equals("C")){
            result.setText("中");
        }
        else{
            result.setText("差");
        }
    }
    //返回键方法的重写
    @Override
    public boolean onKeyDown(int keycode, KeyEvent event){
        if(keycode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keycode,event);
    }
}
