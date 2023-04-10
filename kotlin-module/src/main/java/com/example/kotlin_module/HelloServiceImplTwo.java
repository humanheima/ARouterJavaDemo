package com.example.kotlin_module;


import android.content.Context;
import android.util.Log;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmw.basic_service_lib.interfaces.HelloService;
import com.dmw.basic_service_lib.interfaces.ServiceRegister;

/**
 * Created by p_dmweidu on 2023/2/9
 * Desc:
 */
@Route(path = "/kotlin_module/helloTwo", name = "helloTwo")
public class HelloServiceImplTwo implements HelloService {

    private static final String TAG = "HelloServiceImplTwo";

    @Override
    public String sayHello(String name) {
        Log.i(TAG, "sayHello: " + name);
        ServiceRegister.getInstance().helloService1.sayHello("在HelloServiceImplTwo中hello 1");
        return TAG;
    }

    @Override
    public void init(Context context) {

    }
}
