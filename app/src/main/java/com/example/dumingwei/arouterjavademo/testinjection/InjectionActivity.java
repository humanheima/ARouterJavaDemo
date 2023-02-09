package com.example.dumingwei.arouterjavademo.testinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.dumingwei.arouterjavademo.R;

import java.util.List;
import java.util.Map;

/**
 * Created by p_dmweidu on 2023/2/9
 * Desc: 复杂参数解析
 */
@Route(path = "/app/injection_activity")
public class InjectionActivity extends AppCompatActivity {

    private static final String TAG = "InjectionActivity";

    @Autowired
    String name = "jack";

    @Autowired
    int age = 10;

    @Autowired
    int height = 175;

    @Autowired(name = "boy")
    boolean girl;

    @Autowired
    char ch = 'A';

    @Autowired
    float fl = 12.00f;

    @Autowired
    double dou = 12.01d;

    @Autowired
    TestParcelable pac;

    @Autowired
    TestObj obj;

    @Autowired
    List<TestObj> objList;

    @Autowired
    Map<String, List<TestObj>> map;

    private long high;

    @Autowired
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注意，不加这一行的话，应该不会自动解析数据，需要手动解析。
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_injection);
        String params = String.format(
                "name=%s,\n age=%s, \n height=%s,\n girl=%s,\n high=%s,\n url=%s,\n pac=%s,\n obj=%s \n ch=%s \n fl = %s, \n dou = %s, \n objList=%s, \n map=%s",
                name,
                age,
                height,
                girl,
                high,
                url,
                pac,
                obj,
                ch,
                fl,
                dou,
                objList,
                map
        );
        Log.d(TAG, "onCreate: " + params);
    }
}
