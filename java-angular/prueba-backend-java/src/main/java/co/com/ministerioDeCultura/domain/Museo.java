/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "museos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Museo.findAll", query = "SELECT m FROM Museo m"),
    @NamedQuery(name = "Museo.findByCodigo", query = "SELECT m FROM Museo m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Museo.findByNombre", query = "SELECT m FROM Museo m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Museo.findByDireccion", query = "SELECT m FROM Museo m WHERE m.direccion = :direccion"),
    @NamedQuery(name = "Museo.findByImgMuseo", query = "SELECT m FROM Museo m WHERE m.imgMuseo = :imgMuseo"),
    @NamedQuery(name = "Museo.findByDescripcion", query = "SELECT m FROM Museo m WHERE m.descripcion = :descripcion")})
public class Museo implements Serializable {

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
    @Size(max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "img_museo")
    private String imgMuseo;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "codigoMuseo")
    private List<Artista> artistaList;

    public Museo() {
    }

    public Museo(String codigo) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImgMuseo() {
        return imgMuseo;
    }

    public void setImgMuseo(String imgMuseo) {
        this.imgMuseo = imgMuseo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Artista> getArtistaList() {
        return artistaList;
    }

    public void setArtistaList(List<Artista> artistaList) {
        this.artistaList = artistaList;
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
        if (!(object instanceof Museo)) {
            return false;
        }
        Museo other = (Museo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.ministerioDeCultura.domain.Museo[ codigo=" + codigo + " ]";
    }
    
}
