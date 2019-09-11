package fabrica.prendas.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByName", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idProducto;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "talla")
    private String talla;
    
    @Column(name = "gasto_extra")
    private String gastoExtra;
    
    @Column(name = "precio_unitario")
    private String precioUnitario;
    
    @Column(name = "costo_total")
    private Double costoTotal;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(Integer idProducto, String nombre, Integer cantidad, String talla, String gastoExtra, String precioUnitario, Double costoTotal) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.talla = talla;
        this.gastoExtra = gastoExtra;
        this.precioUnitario = precioUnitario;
        this.costoTotal = costoTotal;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getGastoExtra() {
        return gastoExtra;
    }

    public void setGastoExtra(String gastoExtra) {
        this.gastoExtra = gastoExtra;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idProducto);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", talla=" + talla + ", gastoExtra=" + gastoExtra + ", precioUnitario=" + precioUnitario + ", costoTotal=" + costoTotal + '}';
    }
    
    
}
