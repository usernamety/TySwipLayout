package com.hnlc.tvtransictionanimation.myswipback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 汤意 on 2018/5/11.
 */

public class TySwipBackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)//获取当前页面
                .setSwipeBackEnable(true)//设置是否可滑动
                .setSwipeEdgePercent(0.2f)//可滑动的范围。百分比。0.2表示为左边20%的屏幕
                .setSwipeSensitivity(0.6f)//对横向滑动手势的敏感程度。0为迟钝 1为敏感
                .setClosePercent(0.5f)//触发关闭Activity百分比
                .setSwipeRelateEnable(true)//是否与下一级activity联动(微信效果)。默认关
                .setSwipeRelateOffset((int) (getResources().getDisplayMetrics().widthPixels * 0.3))//activity联动时的偏移量。默认500px。
                .setDisallowInterceptTouchEvent(false)//不抢占事件，默认关（事件将先由子View处理再由滑动关闭处理）
                .addListener(new SwipeListener() {//滑动监听

                    @Override
                    public void onScroll(float percent, int px) {//滑动的百分比与距离

                    }

                    @Override
                    public void onEdgeTouch() {//当开始滑动
                        Utils.convertActivityToTranslucent(TySwipBackActivity.this);
                    }

                    @Override
                    public void onScrollToClose() {//当滑动关闭

                    }

                    @Override
                    public void onScrollStateChange(int state, float px) {
                        if (state == SwipeBackLayout.STATE_IDLE && px == 0) {
                            Utils.convertActivityFromTranslucent(TySwipBackActivity.this);
                        }
                    }
                });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

    @Override
    public void onBackPressed() {
        Utils.convertActivityToTranslucent(TySwipBackActivity.this);
        SwipeBackHelper.getCurrentPage(this).scrollToFinishActivity();
    }
}
