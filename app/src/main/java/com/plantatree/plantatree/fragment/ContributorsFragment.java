package com.plantatree.plantatree.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.plantatree.plantatree.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class ContributorsFragment extends AbstractFragment {
    @Bind(R.id.edit_email)
    EditText editEmail;
    @Bind(R.id.submit_email)
    Button submitEmail;
    @Bind(R.id.amount_content)
    TextView amount;
    @OnClick(R.id.submit_email) void submit(){
        /*
        Do something
         */
    }
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
    }
}
