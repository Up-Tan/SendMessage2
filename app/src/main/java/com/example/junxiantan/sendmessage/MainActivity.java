package com.example.junxiantan.sendmessage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    EditText num,mess;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn =(Button)findViewById(R.id.btn);
        num =(EditText)findViewById(R.id.num);
        mess=(EditText)findViewById(R.id.Mess);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = num.getText().toString();
                String content=mess.getText().toString();
                SmsManager smsManager = SmsManager.getDefault();
                PendingIntent sentIntent = PendingIntent.getActivity(
                        MainActivity.this,0,new Intent(),0);
                List<String>    msgs = smsManager.divideMessage(content);
                for (String msg:msgs){
                    smsManager.sendTextMessage(mobile,null,msg,sentIntent,null);
                }
                Toast.makeText(MainActivity.this,"短信发送完成",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
