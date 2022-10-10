package com.example.demo.foundation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author YuChenXi
 * @date 2022/3/26 9:08 下午
 */
@WebFilter(urlPatterns = "/*")
@Component
public class ServiceFilter implements Filter {

    @Autowired
    private InterfaceLogEvent interfaceLogEvent;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        String ip = getRemoteIP(request);
        if (null == ip || "".equals(ip)) {
            ip = "cannot get ip address";
        }
        Long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
     //   response.setHeader("Access-Control-Allow-Origin","*");
        Long endTime = System.currentTimeMillis();
        InterfaceLogEntity logEntity = new InterfaceLogEntity().
                setInterfaceName(url).
                setIpAddress(ip).
                setStartTime(startTime).
                setEndTime(endTime);
        interfaceLogEvent.printLog(logEntity);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    public String getRemoteIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
