package com.oceansoft.szga.smp.szsh.core.config.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

@NoArgsConstructor
@Data
public class JwtToken implements AuthenticationToken {

    private String token;

    private String username;

    private String password;

    private String uid;

//    private String name;
//
//    private String departmentName;
//
//    private String departmentId;

    public JwtToken(String token, String username, String password) {
        this.token = token;
        this.username = username;
        this.password = password;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
