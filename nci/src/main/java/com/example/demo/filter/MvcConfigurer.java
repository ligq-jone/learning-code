package com.example.demo.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
  //拦截器 将加一个拦截器，检查会话， URL admin 开头的都使用此拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    //将加一个拦截器，检查会话， URL admin 开头的都使用此拦截器
        registry.addInterceptor(new SessionHandlerintercept()).addPathPatterns("/admin/**");
    }
    class SessionHandlerintercept implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            Object obj=request.getSession().getAttribute("user");
            if(obj==null){
                //没有数据重定向到登陆页面
                response.sendRedirect("login.html");
                return false;
            }
            return true;
        }
        // Controller 方法处理完毕后，调用此方法
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //页面渲染完毕后调用此方法，通常用来清除某些资源，类似 Java 语法 finally
        }


    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许所有请求跨域
        registry.addMapping("/**");
        //仅仅允许来自 admin.com 的跨域访问，并且限定访问路径为／app 、方法是 POST 或者 GET
        registry.addMapping("/app/**").
                allowedOrigins("http://admin.com").allowedMethods("POST","GET");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //对于 login.html 请求，设置返回的视图为 login.htl
        //所有以.do 结尾的请求重定向到／ login.html 请求
        registry.addViewController("/login.html").setViewName("login.btl");
        registry.addRedirectViewController("/**/*.do","login.html");

    }
}
