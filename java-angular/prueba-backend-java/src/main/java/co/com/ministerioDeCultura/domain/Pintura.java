/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.domain;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "pinturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pintura.findAll", query = "SELECT p FROM Pintura p"),
    @NamedQuery(name = "Pintura.findByCodigo", query = "SELECT p FROM Pintura p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pintura.findByPrecio", query = "SELECT p FROM Pintura p WHERE p.precio = :precio"),
    @NamedQuery(name = "Pintura.findByFecha", query = "SELECT p FROM Pintura p WHERE p.fecha = :fecha")})
public class Pintura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "codigo_artista", referencedColumnName = "codigo")
    @ManyToOne
    private Artista codigoArtista;

    public Pintura() {
    }

    public Pintura(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   @JsonbTransient 
    public Artista getCodigoArtista() {
        return codigoArtista;
    }

    public void setCodigoArtista(Artista codigoArtista) {
        this.codigoArtista = codigoArtista;
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
        if (!(object instanceof Pintura)) {
            return false;
        }
        Pintura other = (Pintura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.ministerioDeCultura.domain.Pintura[ codigo=" + codigo + " ]";
    }
    
}
