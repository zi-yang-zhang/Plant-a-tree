package com.plantatree.plantatree.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.plantatree.plantatree.DonateActivity;
import com.plantatree.plantatree.R;
import com.plantatree.plantatree.adapter.MainAdapter;
import com.plantatree.plantatree.manager.bus.events.UpdateEvent;
import com.plantatree.plantatree.util.FragmenUtil;
import com.plantatree.plantatree.util.SharedPrefHelper;
import com.squareup.otto.Subscribe;

/**
 * Created by robertzhang on 2015-08-22.
 */
public class MainDataFragment extends AbstractFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
	private ListView mMainContainer;
	private MainAdapter mAdapter;
	private Button donateButton;

	public static MainDataFragment newInstance(){
		MainDataFragment mainDataFragment = new MainDataFragment();
		return mainDataFragment;

	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_data, container, false);
		mMainContainer = (ListView) view.findViewById(R.id.main_list);
		mAdapter = new MainAdapter(getActivity(), View.NO_ID);
		donateButton = (Button) view.findViewById(R.id.donate_button);
		donateButton.setOnClickListener(this);


		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mMainContainer.setAdapter(mAdapter);
		mMainContainer.setOnItemClickListener(this);
		donateButton.setOnClickListener(this);

	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		SharedPrefHelper sharedPrefHelper = new SharedPrefHelper(getActivity());
		sharedPrefHelper.setRateChange(false);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		MainAdapter.DataType dataType = mAdapter.getItem(position);
		switch (dataType){
			case GALLERY:
				FragmenUtil.switchToFragment(getActivity(),GalleryFragment.newInstance());
				break;
			case TYPE_OF_SPECIES:
				FragmenUtil.switchToFragment(getActivity(), TypeOfSpeciesFragment.newInstance());
				break;
			case TYPE_OF_TREE:
				FragmenUtil.switchToFragment(getActivity(), TypeOfTreeDialogFragment.newInstance());
				break;
			case CONTRIBUTORS:
				FragmenUtil.switchToFragment(getActivity(),ContributorsFragment.newInstance());
				break;
		}
	}
	@Subscribe
	public void handleUpdateEvent(UpdateEvent event){
		mAdapter.notifyDataSetInvalidated();
	}

	@Override
	public void onClick(View v) {
		SharedPrefHelper sharedPrefHelper = new SharedPrefHelper(getActivity());
		sharedPrefHelper.setDonated(false);
		startActivity(new Intent(getActivity(), DonateActivity.class));

	}
}
