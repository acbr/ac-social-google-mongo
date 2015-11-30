package com.avenuecode.security;

import com.avenuecode.mongo.MongoConnection;
import com.avenuecode.repositories.UserConnectionInternalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ac-jlima on 11/28/15.
 */
public class MongoUserDetailService implements UserDetailsService {

    @Autowired
    private UserConnectionInternalRepository userConnectionInternalRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MongoConnection userInternal = userConnectionInternalRepository.findByUserId(username);
        User userDetail = new User(userInternal.getUserId(), null, true,
                true, true, true, getAuthorities(1));

        return userDetail;
    }

    public List<GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if(role.equals(1)) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if(role.equals(2)) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return authList;
    }

}
