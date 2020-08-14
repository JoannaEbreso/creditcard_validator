package com.creditCardValidation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validateCardNumber(){
        CreditCard newCard = new CreditCard();
        newCard.setNumber("5370100328846257");
        assertEquals("valid",newCard.validateCardNUmber(newCard.getNumber()));
    }

    @Test
    void checkCardType(){
        CreditCard creditCard1 = new CreditCard();
        creditCard1.setNumber("5370100328846257");
        assertEquals("MasterCard",creditCard1.checkCardType(creditCard1.getNumber()));

    }
}