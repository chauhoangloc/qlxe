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
@Table(name = "nhaxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhaxe.findAll", query = "SELECT n FROM Nhaxe n"),
    @NamedQuery(name = "Nhaxe.findByIdnx", query = "SELECT n FROM Nhaxe n WHERE n.idnx = :idnx"),
    @NamedQuery(name = "Nhaxe.findByTennhaxe", query = "SELECT n FROM Nhaxe n WHERE n.tennhaxe = :tennhaxe"),
    @NamedQuery(name = "Nhaxe.findByDiachi", query = "SELECT n FROM Nhaxe n WHERE n.diachi = :diachi"),
    @NamedQuery(name = "Nhaxe.findBySdt", query = "SELECT n FROM Nhaxe n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "Nhaxe.findByEmail", query = "SELECT n FROM Nhaxe n WHERE n.email = :email"),
    @NamedQuery(name = "Nhaxe.findByGiaohang", query = "SELECT n FROM Nhaxe n WHERE n.giaohang = :giaohang"),
    @NamedQuery(name = "Nhaxe.findByAvatar", query = "SELECT n FROM Nhaxe n WHERE n.avatar = :avatar")})
public class Nhaxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnx")
    private Integer idnx;
    @Size(max = 50)
    @Column(name = "tennhaxe")
    private String tennhaxe;
    @Size(max = 100)
    @Column(name = "diachi")
    private String diachi;
    @Size(max = 20)
    @Column(name = "sdt")
    private String sdt;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "giaohang")
    private Boolean giaohang;
    @Size(max = 50)
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(mappedBy = "idnx")
    private Set<Giaohang> giaohangSet;
    @OneToMany(mappedBy = "idnx")
    private Set<Khoanhaxe> khoanhaxeSet;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne
    private Users iduser;
    @OneToMany(mappedBy = "idnx")
    private Set<Danhgia> danhgiaSet;
    @OneToMany(mappedBy = "idnx")
    private Set<Tuyenxe> tuyenxeSet;

    public Nhaxe() {
    }

    public Nhaxe(Integer idnx) {
        this.idnx = idnx;
    }

    public Integer getIdnx() {
        return idnx;
    }

    public void setIdnx(Integer idnx) {
        this.idnx = idnx;
    }

    public String getTennhaxe() {
        return tennhaxe;
    }

    public void setTennhaxe(String tennhaxe) {
        this.tennhaxe = tennhaxe;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGiaohang() {
        return giaohang;
    }

    public void setGiaohang(Boolean giaohang) {
        this.giaohang = giaohang;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Set<Giaohang> getGiaohangSet() {
        return giaohangSet;
    }

    public void setGiaohangSet(Set<Giaohang> giaohangSet) {
        this.giaohangSet = giaohangSet;
    }

    @XmlTransient
    public Set<Khoanhaxe> getKhoanhaxeSet() {
        return khoanhaxeSet;
    }

    public void setKhoanhaxeSet(Set<Khoanhaxe> khoanhaxeSet) {
        this.khoanhaxeSet = khoanhaxeSet;
    }

    public Users getIduser() {
        return iduser;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
    }

    @XmlTransient
    public Set<Danhgia> getDanhgiaSet() {
        return danhgiaSet;
    }

    public void setDanhgiaSet(Set<Danhgia> danhgiaSet) {
        this.danhgiaSet = danhgiaSet;
    }

    @XmlTransient
    public Set<Tuyenxe> getTuyenxeSet() {
        return tuyenxeSet;
    }

    public void setTuyenxeSet(Set<Tuyenxe> tuyenxeSet) {
        this.tuyenxeSet = tuyenxeSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnx != null ? idnx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhaxe)) {
            return false;
        }
        Nhaxe other = (Nhaxe) object;
        if ((this.idnx == null && other.idnx != null) || (this.idnx != null && !this.idnx.equals(other.idnx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chl.pojo.Nhaxe[ idnx=" + idnx + " ]";
    }
    
}
