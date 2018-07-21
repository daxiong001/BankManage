package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "EncodingFilter",value = "/encoding")
public class EncodingFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

    public EncodingFilter(){
        System.out.println("过滤器构造");
    }

}
