package com.example.dumingwei.arouterjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/app/url_jump_activity")
public class UrlJumpActivity extends AppCompatActivity {

    private static final String TAG = "UrlJumpActivity";

    @Autowired
    String name;

    @Autowired
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_url_jump);
        Log.d(TAG, "onCreate: " + name + "," + age);
    }
}
