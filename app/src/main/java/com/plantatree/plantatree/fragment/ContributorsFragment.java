package com.plantatree.plantatree.fragment;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
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

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class ContributorsFragment extends AbstractFragment {
    private ContributorsAdapter contributorsAdapter;
    private List<Contributor> contributors;
    MenuItem fav;
    @Bind(R.id.contributor_list)
    ListView contributorList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contributor_fragment,container,false);
        ButterKnife.bind(view);
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
        setHasOptionsMenu(true);
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
}
