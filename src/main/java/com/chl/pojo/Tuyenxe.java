/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.pojo;

import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NC
 */
@Entity
@Table(name = "tuyenxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tuyenxe.findAll", query = "SELECT t FROM Tuyenxe t"),
    @NamedQuery(name = "Tuyenxe.findByIdTX", query = "SELECT t FROM Tuyenxe t WHERE t.idTX = :idTX"),
    @NamedQuery(name = "Tuyenxe.findByDiemdi", query = "SELECT t FROM Tuyenxe t WHERE t.diemdi = :diemdi"),
    @NamedQuery(name = "Tuyenxe.findByDiemden", query = "SELECT t FROM Tuyenxe t WHERE t.diemden = :diemden")})
public class Tuyenxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTX")
    private Integer idTX;
    @Size(max = 100)
    @Column(name = "diemdi")
    private String diemdi;
    @Size(max = 100)
    @Column(name = "diemden")
    private String diemden;
    @OneToMany(mappedBy = "idTX")
    private Set<Chuyenxe> chuyenxeSet;
    @JoinColumn(name = "idnx", referencedColumnName = "idnx")
    @ManyToOne
    private Nhaxe idnx;

    public Tuyenxe() {
    }

    public Tuyenxe(Integer idTX) {
        this.idTX = idTX;
    }

    public Integer getIdTX() {
        return idTX;
    }

    public void setIdTX(Integer idTX) {
        this.idTX = idTX;
    }

    public String getDiemdi() {
        return diemdi;
    }

    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    public String getDiemden() {
        return diemden;
    }

    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }

    @XmlTransient
    public Set<Chuyenxe> getChuyenxeSet() {
        return chuyenxeSet;
    }

    public void setChuyenxeSet(Set<Chuyenxe> chuyenxeSet) {
        this.chuyenxeSet = chuyenxeSet;
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
        hash += (idTX != null ? idTX.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tuyenxe)) {
            return false;
        }
        Tuyenxe other = (Tuyenxe) object;
        if ((this.idTX == null && other.idTX != null) || (this.idTX != null && !this.idTX.equals(other.idTX))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chl.pojo.Tuyenxe[ idTX=" + idTX + " ]";
    }
    
}
