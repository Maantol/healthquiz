package com.healthquiz;

public class SharedMessageStrings {

    public static String getWelcomeHelpMessage() {
        return "Aloita peli valitsemalla \"Aloita\"\n" +
                "Voit lopettaa pelin valitsemalla \"Lopeta\"\n" +
                "Voit lukea myöhemmin pelin ohjeet uudelleen valitsemalla kuvaketta \"?\"";
    }

    public static String getGuideHelpMessage() {
        return "Siirry seuraavaan kysymykseen valitsemalla \"Seuraava\"\n" +
                "Voit palata edelliseen kysymykseen valitsemalla \"Edellinen\"\n" +
                "Voit lopettaa pelin valitsemalla \"Lopeta\"\n" +
                "Voit lukea myöhemmin pelin ohjeet uudelleen valitsemalla kuvaketta \"?\"";
    }

    public static String getHelpMessage() {
        return "Pelissä on 10 kysymystä \n" +
                "liittyen uneen, ravitsemukseen ja\n" +
                "liikuntaan. Kaikkiin on vastattava\n" +
                "saadaksesi lopuksi sanallisen palautteen.\n" +
                "\n" +
                "Voit liikkua sivujen välillä\n" +
                "ja keskeyttää milloin haluat.\n" +
                "\n" +
                "Voit halutessasi jättää meille \n" +
                "yhteydenottopyynnön\n" +
                "(valmennuspalvelut täysi-ikäisille).\n" +
                "\n" +
                "Tietojasi ei tallenneta kuin\n" +
                "jättäessäsi yhteydenottopyynnön.\n" +
                "Tietojasi ei luovuteta ulkopuolisille.\n";
    }

    public static String getHelpMessageAfterComplete() {
        return "Olet nyt vastannut kaikkiin kysymyksiin.\n" +
                "Voit jakaa tuloksesi kavereillesi valitsemalla" +
                " \"Jaa kaverille\"\n" +
                "Voit jättää meille yhteydenottopyynnön valitsemalla" +
                " \"Jätä viesti\"\n" +
                "Voit lopettaa pelin valitsemalla \"Lopeta\"\n";
    }

    public static String getHelpMessageContactForm() {
        return "Täytä tähdellä merkityt pakolliset kohdat.\n" +
                "Tietojasi käytetään vain yhteydenottoa varten\n" +
                "eikä niitä luovuteta ulkopuolisille.\n" +
                "\n" +
                "-käytä etu- ja sukunimessä vain kirjaimia ja välilyöntejä\n" +
                "-syötä sähköpostiosoite esimerkiksi muodossa abc@abc.fi\n" +
                "-syötä puhelinnumero ilman suuntanumeroa ja välilyöntejä\n" +
                "-käytä iässä vain numeroita\n" +
                "\nVoit myös palata takaisin ja tarkistaa tuloksesi.";
    }

    public static String getHelpMessageAfterContact() {
        return "Viestisi on nyt lähetetty!\n" +
                "Voit jakaa tuloksesi kavereillesi tai lopettaa pelin.\n" +
                "Voit myös palata takaisin ja tarkistaa tuloksesi.";
    }

    public static String getHelpMessageShare() {
        return "Voit jakaa tuloksesi eri sosiaalisen median alustoille.\n" +
                "Valitse haluamasi sosiaalisen median alusta klikkaamalla logoa.\n" +
                "Voit myös palata takaisin ja tarkistaa tuloksesi.";
    }

    public static String getExitMessage() {
        return "Vahvista pelin lopetus valitsemalla \"Lopeta\"\n" +
                "Voit jatkaa vastaamista kysymyksiin valitsemalla \"Palaa peliin\"";
    }

    public static String getCheckAnswers() {
        return "Ole hyvä ja vastaa kaikkiin kysymyksiin.";
    }
}