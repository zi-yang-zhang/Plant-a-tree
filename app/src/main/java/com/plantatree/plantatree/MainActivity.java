package com.plantatree.plantatree;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.plantatree.plantatree.fragment.ContributorsFragment;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class MainActivity extends AbstractActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.container,new ContributorsFragment())
                .commit();
    }
}
