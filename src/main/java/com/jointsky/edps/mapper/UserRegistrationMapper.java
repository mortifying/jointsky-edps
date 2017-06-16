package com.jointsky.edps.mapper;

/**
 * Created by shilin on 2017/6/14.
 * 用户注册持久层接口
 */
public interface UserRegistrationMapper {
    boolean saveUser(String userId, String userAccount, String userName, String telphone, String email, String region, String factName, String password, String createTime);

    int checkUserAccount(String userAccount);

    int checkTelphone(String telhpone);

    int checkEmial(String email);
}
