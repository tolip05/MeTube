package metube.domein.repositoy;

import metube.domein.enteties.Tube;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class TubeRepositoryImpl implements TubeRepository {
    private final EntityManager entityManager;

    @Inject
    public TubeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Tube save(Tube entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Tube> findAll() {
        this.entityManager.getTransaction().begin();
        List<Tube>allTube =
                this.entityManager
                        .createQuery("SELECT t FROM tubes t",Tube.class)
                        .getResultList();
        this.entityManager.getTransaction().commit();
        return allTube;
    }

    @Override
    public Tube findById(String id) {
 //       this.entityManager.getTransaction().begin();
        Tube tube = this.entityManager
                .createQuery("SELECT t FROM tubes t WHERE t.id = :id ",Tube.class)
                .setParameter("id",id)
                .getSingleResult();
 //       this.entityManager.getTransaction().commit();
        return tube;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();
        long sizeTube = this.entityManager
                .createQuery("SELECT COUNT(t) FROM tubes t",long.class)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return sizeTube;
    }

    @Override
    public Tube update(Tube tube) {
        this.entityManager.merge(tube);
        return tube;
    }
}
