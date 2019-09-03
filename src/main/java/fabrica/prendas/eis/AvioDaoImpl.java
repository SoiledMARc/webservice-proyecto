package fabrica.prendas.eis;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import fabrica.prendas.domain.Avios;

@Stateless
public class AvioDaoImpl implements AvioDao{

    @PersistenceContext(unitName = "MaterialPU")
    EntityManager em;
    
    @Override
    public List<Avios> findAll() {
        return em.createNamedQuery("Avios.findAll").getResultList();
    }

    @Override
    public List<Avios> findByTipo(Avios a) {
        Query query = em.createNamedQuery("Avios.findByTipo");
        query.setParameter("tipoAvio", a.getTipoAvio());
        return query.getResultList();
    }

    @Override
    public Avios findById(Avios a) {
        return em.find(Avios.class, a.getIdAvios());
    }

    @Override
    public Avios findByNombre(Avios a) {
        Query query = em.createNamedQuery("from Avios a where a.nombreAvio =: nombreAvio");
        query.setParameter("nombreAvio", a.getNombreAvio());
        return (Avios) query.getSingleResult();
    }

    @Override
    public void inserteAvio(Avios a) {
        em.persist(a);
    }

    @Override
    public void updateAvios(Avios a) {
        em.merge(a);
    }

    @Override
    public void deleteAvios(Avios a) {
        em.remove(em.merge(a));
    }
    
}
