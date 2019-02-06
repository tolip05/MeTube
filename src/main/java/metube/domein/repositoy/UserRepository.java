package metube.domein.repositoy;

import metube.domein.enteties.User;

public interface UserRepository extends GenericRepository<User,String> {

    User findByUserNameAndPassword(String username,String password);
    User findByUsername(String username);
}
