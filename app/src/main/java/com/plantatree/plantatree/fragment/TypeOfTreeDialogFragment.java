package com.plantatree.plantatree.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
    private void addFakeData(){
        this.trees=new ArrayList<>();
        Tree t1=new Tree();
        t1.setName("Alder (Alnus)");
        t1.setDescription("Blablabla");
        Tree t2=new Tree();
        t2.setName("Apple and Pear (Pyrus)");
        t2.setDescription("Blablabla");
        Tree t3=new Tree();
        t3.setName("Ash (Fraxinus)");
        t3.setDescription("Blablabla");
        trees.add(t1);
        trees.add(t2);
        trees.add(t3);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view=inflater.inflate(R.layout.type_of_tree_dialog_fragment,container,false);
        ButterKnife.bind(this,view);
        addFakeData();

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TypeOfTreeAdapter typeOfTreeAdapter= new TypeOfTreeAdapter(getActivity(),R.layout.tree_info,trees);
        typeOfTrees.setAdapter(typeOfTreeAdapter);
    }
	public static TypeOfTreeDialogFragment newInstance(){
		TypeOfTreeDialogFragment fragment = new TypeOfTreeDialogFragment();
		return fragment;
	}
}
