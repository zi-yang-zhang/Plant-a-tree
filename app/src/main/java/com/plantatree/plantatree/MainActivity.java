package com.plantatree.plantatree;

import android.os.Bundle;

import com.plantatree.plantatree.fragment.MainDataFragment;
import com.plantatree.plantatree.util.FragmenUtil;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class MainActivity extends AbstractActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	protected void onResume() {
		super.onResume();
		FragmenUtil.switchToRootFragment(this, MainDataFragment.newInstance());

	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
	}
}
