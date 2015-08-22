package com.plantatree.plantatree.manager.dagger;

import com.plantatree.plantatree.AbstractActivity;
import com.plantatree.plantatree.AbstractApplication;
import com.plantatree.plantatree.DonateActivity;
import com.plantatree.plantatree.MainActivity;
import com.plantatree.plantatree.fragment.AbstractDialogFragment;
import com.plantatree.plantatree.fragment.AbstractFragment;
import com.plantatree.plantatree.fragment.AverageHeightDialogFragment;
import com.plantatree.plantatree.fragment.ContributorsFragment;
import com.plantatree.plantatree.fragment.GalleryFragment;
import com.plantatree.plantatree.fragment.NumberOfSpeciesDialogFragment;
import com.plantatree.plantatree.fragment.NumberOfTreeDialogFragment;
import com.plantatree.plantatree.fragment.TypeOfTreeDialogFragment;

import dagger.Module;

/**
 * Created by robertzhang on 2015-08-21.
 */


@Module(
		injects ={
//              Core classes
				AbstractApplication.class,
//              Activity classes
				MainActivity.class,
				AbstractActivity.class,
				DonateActivity.class,

//              Fragment classes
				AbstractFragment.class,
				AbstractDialogFragment.class,
				AverageHeightDialogFragment.class,
				ContributorsFragment.class,
				GalleryFragment.class,
				NumberOfSpeciesDialogFragment.class,
				NumberOfTreeDialogFragment.class,
				TypeOfTreeDialogFragment.class


		}


)
public class ControllerModule {
}
