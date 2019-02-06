package metube.web.filters;

import metube.domein.models.binding.UserLoginBindingModel;
import metube.domein.models.binding.UserRegisterBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login")
public class UserLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getMethod().toLowerCase().equals("post")){
            UserLoginBindingModel loginBindingModel = new UserLoginBindingModel();
            loginBindingModel.setUsername(req.getParameter("username"));
            loginBindingModel.setPassword(req.getParameter("password"));

            req.setAttribute("login",loginBindingModel);
        }
        filterChain.doFilter(req,resp);
    }
}
