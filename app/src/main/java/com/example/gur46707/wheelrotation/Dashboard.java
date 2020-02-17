package com.example.gur46707.wheelrotation;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gur46707.wheelrotation.Presenter.IPresenter;
import com.example.gur46707.wheelrotation.Presenter.Presenter;
import com.example.gur46707.wheelrotation.View.IDashboard;

import java.util.Random;


public  class Dashboard extends AppCompatActivity implements IDashboard {
    CoordinatorLayout coordinatorLayout;
    Button speedtest;
    TextView rpmRate;
    ImageView wheelImg;
    private IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);
        setUpUI();
        iPresenter = new Presenter(this);

    }

    public void setUpUI(){
        speedtest = findViewById(R.id.speedtest);
        wheelImg = findViewById(R.id.wheelImg);
        rpmRate = findViewById(R.id.rpmRate);
        speedtest.setEnabled(true);
        speedtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSnackbar(Constants.FETCHING);
                iPresenter.fetchSpeed();
            }
        });
    }


    /**
     * author - Arun yadav
     * Date - 2/6/2019
     * desc - function to get api result from presenter
     */
    @Override
    public void onApiResult(int value, String status) {
         if(status.equalsIgnoreCase(Constants.SUCCESS_API))
            {
                setMeter(value);
                handleSnackbar(Constants.UPDATED);

            } else
                {
                    handleSnackbar(Constants.ERROR);
                }
    }
    /**
     * author - Arun yadav
     * Date - 2/6/2019
     * desc - function to set the meter
     */
    public  void setMeter(int value)
        {
            RotateAnimation rotate =new RotateAnimation(0,3600, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            rpmRate.setText(value +" RPM");
            int y = (360/value)*160;
            rotate.setDuration(y);
            rotate.setInterpolator(new LinearInterpolator());
            wheelImg.startAnimation(rotate);
        }


    /**
     * author - Arun yadav
     * Date - 2/6/2019
     * desc - function to show the snackbar
     */
    public  void handleSnackbar(String fetchingUpdatedErrorStatus)
    {
        String textSnackBar = null ;
        if(fetchingUpdatedErrorStatus.equalsIgnoreCase(Constants.FETCHING)) {
            speedtest.setEnabled(false);
            textSnackBar = Constants.SNACK_FETCHING_RPM;
        } else if(fetchingUpdatedErrorStatus.equalsIgnoreCase(Constants.UPDATED)) {
            speedtest.setEnabled(true);
            textSnackBar = Constants.SNACK_UPDATED_RPM;
            } else {
            speedtest.setEnabled(true);
            textSnackBar = Constants.SNACK_UNABLE_TO_UPDATE_RPM;
            }
        //handling null cordinaate layout
        if (coordinatorLayout != null) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, textSnackBar, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else
        {
            System.out.println("error inflating cordinate layout");
        }
    }
}
