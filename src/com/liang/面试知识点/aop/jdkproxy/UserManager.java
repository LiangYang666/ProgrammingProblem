package com.liang.面试知识点.aop.jdkproxy;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.aop.jdkproxy
 * @ClassName: UserManager
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/12 8:52
 * @Version: 1.0
 */
public interface UserManager {
    void addUser(String userName, String password);
    void delUser(String userName);

}
