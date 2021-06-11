package com.example.mydemoapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SMSActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMSMessage();

//                String number = e1.getText().toString();
//                String msg = e2.getText().toString();
//
//                Intent intent = new Intent(getApplicationContext(), SMSActivity.class);
//                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
//
//                SmsManager sms = SmsManager.getDefault();
//                sms.sendTextMessage(number, null, msg, pi, null);
//
//                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
//                        Toast.LENGTH_LONG).show();
//                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
//                {
//                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
//                    {
//                        sendSms();
//                    }
//                    else {
//                        requestPermissions(new String[]
//                                {Manifest.permission.SEND_SMS},1);
//                    }
//                }
            }
        });
    }

    private void sendSMSMessage() {
        phoneNo = e1.getText().toString();
        message = e2.getText().toString();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS))
            {

            }
            else
                {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }

//    private void sendSms() {
//        String number = e1.getText().toString();
//        String msg = e2.getText().toString();
//
//        try {
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(number,null,msg,null,null);
//            Toast.makeText(getApplicationContext(),"Message send Successfully!",Toast.LENGTH_SHORT).show();
//        }catch (Exception e){
//            e.printStackTrace();
//            Toast.makeText(getApplicationContext(),"Faild to send Message",Toast.LENGTH_SHORT).show();
//
//        }
//    }
}