package com.plantatree.plantatree.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.fragment.AbstractDialogFragment;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class FragmenUtil {
	private static String FRAGMENT_TAG = "fragment_tag";
	private static String DIALOG_FRAGMENT_TAG = "dialog_fragment";
	public static void switchToFragment(Context context, Fragment fragment){
		if(context instanceof Activity){
			if(fragment instanceof AbstractDialogFragment){
				((AbstractDialogFragment) fragment).show(((Activity) context).getFragmentManager(), DIALOG_FRAGMENT_TAG);
			} else{
				((Activity) context).getFragmentManager().beginTransaction().addToBackStack(FRAGMENT_TAG);
				((Activity) context).getFragmentManager().beginTransaction().replace(R.id.container, fragment, FRAGMENT_TAG).commit();
			}
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
