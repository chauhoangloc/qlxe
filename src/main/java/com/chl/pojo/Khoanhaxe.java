/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NC
 */
@Entity
@Table(name = "khoanhaxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khoanhaxe.findAll", query = "SELECT k FROM Khoanhaxe k"),
    @NamedQuery(name = "Khoanhaxe.findByIdkhoaxe", query = "SELECT k FROM Khoanhaxe k WHERE k.idkhoaxe = :idkhoaxe"),
    @NamedQuery(name = "Khoanhaxe.findByTrangthai", query = "SELECT k FROM Khoanhaxe k WHERE k.trangthai = :trangthai")})
public class Khoanhaxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idkhoaxe")
    private Integer idkhoaxe;
    @Column(name = "trangthai")
    private Boolean trangthai;
    @JoinColumn(name = "idnx", referencedColumnName = "idnx")
    @ManyToOne
    private Nhaxe idnx;

    public Khoanhaxe() {
    }

    public Khoanhaxe(Integer idkhoaxe) {
        this.idkhoaxe = idkhoaxe;
    }

    public Integer getIdkhoaxe() {
        return idkhoaxe;
    }

    public void setIdkhoaxe(Integer idkhoaxe) {
        this.idkhoaxe = idkhoaxe;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public Nhaxe getIdnx() {
        return idnx;
    }

    public void setIdnx(Nhaxe idnx) {
        this.idnx = idnx;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkhoaxe != null ? idkhoaxe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khoanhaxe)) {
            return false;
        }
        Khoanhaxe other = (Khoanhaxe) object;
        if ((this.idkhoaxe == null && other.idkhoaxe != null) || (this.idkhoaxe != null && !this.idkhoaxe.equals(other.idkhoaxe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chl.pojo.Khoanhaxe[ idkhoaxe=" + idkhoaxe + " ]";
    }
    
}
