package com.plantatree.plantatree.util;

import com.plantatree.plantatree.R;

import java.util.ArrayList;

/**
 * Created by jianhuizhu on 15-08-22.
 */
public class TreeResourceList {
    private static  Integer[] mThumbIds = new Integer[]{
            R.drawable.borneo_teak,
            R.drawable.borneo_teak_intsia_bijuga,R.drawable.langsat,
            R.drawable.langsat_lansium_domestic,R.drawable.leucaena,
            R.drawable.leucaena_leucaena_leucocephala,R.drawable.lychee,
            R.drawable.lychee_litchi_chinensis,R.drawable.para_rubber,
            R.drawable.para_rubber_hevea_brasiliensis,R.drawable.queens_flower,
            R.drawable.queens_flower_lagerstroemia_speciosa,R.drawable.silky_oak_grevilla_robusta,
            R.drawable.silky_oat,R.drawable.spanish_joint,R.drawable.spanish_joint_gnetum_gnemom
    };
    private static  ArrayList<Integer> trees=new ArrayList<>();
    private  TreeResourceList() {
        for (Integer i:mThumbIds) {
            trees.add(i);
        }
    }
    public  static ArrayList<Integer> getTrees(){
        if(trees.size()==0){
            new TreeResourceList();
        }
        return trees;
    }
}
