package com.hnlc.tvtransictionanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import com.hnlc.tyswipelayout.TySwipBackActivity;


/**
 * Created by 汤意 on 2018/5/14.
 */

public class TestActivity extends TySwipBackActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.body_testactivity);

    }
}
