package com.digicon_valley.fragment_interface_1;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment_message extends Fragment {

    private EditText editText;
    private Button button;
    OnMessageReadListener messageReadListener;

    public Fragment_message() {
        // Required empty public constructor
    }

    public  interface OnMessageReadListener{

            public void onMessageRead(String message);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_message, container, false);

        editText=view.findViewById(R.id.editText_message_id);
        button=view.findViewById(R.id.btn_send_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message =editText.getText().toString();
                messageReadListener.onMessageRead(message);

                Toast.makeText(getContext()," "+editText.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });



    return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity=(Activity) context;

       try{
           messageReadListener  = (OnMessageReadListener) activity;
       }catch (ClassCastException e) {

           throw new ClassCastException(activity.toString() + "Must Override onMessageRead...");
       }
}}
