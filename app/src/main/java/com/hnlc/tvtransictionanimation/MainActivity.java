package com.hnlc.tvtransictionanimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.hnlc.tyswipelayout.SwipeBackHelper;
import com.hnlc.tyswipelayout.TySwipBackActivity;

public class MainActivity extends TySwipBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(false);
    }

    public void heheda(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }
}
