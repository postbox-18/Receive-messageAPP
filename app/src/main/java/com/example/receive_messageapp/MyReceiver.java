package com.example.receive_messageapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String SMS_RECEVIE="android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG="SmsBroadcastRecevier";
    String msg,phoneno="";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"Intent Recived"+intent.getAction());
        if(intent.getAction()==SMS_RECEVIE)
        {
            Bundle dataBundle=intent.getExtras();
            if(dataBundle!=null)
            {
                Object[] mypdu=(Object[])dataBundle.get("pdus");
                final SmsMessage[] messages=new SmsMessage[mypdu.length];

                for(int i=0 ;i<mypdu.length;i++)
                {
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
                    {
                        String format =dataBundle.getString("format");
                        messages[i]=SmsMessage.createFromPdu((byte[])mypdu[i],format);
                    }
                    else
                    {
                        messages[i]=SmsMessage.createFromPdu((byte[])mypdu[i]);

                    }
                    msg =messages[i].getMessageBody();
                    phoneno=messages[i].getOriginatingAddress();
                }
                Toast.makeText(context,msg+"\n No."+phoneno,Toast.LENGTH_LONG).show();
            }
        }
    }
}