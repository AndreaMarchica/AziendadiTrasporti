package BuildWeek1BETeam3;

import BuildWeek1BETeam3.entities.*;
import BuildWeek1BETeam3.entities.DAO.*;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaDiTrasporti");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALIAN);

        Supplier<LocalDate> dateSupplier = () -> {
            Random rdm = new Random();
            int randomYear = rdm.nextInt(2000, 2024);
            int randomDay = rdm.nextInt(1, 29);
            int randomMonth = rdm.nextInt(1, 12);
            return LocalDate.of(randomYear, randomMonth, randomDay);
        };


        TrattaDAO td = new TrattaDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        MezzoDiTrasportoDAO mtd = new MezzoDiTrasportoDAO(em);
        TesseraDAO tsd = new TesseraDAO(em);
        TitoloDiViaggioDAO tvd = new TitoloDiViaggioDAO(em);
        PuntoDiEmissioneDAO ped = new PuntoDiEmissioneDAO(em);

//        ****************************************CREAZIONE DELLE TRATTE*********************************************

/*
        for (int i = 0; i < 10; i++) {
            Random rndm = new Random();
            int tempo = rndm.nextInt(1, 150);
            Tratta t = new Tratta(faker.address().streetAddress(), faker.address().streetAddress(), tempo);
            td.save(t);
        }


//    ****************************************CREAZIONE E SALVATAGGIO DEGLI UTENTI************************************

        for (int i = 0; i < 10; i++) {
            Utente u = new Utente(faker.name().name(), faker.name().lastName());
            ud.save(u);
        }


//   **************************************** CREAZIONE E SALVATAGGIO DEI TRAM ****************************************

        for (int i = 0; i < 10; i++) {
            Random rndm = new Random();
            int posti = rndm.nextInt(50, 100);
            Tram t = new Tram(posti, dateSupplier.get());
            mtd.save(t);
        }


//        **************************************** CREAZIONE DEI BUS E SALVATAGGIO *******************************

        for (int i = 0; i < 10; i++) {
            Autobus a = new Autobus(50, dateSupplier.get());
            mtd.save(a);
        }

        //      **************************************** CREAZIONE E SALVATAGGIO DELLE TESSERE *******************************

        ud.getAll().forEach(utente -> {
            Tessera tessera = new Tessera(utente);
            tsd.save(tessera);
        });


        //       **************************************** CREAZIONE DEI TITOLI DI VIAGGIO *******************************


        tsd.getAll().forEach(tessera -> {
            Random rndm = new Random();
            boolean random = rndm.nextBoolean();

            if (random) {
                Abbonamento abbonamento = new Abbonamento(tessera, VALIDITA.MENSILE);
                tvd.save(abbonamento);
            } else {
                Abbonamento abbonamento = new Abbonamento(tessera, VALIDITA.SETTIMANALE);
                tvd.save(abbonamento);

            }
        });


        //         **************************************** CREAZIONE DEI TITOLI DI VIAGGIO *******************************
        for (int i = 0; i < 10; i++) {
            Random rdm = new Random();
            int a = rdm.nextInt(0, 2);
            boolean b;
            b = a == 1;
            RivenditoreAutomatico raut = new RivenditoreAutomatico(faker.address().streetAddress(), b);
            ped.save(raut);
        }

        RivenditoreAutomatico aRiv1 = new RivenditoreAutomatico("EUR", true);
        RivenditoreAutomatico aRiv2 = new RivenditoreAutomatico("Garbatella", false);
        RivenditoreAutomatico aRiv3 = new RivenditoreAutomatico("Centocelle", true);
        RivenditoreAutorizzato riv4 = new RivenditoreAutorizzato("Trastevere");
        RivenditoreAutorizzato riv5 = new RivenditoreAutorizzato("Palatino");


        //           ****************************************SALVATAGGIO NEL DB ****************************************

*/



        // *******************************QUERY***************************************************


        TesseraDAO tesseraDAO = new TesseraDAO(em);
        UUID tesseraIdToCheck = UUID.fromString("e8d4d416-2da8-4dc4-b419-03d03893054e");
        boolean isAbbonamentoValid = tesseraDAO.isAbbonamentoValido(tesseraIdToCheck);
        if (isAbbonamentoValid) {
            System.out.printf("**************************************");
            System.out.printf("Abbonamento valido.");
            System.out.println("**************************************");
        } else {
            System.out.println("Non è stato trovato un abbonamento valido.");
        }

        em.close();
        emf.close();


        System.out.printf("**************************************");
        System.out.printf("Hello Moto!");
        System.out.println("**************************************");


    }
}
