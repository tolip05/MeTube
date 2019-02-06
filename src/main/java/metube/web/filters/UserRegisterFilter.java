package metube.web.filters;

import metube.domein.models.binding.UserRegisterBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/register")
public class UserRegisterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getMethod().toLowerCase().equals("post")){
            UserRegisterBindingModel registerBindingModel = new UserRegisterBindingModel();
            registerBindingModel.setUsername(req.getParameter("username"));
            registerBindingModel.setPassword(req.getParameter("password"));
            registerBindingModel.setConfirmPassword(req.getParameter("confirmPassword"));
            registerBindingModel.setEmail(req.getParameter("email"));
            req.setAttribute("model",registerBindingModel);
        }
        filterChain.doFilter(req,resp);
    }
}
