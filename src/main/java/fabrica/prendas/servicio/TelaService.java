package fabrica.prendas.servicio;

import java.util.List;
import javax.ejb.Local;
import fabrica.prendas.domain.Tela;

@Local
public interface TelaService {
    public List<Tela> listarTelas();
    public Tela encontrarTelaPorId(Tela tela);
    public List<Tela> encontrarPorTipo(Tela tela);
    public Tela encontrarPorNombre(Tela tela);
    public void agregarTela(Tela tela);
    public void modificar(Tela tela);
    public void eliminar(Tela tela);
}
