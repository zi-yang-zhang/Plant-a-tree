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
import com.plantatree.plantatree.util.TreeResourceList;

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
        t1.setName("Gnetum gnemon");
        t1.setDescription("Shrub or small tree; branches in whorls down to base of trunk; leaves opposite, with bent and joining secondary nerves; flowers in whorls at nodes. Fruit nut-like, yellow to red or purple, with one seed.");
        t1.setImageResourceId(TreeResourceList.getTrees().get(1));
        Tree t2=new Tree();
        t2.setName("Grevillea robusta");
        t2.setDescription("Evergreen; straight bole; cone shaped crown; new twigs and branchlets with grey or rust colored hairs; leaves fernlike, silky white haired below; flowers 4-merous yellow.");
        t2.setImageResourceId(TreeResourceList.getTrees().get(2));
        Tree t3=new Tree();
        t3.setName("Hevea brasiliensis");
        t3.setDescription("Medium sized tree; straight stem; trifoliate leaves of variable size, leaflets elliptic or obovate; fruits 3-lobed capsules, 3–5 cm in diameter; white latex in all parts.");
        t3.setImageResourceId(TreeResourceList.getTrees().get(3));
        Tree t4=new Tree();
        t4.setName("ntsia bijuga");
        t4.setDescription("Large; sometimes buttressed; bark grey with orange tinge; leaves with 2 pairs of leaflets; flowers white and pink with only one petal; freshly cut wood smells like beans.");
        t4.setImageResourceId(TreeResourceList.getTrees().get(4));
        trees.add(t4);
        Tree t5=new Tree();
        t5.setName("Lagerstroemia speciosa");
        t5.setDescription("Medium sized tree; bark with thin yellowish lines; leaves mostly opposite, large, entire; large, purplish, showy flowers; seeds winged.");
        t5.setImageResourceId(TreeResourceList.getTrees().get(5));
        trees.add(t5);
        Tree t6=new Tree();
        t6.setName("Lansium domesticum");
        t6.setDescription("Bole irregularly fluted; steep buttresses; furrowed bark mottled grey and orange and with milky, sticky sap; twigs and leaves sometimes hairy; leaves odd-pinnate with 6– 9 leaflets; fruit up to 5 cm in diameter, yellowish hairy.");
        t6.setImageResourceId(TreeResourceList.getTrees().get(6));
        trees.add(t6);
        Tree t7=new Tree();
        t7.setName("Leucaena leucocephala");
        t7.setDescription("Bipinnately compound leaves with 10–20 pairs of leaflets on each pinnae; flowers white, in round heads 2–2.5 cm in diameter; “giant” forms are distinguished from L. diversifolia by two, 1–2 mm wide round glands on the leaf stalk at the first and last pair of pinnae of most leaves.");
        t7.setImageResourceId(TreeResourceList.getTrees().get(7));
        trees.add(t7);
        Tree t8=new Tree();
        t8.setName("Litchi chinensis");
        t8.setDescription("Short stocky trunk; often broad crown; compound leaves with 2–5 pairs of oblong-lanceolate leaflets; yellow-white flowers, red to purple, round fruits, about 3 cm in diameter, with flat warts.");
        t8.setImageResourceId(TreeResourceList.getTrees().get(8));
        trees.add(t1);
        trees.add(t2);
        trees.add(t3);
        trees.add(t8);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view=inflater.inflate(R.layout.type_of_tree_dialog_fragment,container,false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addFakeData();
        TypeOfTreeAdapter typeOfTreeAdapter= new TypeOfTreeAdapter(getActivity(),R.layout.tree_info,trees);
        typeOfTrees.setAdapter(typeOfTreeAdapter);
    }
	public static TypeOfTreeDialogFragment newInstance(){
		TypeOfTreeDialogFragment fragment = new TypeOfTreeDialogFragment();
		return fragment;
	}
}
