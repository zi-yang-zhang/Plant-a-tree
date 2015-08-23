package com.plantatree.plantatree.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.plantatree.plantatree.MainActivity;
import com.plantatree.plantatree.manager.bus.events.UpdateEvent;
import com.plantatree.plantatree.util.SharedPrefHelper;
import com.squareup.otto.EventBus;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by robertzhang on 2015-08-22.
 */
public class GcmBroadcastReceiver extends BroadcastReceiver{
	public static final String ACTION_UPDATE_STATUS = "status_update";
	protected EventBus mEventBus;

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle extras = intent.getExtras();
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
		// The getMessageType() intent parameter must be the intent you received
		// in your BroadcastReceiver.
		String messageType = gcm.getMessageType(intent);

		if (extras != null && !extras.isEmpty()) {  // has effect of unparcelling Bundle
			// Since we're not using two way messaging, this is all we really to check for
			if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
				mEventBus = EventBus.newInstance();
				mEventBus.post(new UpdateEvent());
				Logger.getLogger("GCM_RECEIVED").log(Level.INFO, extras.toString());
				SharedPrefHelper sharedPrefHelper = new SharedPrefHelper(context);
				sharedPrefHelper.setRateChange(true);
				createNotification(context);

			}
		}
	}
	private void createNotification(Context context){
		Intent contentIntent = new Intent(context, MainActivity.class);
		contentIntent.setAction(ACTION_UPDATE_STATUS);
		contentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendingIntent = PendingIntent.getActivity(context,123,contentIntent,PendingIntent.FLAG_ONE_SHOT);
		Notification.Builder notificationBuilder= (new Notification.Builder(context))
				.setSmallIcon(android.R.drawable.sym_def_app_icon)
				.setContentTitle("Forest status update")
				.setContentText("Your forest has grown up!")
				.setContentIntent(pendingIntent)
				.setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS)
				.setAutoCancel(true);
		notificationBuilder.setPriority(Notification.PRIORITY_MAX);

		Notification notification  = notificationBuilder.build();
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(456, notification);

	}

}
