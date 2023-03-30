package com.example.aosmb6;

import android.app.Service;
import android.os.IBinder;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

public class Serv1 extends Service {
    public Serv1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("onbind");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        final WindowManager.LayoutParams params = new
                WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        View view = LayoutInflater.from(this).inflate(R.layout.banner, null);
        ((TextView) view.findViewById(R.id.textBanner)).setText("Notifyyyy");
        windowManager.addView(view, params);
        params.gravity = Gravity.BOTTOM | Gravity.CENTER;
        windowManager.updateViewLayout(view, params);

        view.findViewById(R.id.cls).setOnClickListener(v -> {
            windowManager.removeView(view);
        });

        return super.onStartCommand(intent, flags, startId);
    }
}


