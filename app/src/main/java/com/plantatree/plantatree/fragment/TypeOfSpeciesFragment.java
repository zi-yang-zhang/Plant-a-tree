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

    private String[] mTitles = {"Chameleons", "Wilson's bird-of-paradise", "Leopard cats",
            "Celebes crested macaque", "Orangutans", "Pangolins", "Red knobbed hornbill", "Sumatran Elephant"};

    private String[] mDescriptions = {"Chameleons inhabit all kinds of tropical and mountain rain forests, savannas, and sometimes deserts and steppes. The typical chameleons from the subfamily Chamaeleoninae are arboreal and usually found in trees or bushes, although a few (notably the Namaqua chameleon) are partially or largely terrestrial.\n",
                    "Wilson's bird-of-paradise is small, up to 21 cm (8.3 in) long. The male is a red and black bird-of-paradise, with a yellow mantle on its neck, light green mouth, rich blue feet and two curved violet tail feathers. The head is naked blue, with a black double cross pattern on it. The female is a brownish bird with bare blue crown.\n",
                    "Leopard cats are solitary, except during breeding season. Some are active during the day, but most hunt at night, preferring to stalk murids, tree shrews and hares. They are agile climbers and quite arboreal in their habits. They rest in trees\n",
                    "It lives typically in groups of five to twenty-five animals, and occasionally in groups of up to seventy-five animals. Smaller groups have only a single adult male, while larger groups have up to four adult males. However, adult females always outnumber adult males by about 4:1.\n",
                    "Orangutans are the most arboreal of the great apes and spend most of their time in trees. Their hair is typically reddish-brown, instead of the brown or black hair typical of chimpanzees and gorillas. Males and females differ in size and appearance.\n",
                    "Pangolins are nocturnal, and their diet consists of mainly ants and termites which they capture using their long, specially adapted tongues. They tend to be solitary animals, meeting only to mate and produce a litter of one to three offspring which are raised for about two years.\n",
                    "As with other hornbills, the knobbed hornbill is believed to be a monogamous species. The diet consists mainly of fruits and figs. Breeding season spans 27–30 weeks and appears to be triggered by a dramatic reduction in rainfall.\n",
                    "The Sumatran elephant (Elephas maximus sumatranus) is one of three recognized subspecies of the Asian elephant, and native to the Indonesia island of Sumatra. In 2011, the Sumatran elephant has been classified ascritically endangered by IUCN as the population has declined by at least 80% over the last three generations, estimated to be about 75 years.\n"};

    private int[] mImages = {R.drawable.chameleon, R.drawable.bird_of_paradise, R.drawable.leopard_cat, R.drawable.celebes_crested_macaque,
            R.drawable.oranguantan, R.drawable.pangolins, R.drawable.red_knobbed_hornbill, R.drawable.elephant};

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
        mAdapter = new TypeOfSpeciesAdapter(mTitles, mDescriptions, mImages, getActivity());
        type_of_species_recycler_view.setAdapter(mAdapter);

        return rootView;
    }
}
