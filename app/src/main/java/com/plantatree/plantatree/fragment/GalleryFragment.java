package com.plantatree.plantatree.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.adapter.GalleryGridImageAdapter;
import com.plantatree.plantatree.util.TreeResourceList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class GalleryFragment extends AbstractFragment {
    @Bind(R.id.time_title_1)
    TextView timeTitle1;
    @Bind(R.id.time_title_2)
    TextView timeTitle2;
    @Bind(R.id.time_title_3)
    TextView timeTitle3;
    @Bind(R.id.gallery_content_1)
    GridView gallery1;
    @Bind(R.id.gallery_content_2)
    GridView gallery2;
    @Bind(R.id.gallery_content_3)
    GridView gallery3;

	public static GalleryFragment newInstance(){
		GalleryFragment galleryFragment = new GalleryFragment();
		return galleryFragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.gallery_fragment,container,false);
		ButterKnife.bind(this,view);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
        timeTitle1.setText("2015-01-12");
        timeTitle2.setText("2015-03-14");
        timeTitle3.setText("2015-06-11");
        gallery1.setNumColumns(5);
        gallery2.setNumColumns(5);
        gallery3.setNumColumns(5);
        gallery1.setAdapter(new GalleryGridImageAdapter(getActivity(), TreeResourceList.getTrees().subList(0, 4)));
        gallery2.setAdapter(new GalleryGridImageAdapter(getActivity(),TreeResourceList.getTrees().subList(5,10)));
        gallery3.setAdapter(new GalleryGridImageAdapter(getActivity(), TreeResourceList.getTrees().subList(11, TreeResourceList.getTrees().size() - 1)));


    }

}
