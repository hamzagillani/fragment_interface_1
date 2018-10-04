package com.digicon_valley.fragment_interface_1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment_message.OnMessageReadListener {

private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null){

            if (savedInstanceState != null){
                return;
            }

            Fragment_message fragment_message=new Fragment_message();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,fragment_message,null);
           fragmentTransaction.commit();
        }


    }

    @Override
    public void onMessageRead(String message) {

        textView=findViewById(R.id.messageApear_textView_id);
        textView.setText(message);
    }
}
