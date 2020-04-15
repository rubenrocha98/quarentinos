package org.academiadecodigo.apiores.quarentinos.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

public class Client extends AbstractModel {

    private MaritalStatus maritalStatus;

    private List <Appointment> requests;


    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<Appointment> getRequests() {
        return requests;
    }

    public void setRequests(List<Appointment> requests) {
        this.requests = requests;
    }
}
