package com.wingify.vwosample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vwo.mobile.Vwo;

public class HomeActivity extends AppCompatActivity {

    private ImageView bannerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bannerImageView = (ImageView) findViewById(R.id.banner);

        Object bannerObject = Vwo.getObjectForKey("banner");
        if (bannerObject != null) {
            String bannerUrl = (String) bannerObject;
            Glide.with(this).load(bannerUrl).into(bannerImageView);
        }

        bannerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vwo.markConversionForGoal("bannerClick");
            }
        });
    }

}
