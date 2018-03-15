package com.uyenpham.diploma.antitheft.service;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;

public class BackgroundMovementService extends Service
        implements SensorEventListener, Thread.UncaughtExceptionHandler
{
    private static boolean b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    private SensorManager localSensorManager;
//    private g g;

    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}

    public IBinder onBind(Intent paramIntent)
    {
        return null;
    }

    public void onCreate()
    {
//        this.g = new g(getApplicationContext());
    }

    public void onDestroy()
    {
        if (localSensorManager != null)
        {
            localSensorManager.unregisterListener(this, localSensorManager.getDefaultSensor(1));
            localSensorManager = null;
        }
    }

    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
        if (b)
        {
            b = false;
//            int k = this.a.getInt("movementSensitivityValue", 1);
            int m = (int)paramSensorEvent.values[0];
            int n = (int)paramSensorEvent.values[1];
//            c = k + m;
//            d = k + n;
//            e = m - k;
//            f = n - k;
        }
        int i = (int)paramSensorEvent.values[0];
        int j = (int)paramSensorEvent.values[1];
        boolean bool1;
        boolean bool2;
        if ((i > c) || (i < e) || (j > d) || (j < f))
        {
            if (localSensorManager != null)
            {
                localSensorManager.unregisterListener(this, localSensorManager.getDefaultSensor(1));
                localSensorManager = null;
            }
//            bool1 = this.g.h();
//            bool2 = this.g.n();
//            this.g.b(false);
//            if ((!bool1) || (bool2)) {
//                break label245;
            }
//            Intent localIntent2 = new Intent(getApplicationContext(), PatternLock.class);
//            localIntent2.addFlags(268435456);
//            localIntent2.putExtra(getApplicationContext().getString(2131230958), true);
//            startActivity(localIntent2);
        }
//        for (;;)
//        {
//            stopService(new Intent(getApplicationContext(), BackgroundMovementService.class));
//            return;
//            label245:
//            if ((!bool1) && (!bool2))
//            {
//                Intent localIntent1 = new Intent(getApplicationContext(), PasswordPin.class);
//                localIntent1.addFlags(268435456);
//                localIntent1.putExtra(getString(2131230958), true);
//                startActivity(localIntent1);
//            }
//        }
//    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
        b = true;
        localSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        localSensorManager.registerListener(this, localSensorManager.getDefaultSensor(1), 3);
        return START_STICKY;
    }

    public boolean stopService(Intent paramIntent)
    {
        if (localSensorManager != null)
        {
            localSensorManager.unregisterListener(this, localSensorManager.getDefaultSensor(1));
            localSensorManager = null;
        }
        return super.stopService(paramIntent);
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {}
}

