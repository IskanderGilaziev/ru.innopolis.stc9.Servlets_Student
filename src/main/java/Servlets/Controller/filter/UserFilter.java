package Servlets.Controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest)servletRequest).getSession();

        if(httpSession.getAttribute("login")!= null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login?errorMsg=noAuth");
        }
    }

    @Override
    public void destroy() {

    }
}
