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
@Table(name = "ctdatve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctdatve.findAll", query = "SELECT c FROM Ctdatve c"),
    @NamedQuery(name = "Ctdatve.findByIdctdatved", query = "SELECT c FROM Ctdatve c WHERE c.idctdatved = :idctdatved"),
    @NamedQuery(name = "Ctdatve.findByGia", query = "SELECT c FROM Ctdatve c WHERE c.gia = :gia"),
    @NamedQuery(name = "Ctdatve.findBySoluongve", query = "SELECT c FROM Ctdatve c WHERE c.soluongve = :soluongve"),
    @NamedQuery(name = "Ctdatve.findByThanhtoanOnl", query = "SELECT c FROM Ctdatve c WHERE c.thanhtoanOnl = :thanhtoanOnl"),
    @NamedQuery(name = "Ctdatve.findByStatusThanhtoan", query = "SELECT c FROM Ctdatve c WHERE c.statusThanhtoan = :statusThanhtoan")})
public class Ctdatve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idctdatved")
    private Integer idctdatved;
    @Column(name = "gia")
    private Integer gia;
    @Column(name = "soluongve")
    private Integer soluongve;
    @Column(name = "thanhtoanOnl")
    private Boolean thanhtoanOnl;
    @Size(max = 20)
    @Column(name = "statusThanhtoan")
    private String statusThanhtoan;
    @JoinColumn(name = "idchuyenxe", referencedColumnName = "idchuyenxe")
    @ManyToOne
    private Chuyenxe idchuyenxe;
    @JoinColumn(name = "iddatved", referencedColumnName = "iddatved")
    @ManyToOne
    private Datve iddatved;

    public Ctdatve() {
    }

    public Ctdatve(Integer idctdatved) {
        this.idctdatved = idctdatved;
    }

    public Integer getIdctdatved() {
        return idctdatved;
    }

    public void setIdctdatved(Integer idctdatved) {
        this.idctdatved = idctdatved;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getSoluongve() {
        return soluongve;
    }

    public void setSoluongve(Integer soluongve) {
        this.soluongve = soluongve;
    }

    public Boolean getThanhtoanOnl() {
        return thanhtoanOnl;
    }

    public void setThanhtoanOnl(Boolean thanhtoanOnl) {
        this.thanhtoanOnl = thanhtoanOnl;
    }

    public String getStatusThanhtoan() {
        return statusThanhtoan;
    }

    public void setStatusThanhtoan(String statusThanhtoan) {
        this.statusThanhtoan = statusThanhtoan;
    }

    public Chuyenxe getIdchuyenxe() {
        return idchuyenxe;
    }

    public void setIdchuyenxe(Chuyenxe idchuyenxe) {
        this.idchuyenxe = idchuyenxe;
    }

    public Datve getIddatved() {
        return iddatved;
    }

    public void setIddatved(Datve iddatved) {
        this.iddatved = iddatved;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idctdatved != null ? idctdatved.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctdatve)) {
            return false;
        }
        Ctdatve other = (Ctdatve) object;
        if ((this.idctdatved == null && other.idctdatved != null) || (this.idctdatved != null && !this.idctdatved.equals(other.idctdatved))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chl.pojo.Ctdatve[ idctdatved=" + idctdatved + " ]";
    }
    
}
