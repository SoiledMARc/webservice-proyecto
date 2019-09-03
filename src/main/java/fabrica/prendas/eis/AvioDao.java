package fabrica.prendas.eis;

import java.util.List;
import javax.ejb.Local;
import fabrica.prendas.domain.Avios;

@Local
public interface AvioDao {
    public List<Avios> findAll();
    public List<Avios> findByTipo(Avios a);
    public Avios findById(Avios a);
    public Avios findByNombre(Avios a);
    public void inserteAvio(Avios a);
    public void updateAvios(Avios a);
    public void deleteAvios(Avios a);
}
