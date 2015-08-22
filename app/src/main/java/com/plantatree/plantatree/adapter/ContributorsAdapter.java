package com.plantatree.plantatree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.model.Contributor;
import com.plantatree.plantatree.util.Constant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jianhuizhu on 15-08-22.
 */
public class ContributorsAdapter extends ArrayAdapter<Contributor> {
    private List<Contributor> contributors;
    public ContributorsAdapter(Context context, int resource, List<Contributor> objects) {
        super(context, resource, objects);
        contributors=new ArrayList<>(objects);
    }
    public void sort(int type){
        switch (type){
            case Constant.ALPHABET:
                this.sort(new Comparator<Contributor>() {
                    @Override
                    public int compare(Contributor lhs, Contributor rhs) {
                        return lhs.getName().compareTo(rhs.getName());
                    }
                });
                break;
            case Constant.AMOUNT:
                this.sort(new Comparator<Contributor>() {
                    @Override
                    public int compare(Contributor lhs, Contributor rhs) {
                        return new Double(rhs.getDonation()).intValue()- new Double(lhs.getDonation()).intValue();
                    }
                });
                break;
            case Constant.FREQUENCY:
                this.sort(new Comparator<Contributor>() {
                    @Override
                    public int compare(Contributor lhs, Contributor rhs) {
                        return rhs.getFrequency()-lhs.getFrequency();
                    }
                });
                break;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.contributor,parent,false);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.contributorName.setText(getItem(position).getName());
        return convertView;
    }
    class ViewHolder{
        @Bind(R.id.contributor_portrait)
        ImageView contributorPortrait;
        @Bind(R.id.contributor_name)
        TextView contributorName;
        ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }
}

