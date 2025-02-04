/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ilias.uniapp.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ilias
 */
@Entity
@Table(name = "UNIVERSITY")
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u"),
    @NamedQuery(name = "University.findById", query = "SELECT u FROM University u WHERE u.id = :id"),
    @NamedQuery(name = "University.findByName", query = "SELECT u FROM University u WHERE u.name = :name"),
    @NamedQuery(name = "University.findByDomain", query = "SELECT u FROM University u WHERE u.domain = :domain"),
    @NamedQuery(name = "University.findByWebpage", query = "SELECT u FROM University u WHERE u.webpage = :webpage"),
    @NamedQuery(name = "University.findByAlphatwocode", query = "SELECT u FROM University u WHERE u.alphatwocode = :alphatwocode"),
    @NamedQuery(name = "University.findByCountry", query = "SELECT u FROM University u WHERE u.country = :country"),
    @NamedQuery(name = "University.findByStateprovince", query = "SELECT u FROM University u WHERE u.stateprovince = :stateprovince")})
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "DOMAIN")
    private String domain;
    @Basic(optional = false)
    @Column(name = "WEBPAGE")
    private String webpage;
    @Basic(optional = false)
    @Column(name = "ALPHATWOCODE")
    private String alphatwocode;
    @Basic(optional = false)
    @Column(name = "COUNTRY")
    private String country;
    @Basic(optional = false)
    @Column(name = "STATEPROVINCE")
    private String stateprovince;

    public University() {
    }

    public University(Integer id) {
        this.id = id;
    }

    public University(Integer id, String name, String domain, String webpage, String alphatwocode, String country, String stateprovince) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.webpage = webpage;
        this.alphatwocode = alphatwocode;
        this.country = country;
        this.stateprovince = stateprovince;
    }

    public University(String name, String domain, String webpage, String alphatwocode, String country, String stateprovince) {
        this.name = name;
        this.domain = domain;
        this.webpage = webpage;
        this.alphatwocode = alphatwocode;
        this.country = country;
        this.stateprovince = stateprovince;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getAlphatwocode() {
        return alphatwocode;
    }

    public void setAlphatwocode(String alphatwocode) {
        this.alphatwocode = alphatwocode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateprovince() {
        return stateprovince;
    }

    public void setStateprovince(String stateprovince) {
        this.stateprovince = stateprovince;
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
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ilias.uniapp.db.University[ id=" + id + " ]";
    }
    
}
