package com.example.dumingwei.arouterjavademo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dmw.basic_service_lib.interfaces.ServiceRegister;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();
        ARouter.init(this);
        //ServiceRegister.getInstance();
    }
}
