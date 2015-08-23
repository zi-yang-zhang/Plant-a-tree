package com.plantatree.plantatree.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.plantatree.plantatree.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yucunli on 2015-08-22.
 */
public class TypeOfSpeciesDetailFragment extends AbstractFragment {

    @Bind(R.id.image) ImageView imageView;
    @Bind(R.id.title) TextView titleView;
    @Bind(R.id.description) TextView descriptionView;
    @Bind(R.id.container) LinearLayout container;
    @Bind(R.id.toolbar) Toolbar toolbar;

    public  static TypeOfSpeciesDetailFragment newInstance(int image, String title, String description){
        TypeOfSpeciesDetailFragment fragment = new TypeOfSpeciesDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("image", image);
        bundle.putString("title", title);
        bundle.putString("description", description);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_type_of_species_detail, container, false);
        ButterKnife.bind(this, rootView);

        int image = getArguments().getInt("image");
        String title = getArguments().getString("title");
        String description = getArguments().getString("description");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), image);
        imageView.setImageBitmap(bitmap);

        colorize(bitmap);

        titleView.setText(title);
        descriptionView.setText(description);

        return rootView;
    }

    private void colorize(Bitmap photo) {
        Palette palette = Palette.generate(photo);
        applyPalette(palette);
    }

    private void applyPalette(Palette palette) {

        container.setBackgroundColor(palette.getDarkMutedColor(0x000000));

        titleView.setTextColor(palette.getVibrantColor(0x000000));

        descriptionView.setTextColor(palette.getLightVibrantColor(0x000000));

    }
}
