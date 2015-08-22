package com.plantatree.plantatree.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.adapter.TypeOfTreeAdapter;
import com.plantatree.plantatree.model.Tree;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class TypeOfTreeDialogFragment extends AbstractDialogFragment {
    ArrayList<Tree> trees;
    @Bind(R.id.type_of_tree_listview)
    ListView typeOfTrees;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.type_of_tree_dialog_fragment,container,false);
        ButterKnife.bind(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TypeOfTreeAdapter typeOfTreeAdapter= new TypeOfTreeAdapter(getActivity(),R.layout.tree_info,trees);
        typeOfTrees.setAdapter(typeOfTreeAdapter);
    }
}
