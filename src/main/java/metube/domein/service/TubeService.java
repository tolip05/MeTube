package metube.domein.service;

import metube.domein.models.service.TubeServiceModel;

public interface TubeService {
    boolean uploadTube(TubeServiceModel tubeServiceModel);

    TubeServiceModel findTubeById(String id);
}
