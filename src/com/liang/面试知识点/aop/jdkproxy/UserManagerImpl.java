package com.liang.面试知识点.aop.jdkproxy;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.aop.jdkproxy
 * @ClassName: UserManagerImpl
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/12 8:53
 * @Version: 1.0
 */
public class UserManagerImpl implements UserManager{
    //重写新增用户方法
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: "+userName+" password: "+password);
    }
    //重写删除用户方法
    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: "+userName);
    }
}
