package com.plantatree.plantatree.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jianhuizhu on 15-08-22.
 */
public class GalleryGridImageAdapter extends BaseAdapter {
    private boolean zoomOut =  false;
    private Context mContext;
    private List<Integer> trees;
    public GalleryGridImageAdapter(Context mContext, List<Integer> trees){
        this.mContext=mContext;
        this.trees=trees;
    }
    @Override
    public int getCount() {
        return trees.size();
    }

    @Override
    public Object getItem(int position) {
        return trees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return trees.get(position);
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //imageView.setPadding(10, 10, 10, 10);
            imageView.setAdjustViewBounds(true);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext).load(trees.get(position)).fit().into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmenUtil.switchToFragment(mContext,FullScreenDialogFragment.newInstance(trees.get(position)));
                Dialog builder = new Dialog(mContext);
                builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
                builder.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.graphics.Color.TRANSPARENT));
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        //nothing;
                    }
                });

                ImageView imageView = new ImageView(mContext);
                imageView.setImageResource(trees.get(position));
                //imageView.setImageURI(imageUri);
                builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                builder.show();
            }
        });
        return imageView;
    }

}
