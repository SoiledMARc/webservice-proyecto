package fabrica.prendas.eis;

import java.util.List;
import javax.ejb.Local;
import fabrica.prendas.domain.Tela;

@Local
public interface TelaDao {
    
    public List<Tela> findAll();    
    public Tela findTelaById(Tela tela);    
    public List<Tela> findTelaByTipo(Tela tela);
    public Tela findTelaByNombre(Tela tela);
    public void insertTela(Tela tela);
    public void updateTela(Tela tela);
    public void delete(Tela tela);
    
}
