package org.academiadecodigo.apiores.quarentinos.persistence.model;

public enum RoleType {
    HITMAN("Hitman"),
    INSURANCE_AGENT("Insurance Agent"),
    PROSTITUTION("Escort"),
    FRAMER("Framer"),
    DETECTIVE("Detective");

    private String desc;

    RoleType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
