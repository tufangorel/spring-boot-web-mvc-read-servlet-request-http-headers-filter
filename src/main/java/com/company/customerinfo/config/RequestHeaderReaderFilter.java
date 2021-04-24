package com.company.customerinfo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class RequestHeaderReaderFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHeaderReaderFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {


        Map<String, Object> returnValue = new HashMap<>();
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while(headerNames.hasMoreElements())
        {
            String headerName = headerNames.nextElement();
            String headerValue = httpServletRequest.getHeader(headerName);
            returnValue.put(headerName, headerValue);
            LOGGER.info(headerName+" : "+headerValue);

            httpServletResponse.addHeader(headerName,headerValue);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}