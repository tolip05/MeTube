package metube.web.filters;

import metube.domein.models.binding.TubeUploadBindingModel;
import metube.domein.models.binding.UserLoginBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/tube/upload")
public class TubeUploadFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        TubeUploadBindingModel tubeUploadBindingModel = new TubeUploadBindingModel();
        tubeUploadBindingModel.setTitle(req.getParameter("title"));
        tubeUploadBindingModel.setAuthor(req.getParameter("author"));
        tubeUploadBindingModel.setYoutubeLink(req.getParameter("youtube-link"));
        tubeUploadBindingModel.setDescription(req.getParameter("description"));

        tubeUploadBindingModel.setUploader((String) req.getSession().getAttribute("username"));
        req.setAttribute("model",null);
        req.setAttribute("model",tubeUploadBindingModel);
        filterChain.doFilter(req,resp);
    }

}
