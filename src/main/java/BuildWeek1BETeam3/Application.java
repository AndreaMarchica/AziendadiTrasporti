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
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaDiTrasporti");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALIAN);

        Supplier<LocalDate> dateSupplier = () -> {
            Random rdm = new Random();
            int randomYear = rdm.nextInt(2000,2024);
            int randomDay = rdm.nextInt(1,29);
            int randomMonth = rdm.nextInt(1,12);
            return LocalDate.of(randomYear, randomMonth,randomDay);
        };


        TrattaDAO td = new TrattaDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        MezzoDiTrasportoDAO mtd = new MezzoDiTrasportoDAO(em);
        TesseraDAO tsd = new TesseraDAO(em);
        TitoloDiViaggioDAO tvd = new TitoloDiViaggioDAO(em);
        PuntoDiEmissioneDAO ped = new PuntoDiEmissioneDAO(em);

//        ****************************************CREAZIONE DELLE TRATTE*********************************************

        Tratta Linea1 = new Tratta("Piazza della Libertà", "via Svevo", 20);
        Tratta Linea3 = new Tratta("Conconello", "Piazza della Libertà", 45);
        Tratta Linea4 = new Tratta("Villa Carsia", "Piazza Oberdan", 30);
        Tratta Linea5 = new Tratta("Piazza del Perugino", "Roiano", 30);
        Tratta Linea6 = new Tratta("San Giovanni(Piazzale Gioberti)", "Grignano", 25);
        Tratta Linea7 = new Tratta("Muggia", "Lazzaretto", 60);
        Tratta Linea8 = new Tratta("Roiano", "Via Valmaura", 45);
        Tratta Linea9 = new Tratta("Piazzale Gioberti", "largo Irneri", 30);
        Tratta Linea10 = new Tratta("Piazza Tommaseo", "Via Valmaura", 40);

//        ****************************************SALVATAGGIO NEL DB DELLE TRATTE****************************

        td.save(Linea1);
        td.save(Linea3);
        td.save(Linea4);
        td.save(Linea5);
        td.save(Linea6);
        td.save(Linea7);
        td.save(Linea8);
        td.save(Linea9);
        td.save(Linea10);

//    ****************************************CREAZIONE E SALVATAGGIO DEGLI UTENTI************************************

        for (int i = 0; i < 10; i++){
            Utente u = new Utente(faker.name().name(), faker.name().lastName());
            ud.save(u);
        }


//   **************************************** CREAZIONE E SALVATAGGIO DEI TRAM ****************************************

        for (int i = 0; i < 10; i++){
            Random rndm = new Random();
            int posti =  rndm.nextInt(50,100);
            Tram t = new Tram(posti, dateSupplier.get());
            mtd.save(t);
        }


//        **************************************** CREAZIONE DEI BUS E SALVATAGGIO *******************************

        for (int i = 0; i < 10; i++) {
            Autobus a = new Autobus(50,dateSupplier.get());
            mtd.save(a);
        }

 //      **************************************** CREAZIONE E SALVATAGGIO DELLE TESSERE *******************************

        ud.getAll().forEach(utente -> {
            Tessera tessera = new Tessera(utente);
            tsd.save(tessera);
        });

 //       **************************************** CREAZIONE DEI TITOLI DI VIAGGIO *******************************

        Biglietto biglietto1 = new Biglietto();
        Biglietto biglietto2 = new Biglietto();
        Biglietto biglietto3 = new Biglietto();
        Biglietto biglietto4 = new Biglietto();
        Biglietto biglietto5 = new Biglietto();

        tsd.getAll().forEach( tessera -> {
            Abbonamento abbonamento = new Abbonamento(tessera, VALIDITA.MENSILE);
            tvd.save(abbonamento);
        });

 //        ****************************************SALVATAGGIO NEL DB ****************************************


        tvd.save(biglietto1);
        tvd.save(biglietto2);
        tvd.save(biglietto3);
        tvd.save(biglietto4);
        tvd.save(biglietto5);



 //         **************************************** CREAZIONE DEI TITOLI DI VIAGGIO *******************************
        for (int i = 0; i <10; i++){
            Random rdm = new Random();
            int a = rdm.nextInt(0, 2);
            boolean b;
            b = a == 1 ;
            RivenditoreAutomatico raut = new RivenditoreAutomatico(faker.address().streetAddress(), b);
            ped.save(raut);
        }
/*        RivenditoreAutomatico aRiv1 = new RivenditoreAutomatico("EUR", true);
        RivenditoreAutomatico aRiv2 = new RivenditoreAutomatico("Garbatella", false);
        RivenditoreAutomatico aRiv3 = new RivenditoreAutomatico("Centocelle", true);
        RivenditoreAutorizzato riv4 = new RivenditoreAutorizzato("Trastevere");
        RivenditoreAutorizzato riv5 = new RivenditoreAutorizzato("Palatino");*/

 //           ****************************************SALVATAGGIO NEL DB ****************************************

/*        ped.save(aRiv1);
        ped.save(aRiv2);
        ped.save(aRiv3);
        ped.save(riv4);
        ped.save(riv5);*/


/*        tvd.save(aRiv1.stampaBiglietto());*/


        em.close();
        emf.close();
        System.out.println("Hello Moto!");
    }
}
