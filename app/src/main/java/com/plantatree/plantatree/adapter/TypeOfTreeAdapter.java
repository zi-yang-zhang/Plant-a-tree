package com.plantatree.plantatree.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.model.Tree;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jianhuizhu on 15-08-22.
 */
public class TypeOfTreeAdapter extends ArrayAdapter<Tree> {


    public TypeOfTreeAdapter(Context context, int resource, ArrayList<Tree> trees) {
        super(context, resource, trees);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.tree_info,parent,false);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.treeName.setText(getItem(position).getName());
        viewHolder.treeDescription.setText(getItem(position).getDescription());
        Picasso.with(getContext()).load(getItem(position).getImageResourceId()).into(viewHolder.treeImage);
        return convertView;
    }
    class ViewHolder {
        @Bind(R.id.tree_image)
        ImageView treeImage;
        @Bind(R.id.tree_name)
        TextView treeName;
        @Bind(R.id.tree_description)
        TextView treeDescription;
        public ViewHolder(View convertView) {
            ButterKnife.bind(this,convertView);
        }
    }
}
