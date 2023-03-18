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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NC
 */
@Entity
@Table(name = "danhgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Danhgia.findAll", query = "SELECT d FROM Danhgia d"),
    @NamedQuery(name = "Danhgia.findByIddanhgia", query = "SELECT d FROM Danhgia d WHERE d.iddanhgia = :iddanhgia"),
    @NamedQuery(name = "Danhgia.findByNoidung", query = "SELECT d FROM Danhgia d WHERE d.noidung = :noidung"),
    @NamedQuery(name = "Danhgia.findByDiem", query = "SELECT d FROM Danhgia d WHERE d.diem = :diem")})
public class Danhgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddanhgia")
    private Integer iddanhgia;
    @Size(max = 500)
    @Column(name = "noidung")
    private String noidung;
    @Column(name = "diem")
    private Integer diem;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne
    private Users iduser;
    @JoinColumn(name = "idnx", referencedColumnName = "idnx")
    @ManyToOne
    private Nhaxe idnx;

    public Danhgia() {
    }

    public Danhgia(Integer iddanhgia) {
        this.iddanhgia = iddanhgia;
    }

    public Integer getIddanhgia() {
        return iddanhgia;
    }

    public void setIddanhgia(Integer iddanhgia) {
        this.iddanhgia = iddanhgia;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Integer getDiem() {
        return diem;
    }

    public void setDiem(Integer diem) {
        this.diem = diem;
    }

    public Users getIduser() {
        return iduser;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
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
        hash += (iddanhgia != null ? iddanhgia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danhgia)) {
            return false;
        }
        Danhgia other = (Danhgia) object;
        if ((this.iddanhgia == null && other.iddanhgia != null) || (this.iddanhgia != null && !this.iddanhgia.equals(other.iddanhgia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chl.pojo.Danhgia[ iddanhgia=" + iddanhgia + " ]";
    }
    
}
