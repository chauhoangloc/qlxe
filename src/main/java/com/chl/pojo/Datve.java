/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Datve.findByTotal", query = "SELECT d FROM Datve d WHERE d.total = :total")})
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
    @Column(name = "total")
    private Integer total;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne
    private Users iduser;
    @OneToMany(mappedBy = "iddatved")
    private Set<Ctdatve> ctdatveSet;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Users getIduser() {
        return iduser;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
    }

    @XmlTransient
    public Set<Ctdatve> getCtdatveSet() {
        return ctdatveSet;
    }

    public void setCtdatveSet(Set<Ctdatve> ctdatveSet) {
        this.ctdatveSet = ctdatveSet;
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
