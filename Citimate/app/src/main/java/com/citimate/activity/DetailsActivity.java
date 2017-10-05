package com.citimate.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends FragmentActivity implements View.OnClickListener, OnMapReadyCallback {

    private ImageView iv_back_button, ivListImage, ivLocation, ivSaved, ivChat, ivReview;
    private TextView tvDistance, tvItemName, tvTags, tvFourS, tvCall, tvOpenTime, tvTime, tvAddress, tvViewReview;
    private RatingBar ratingBar;
    private int image;
    private GoogleMap mMap;
    private LinearLayout time_layout;
    private RelativeLayout layoutMid2;
    private boolean isVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initialization();
        setData();
    }

    //    Views Id Initialize Method
    public void initialization() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        RelativeLayout Id
        layoutMid2 = (RelativeLayout) findViewById(R.id.layoutMid2);

//        LinearLayout Id
        time_layout = (LinearLayout) findViewById(R.id.time_layout);

//        RatingBar Id
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

//      ImageView Id
        ivListImage = (ImageView) findViewById(R.id.ivListImage);
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);
        ivLocation = (ImageView) findViewById(R.id.ivLocation);
        ivSaved = (ImageView) findViewById(R.id.ivSaved);
        ivChat = (ImageView) findViewById(R.id.ivChat);
        ivReview = (ImageView) findViewById(R.id.ivReview);

//        TextView Id
        tvDistance = (TextView) findViewById(R.id.tvDistance);
        tvViewReview = (TextView) findViewById(R.id.tvViewReview);
        tvItemName = (TextView) findViewById(R.id.tvItemName);
        tvTags = (TextView) findViewById(R.id.tvTags);
        tvCall = (TextView) findViewById(R.id.tvCall);
        tvOpenTime = (TextView) findViewById(R.id.tvOpenTime);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvAddress = (TextView) findViewById(R.id.tvAddress);

//        Click Listener
        layoutMid2.setOnClickListener(this);
        ivLocation.setOnClickListener(this);
        ivSaved.setOnClickListener(this);
        ivChat.setOnClickListener(this);
        ivReview.setOnClickListener(this);
        tvViewReview.setOnClickListener(this);
        tvCall.setOnClickListener(this);
        iv_back_button.setOnClickListener(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //    Set Static Data
    public void setData() {
        tvItemName.setText(getIntent().getStringExtra("ItemName"));
        tvTags.setText(getIntent().getStringExtra("Tags"));
        tvDistance.setText(getIntent().getStringExtra("Distance"));

        float f = Float.parseFloat(getIntent().getStringExtra("Rating"));
        ratingBar.setRating(f);
        image = getIntent().getIntExtra("Image", 0);
        Log.d("Image URL----", String.valueOf(image));

        Picasso.with(this)
                .load(image)
                .centerCrop()
                .resize(500, 500)
                .into(ivListImage);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_back_button:
                finish();
                break;

            case R.id.ivLocation:
                Intent navigation_intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=" + 22.72 + "," + 75.88 + "&daddr=" + 22.75 + "," + 75.89));
                startActivity(navigation_intent);
                break;

            case R.id.ivSaved:
                Intent intent1 = new Intent(DetailsActivity.this, SavedListActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                break;

            case R.id.ivChat:
                Intent intent = new Intent(DetailsActivity.this, ChatActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.ivReview:
                showDialog();
                break;

            case R.id.tvCall:
                Toast.makeText(this, "In progress", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tvViewReview:
                Intent intent4 = new Intent(DetailsActivity.this, ReviewActivity.class);
                startActivity(intent4);
                overridePendingTransition(0, 0);
                break;

            case R.id.layoutMid2:

                if (!isVisible) {
                    isVisible = true;
                    time_layout.setVisibility(View.VISIBLE);

                } else {
                    isVisible = false;
                    time_layout.setVisibility(View.GONE);
                }
                break;
        }
    }

    //    Rating Custom Dialog
    private void showDialog() {
        final Dialog dialog = new Dialog(DetailsActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.rating_dialog);

        ImageButton iv_back_button = (ImageButton) dialog.findViewById(R.id.iv_back_button);

        iv_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        TextView tvPostReview = (TextView) dialog.findViewById(R.id.tvPostReview);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        float f = ratingBar.getRating();
        tvPostReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    //    GoogleMap Call Method
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.getUiSettings().setZoomGesturesEnabled(false);
        mMap.getUiSettings().setScrollGesturesEnabled(false);

        // Add a marker in Sydney and move the camera
        // create marker
        LatLng sydney = new LatLng(22.72, 75.88);
        MarkerOptions marker = new MarkerOptions().position(sydney).title("Marker in Palasiya");
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(22.72, 75.88), 15));

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_location_map));

        // adding marker
        mMap.addMarker(marker);
    }
}
