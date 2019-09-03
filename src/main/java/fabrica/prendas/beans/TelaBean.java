package fabrica.prendas.beans;

import fabrica.prendas.domain.Tela;
import fabrica.prendas.servicio.TelaService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named("telaBean")
@RequestScoped
public class TelaBean {

    @Inject
    private TelaService telaService;

    private Tela telaSeleccionada;

    List<Tela> telas;

    public TelaBean() {
    }

    @PostConstruct
    public void inicializar() {
        telas = telaService.listarTelas();
        telaSeleccionada = new Tela();
    }

    public void editListener(RowEditEvent event) {
        Tela tela = (Tela) event.getObject();
        telaService.modificar(tela);
    }

    public List<Tela> getTelas() {
        return telas;
    }

    public void setTelas(List<Tela> telas) {
        this.telas = telas;
    }

    public Tela getTelaSeleccionada() {
        return telaSeleccionada;
    }

    public void setTelaSeleccionada(Tela telaSeleccionada) {
        this.telaSeleccionada = telaSeleccionada;
    }

    public void reiniciarTelaSeleccionada() {
        this.telaSeleccionada = new Tela();
    }

    public void agregarTela() {
        telaService.agregarTela(this.telaSeleccionada);
        this.telaSeleccionada = null;
        this.inicializar();
    }

    public void eliminarTela() {
        telaService.eliminar(this.telaSeleccionada);
        this.telaSeleccionada = null;
        this.inicializar();
    }

    public TelaService getTelaService() {
        return telaService;
    }

    public void setTelaService(TelaService telaService) {
        this.telaService = telaService;
    }
}
