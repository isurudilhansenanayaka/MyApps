package com.indrustrialmaster.mycounter;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    NumberPicker n1,n2;
    Handler handler;
    int m,s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);

        n1.setMinValue(0);
        n1.setMaxValue(60)
        ;
        n2.setMinValue(0);
        n2.setMaxValue(60);
        btn=findViewById(R.id.button);

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                n1.setValue(m);
                n2.setValue(s);
            }
        };
    }
    public void start(View v){
        final int total=(n1.getValue()*60)+n2.getValue();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int x=total;x>=1;x--){
                    try {
                        Thread.sleep(1000);
                        System.out.println(x);
                        m=x/60;
                        s=x%60;
                        handler.sendEmptyMessage(0);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
            }
        }


        };
        Thread t=new Thread(r);
        t.start();
    }
}
