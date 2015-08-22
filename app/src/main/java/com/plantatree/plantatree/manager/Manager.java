package com.plantatree.plantatree.manager;

import android.content.Context;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.plantatree.gcmbackend.registration.Registration;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class Manager implements IManager {
	private static final String SENDER_ID = "820234133273";
	private static Registration regService = null;
	private GoogleCloudMessaging gcm;
	public Manager(){

	}
	@Override
	public Observable<Boolean> registerGcm(final Context context) {
		return Observable.create(new Observable.OnSubscribe<Boolean>() {
			@Override
			public void call(Subscriber<? super Boolean> subscriber) {
				if (regService == null) {
					Registration.Builder builder = new Registration.Builder(AndroidHttp.newCompatibleTransport(),
							new AndroidJsonFactory(), null)
							// Need setRootUrl and setGoogleClientRequestInitializer only for local testing,
							// otherwise they can be skipped
							.setRootUrl("https://plant-a-tree-1045.appspot.com/_ah/api/")
							;
					regService = builder.build();
				}

				String msg = "";
				try {
					if (gcm == null) {
						gcm = GoogleCloudMessaging.getInstance(context);
					}
					String regId = gcm.register(SENDER_ID);
					msg = "Device registered, registration ID=" + regId;

					// You should send the registration ID to your server over HTTP,
					// so it can use GCM/HTTP or CCS to send messages to your app.
					// The request to your server should be authenticated if your app
					// is using accounts.
					regService.register(regId).execute();
					subscriber.onNext(true);
					subscriber.onCompleted();
				} catch (IOException ex) {
					ex.printStackTrace();
					subscriber.onError(ex);
					msg = "Error: " + ex.getMessage();
				}
			}
		});
	}
}
