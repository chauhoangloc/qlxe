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
@Table(name = "datve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datve.findAll", query = "SELECT d FROM Datve d"),
    @NamedQuery(name = "Datve.findByIddatved", query = "SELECT d FROM Datve d WHERE d.iddatved = :iddatved"),
    @NamedQuery(name = "Datve.findByNgaydatve", query = "SELECT d FROM Datve d WHERE d.ngaydatve = :ngaydatve"),
    @NamedQuery(name = "Datve.findBySoluongve", query = "SELECT d FROM Datve d WHERE d.soluongve = :soluongve"),
    @NamedQuery(name = "Datve.findByThanhtoanOnl", query = "SELECT d FROM Datve d WHERE d.thanhtoanOnl = :thanhtoanOnl"),
    @NamedQuery(name = "Datve.findByStatusThanhtoan", query = "SELECT d FROM Datve d WHERE d.statusThanhtoan = :statusThanhtoan")})
public class Datve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddatved")
    private Integer iddatved;
    @Column(name = "ngaydatve")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaydatve;
    @Column(name = "soluongve")
    private Integer soluongve;
    @Column(name = "thanhtoanOnl")
    private Boolean thanhtoanOnl;
    @Size(max = 20)
    @Column(name = "statusThanhtoan")
    private String statusThanhtoan;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne
    private Users iduser;
    @JoinColumn(name = "idchuyenxe", referencedColumnName = "idchuyenxe")
    @ManyToOne
    private Chuyenxe idchuyenxe;

    public Datve() {
    }

    public Datve(Integer iddatved) {
        this.iddatved = iddatved;
    }

    public Integer getIddatved() {
        return iddatved;
    }

    public void setIddatved(Integer iddatved) {
        this.iddatved = iddatved;
    }

    public Date getNgaydatve() {
        return ngaydatve;
    }

    public void setNgaydatve(Date ngaydatve) {
        this.ngaydatve = ngaydatve;
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

    public Users getIduser() {
        return iduser;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
    }

    public Chuyenxe getIdchuyenxe() {
        return idchuyenxe;
    }

    public void setIdchuyenxe(Chuyenxe idchuyenxe) {
        this.idchuyenxe = idchuyenxe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddatved != null ? iddatved.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datve)) {
            return false;
        }
        Datve other = (Datve) object;
        if ((this.iddatved == null && other.iddatved != null) || (this.iddatved != null && !this.iddatved.equals(other.iddatved))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chl.pojo.Datve[ iddatved=" + iddatved + " ]";
    }
    
}
