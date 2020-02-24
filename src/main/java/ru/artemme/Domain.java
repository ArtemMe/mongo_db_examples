package ru.artemme;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class Domain {
    @Id
    private int id;

//    @Indexed(unique = true)
    private String domain;

    private boolean displayAds;

    public Domain(int id, String domain, boolean displayAds) {
        this.id = id;
        this.domain = domain;
        this.displayAds = displayAds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isDisplayAds() {
        return displayAds;
    }

    public void setDisplayAds(boolean displayAds) {
        this.displayAds = displayAds;
    }
}
