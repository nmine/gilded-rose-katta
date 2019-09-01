package com.gildedrose.documentation;

public enum Type {

    TEMPLATE_METHODE("Template Methode", "https://refactoring.guru/design-patterns/template-method"),

    BUILDER("Builder", "https://refactoring.guru/design-patterns/builder");

    private String value;

    private String link;

    Type(String value, String link) {
        this.value = value;this.link = link;
    }
}
