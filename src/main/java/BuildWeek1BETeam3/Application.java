package BuildWeek1BETeam3;

import BuildWeek1BETeam3.entities.*;
import BuildWeek1BETeam3.entities.DAO.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaDiTrasporti");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Supplier<LocalDate> dateSupplier = () -> {
            Random rdm = new Random();
            int randomYear = rdm.nextInt(2000,2024);
            int randomDay = rdm.nextInt(1,30);
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

//        ****************************************CREAZIONE DEGLI UTENTI************************************

        Utente aldo = new Utente("Aldo", "Baglio");
        Utente giovanni = new Utente("Giovanni", "Storti");
        Utente giacomo = new Utente("Giacomo", "Poretti");
        Utente fabrizio = new Utente("Fabrizio" ,"de Andrò");
        Utente mina = new Utente("Mina", "Mazzini");
        Utente lidija = new Utente ( "lidija" , "Percan");
        Utente lucio = new Utente ( "Lucio" , "Battisti");
        Utente francesco = new Utente ( "Francesco" , "de Gregori");
        Utente andrea = new Utente ( "Andrea" , "Boccelli");
        Utente niccolò  = new Utente ( "Niccolò " , "Paganini");

//        ****************************************SALVATAGGIO NEL DB ****************************************

        ud.save(aldo);
        ud.save(giovanni);
        ud.save(giacomo);
        ud.save(fabrizio);
        ud.save(mina);
        ud.save(lidija);
        ud.save(lucio);
        ud.save(francesco);
        ud.save(andrea);
        ud.save(niccolò);

//        **************************************** CREAZIONE DEI TRAM ****************************************

        Tram tram1 = new Tram (70, LocalDate.of(2011, 7, 30));
        Tram tram2 = new Tram (60, LocalDate.of(2021, 9, 3));
        Tram tram3 = new Tram (71, LocalDate.of(2010, 2, 15));

//           ****************************************SALVATAGGIO NEL DB ****************************************

        mtd.save(tram1);
        mtd.save(tram2);
        mtd.save(tram3);

//        **************************************** CREAZIONE DEI BUS E SALVATAGGIO *******************************

        for (int i = 0; i < 10; i++) {
            Autobus a = new Autobus(50,dateSupplier.get());
            mtd.save(a);
        }

 //         **************************************** CREAZIONE DELLE TESSERE *******************************

        Tessera tessera1 = new Tessera(aldo);
        Tessera tessera2 = new Tessera(giovanni);
        Tessera tessera3 = new Tessera(giacomo);
        Tessera tessera4 = new Tessera(mina);

 //        ****************************************SALVATAGGIO NEL DB ****************************************

        tsd.save(tessera1);
        tsd.save(tessera2);
        tsd.save(tessera3);
        tsd.save(tessera4);

 //       **************************************** CREAZIONE DEI TITOLI DI VIAGGIO *******************************

        Biglietto biglietto1 = new Biglietto();
        Biglietto biglietto2 = new Biglietto();
        Biglietto biglietto3 = new Biglietto();
        Biglietto biglietto4 = new Biglietto();
        Biglietto biglietto5 = new Biglietto();
        Abbonamento abbonamento1 = new Abbonamento(tessera1, VALIDITA.MENSILE);
        Abbonamento abbonamento2 = new Abbonamento(tessera2, VALIDITA.SETTIMANALE);
        Abbonamento abbonamento3 = new Abbonamento(tessera3, VALIDITA.MENSILE);
        Abbonamento abbonamento4 = new Abbonamento(tessera4, VALIDITA.MENSILE);
        Abbonamento abbonamento5 = new Abbonamento(tessera1, VALIDITA.SETTIMANALE);

 //        ****************************************SALVATAGGIO NEL DB ****************************************

/*        tvd.save(abbonamento1);
        tvd.save(abbonamento2);
        tvd.save(abbonamento3);
        tvd.save(abbonamento4);
        tvd.save(abbonamento5);
        tvd.save(biglietto1);
        tvd.save(biglietto2);
        tvd.save(biglietto3);
        tvd.save(biglietto4);
        tvd.save(biglietto5);*/



 //         **************************************** CREAZIONE DEI TITOLI DI VIAGGIO *******************************

        RivenditoreAutomatico aRiv1 = new RivenditoreAutomatico("EUR", true);
        RivenditoreAutomatico aRiv2 = new RivenditoreAutomatico("Garbatella", false);
        RivenditoreAutomatico aRiv3 = new RivenditoreAutomatico("Centocelle", true);
        RivenditoreAutorizzato riv4 = new RivenditoreAutorizzato("Trastevere");
        RivenditoreAutorizzato riv5 = new RivenditoreAutorizzato("Palatino");

 //           ****************************************SALVATAGGIO NEL DB ****************************************

        ped.save(aRiv1);
        ped.save(aRiv2);
        ped.save(aRiv3);
        ped.save(riv4);
        ped.save(riv5);
        tvd.save(aRiv1.stampaBiglietto());
        em.close();
        emf.close();
        System.out.println("Hello Moto!");
    }
}
