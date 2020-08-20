/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "joyeria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Joyeria.findAll", query = "SELECT j FROM Joyeria j")
    , @NamedQuery(name = "Joyeria.findByIdJoyeria", query = "SELECT j FROM Joyeria j WHERE j.idJoyeria = :idJoyeria")
    , @NamedQuery(name = "Joyeria.findByNombre", query = "SELECT j FROM Joyeria j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Joyeria.findByUbicacion", query = "SELECT j FROM Joyeria j WHERE j.ubicacion = :ubicacion")
    , @NamedQuery(name = "Joyeria.findByDireccion", query = "SELECT j FROM Joyeria j WHERE j.direccion = :direccion")
    , @NamedQuery(name = "Joyeria.findByNombreEncargado", query = "SELECT j FROM Joyeria j WHERE j.nombreEncargado = :nombreEncargado")
    , @NamedQuery(name = "Joyeria.findByDimencionLocal", query = "SELECT j FROM Joyeria j WHERE j.dimencionLocal = :dimencionLocal")
    , @NamedQuery(name = "Joyeria.findByCiudad", query = "SELECT j FROM Joyeria j WHERE j.ciudad = :ciudad")})
public class Joyeria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJoyeria")
    private Integer idJoyeria;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @Size(max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "NombreEncargado")
    private String nombreEncargado;
    @Column(name = "DimencionLocal")
    private Integer dimencionLocal;
    @Size(max = 45)
    @Column(name = "Ciudad")
    private String ciudad;

    public Joyeria() {
    }

    public Joyeria(Integer idJoyeria, String nombre, String ubicacion, String direccion, String nombreEncargado, Integer dimencionLocal, String ciudad) {
        this.idJoyeria = idJoyeria;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.nombreEncargado = nombreEncargado;
        this.dimencionLocal = dimencionLocal;
        this.ciudad = ciudad;
    }
    

    public Joyeria(Integer idJoyeria) {
        this.idJoyeria = idJoyeria;
    }

    public Integer getIdJoyeria() {
        return idJoyeria;
    }

    public void setIdJoyeria(Integer idJoyeria) {
        this.idJoyeria = idJoyeria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public Integer getDimencionLocal() {
        return dimencionLocal;
    }

    public void setDimencionLocal(Integer dimencionLocal) {
        this.dimencionLocal = dimencionLocal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJoyeria != null ? idJoyeria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joyeria)) {
            return false;
        }
        Joyeria other = (Joyeria) object;
        if ((this.idJoyeria == null && other.idJoyeria != null) || (this.idJoyeria != null && !this.idJoyeria.equals(other.idJoyeria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Joyeria[ idJoyeria=" + idJoyeria + " ]";
    }
    
}
