package com.study.study_springboot_security.services;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.study.study_springboot_security.daos.SharedDao;
import com.study.study_springboot_security.utils.CommonUtils;

import java.util.Map;

@Service
public class MemberWithAuthorityService {

    @Autowired
    SharedDao sharedDao;

    @Autowired
    CommonUtils commonUtils;

    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;

    public Object insert(Object dataMap) {
        String sqlMapId = "Memberwithauthority.insertWithUID";
        // 자동으로 만든 uid를 dataMap에 넣어주기
        ((Map)dataMap).put("USERS_UID", commonUtils.getUniqueSequence());
        ((Map)dataMap).put("role", "ROLE_USER");
        // normal to crypto password
        String password = (String)((Map)dataMap).get("password");    // 먼저 가져오기
        ((Map)dataMap).put("password", bcryptPasswordEncoder.encode(password));
        
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }
}
