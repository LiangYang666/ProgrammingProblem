package com.liang.面试知识点.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.aop.jdkproxy
 * @ClassName: JdkProxy
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/12 8:55
 * @Version: 1.0
 */
public class JdkProxy implements InvocationHandler {
    private Object target;

    public JdkProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

    //测试
    public static void main(String[] args) {
        UserManagerImpl userManager = new UserManagerImpl();
        JdkProxy jdkProxy = new JdkProxy(userManager);
        UserManager user = (UserManager) Proxy.newProxyInstance(
                userManager.getClass().getClassLoader(),
                userManager.getClass().getInterfaces(),
                jdkProxy);
        user.addUser("name", "123");
        user.delUser("bbb");

    }
}
