package com.xavier.mservice.model;

import lombok.Getter;

public enum Province {

    MAPUTO("Maputo"),
    GAZA("Gaza"),
    INHAMBANE("Inhambane"),
    MANICA("Manica"),
    SOFALA("Sofala"),
    TETE("Tete"),
    ZAMBEZIA("Zambézia"),
    NAMPULA("Nampula"),
    CABO_DELGADO("Cabo Delgado"),
    NIASSA("Niassa");

    @Getter
    private String description;

    Province(String description) {
        this.description = description;
    }
}
