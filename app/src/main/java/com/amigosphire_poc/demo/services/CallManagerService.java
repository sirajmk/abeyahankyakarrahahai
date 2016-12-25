package com.amigosphire_poc.demo.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.amigosphire_poc.R;

public class CallManagerService extends Service implements View.OnClickListener {
    private Context mContext;
    private TelephonyManager mTelephonyManager;

    @Override
    public void onCreate() {
        mContext = this;
        mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        mTelephonyManager.listen(new CallStateListener(), PhoneStateListener.LISTEN_CALL_STATE);

        Log.e("sharath","*** CallManagerService started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onClick(View v) {
        final WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.removeView(v.getRootView());
    }

    /**
     * Listener to detect incoming calls.
     */
    private class CallStateListener extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    // called when someone is ringing to this phone

                    Toast.makeText(mContext,
                            "Incoming: "+incomingNumber,
                            Toast.LENGTH_LONG).show();

                    showDialog();
                    break;
            }
        }
    }

    void showDialog() {
        Toast.makeText(getBaseContext(),"onCreate", Toast.LENGTH_LONG).show();
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                0,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.VERTICAL_GRAVITY_MASK | Gravity.TOP;
        //params.setTitle("Load Average");

        final WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);

        final View view = View.inflate(this.getApplicationContext(), R.layout.caller_info, null);
        ImageView cancelCall = (ImageView) view.findViewById(R.id.canceldialog);
        cancelCall.setOnClickListener(this);

        wm.addView(view, params);
    }

}
