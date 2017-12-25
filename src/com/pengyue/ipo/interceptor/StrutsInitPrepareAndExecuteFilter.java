package com.pengyue.ipo.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
 import javax.servlet.ServletException;
 import javax.servlet.ServletRequest;
 import javax.servlet.ServletResponse;
 import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class StrutsInitPrepareAndExecuteFilter extends StrutsPrepareAndExecuteFilter 
 {
      @Override  
     public void doFilter(ServletRequest req, ServletResponse res,  
               FilterChain chain) throws IOException, ServletException {  
     
         try {  
               HttpServletRequest request = (HttpServletRequest) req;  
               // 判断是否是向WebService发出的请求   
              // System.out.println(request.getRequestURI());
                if (request.getRequestURI().contains("/webservice") ) {  
                  // 如果是来自向CXFService发出的请求   
                   chain.doFilter(req, res);  
                   
                }else if (request.getRequestURI().contains("controller.jsp")) {  
                    // 如果是来自向CXFService发出的请求   
                    chain.doFilter(req, res);  
                    
                 } else {  
                   // 默认action请求 
                  super.doFilter(req, res, chain);  
               }  
           } catch (Exception e) {  
                 e.printStackTrace();  
            }  
         }
 }
