package org.academiadecodigo.apiores.quarentinos.persistence.model;


import javax.persistence.*;
import java.util.Date;


public class Appointment implements Model {


    private Integer id;

    private Date date;


    private Client client;

    private Provider provider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
