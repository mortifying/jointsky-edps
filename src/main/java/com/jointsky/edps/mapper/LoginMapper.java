package com.jointsky.edps.mapper;

import com.jointsky.edps.model.UserInfo;

/**
 * Created by Minght on 2017/6/15.
 */
public interface LoginMapper {
    UserInfo getUserByAccount(String userAccount);
}
