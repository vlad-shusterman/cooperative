package by.bsuir.document.model.template;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static by.bsuir.document.model.template.Tag.Param.*;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Getter
public enum Tag {
    // TODO: 11.03.2020 Implement other processors

    // Person
    FAMILY(Collections.singletonList(PERSON_ID)), // First, last names and surname
    PASP(Collections.singletonList(PERSON_ID)), // Passport number
    PW(Collections.singletonList(PERSON_ID)), // Passport issuing authority
    PD(Collections.singletonList(PERSON_ID)), // Issuing date
    PN(Collections.singletonList(PERSON_ID)), // Personal number
    ADDRESS(Collections.singletonList(PERSON_ID)), // Address
    PHONE(Collections.singletonList(PERSON_ID)), // Phone number
    MAIL(Collections.singletonList(PERSON_ID)), // Mail

    // Property
    BOX_SQ(Collections.singletonList(PROPERTY_ID)), // Square
    FIO(Collections.singletonList(PROPERTY_ID)), // Apartment number
    INV(Collections.singletonList(PROPERTY_ID)), // Inventory number
    DATE_REG(Collections.singletonList(PROPERTY_ID)), // Registration date
    NUM(Collections.singletonList(PROPERTY_ID)), // Number of Certificate of state registration

    // Requisites of organization
    ORG_NAME(Collections.emptyList()), // Full russian name
    ORG_TYPE(Collections.emptyList()), // Type (shorten)
    ORG_ADDR(Collections.emptyList()), // Address
    ORG_PAY_ACC(Collections.emptyList()), // Payment account
    ORG_MAIL_ADDR(Collections.emptyList()), // Mail address
    ORG_EMAIL(Collections.emptyList()), // Email
    PRESIDENT(Collections.emptyList()), // President surname and initials
    PAN(Collections.emptyList()), // Payer's account number

    // Agreement
    IND_DOG(Collections.singletonList(ID)), // Id in system
    INDEX(Collections.singletonList(Param.INDEX)), // Line entered by user

    // Vicarious authority
    FAMILY_TO(Collections.singletonList(TO_PERSON_ID)), // Full name of delegate
    ATP(Arrays.asList(START_DATE, DURATION)), // Duration in words representation
    AN(Collections.singletonList(ID)), // Id in system

    // Equipment acceptance certificate
    EQS(Collections.singletonList(EQS_PARAM)), // Acceptance equipment list with names and nums

    // Registration sheet
    LIST(Collections.singletonList(LIST_PARAM)), /* List of registered proprietors with such data as
                                                     - Apartment number
                                                     - Full name
                                                     - Owning percent for current proprietor
                                                     - Delegate (by vicarious authority)
                                                     - Authority (number of document)
                                                     - Participation (personally or delegate)
                                                 */

    // Common
    DAY(Collections.singletonList(DATE_PARAM)),
    MONTH(Collections.singletonList(DATE_PARAM)),
    YEAR(Collections.singletonList(DATE_PARAM)),
    DATE(Collections.singletonList(DATE_PARAM));

    private List<Param> params;

    public enum Param {
        PERSON_ID,
        TO_PERSON_ID,
        PROPERTY_ID,
        START_DATE,
        DURATION,
        ID,
        INDEX,
        EQS_PARAM,
        LIST_PARAM,
        DATE_PARAM
    }
}
