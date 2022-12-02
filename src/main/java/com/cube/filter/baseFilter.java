package com.cube.filter;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class baseFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        String contextPath = request.getServletContext().getContextPath();
        String uri = ((HttpServletRequest) request).getRequestURI(); //获得访问URI
        uri = StringUtils.remove(uri, contextPath); //截取URI访问路径部分，如 admin_category_list
        if (uri.startsWith("/admin_")) {
            String servletPath = StringUtils.substringAfterLast(uri, "_") + "Servlet"; // list
            request.getRequestDispatcher("/" + servletPath).forward(request, response); // 服务端跳转，算同一次请求，数据可以放 request 里传递
            return;
        }

        chain.doFilter(request, response);
    }
}
