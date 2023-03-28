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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NC
 */
@Entity
@Table(name = "chuyenxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chuyenxe.findAll", query = "SELECT c FROM Chuyenxe c"),
    @NamedQuery(name = "Chuyenxe.findByIdchuyenxe", query = "SELECT c FROM Chuyenxe c WHERE c.idchuyenxe = :idchuyenxe"),
    @NamedQuery(name = "Chuyenxe.findByTenchuyenxe", query = "SELECT c FROM Chuyenxe c WHERE c.tenchuyenxe = :tenchuyenxe"),
    @NamedQuery(name = "Chuyenxe.findByNgaydi", query = "SELECT c FROM Chuyenxe c WHERE c.ngaydi = :ngaydi"),
    //@NamedQuery(name = "Chuyenxe.findByGiodi", query = "SELECT c FROM Chuyenxe c WHERE c.giodi = :giodi"),
    @NamedQuery(name = "Chuyenxe.findByGiave", query = "SELECT c FROM Chuyenxe c WHERE c.giave = :giave"),
    @NamedQuery(name = "Chuyenxe.findBySlve", query = "SELECT c FROM Chuyenxe c WHERE c.slve = :slve"),
    @NamedQuery(name = "Chuyenxe.findBySlvedaban", query = "SELECT c FROM Chuyenxe c WHERE c.slvedaban = :slvedaban"),
    @NamedQuery(name = "Chuyenxe.findByHinhanh", query = "SELECT c FROM Chuyenxe c WHERE c.hinhanh = :hinhanh")})
public class Chuyenxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchuyenxe")
    private Integer idchuyenxe;
    @Size(max = 100,message = "{chuyenxe.tenchuyenxe.nullerr}")
    @Column(name = "tenchuyenxe")
    private String tenchuyenxe;
    @Column(name = "ngaydi")
    @Temporal(TemporalType.DATE)
    private Date ngaydi;
   // @Column(name = "giodi")
    //@Temporal(TemporalType.TIME)
   // private Date giodi;
    @Column(name = "giave")
    private Integer giave;
    @Column(name = "slve")
    private Integer slve;
    @Column(name = "slvedaban")
    private Integer slvedaban;
    @Size(max = 200)
    @Column(name = "hinhanh")
    private String hinhanh;
    @JoinColumn(name = "idTX", referencedColumnName = "idTX")
    @ManyToOne
    private Tuyenxe idTX;
    @OneToMany(mappedBy = "idchuyenxe")
    private Set<Datve> datveSet;

    @Transient
    private MultipartFile file;
    public Chuyenxe() {
    }

    public Chuyenxe(Integer idchuyenxe) {
        this.idchuyenxe = idchuyenxe;
    }

    public Integer getIdchuyenxe() {
        return idchuyenxe;
    }

    public void setIdchuyenxe(Integer idchuyenxe) {
        this.idchuyenxe = idchuyenxe;
    }

    public String getTenchuyenxe() {
        return tenchuyenxe;
    }

    public void setTenchuyenxe(String tenchuyenxe) {
        this.tenchuyenxe = tenchuyenxe;
    }

    public Date getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(Date ngaydi) {
        this.ngaydi = ngaydi;
    }

  //  public Date getGiodi() {
   //     return giodi;
  //  }

  //  public void setGiodi(Date giodi) {
  //      this.giodi = giodi;
   // }

    public Integer getGiave() {
        return giave;
    }

    public void setGiave(Integer giave) {
        this.giave = giave;
    }

    public Integer getSlve() {
        return slve;
    }

    public void setSlve(Integer slve) {
        this.slve = slve;
    }

    public Integer getSlvedaban() {
        return slvedaban;
    }

    public void setSlvedaban(Integer slvedaban) {
        this.slvedaban = slvedaban;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public Tuyenxe getIdTX() {
        return idTX;
    }

    public void setIdTX(Tuyenxe idTX) {
        this.idTX = idTX;
    }

    @XmlTransient
    public Set<Datve> getDatveSet() {
        return datveSet;
    }

    public void setDatveSet(Set<Datve> datveSet) {
        this.datveSet = datveSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchuyenxe != null ? idchuyenxe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chuyenxe)) {
            return false;
        }
        Chuyenxe other = (Chuyenxe) object;
        if ((this.idchuyenxe == null && other.idchuyenxe != null) || (this.idchuyenxe != null && !this.idchuyenxe.equals(other.idchuyenxe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chl.pojo.Chuyenxe[ idchuyenxe=" + idchuyenxe + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
