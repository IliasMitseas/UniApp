package ilias.uniapp.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class University {

    @Id
    private String id;
    private String name;
    private String domain;
    private String webPage;
    private String alphaTwoCode;
    private String country;
    private String stateProvince;


    public University(String name, String domain, String webPage, String alphaTwoCode, String country, String stateProvince) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.webPage = webPage;
        this.alphaTwoCode = alphaTwoCode;
        this.country = country;
        this.stateProvince = stateProvince;
    }

    public University() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", webPage='" + webPage + '\'' +
                ", alphaTwoCode='" + alphaTwoCode + '\'' +
                ", country='" + country + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }
}
