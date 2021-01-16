package com.example.receive_messageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends vcgh {
    private static final int MY_PERMISSION_REQUEST_RECEVICE_SMS=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
          if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.RECEIVE_SMS))
          {

          }
          else
          {
              ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},MY_PERMISSION_REQUEST_RECEVICE_SMS);

          }

        }

    }
    @Override
    public void  onRequestPermissionResult(int requestCode,String permission[],int[] grantResults )
    {
        switch(requestCode)
        {
            case MY_PERMISSION_REQUEST_RECEVICE_SMS:
            {
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this,"thku permitting",Toast.LENGTH_LONG).show();

                }
                else
                {

                        Toast.makeText(this,"well can't",Toast.LENGTH_LONG).show();

                }
            }
        }
    }

}