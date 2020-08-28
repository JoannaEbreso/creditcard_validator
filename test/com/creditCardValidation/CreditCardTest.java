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
    void checkIfCardNumberIsValid(){
        CreditCard newCard = new CreditCard();
        newCard.setCreditCardNumber("5370100328846257");
        assertTrue(newCard.isValid(newCard.getCreditCardNumber()));

        CreditCard newCard2 = new CreditCard();
        newCard2.setCreditCardNumber("5890652109876544");
        assertFalse(newCard2.isValid(newCard2.getCreditCardNumber()));
    }

    @Test
    void checkCardType(){
        CreditCard creditCard1 = new CreditCard();
        creditCard1.setCreditCardNumber("5470136732184657");
        assertEquals(CardType.NotValid,creditCard1.checkCardType());

        CreditCard creditCard2 = new CreditCard();
        creditCard2.setCreditCardNumber("4000123456789010");
        assertEquals(CardType.NotValid,creditCard2.checkCardType());

        CreditCard creditCard3 = new CreditCard();
        creditCard3.setCreditCardNumber("5370100328846257");
        assertEquals(CardType.MasterCard,creditCard3.checkCardType());

        CreditCard creditCard4 = new CreditCard();
        creditCard4.setCreditCardNumber("5061040228117203881");
        assertEquals(CardType.VerveCard,creditCard4.checkCardType());
    }

    @Test
    void sumStringedDigits(){
        CreditCard creditCard2 = new CreditCard();
        int sum = creditCard2.getSumOfDigits("123456789");
        assertEquals(45,sum);
    }

}