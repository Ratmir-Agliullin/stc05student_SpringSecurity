package main.Controllers.filters;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 20.04.2017.
 */
public class WhiteList implements javax.servlet.Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userLogin = (String)((HttpServletRequest)servletRequest).getSession().getAttribute("userLogin");
        if(userLogin !=null) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else{
            ((HttpServletResponse)servletResponse).sendRedirect("error"); // пометка 6
        }
    }

    @Override
    public void destroy() {

    }
}
