package com.study.study_springboot_security.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component  
public class CommonUtils {

    // uid자동으로 만들기 위해
    public String getUniqueSequence() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
