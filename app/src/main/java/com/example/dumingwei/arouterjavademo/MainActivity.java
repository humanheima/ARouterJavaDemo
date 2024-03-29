package com.example.dumingwei.arouterjavademo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dmw.basic_service_lib.interfaces.ServiceRegister;
import com.example.dumingwei.arouterjavademo.testinjection.TestObj;
import com.example.dumingwei.arouterjavademo.testinjection.TestParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static Context activity;

    public static Context getActivity() {
        return activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        invokeOtherComponentService();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_interface_impl:
                invokeOtherComponentService();
                break;
            case R.id.btn_simple_jump:
                ARouter.getInstance()
                        .build("/app/second_activity")
                        .navigation();
                break;
            case R.id.btn_simple_jump_with_params:
                ARouter.getInstance()
                        .build("/app/third_activity")
                        .withString("key0", "value0")
                        .withInt("key1", 100)
                        .navigation();
                break;
            case R.id.btn_simple_jump_for_result:
                ARouter.getInstance().build("/app/second_activity").navigation(this, 666, new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {
                        Toast.makeText(MainActivity.this, "跳转完了", Toast.LENGTH_SHORT).show();
                    }

                });
                break;
            case R.id.btn_find_fragment:
                Fragment fragment = (Fragment) ARouter.getInstance().build("/app/fragment/blank_fragment").navigation();
                Toast.makeText(this, "找到Fragment:" + fragment.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_new_transition_animation:
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(view,
                            view.getWidth() / 2, view.getHeight() / 2, 0, 0);
                    ARouter.getInstance().build("/app/second_activity").withOptionsCompat(compat).navigation();
                } else {
                    Toast.makeText(MainActivity.this, "API < 16,不支持新版本动画", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_jump_vir_url:
                TestParcelable parcelable = new TestParcelable("jack", 666);
                Uri testUriMix = Uri.parse("arouter://dumingwei.example.com/app/url_jump_activity");
                ARouter.getInstance().build(testUriMix)
                        .withString("name", "dumingwei")
                        .withInt("age", 27)
                        .withParcelable("parcelable", parcelable)
                        .navigation();
                break;
            case R.id.btn_intercept_test:
                ARouter.getInstance()
                        .build("/app/second_activity")
                        .navigation(this, new NavCallback() {

                            @Override
                            public void onFound(Postcard postcard) {
                                super.onFound(postcard);
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                super.onLost(postcard);
                            }

                            @Override
                            public void onArrival(Postcard postcard) {

                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.d("ARouter", "被拦截了");
                            }
                        });

                break;
            case R.id.btn_inject:
                TestParcelable testParcelable = new TestParcelable("jack", 666);
                TestObj testObj = new TestObj("Rose", 777);
                List<TestObj> objList = new ArrayList<>();
                objList.add(testObj);

                Map<String, List<TestObj>> map = new HashMap<>();
                map.put("testMap", objList);

                ARouter.getInstance().build("/app/injection_activity")
                        .withString("name", "老王")
                        .withInt("age", 18)
                        .withBoolean("boy", true)
                        .withLong("high", 163)
                        .withString("url", "https://a.b.c")
                        .withParcelable("pac", testParcelable)
                        .withObject("obj", testObj)
                        .withObject("objList", objList)
                        .withObject("map", map)
                        .navigation();
                break;
            case R.id.btn_nav_to_java_module:
                //注意要在build里面依赖 implementation project(':java-module')
                Log.d(TAG, "onClick: btn_nav_to_java_module");
                ARouter.getInstance()
                        .build("/javamodule/javamodule_activity")
                        .navigation();
                break;
            case R.id.btn_nav_to_kotlin_module:
                ARouter.getInstance()
                        .build("/kotlin/kotlin_activity")
                        .navigation();
                break;
            case R.id.btn_test_degrade:
                //navigation(方法里面一定要传递一个context)
                ARouter.getInstance()
                        .build("/app/app_activity")
                        .navigation(this);
                break;
            default:
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 100) {
            Toast.makeText(activity, "onActivityResult resultCode = " + resultCode, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onActivityResult: " + resultCode);
        }
    }

    /**
     * 测试调用其他组件中的接口
     */
    private void invokeOtherComponentService() {
        ServiceRegister.getInstance().helloService1.sayHello("hello 1");
        ServiceRegister.getInstance().helloService2.sayHello("hello 2");
        ServiceRegister.getInstance().helloService3.sayHello("hello 3");
    }
}
