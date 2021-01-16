package com.example.receive_messageapp;

import androidx.appcompat.app.AppCompatActivity;

public abstract class vcgh extends AppCompatActivity {
    public abstract void  onRequestPermissionResult(int requestCode, String permission[], int[] grantResults);
}
