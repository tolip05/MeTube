package metube.web.servlets;

import metube.domein.models.binding.TubeUploadBindingModel;
import metube.domein.models.service.TubeServiceModel;
import metube.domein.models.service.UserServiceModel;
import metube.domein.service.TubeService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tube/upload")
public class TubeUploadServlet extends HttpServlet {

    private final ModelMapper modelMapper;
    private final TubeService tubeService;

    @Inject
    public TubeUploadServlet(ModelMapper modelMapper, TubeService tubeService) {
        this.modelMapper = modelMapper;
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/upload.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TubeUploadBindingModel tubeUploadBindingModel = (TubeUploadBindingModel) req.getAttribute("model");
        TubeServiceModel tubeServiceModel = this.modelMapper
                .map(tubeUploadBindingModel,TubeServiceModel.class);
        tubeServiceModel.setYoutubeId(tubeUploadBindingModel.getYoutubeLink()
                .split("\\=")[1]);
        UserServiceModel userServiceModel = new UserServiceModel();
        userServiceModel.setUsername(tubeUploadBindingModel.getUploader());

        tubeServiceModel.setUploader(userServiceModel);

        this.tubeService.uploadTube(tubeServiceModel);
        resp.sendRedirect("/home");
    }
}
