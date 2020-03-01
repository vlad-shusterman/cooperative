package by.bsuir.document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TagType {
    // Person
    FAMILY("FAMILY"), // First, last names and surname
    PASP("PASP"), //
    PW("PW"),
    PD("PD"),
    PN("PN"),
    ADDRESS("ADDRESS"),
    PHONE("PHONE"),
    MAIL("MAIL"),

    // Property
    BOX_SQ("BOX_SQ"),
    FIO("FIO"),
    INV("INV"),
    DATE_REG("DATE_REG"),
    NUM("NUM"),

    // Requisites
    PARTNERSHIP("PARTNERSHIP"),
    PRESIDENT("PRESIDENT"),
    PAN("PAN"),

    // Agreement
    IND_DOG("IND_DOG"),
    INDEX("INDEX"),

    // VicariousAuthority
    FAMILY_TO("FAMILY_TO"),
    ATP("ATP"),
    AN("AN");

    private String value;
}
