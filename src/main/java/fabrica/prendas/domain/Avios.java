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
    @Column(name = "idavios")
    private Integer idAvios;
    
    @Column(name = "tipo_avio")
    private String tipoAvio;
    
    @Column(name = "nombre_avio")
    private String nombreAvio;
    
    @Column(name = "cantidad_avio")
    private Integer cantidadAvio;
    
    @Column(name = "costo_avio")
    private Integer costoAvio;

    public Avios() {
    }

    public Avios(Integer idAvios) {
        this.idAvios = idAvios;
    }

    public Avios(String tipoAvio) {
        this.tipoAvio = tipoAvio;
    }

    public Avios(Integer idAvios, String tipoAvio, String nombreAvio, Integer cantidadAvio, Integer costoAvio) {
        this.idAvios = idAvios;
        this.tipoAvio = tipoAvio;
        this.nombreAvio = nombreAvio;
        this.cantidadAvio = cantidadAvio;
        this.costoAvio = costoAvio;
    }

    public Avios(String tipoAvio, String nombreAvio, Integer cantidadAvio, Integer costoAvio) {
        this.tipoAvio = tipoAvio;
        this.nombreAvio = nombreAvio;
        this.cantidadAvio = cantidadAvio;
        this.costoAvio = costoAvio;
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

    public Integer getCostoAvio() {
        return costoAvio;
    }

    public void setCostoAvio(Integer costoAvio) {
        this.costoAvio = costoAvio;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idAvios);
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
        return "Avios{" + "idAvios=" + idAvios + ", tipoAvio=" + tipoAvio + ", nombreAvio=" + nombreAvio + ", cantidadAvio=" + cantidadAvio + ", costoAvio=" + costoAvio + '}';
    }
    
    
    
    
}
