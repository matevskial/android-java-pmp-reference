package com.matevskial.androidjavapmpreference;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CalculateBigNumberService extends Service {
    public CalculateBigNumberService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        long num = calculateBigNumber();

        Intent done = new Intent();
        done.setAction(intent.getAction());
        done.putExtra("bigNumber", String.valueOf(num));
        sendBroadcast(done);

        System.out.println("SERVICE RAN");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    long calculateBigNumber() {
        long num = 0;
        int largeNumber = 190000000;
        for(int i = 0; i < largeNumber; i++) {
            num += i;
        }
        return num;
    }
}