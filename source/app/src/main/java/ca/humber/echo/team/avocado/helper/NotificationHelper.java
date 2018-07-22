package ca.humber.echo.team.avocado.helper;

import android.app.NotificationChannel;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import ca.humber.echo.team.avocado.AvocadoApplication;
import ca.humber.echo.team.avocado.R;

public class NotificationHelper {

    private static NotificationHelper notificationHelper;
    private NotificationHelper(){ }


    public static NotificationHelper getInstance(){

        if(notificationHelper == null){
            synchronized (NotificationHelper.class){
                if(notificationHelper == null){
                    notificationHelper = new NotificationHelper();
                }
            }
        }

        return notificationHelper;
    }

    public void emmitNotification(String notificationTitle, String notificatonMessage){

        Context context = AvocadoApplication.getContext();

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,
                NotificationChannel.DEFAULT_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_stat_avocado)
                //.setLargeIcon(R.mipmap.ic_avocado_launcher_round)
                .setContentTitle(notificationTitle)
                //.setContentText()
                .setStyle(new NotificationCompat.BigTextStyle().bigText(notificatonMessage))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, mBuilder.build());

    }

}
