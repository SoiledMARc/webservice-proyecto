package fabrica.prendas.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import fabrica.prendas.domain.Tela;

@WebService
public interface TelaServiceWs {
    @WebMethod
    public List<Tela> listarTelas();
    @WebMethod
    public Tela encontrarTelaPorId(Tela tela);
    @WebMethod
    public List<Tela> encontrarPorTipo(Tela tela);
    @WebMethod
    public Tela encontrarPorNombre(Tela tela);
    @WebMethod
    public void agregarTela(Tela tela);
    @WebMethod
    public void modificar(Tela tela);
    @WebMethod
    public void eliminar(Tela tela);
}
