package com.oceansoft.szga.smp.exception;

import com.alibaba.fastjson.JSON;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 控制器异常处理(仅处理Spring框架内异常)
 *
 * @author chenw
 * @create 2016-12-29 17:13
 * @email javacspring@gmail.com
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    private static final String DEFAULT_ERROR_VIEW="error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        logger.error("系统异常", ex);
        if(isAjax(request)){
            PrintWriter writer = null;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            try {
                writer = response.getWriter();
                writer.write(JSON.toJSONString(new ApiResult<>().failure(ex.getMessage())));
            } catch (IOException e) {
                logger.error(e.getMessage());
            } finally {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            }
            return null;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", ex);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            return mav;
        }

    }

    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))
                || "application/json".equalsIgnoreCase(request.getHeader("Accept"))
                || request.getRequestURI().endsWith("json");
    }

}
