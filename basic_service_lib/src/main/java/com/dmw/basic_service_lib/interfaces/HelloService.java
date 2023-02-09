package com.dmw.basic_service_lib.interfaces;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by p_dmweidu on 2023/2/9
 * Desc: 测试 通过依赖注入解耦:服务管理(一) 暴露服务
 */
public interface HelloService extends IProvider {

    String sayHello(String name);
}
