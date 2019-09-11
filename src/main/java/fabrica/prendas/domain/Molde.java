package fabrica.prendas.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@Table(name = "molde")
@NamedQueries({
    @NamedQuery(name = "Molde.findAll", query = "SELECT m FROM Molde m"),
    @NamedQuery(name = "Molde.findById", query = "SELECT m FROM Molde m WHERE m.idMolde = :idMolde"),
    
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Molde implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMolde;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "cm_ancho")
    private String cmAncho;
    
    @Column(name = "cm_largo")
    private String cmLargo;
    
    @Column(name = "cm_manga")
    private String cmManga;
    
    @Column(name = "cm_cuello")
    private String cmCuello;
    
    @Column(name = "cm_cintura")
    private String cmCintura;
    
    @Column(name = "cm_cadera")
    private String cmCadera;
}
