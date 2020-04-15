package org.academiadecodigo.apiores.quarentinos.persistence.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Date date;

    @ManyToOne
    private Client client;

    @ManyToOne
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
