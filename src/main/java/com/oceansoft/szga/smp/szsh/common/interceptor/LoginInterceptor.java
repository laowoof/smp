package com.oceansoft.szga.smp.szsh.common.interceptor;

import com.oceansoft.szga.smp.szsh.common.util.SpringContext;
import com.oceansoft.szga.smp.szsh.core.dto.SignInDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysUser;
import com.oceansoft.szga.smp.szsh.core.service.system.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wx
 * @version 2018/12/25
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (session != null&&session.getAttribute("session_user")==null) {
            Object obj = session.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
            if (obj != null) {
                Assertion assertion = (Assertion)obj;
                AttributePrincipal p= assertion.getPrincipal();
//                String userName= p.getName();//获取警号
                String idcard = (String) p.getAttributes().get("idcard");
                SysUserService userService= SpringContext.getBean(SysUserService.class);
                SysUser user=userService.findUserByNameNoRole(idcard);
                if(user==null){//临时处理，未找到用户，使用admin
                    user=userService.findUserByNameNoRole("123456");
                }
                session.setAttribute("session_user",user);

//                session.setAttribute(AbstractCasFilter.CONST_CAS_ASSERTION,null);
//                httpServletRequest.logout();
                if(user!=null) {
                    SignInDTO signInDTO=new SignInDTO();
                    signInDTO.setUsername(user.getUsername());
                    signInDTO.setPassword(user.getPassword());
                    userService.signIn(signInDTO);
                }else{//清空单点session
//                    session.setAttribute(AbstractCasFilter.CONST_CAS_ASSERTION,null);
                    SecurityUtils.getSubject().logout();
                }

            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
