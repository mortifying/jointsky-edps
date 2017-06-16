package com.jointsky.edps.service;

import com.jointsky.edps.mapper.UserRegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by shilin on 2017/6/14.
 * 用户注册业务处理类
 */
@Service
public class UserRegistrationService {

    @Autowired
    private UserRegistrationMapper userRegistrationMapper;

    /**
     * 保存用户注册信息
     * @param userAccount
     * @param userName
     * @param telphone
     * @param email
     * @param region
     * @param factName
     * @param password
     * @return
     */
    public boolean saveUser(String userAccount, String userName, String telphone, String email, String region, String factName, String password) {
        //生成32位UUID作为用户ID
        String userId = UUID.randomUUID().toString().replace("-","");
        //用户注册时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(new Date());
        //用户密码进行MD5加密
        String password_md5 = "";
        try {
            MessageDigest md5
                    = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的密码
            password_md5 = base64en.encode(md5.digest(password.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRegistrationMapper.saveUser(userId,userAccount,userName,telphone,email,region,factName,password_md5,createTime);
    }

    /**
     * 用户名重名检测
     * @param userAccount
     * @return
     */
    public boolean checkUserAccount(String userAccount) {
        int count = userRegistrationMapper.checkUserAccount(userAccount);
        if(count > 0){
            return false;
        } else {
            return true;
        }
    }

    /**
     * 手机号码重复检测
     * @param telhpone
     * @return
     */
    public boolean checkTelphone(String telhpone) {
        int count = userRegistrationMapper.checkTelphone(telhpone);
        if(count > 0){
            return false;
        } else {
            return true;
        }
    }

    /**
     * 电子邮箱重复检测
     * @param email
     * @return
     */
    public boolean checkEmail(String email) {
        int count = userRegistrationMapper.checkEmial(email);
        if(count > 0){
            return false;
        } else {
            return true;
        }
    }
}
