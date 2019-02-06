package metube.domein.service;

import metube.domein.models.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    boolean userLogin(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsername(String username);
}
