package com.dmw.basic_service_lib.interfaces;

import android.util.Log;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by p_dmweidu on 2023/2/9
 * Desc:
 */
public class ServiceRegister {

    private static final String TAG = "ServiceRegister";

    //@Autowired(name = "/javamoudle/helloOne")
    public HelloService helloService1;

    //@Autowired(name = "/kotlin_module/helloTwo")
    public HelloService helloService2;

    //@Autowired(name = "/app/helloThree")
    public HelloService helloService3;

    public static ServiceRegister INSTANCE;

    private ServiceRegister() {

        Log.i(TAG, "ServiceRegister: ");
        helloService1= (HelloService) ARouter.getInstance().build("/jav_amodule/helloOne").navigation();
        helloService2= (HelloService) ARouter.getInstance().build("/kotlin_module/helloTwo").navigation();
        helloService3= (HelloService) ARouter.getInstance().build("/app/helloThree").navigation();
    }

    public synchronized static ServiceRegister getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ServiceRegister();
        }
        return INSTANCE;
    }

}
