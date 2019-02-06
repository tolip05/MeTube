package metube.domein.repositoy;

import metube.domein.enteties.Tube;

public interface TubeRepository extends GenericRepository<Tube,String> {
    Tube update(Tube tube);
}
