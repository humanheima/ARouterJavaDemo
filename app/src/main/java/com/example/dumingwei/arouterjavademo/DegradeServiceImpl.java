package com.example.dumingwei.arouterjavademo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * 自定义全局降级策略
 */
@Route(path = "/dmw/app")
public class DegradeServiceImpl implements DegradeService {

    private static final String TAG = "DegradeServiceImpl";

    @Override
    public void onLost(Context context, Postcard postcard) {
        Log.d(TAG, "onLost: ");
        Toast.makeText(context, "lost", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        Log.d(TAG, "init: ");
    }
}
