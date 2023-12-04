package com.example.dumingwei.arouterjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/app/third_activity")
public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";

    /**
     * 注解字段
     */
    @Autowired
    String key0;
    @Autowired
    int key1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inject，配合   @Autowired 使用，自动解析参数
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_third);
        Log.d(TAG, "onCreate: key0=" + key0 + ",key1=" + key1);
    }
}
