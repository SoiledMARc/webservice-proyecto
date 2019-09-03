package fabrica.prendas.servicio;

import java.util.List;
import javax.ejb.Local;
import fabrica.prendas.domain.Avios;

@Local
public interface AvioService {
    public List<Avios> listarTodos();
    public List<Avios> encontraPorTipo(Avios a);
    public Avios encontrarPorId(Avios a);
    public Avios encontrarPorNombre(Avios a);
    public void insertarAvio(Avios a);
    public void modificarAvio(Avios a);
    public void eliminarAvio(Avios a);
    
}
