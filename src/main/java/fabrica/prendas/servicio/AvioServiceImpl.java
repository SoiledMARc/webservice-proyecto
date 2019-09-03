package fabrica.prendas.servicio;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import fabrica.prendas.domain.Avios;
import fabrica.prendas.eis.AvioDao;


@Stateless
@DeclareRoles({ "ROLE_ADMIN", "ROLE_USER" })
@RolesAllowed({ "ROLE_ADMIN", "ROLE_USER" })
public class AvioServiceImpl implements AvioService{

    @Resource
    private SessionContext contexto;
    
    @Inject
    private AvioDao avioDao;
    
    @Override
    public List<Avios> listarTodos() {
        return avioDao.findAll();
    }

    @Override
    public List<Avios> encontraPorTipo(Avios a) {
        return avioDao.findByTipo(a);
    }

    @Override
    public Avios encontrarPorId(Avios a) {
        return avioDao.findById(a);
    }

    @Override
    public Avios encontrarPorNombre(Avios a) {
        return avioDao.findByNombre(a);
    }

    @Override
    public void insertarAvio(Avios a) {
        avioDao.inserteAvio(a);
    }

    @Override
    public void modificarAvio(Avios a) {
        avioDao.updateAvios(a);
    }

    @Override
    public void eliminarAvio(Avios a) {
        avioDao.deleteAvios(a);
    }
    
}
