package fabrica.prendas.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "tela")
@NamedQueries({
    @NamedQuery(name = "Tela.findAll", query = "SELECT t FROM Tela t"),
    @NamedQuery(name = "Tela.findById", query = "SELECT t FROM Tela t WHERE t.idTela = :idTela"),
    @NamedQuery(name = "Tela.findByTipo" , query = "SELECT t FROM Tela t WHERE t.tipoTela = :tipoTela"),
    @NamedQuery(name = "Tela.findByNombre", query = "SELECT t FROM Tela t WHERE t.nombreTela = :nombreTela"),
    @NamedQuery(name = "Tela.findByColor" , query = "SELECT t FROM Tela t WHERE t.colorTela = :colorTela"),
    @NamedQuery(name = "Tela.findByMetros", query = "SELECT t FROM Tela t WHERE t.metros = :metros"),
    @NamedQuery(name = "Tela.findByCosto", query = "SELECT t FROM Tela t WHERE t.costo = :costo")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tela implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtela")
    private Integer idTela;
    
    @Column(name = "tipo")
    private String tipoTela;
    
    @Column(name = "nombre")
    private String nombreTela;
    
    @Column(name = "color")
    private String colorTela;
    
    @Column(name = "metros")
    private Integer metros;
    
    @Column(name = "costo")
    private Integer costo;

    public Tela() {
    }

    public Tela(Integer idTela) {
        this.idTela = idTela;
    }

    public Tela(Integer idTela, String tipoTela, String nombreTela, String colorTela, Integer metros, Integer costo) {
        this.idTela = idTela;
        this.tipoTela = tipoTela;
        this.nombreTela = nombreTela;
        this.colorTela = colorTela;
        this.metros = metros;
        this.costo = costo;
    }

    public Tela(String tipoTela, String nombreTela, String colorTela, Integer metros, Integer costo) {
        this.tipoTela = tipoTela;
        this.nombreTela = nombreTela;
        this.colorTela = colorTela;
        this.metros = metros;
        this.costo = costo;
    }    
    
    public Integer getIdTela() {
        return idTela;
    }

    public void setIdTela(Integer idTela) {
        this.idTela = idTela;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getNombreTela() {
        return nombreTela;
    }

    public void setNombreTela(String nombreTela) {
        this.nombreTela = nombreTela;
    }
    
    public Integer getMetros() {
        return metros;
    }

    public String getColorTela() {
        return colorTela;
    }

    public void setColorTela(String colorTela) {
        this.colorTela = colorTela;
    }

    public void setMetros(Integer metros) {
        this.metros = metros;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idTela);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tela other = (Tela) obj;
        if (!Objects.equals(this.idTela, other.idTela)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tela{" + "idTela=" + idTela + ", tipoTela=" + tipoTela + ", nombreTela=" + nombreTela + ", colorTela=" + colorTela + ", metros=" + metros + ", costo=" + costo + '}';
    }
    
}
