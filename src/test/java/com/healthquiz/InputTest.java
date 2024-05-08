package com.healthquiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JPanel;

class InputTest {

    @Test
    void CorrectFirstNameOrSurname() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertTrue(contactCard.ValidateTextInput("Sini-Vuokko")); 
        assertTrue(contactCard.ValidateTextInput("Timo"));
        assertTrue(contactCard.ValidateTextInput("Keinänen"));
        assertTrue(contactCard.ValidateTextInput("KALLEN"));
        assertTrue(contactCard.ValidateTextInput("MÄTITÄHNÄ"));
    }

    @Test
    void CorrectNumber() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertTrue(contactCard.ValidateNumberInput("18"));
        assertTrue(contactCard.ValidateNumberInput("99")); 
        assertTrue(contactCard.ValidateNumberInput("100"));
    }

    @Test
    void CorrectAge() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertTrue(contactCard.ValidateUnderAgeLimit("18")); 
        assertTrue(contactCard.ValidateUnderAgeLimit("100")); 
    }

    @Test
    void CorrectEmailAddress() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertTrue(contactCard.ValidateEmailAddress("onnellinen.opiskelija@student.oulu.fi")); 
        assertTrue(contactCard.ValidateEmailAddress("opiskelija.onnellinen@gmail.com")); 
        assertTrue(contactCard.ValidateEmailAddress("toripoliisin.kattelija@student.oulu.fi")); 
    }

    @Test
    void CorrectPhoneNumber() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertTrue(contactCard.ValidatePhoneNumber("0294480000"));
        assertTrue(contactCard.ValidatePhoneNumber("0400123456")); 
        assertTrue(contactCard.ValidatePhoneNumber("0501234567"));
        assertTrue(contactCard.ValidatePhoneNumber("0601234567"));
    }

    @Test
    void InvalidFirstNameOrSurname() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertFalse(contactCard.ValidateTextInput("Seppo!")); 
        assertFalse(contactCard.ValidateTextInput("T44l4sm44")); 
    }

    @Test
    void InvalidNumber() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertFalse(contactCard.ValidateNumberInput("18 vuotta vanha"));
        assertFalse(contactCard.ValidateNumberInput("Satavuotta"));
    }

    @Test
    void InvalidAge() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertFalse(contactCard.ValidateUnderAgeLimit("17")); 
        assertFalse(contactCard.ValidateUnderAgeLimit("0")); 
    }

    @Test
    void InvalidEmailAddress() {
        ContactCard contactCard = new ContactCard(new JPanel()); 
        assertFalse(contactCard.ValidateEmailAddress("opiskelija,vihainen@student.oulu.fi")); 
        assertFalse(contactCard.ValidateEmailAddress("vihainen.opiskelija@student"));
        assertFalse(contactCard.ValidateEmailAddress("@student.oulu.fi"));
        assertFalse(contactCard.ValidateEmailAddress("opiskelija.vihainen@.fi"));
        assertFalse(contactCard.ValidateEmailAddress("vihainen.opiskelija@student.oulu."));
        assertFalse(contactCard.ValidateEmailAddress("opiskelija@vihainen@student.oulu.fi")); 
        assertFalse(contactCard.ValidateEmailAddress("vappu.venähti@student.oulu.fi"));
    }

    @Test
    void InvalidPhoneNumber() {
        ContactCard contactCard = new ContactCard(new JPanel());
        assertFalse(contactCard.ValidatePhoneNumber("Oulun Yliopisto")); 
        assertFalse(contactCard.ValidatePhoneNumber("Ohjelmointi4"));
        assertFalse(contactCard.ValidatePhoneNumber("12"));
    }

}