package org.academiadecodigo.apiores.quarentinos.persistence.model;

import java.util.List;

public class Provider extends AbstractModel {

    private RoleType roleType;
    private List<Appointment> agenda;
    private int priceMin;
    private int priceMax;

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

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }
}
