package com.itheima.utils;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1.获取请求url 可删掉,用来看访问路径的日志
        String url = request.getRequestURL().toString();
        log.info("请求路径:{}", url); // http://localhost:90/login

        // 3.获取请求头中的令牌(token)
        String token = request.getHeader("token");
        log.info("从请求头中获取的令牌:{}", token);

        // 4.判断令牌是否存在,如果不存在,返回错误结果(未登录)
        if (!StringUtils.hasLength(token)) {
            log.info("Token不存在");
            Result responseResult = Result.error("NOT_LOGIN");
            // 把Result对象转换为JSON格式字符串(fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            // 响应
            response.getWriter().write(json);

            return false;
        }

        // 5.解析token,如果解析失败,返回错误结果(未登录)
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("令牌解析失败");
            Result responseResult = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);

            return false;
        }

        // 放行请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
