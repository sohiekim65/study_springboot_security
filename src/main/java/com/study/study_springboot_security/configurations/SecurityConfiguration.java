package com.study.study_springboot_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean   // 메소드 자체를 Bean으로 만들어주기
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // csrf protection 사용하지 않는다는 걸 security에게 알리기
        httpSecurity.csrf().disable();

        // 권한에 대한 부분 - url & roles : user url & roles 비교
        httpSecurity.authorizeRequests()
            // main 페이지는 일반 사용자와 관리자 권한 모두 가능하게
            // .antMatchers("/").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")   // 복수일 경우 hasRole(''으로 감싸주기)로 감싸줘서 or 로 추가해주기
            // admin 페이지는 관리자 권한만
            // .antMatchers("/").authenticated()   // 로그인 여부만 체크
            // .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")  // 로그인 & 권한까지 체크
            .antMatchers("/admin").authenticated()  // admin은 로그인을 해야하고 나머지는 로그인 안해도 됨.
            .anyRequest().permitAll(); // 위에 설정한 거 말고 그 외는 모두 접근 가능(로그인 & 로그아웃도 가능).
        
            // 로그인에 대한 부분
            httpSecurity.formLogin().loginPage("/loginForm")
                .loginProcessingUrl("/login") // 여기 /login은 spring 주소창 /login
                .defaultSuccessUrl("/");

        return httpSecurity.build();    // build는 SecurityFilterChain와 httpSecurity 타입이 안맞아서 해줌.
    }
}
