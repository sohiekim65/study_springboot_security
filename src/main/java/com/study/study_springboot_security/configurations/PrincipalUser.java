package com.study.study_springboot_security.configurations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PrincipalUser implements UserDetails {

    private Map userInfo;
    private String memberName;

    public Map getUserInfo() {
        return userInfo;
    }

    public String getMemberName() {
        return memberName;
    }

    public PrincipalUser(Map userInfo) {
        this.userInfo = userInfo;   // 생성자에 들어온 userInfo 세팅
        int i = 1;
        this.memberName = (String) userInfo.get("NAME");
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // 권한들
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(new SimpleGrantedAuthority((String) userInfo.get("AUTHORITY")));
        return collections;
    }


    @Override
    public String getPassword() {
        // password
        return (String) userInfo.get("PASSWORD");
    }

    @Override
    public String getUsername() {
        // ID
        return (String) userInfo.get("MEMBER_ID");  // DB에서 가져와서 MEMBER_ID로
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정을 일시적으로 잠구고 싶을 때 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 원래 계정에서 변경 기간 만료 (주로 비밀번호)
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 휴면 계정 여부
        return true;
    }
}
