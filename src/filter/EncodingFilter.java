package filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements javax.servlet.Filter {
    private static String encoding;
    public EncodingFilter(){
        System.out.println("过滤器");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8"); //将编码改为utf-8
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
