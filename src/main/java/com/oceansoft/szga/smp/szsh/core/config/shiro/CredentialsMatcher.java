package com.oceansoft.szga.smp.szsh.core.config.shiro;


import com.oceansoft.szga.smp.szsh.core.config.jwt.JwtToken;
import com.oceansoft.szga.smp.szsh.common.util.Encrypt;
import com.oceansoft.szga.smp.szsh.common.util.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author wx
 * @version 2018/9/25
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        JwtToken jwtToken = (JwtToken) token;
        Object accountCredentials = getCredentials(info);
        if(jwtToken.getPassword()!=null){
            Object tokenCredentials;
            if(jwtToken.getPassword().length()>30){
                tokenCredentials=jwtToken.getPassword();
            }else{
                tokenCredentials = Encrypt.md5(String.valueOf(
                        jwtToken.getPassword())+jwtToken.getUsername());
            }
            if(!accountCredentials.equals(tokenCredentials)){
                throw new DisabledAccountException("密码不正确！");
            }
        }else{
            boolean verify = JwtUtil.verify(jwtToken.getToken(), jwtToken.getUsername(), accountCredentials.toString());
            if(!verify){
                throw new DisabledAccountException("verifyFail");
            }
        }
        return true;
    }

}
