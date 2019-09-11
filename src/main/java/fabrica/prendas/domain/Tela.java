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
    @NamedQuery(name = "Tela.findByCosto", query = "SELECT t FROM Tela t WHERE t.costo = :costo"),
    @NamedQuery(name = "Tela.findByCostoPorMetro", query = "SELECT t FROM Tela t WHERE t.costoMetro = :costoMetro")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tela implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    private Double costo;
    
    @Column(name = "costo_por_metro")
    private Double costoMetro;
    
    @Column(name = "largo")
    private Integer largo;
    
    @Column(name = "ancho")
    private Integer ancho;

    public Tela() {
    }

    public Tela(Integer idTela) {
        this.idTela = idTela;
    }

    public Tela(String nombreTela) {
        this.nombreTela = nombreTela;
    }
    
    public Tela(Integer idTela, String tipoTela, String nombreTela, String colorTela, Integer metros, Double costo, Double costoMetro, Integer largo, Integer ancho) {
        this.idTela = idTela;
        this.tipoTela = tipoTela;
        this.nombreTela = nombreTela;
        this.colorTela = colorTela;
        this.metros = metros;
        this.costo = costo;
        this.costoMetro = costoMetro;
        this.largo = largo;
        this.ancho = ancho;
    }

    public Tela(String tipoTela, String nombreTela, String colorTela, Integer metros, Double costo, Double costoMetro, Integer largo, Integer ancho) {
        this.tipoTela = tipoTela;
        this.nombreTela = nombreTela;
        this.colorTela = colorTela;
        this.metros = metros;
        this.costo = costo;
        this.costoMetro = costoMetro;
        this.largo = largo;
        this.ancho = ancho;
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

    public String getColorTela() {
        return colorTela;
    }

    public void setColorTela(String colorTela) {
        this.colorTela = colorTela;
    }

    public Integer getMetros() {
        return metros;
    }

    public void setMetros(Integer metros) {
        this.metros = metros;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getCostoMetro() {
        return costoMetro;
    }

    public void setCostoMetro(Double costoMetro) {
        this.costoMetro = costoMetro;
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idTela);
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
        return "Tela{" + "idTela=" + idTela + ", tipoTela=" + tipoTela + ", nombreTela=" + nombreTela + ", colorTela=" + colorTela + ", metros=" + metros + ", costo=" + costo + ", costoMetro=" + costoMetro + ", largo=" + largo + ", ancho=" + ancho + '}';
    }
    
    
}
