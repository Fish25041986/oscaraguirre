/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.domain;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "artistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artista.findAll", query = "SELECT a FROM Artista a"),
    @NamedQuery(name = "Artista.findByCodigo", query = "SELECT a FROM Artista a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Artista.findByNombre", query = "SELECT a FROM Artista a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Artista.findByApellido", query = "SELECT a FROM Artista a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "Artista.findByImgArtista", query = "SELECT a FROM Artista a WHERE a.imgArtista = :imgArtista")
})
public class Artista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 100)
    @Column(name = "img_artista")
    private String imgArtista;
    @JoinColumn(name = "codigo_museo", referencedColumnName = "codigo")
    @ManyToOne
    private Museo codigoMuseo;
    @OneToMany(mappedBy = "codigoArtista")
    private List<Pintura> pinturaList;

    public Artista() {
    }

    public Artista(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImgArtista() {
        return imgArtista;
    }

    public void setImgArtista(String imgArtista) {
        this.imgArtista = imgArtista;
    }

    @JsonbTransient 
    public Museo getCodigoMuseo() {
        return codigoMuseo;
    }

    public void setCodigoMuseo(Museo codigoMuseo) {
        this.codigoMuseo = codigoMuseo;
    }

    @XmlTransient
    public List<Pintura> getPinturaList() {
        return pinturaList;
    }

    public void setPinturaList(List<Pintura> pinturaList) {
        this.pinturaList = pinturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.ministerioDeCultura.domain.Artista[ codigo=" + codigo + " ]";
    }
    
}
