package fabrica.prendas.servicio;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import fabrica.prendas.domain.Tela;
import fabrica.prendas.eis.TelaDao;

@Stateless
@WebService(endpointInterface = "fabrica.prendas.servicio.TelaServiceWs")
@DeclareRoles({ "ROLE_ADMIN", "ROLE_USER" })
@RolesAllowed({ "ROLE_ADMIN", "ROLE_USER" })
public class TelaServiceImpl implements TelaService, TelaServiceWs{

    @Resource
    private SessionContext contexto;
    
    @Inject
    private TelaDao telaDao;
    
    @Override
    public List<Tela> listarTelas() {
        return telaDao.findAll();
    }

    @Override
    public Tela encontrarTelaPorId(Tela tela) {
        return telaDao.findTelaById(tela);
    }

    @Override
    public List<Tela> encontrarPorTipo(Tela tela) {
        return telaDao.findTelaByTipo(tela);
    }

    @Override
    public Tela encontrarPorNombre(Tela tela) {
        return telaDao.findTelaByNombre(tela);
    }

    @Override
    public void agregarTela(Tela tela) {
        System.out.println("dao: " + tela.getNombreTela());
        telaDao.insertTela(tela);
    }

    @Override
    public void modificar(Tela tela) {
        try{
            telaDao.updateTela(tela);
        }catch(Throwable t){
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminar(Tela tela) {
        telaDao.delete(tela);
    }
    
}
