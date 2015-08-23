package com.plantatree.plantatree.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.fragment.TypeOfSpeciesDetailFragment;
import com.plantatree.plantatree.fragment.TypeOfSpeciesFragment;
import com.plantatree.plantatree.util.FragmenUtil;

/**
 * Created by yucunli on 2015-08-22.
 */
public class TypeOfSpeciesAdapter extends RecyclerView.Adapter<TypeOfSpeciesAdapter.ViewHolder> {


    private String[] mTitles;
    private int[] mImages;
    private Context context;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView card_view_title;
        public ImageView card_view_image;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            card_view_title = (TextView) itemLayoutView.findViewById(R.id.card_view_title);
            card_view_image = (ImageView) itemLayoutView.findViewById(R.id.card_view_image);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TypeOfSpeciesAdapter(String[] mTitles, int[] mImages, Context context) {
        this.mTitles = mTitles;
        this.mImages = mImages;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TypeOfSpeciesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.type_of_species_recyclerview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.card_view_title.setText(mTitles[position]);
        holder.card_view_image.setImageDrawable(context.getDrawable(mImages[position]));
        holder.card_view_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmenUtil.switchToFragment(context, TypeOfSpeciesDetailFragment.newInstance(mImages[position], mTitles[position]));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitles.length;
    }

}
