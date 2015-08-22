package com.plantatree.plantatree.fragment;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.adapter.ContributorsAdapter;
import com.plantatree.plantatree.model.Contributor;
import com.plantatree.plantatree.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class ContributorsFragment extends AbstractFragment {
    private ContributorsAdapter contributorsAdapter;
    private List<Contributor> contributors;
    private void addFakeContributors(){
        Contributor c1=new Contributor();
        c1.setName("David");
        c1.setDonation(12.5);
        c1.setFrequency(3);
        Contributor c2=new Contributor();
        c2.setName("Robert");
        c2.setDonation(18.8);
        c2.setFrequency(4);
        Contributor c3=new Contributor();
        c3.setName("Caron");
        c3.setDonation(1000.98);
        c3.setFrequency(10);
        Contributor c4=new Contributor();
        c4.setName("Yucun");
        c4.setDonation(1.0);
        c4.setFrequency(1);
        Contributor c5=new Contributor();
        c5.setName("zhu");
        c5.setDonation(12.3);
        c5.setFrequency(8);
        Contributor c6=new Contributor();
        c6.setName("Soyang");
        c6.setDonation(15.4);
        c6.setFrequency(2);
        this.contributors=new ArrayList<>();
        this.contributors.add(c1);
        this.contributors.add(c2);
        this.contributors.add(c3);
        this.contributors.add(c4);
        this.contributors.add(c5);
        this.contributors.add(c6);
    }
    MenuItem fav;
    @Bind(R.id.contributor_list)
    ListView contributorList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view=inflater.inflate(R.layout.contributor_fragment,container,false);
        this.contributors=new ArrayList<>();
        addFakeContributors();
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contributorsAdapter=new ContributorsAdapter(getActivity(),R.layout.contributor,contributors);
        contributorList.setAdapter(contributorsAdapter);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        Log.i("FragCreateList", "onCreateOptionsMenu called");
        inflater.inflate(R.menu.contributor_sorting, menu);
        setMenuVisibility(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alpha:
                contributorsAdapter.sort(Constant.ALPHABET);
                return true;
            case R.id.amount:
                contributorsAdapter.sort(Constant.AMOUNT);
                return true;
            case R.id.frequency:
                contributorsAdapter.sort(Constant.FREQUENCY);
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }

	public static ContributorsFragment newInstance(){
		ContributorsFragment fragment = new ContributorsFragment();
		return fragment;
	}
}
