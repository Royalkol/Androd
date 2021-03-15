package com.example.helloworld.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class AActivity extends AppCompatActivity {

    private Button mbtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
        mbtnJump = findViewById(R.id.Jump);
        mbtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                显示1
                Intent intent = new Intent(      AActivity.this, BActivity.class);
                startActivity(intent);

                //显示 2
//                Intent intent =new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显示3
//                Intent intent =new Intent();
//                intent.setClassName(AActivity.this,"com.example.helloworld.jump.BActivity");
//                startActivity(intent);

//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.helloworld.jump.BActivity"));
//                startActivity(intent);

                //隐式调用
//                Intent intent = new Intent();
//                intent.setAction("com.royal.test.BActivity");
//                startActivity(intent);
            }
        });
    }
}