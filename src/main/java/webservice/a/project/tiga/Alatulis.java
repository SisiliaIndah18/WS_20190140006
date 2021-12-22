/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.a.project.tiga;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "alatulis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alatulis.findAll", query = "SELECT a FROM Alatulis a"),
    @NamedQuery(name = "Alatulis.findById", query = "SELECT a FROM Alatulis a WHERE a.id = :id"),
    @NamedQuery(name = "Alatulis.findByNama", query = "SELECT a FROM Alatulis a WHERE a.nama = :nama"),
    @NamedQuery(name = "Alatulis.findByJumlah", query = "SELECT a FROM Alatulis a WHERE a.jumlah = :jumlah")})
public class Alatulis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "jumlah")
    private Integer jumlah;

    public Alatulis() {
    }

    public Alatulis(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alatulis)) {
            return false;
        }
        Alatulis other = (Alatulis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservice.a.project.tiga.Alatulis[ id=" + id + " ]";
    }
    
}
