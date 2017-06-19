package com.jointsky.edps.service;

import com.jointsky.edps.mapper.LoginMapper;
import com.jointsky.edps.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shilin on 2017/6/15.
 */
@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {

        System.out.println("username = [" + username + "]");

        UserInfo userInfo = getUserByAccount(username);
        if(userInfo == null){
            throw  new UsernameNotFoundException(username);
        }

        List<SimpleGrantedAuthority> grantedAuthoritys = new ArrayList<SimpleGrantedAuthority>();
        grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_ADMIN"));


        User user = new User(userInfo.getUserAccount(),userInfo.getPassword(),grantedAuthoritys);

        return user;
    }

    public UserInfo getUserByAccount(String userAccount) {

        UserInfo userInfo = loginMapper.getUserByAccount(userAccount);

        return userInfo;
    }
}
