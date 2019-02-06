package metube.domein.service;

import metube.domein.enteties.Tube;
import metube.domein.models.service.TubeServiceModel;
import metube.domein.repositoy.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class TubeServiceImpl implements TubeService {

    private final TubeRepository tubeRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, UserService userService, ModelMapper modelMapper) {
        this.tubeRepository = tubeRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean uploadTube(TubeServiceModel tubeServiceModel) {
        tubeServiceModel
                .setUploader(this.userService.findUserByUsername(tubeServiceModel.getUploader().getUsername()));

        try{
         this.tubeRepository.update(this.modelMapper.map(tubeServiceModel, Tube.class));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public TubeServiceModel findTubeById(String id) {
        Tube tube = this.tubeRepository.findById(id);

        if (tube == null){
            throw new IllegalStateException();
        }
        return this.modelMapper.map(tube,TubeServiceModel.class);
    }
}
