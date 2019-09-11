package fabrica.prendas.eis;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import fabrica.prendas.domain.Tela;
        
@Stateless
public class TelaDaoImpl implements TelaDao{

    @PersistenceContext(unitName = "MaterialPU")
    EntityManager em;
    
    @Override
    public List<Tela> findAll() {
        return em.createNamedQuery("Tela.findAll").getResultList();
    }

    @Override
    public Tela findTelaById(Tela tela) {
        return em.find(Tela.class, tela.getIdTela());
    }

    @Override
    public List<Tela> findTelaByTipo(Tela tela) {
       Query query = em.createNamedQuery("Tela.findByTipo");
       query.setParameter("tipoTela", tela.getTipoTela());
       return query.getResultList();
    }

    @Override
    public Tela findTelaByNombre(Tela tela) {
        Query query = em.createNamedQuery("Tela.findByNombre");
        query.setParameter("nombre", tela.getNombreTela());
        return (Tela) query.getSingleResult();
    }

    @Override
    public void insertTela(Tela tela) {
        System.out.println("persist: " + tela.getNombreTela());
        em.persist(tela);
    }

    @Override
    public void updateTela(Tela telaModificada) {
       em.merge(telaModificada);
    }

    @Override
    public void delete(Tela tela) {
        em.remove(em.merge(tela));
    }
    
}
