package fabrica.prendas.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "avios")
@NamedQueries({
    @NamedQuery(name = "Avios.findAll", query = "SELECT a FROM Avios a"),
    @NamedQuery(name = "Avios.findById", query = "SELECT a FROM Avios a WHERE a.idAvios = :idAvios"),
    @NamedQuery(name = "Avios.findByTipo", query = "SELECT a FROM Avios a WHERE a.tipoAvio = :tipoAvios"),
    @NamedQuery(name = "Avios.findByNombre", query = "SELECT a FROM Avios a WHERE a.nombreAvio = :nombreAvio"),
    @NamedQuery(name = "Avios.findByCantidad", query = "SELECT a FROM Avios a WHERE a.cantidadAvio = :cantidadAvio"),
    @NamedQuery(name = "Avios.findByCosto", query = "SELECT a FROM Avios a WHERE a.costoAvio = :costoAvio")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Avios implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idAvios;
    
    @Column(name = "tipo")
    private String tipoAvio;
    
    @Column(name = "nombre")
    private String nombreAvio;
    
    @Column(name = "cantidad")
    private Integer cantidadAvio;
    
    @Column(name = "costo")
    private Double costoAvio;
    
    @Column(name = "costo_unitario")
    private Double costoUnitario;

    public Avios() {
    }

    public Avios(Integer idAvios) {
        this.idAvios = idAvios;
    }

    public Avios(String tipoAvio) {
        this.tipoAvio = tipoAvio;
    }

    public Avios(Integer idAvios, String tipoAvio, String nombreAvio, Integer cantidadAvio, Double costoAvio, Double costoUnitario) {
        this.idAvios = idAvios;
        this.tipoAvio = tipoAvio;
        this.nombreAvio = nombreAvio;
        this.cantidadAvio = cantidadAvio;
        this.costoAvio = costoAvio;
        this.costoUnitario = costoUnitario;
    }

    public Integer getIdAvios() {
        return idAvios;
    }

    public void setIdAvios(Integer idAvios) {
        this.idAvios = idAvios;
    }

    public String getTipoAvio() {
        return tipoAvio;
    }

    public void setTipoAvio(String tipoAvio) {
        this.tipoAvio = tipoAvio;
    }

    public String getNombreAvio() {
        return nombreAvio;
    }

    public void setNombreAvio(String nombreAvio) {
        this.nombreAvio = nombreAvio;
    }

    public Integer getCantidadAvio() {
        return cantidadAvio;
    }

    public void setCantidadAvio(Integer cantidadAvio) {
        this.cantidadAvio = cantidadAvio;
    }

    public Double getCostoAvio() {
        return costoAvio;
    }

    public void setCostoAvio(Double costoAvio) {
        this.costoAvio = costoAvio;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.idAvios);
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
        final Avios other = (Avios) obj;
        if (!Objects.equals(this.idAvios, other.idAvios)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avios{" + "idAvios=" + idAvios + ", tipoAvio=" + tipoAvio + ", nombreAvio=" + nombreAvio + ", cantidadAvio=" + cantidadAvio + ", costoAvio=" + costoAvio + ", costoUnitario=" + costoUnitario + '}';
    }
    
}
