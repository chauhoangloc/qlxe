/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NC
 */
@Entity
@Table(name = "giaohang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giaohang.findAll", query = "SELECT g FROM Giaohang g"),
    @NamedQuery(name = "Giaohang.findByIdgiaoHang", query = "SELECT g FROM Giaohang g WHERE g.idgiaoHang = :idgiaoHang"),
    @NamedQuery(name = "Giaohang.findByTenNguoigui", query = "SELECT g FROM Giaohang g WHERE g.tenNguoigui = :tenNguoigui"),
    @NamedQuery(name = "Giaohang.findBySdtnguoigui", query = "SELECT g FROM Giaohang g WHERE g.sdtnguoigui = :sdtnguoigui"),
    @NamedQuery(name = "Giaohang.findByTennguoinhann", query = "SELECT g FROM Giaohang g WHERE g.tennguoinhann = :tennguoinhann"),
    @NamedQuery(name = "Giaohang.findBySdtnguoinhan", query = "SELECT g FROM Giaohang g WHERE g.sdtnguoinhan = :sdtnguoinhan"),
    @NamedQuery(name = "Giaohang.findByTggui", query = "SELECT g FROM Giaohang g WHERE g.tggui = :tggui"),
    @NamedQuery(name = "Giaohang.findByTgnhan", query = "SELECT g FROM Giaohang g WHERE g.tgnhan = :tgnhan"),
    @NamedQuery(name = "Giaohang.findByTrangthai", query = "SELECT g FROM Giaohang g WHERE g.trangthai = :trangthai")})
public class Giaohang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgiaoHang")
    private Integer idgiaoHang;
    @Size(max = 50)
    @Column(name = "tenNguoigui")
    private String tenNguoigui;
    @Size(max = 20)
    @Column(name = "sdtnguoigui")
    private String sdtnguoigui;
    @Size(max = 50)
    @Column(name = "tennguoinhann")
    private String tennguoinhann;
    @Size(max = 20)
    @Column(name = "sdtnguoinhan")
    private String sdtnguoinhan;
    @Column(name = "tggui")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tggui;
    @Column(name = "tgnhan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgnhan;
    @Size(max = 20)
    @Column(name = "trangthai")
    private String trangthai;
    @JoinColumn(name = "idnx", referencedColumnName = "idnx")
    @ManyToOne
    private Nhaxe idnx;

    public Giaohang() {
    }

    public Giaohang(Integer idgiaoHang) {
        this.idgiaoHang = idgiaoHang;
    }

    public Integer getIdgiaoHang() {
        return idgiaoHang;
    }

    public void setIdgiaoHang(Integer idgiaoHang) {
        this.idgiaoHang = idgiaoHang;
    }

    public String getTenNguoigui() {
        return tenNguoigui;
    }

    public void setTenNguoigui(String tenNguoigui) {
        this.tenNguoigui = tenNguoigui;
    }

    public String getSdtnguoigui() {
        return sdtnguoigui;
    }

    public void setSdtnguoigui(String sdtnguoigui) {
        this.sdtnguoigui = sdtnguoigui;
    }

    public String getTennguoinhann() {
        return tennguoinhann;
    }

    public void setTennguoinhann(String tennguoinhann) {
        this.tennguoinhann = tennguoinhann;
    }

    public String getSdtnguoinhan() {
        return sdtnguoinhan;
    }

    public void setSdtnguoinhan(String sdtnguoinhan) {
        this.sdtnguoinhan = sdtnguoinhan;
    }

    public Date getTggui() {
        return tggui;
    }

    public void setTggui(Date tggui) {
        this.tggui = tggui;
    }

    public Date getTgnhan() {
        return tgnhan;
    }

    public void setTgnhan(Date tgnhan) {
        this.tgnhan = tgnhan;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
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
        hash += (idgiaoHang != null ? idgiaoHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giaohang)) {
            return false;
        }
        Giaohang other = (Giaohang) object;
        if ((this.idgiaoHang == null && other.idgiaoHang != null) || (this.idgiaoHang != null && !this.idgiaoHang.equals(other.idgiaoHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chl.pojo.Giaohang[ idgiaoHang=" + idgiaoHang + " ]";
    }
    
}
