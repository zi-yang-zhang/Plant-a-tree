package com.plantatree.plantatree.manager;

import android.content.Context;

import rx.Observable;

/**
 * Created by robertzhang on 2015-08-21.
 */
public interface IManager {

	Observable<Boolean> registerGcm(Context context);
}
