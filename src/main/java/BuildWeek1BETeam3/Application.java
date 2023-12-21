package BuildWeek1BETeam3;

import BuildWeek1BETeam3.entities.*;
import BuildWeek1BETeam3.entities.DAO.*;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaDiTrasporti");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        //test della query per trovare il numero di biglietti emessi da uno specifico punto di emissione in un certo lasso di tempo
//        TitoloDiViaggioDAO dao = new TitoloDiViaggioDAO(em);
//        System.out.println(dao.findNumberTitoliByPeriod(LocalDate.now().minusWeeks(1), LocalDate.now().plusDays(20), UUID.fromString("8b5d8eaf-06b8-46f5-98d1-0de88d3f9c9a")));


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


//  ****************************************CREAZIONE E SALVATAGGIO DEGLI UTENTI************************************

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

        //       ****************************************CREAZIONE DELLE TRATTE*********************************************


        mtd.getAll().forEach(mezzo -> {
            Random rndm = new Random();
            int tempo = rndm.nextInt(1, 150);
            Tratta t = new Tratta(faker.address().streetAddress(), faker.address().streetAddress(), tempo, mezzo);
            td.save(t);
        });


//       **************************************** CREAZIONE E SALVATAGGIO DELLE TESSERE *******************************

        ud.getAll().forEach(utente -> {
            Tessera tessera = new Tessera(utente);
            tsd.save(tessera);
        });

//          **************************************** CREAZIONE DEI TITOLI DI VIAGGIO *******************************

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
            //salvo nel database il biglietto ritornato dalla funzione 'stampaBiglietto()'
            if (b) {
                tvd.save(raut.stampaBiglietto());
            }
        }


        UUID tesseraId = UUID.fromString("f20a3582-5e8d-416f-9a89-5e8acd2a0e21");
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        if (tesseraDAO.isAbbonamentoValido(tesseraId) == null) {
            System.out.println("Tessera non è valida");
        } else {
            System.out.println("Tessera valida");
            System.out.println(tesseraDAO.isAbbonamentoValido(tesseraId));
        }


        em.close();
        emf.close();


        System.out.println("**************************************");
        System.out.println("Hello Moto!");
        System.out.println("**************************************");


    }
}

