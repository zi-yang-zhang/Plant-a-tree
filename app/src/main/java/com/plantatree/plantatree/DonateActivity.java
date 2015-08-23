package com.plantatree.plantatree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.plantatree.plantatree.util.SharedPrefHelper;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class DonateActivity extends AbstractActivity implements View.OnClickListener{
    SharedPrefHelper sharedPrefHelper;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        sharedPrefHelper = new SharedPrefHelper(this);
        loginButton = (Button) findViewById(R.id.btn_login);
        loginButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sharedPrefHelper.getDonated()){
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId){
            case R.id.btn_login:
                sharedPrefHelper.setDonated(true);
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
