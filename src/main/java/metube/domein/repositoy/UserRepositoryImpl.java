package metube.domein.repositoy;

import metube.domein.enteties.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User save(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAll() {
        this.entityManager.getTransaction().begin();
        List<User>allUser =
                this.entityManager
                        .createQuery("SELECT u FROM users u",User.class)
                        .getResultList();
        this.entityManager.getTransaction().commit();
        return allUser;
    }

    @Override
    public User findById(String id) {
        this.entityManager.getTransaction().begin();
        User user = this.entityManager
                .createQuery("SELECT t FROM users  t WHERE t.id = :id ",User.class)
                .setParameter("id",id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();
        long sizeUser = this.entityManager
                .createQuery("SELECT COUNT(t) FROM users t",long.class)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return sizeUser;
    }

    @Override
    public User findByUserNameAndPassword(String username,String password) {

        this.entityManager.getTransaction().begin();
        User user = null;
        try{
             user = this.entityManager
                    .createQuery("SELECT u FROM users u WHERE u.username =: username AND u.password =:password"
                            ,User.class)
                    .setParameter("username",username)
                    .setParameter("password",password)
                    .getSingleResult();
            return user;
        }catch (Exception e){
            return null;
        }finally {
            this.entityManager.getTransaction().commit();
        }


    }

    @Override
    public User findByUsername(String username) {
        this.entityManager.getTransaction().begin();
        User user = null;
        try{
            user = this.entityManager
                    .createQuery("SELECT u FROM users u WHERE u.username =:username"
                            ,User.class)
                    .setParameter("username",username)
                    .getSingleResult();
            return user;
        }catch (Exception e){
            return null;
        }finally {
            this.entityManager.getTransaction().commit();
        }
    }
}
