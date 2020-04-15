package org.academiadecodigo.apiores.quarentinos.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

public class Provider extends AbstractModel {




    private List<Appointment> agenda;

    private RoleType roleType;

    private Integer priceMin;
    private Integer priceMax;

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public List<Appointment> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Appointment> agenda) {
        this.agenda = agenda;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public Integer getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Integer priceMax) {
        this.priceMax = priceMax;
    }
}
