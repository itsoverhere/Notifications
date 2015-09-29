package edu.mobidev.labnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    public static final int TEMP_REQUEST_CODE = 0;
    public static final int NO_NAME_NOTIFICATION_ID = 0;

    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        // throw new UnsupportedOperationException("Not yet implemented");
        Intent enterName = new Intent();
        enterName.setClass(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, TEMP_REQUEST_CODE, enterName, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder
                = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("No name!")
                .setContentTitle("Alert")
                .setContentText("Please enter name")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);
        notificationManager.notify(NO_NAME_NOTIFICATION_ID, notificationBuilder.build());
    }
}
