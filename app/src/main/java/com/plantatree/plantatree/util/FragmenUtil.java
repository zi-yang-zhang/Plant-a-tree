package com.plantatree.plantatree.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

import com.plantatree.plantatree.R;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class FragmenUtil {
	private static String FRAGMENT_TAG = "fragment_tag";
	public static void switchToFragment(Context context, Fragment fragment){
		if(context instanceof Activity){
			((Activity) context).getFragmentManager().beginTransaction().add(R.id.container,fragment,FRAGMENT_TAG).commit();
		}
	}
	public static void switchToRootFragment(Context context, Fragment fragment){
		if(context instanceof Activity){
			int backStackCounts = ((Activity) context).getFragmentManager().getBackStackEntryCount();
			while (backStackCounts>0){
				((Activity) context).getFragmentManager().popBackStackImmediate(FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
				backStackCounts--;
			}
			((Activity) context).getFragmentManager().beginTransaction().add(R.id.container,fragment).commit();
		}
	}
}
