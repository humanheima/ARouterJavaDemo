package com.example.java_module;


import android.content.Context;
import android.util.Log;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmw.basic_service_lib.interfaces.HelloService;

/**
 * Created by p_dmweidu on 2023/2/9
 * Desc:
 */
@Route(path = "/jav_amodule/helloOne", name = "helloOne")
public class HelloServiceImplOne implements HelloService {

    private static final String TAG = "HelloServiceImplOne";
    @Override
    public String sayHello(String name) {
        Log.i(TAG, "sayHello: " + name);
        return TAG;
    }

    @Override
    public void init(Context context) {

    }
}
