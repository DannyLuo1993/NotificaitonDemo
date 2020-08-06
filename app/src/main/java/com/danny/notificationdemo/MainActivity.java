package com.danny.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,0);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(MainActivity.this)
                .setContentTitle("这是测试通知标题")  //设置标题
                .setContentText("这是测试通知内容") //设置内容
                .setWhen(System.currentTimeMillis())  //设置时间
                //.setSmallIcon(R.mipmap.ic_launcher)  //设置小图标  只能使用alpha图层的图片进行设置
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))   //设置大图标
                .setContentIntent(pi)
                .build();
        manager.notify(1,notification);

        Notification cancelNotification = new NotificationCompat.Builder(MainActivity.this)
                        .setAutoCancel(true) //设置为自动取消
                        .build();
        manager.notify(1,cancelNotification);
        manager.cancel(1);
    }
}