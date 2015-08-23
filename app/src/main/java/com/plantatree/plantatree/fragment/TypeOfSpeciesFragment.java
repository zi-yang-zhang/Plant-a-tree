package com.plantatree.plantatree.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.adapter.TypeOfSpeciesAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yucunli on 2015-08-22.
 */
public class TypeOfSpeciesFragment extends AbstractFragment {

    @Bind(R.id.type_of_species_recycler_view)
    RecyclerView type_of_species_recycler_view;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private RecyclerView.LayoutManager mLayoutManager;
    private TypeOfSpeciesAdapter mAdapter;

    private String[] mTitles = {"bboy lil chao", "bboy kill", "bboy wing", "bboy shorty force"};
    private int[] mImages = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4};

    public  static TypeOfSpeciesFragment newInstance(){
        TypeOfSpeciesFragment fragment = new TypeOfSpeciesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_type_of_species, container, false);
        ButterKnife.bind(this, rootView);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        type_of_species_recycler_view.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        type_of_species_recycler_view.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new TypeOfSpeciesAdapter(mTitles, mImages, getActivity());
        type_of_species_recycler_view.setAdapter(mAdapter);

        return rootView;
    }
}
