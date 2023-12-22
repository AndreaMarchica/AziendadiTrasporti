package BuildWeek1BETeam3;

import BuildWeek1BETeam3.entities.*;
import BuildWeek1BETeam3.entities.DAO.*;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaDiTrasporti");
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, Boolean> isAdmin = new HashMap<>();
    private static boolean logged = false;

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
        StoricoTratteDAO std = new StoricoTratteDAO(em);
        StatoDao sd = new StatoDao(em);

//  ****************************************CREAZIONE E SALVATAGGIO DEGLI UTENTI************************************
/*        for (int i = 0; i < 10; i++) {
            Utente u = new Utente(faker.name().name(), faker.name().lastName());
            ud.save(u);
        }

//   **************************************** CREAZIONE E SALVATAGGIO DEI TRAM ****************************************
        Stato stato = new Stato(StatoMezzo.IN_SERVIZIO);
        sd.save(stato);

        for (int i = 0; i < 10; i++) {
            Random rndm = new Random();
            int posti = rndm.nextInt(50, 100);
            Tram t = new Tram(posti, dateSupplier.get(), stato);
            stato.aggiungiMezzo(t);
            mtd.save(t);
        }


//        **************************************** CREAZIONE DEI BUS E SALVATAGGIO *******************************

        for (int i = 0; i < 10; i++) {
            Random rndm = new Random();
            int posti = rndm.nextInt(50, 100);
            Autobus a = new Autobus(posti, dateSupplier.get(), stato);
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
        }*/

//        System.out.println(td.contaPercorsi(UUID.fromString("0d1c4f10-82af-4b05-812b-b824d2f5751d")));

        // ricupero il mezzo dal db
 //       MezzoDiTrasporto berlusconiBus = mtd.getById(UUID.fromString("00b02f09-b816-47ea-93db-0ed1f0528a9c"));


        //ricupero una tratta dal db

        Tratta trattaUno = td.getById(UUID.fromString("1d345322-3f7f-4112-ba42-d309dc853c68"));

 //       StoricoTratte trattaNunzio = new StoricoTratte(LocalDate.now().minusDays(1), 10, trattaUno, berlusconiBus);

//        std.save(trattaNunzio);


//        **************************************CREAO UNO STATO DEL MEZZO***********************************

 //       Stato manutenzione1 = new Stato(StatoMezzo.IN_MANUTENZIONE, LocalDate.now(), TipoManutenzione.STRAORDINARIA, berlusconiBus);
 //       sd.save(manutenzione1);

        //****************************ASSEGNO LO STATO AL MEZZO ESISTENTE PRESO DAL DATABASE**********

//        berlusconiBus.setStato(manutenzione1);

//       ***************************AGGIORNO LO STATO DEL MEZZO*************************************

 //       mtd.save(berlusconiBus);

 //       handleUserLoginAndRegister();

        Biglietto biglietto2 = (Biglietto) tvd.getById(UUID.fromString("1dac8686-beb5-4781-a1e6-8ea8b1574269"));
        MezzoDiTrasporto berlusconiBus = mtd.getById(UUID.fromString("1bcc7861-3788-41b3-bb2a-3e8db1053b04"));
        berlusconiBus.timbraBiglietto(biglietto2);
        mtd.update(berlusconiBus);

        new MezzoDiTrasportoDAO(em).getAllOutOfService().forEach(System.out::println);
        new TitoloDiViaggioDAO(em).getAllVidimati().forEach(System.out::println);

        em.close();
        emf.close();


        System.out.println("**************************************");
        System.out.println("Hello Moto!");
        System.out.println("**************************************");



    }


    public static void handleUserLoginAndRegister() {

        Scanner scanner = new Scanner(System.in);


        while (!logged) {
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Registrati come Utente Normale");
            System.out.println("2. Registrati come Admin");
            System.out.println("3. Effettua il login");
            System.out.println("4. Esci");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Inserisci il nome utente: ");
                    String username = scanner.next();
                    scanner.nextLine();
                    System.out.print("Inserisci la password: ");
                    String password = scanner.next();
                    scanner.nextLine();
                    if (!users.containsKey(username)) {
                        users.put(username, password);
                        //entra in questo case sia se la scelta é uno sia se é due.
                        //quindi, per stabilire se é un admin, passo il risultato booleano della condizione choice == 2
                        isAdmin.put(username, choice == 2);
                        System.out.println("Registrazione avvenuta con successo.");
                    } else {
                        System.out.println("Username già in uso. Riprova.");
                    }
                    break;
                case 3:
                    System.out.print("Inserisci il nome utente: ");
                    String loginUsername = scanner.next();
                    scanner.nextLine();
                    System.out.print("Inserisci la password: ");
                    String loginPassword = scanner.next();
                    scanner.nextLine();
                    if (users.containsKey(loginUsername) && users.get(loginUsername).equals(loginPassword)) {
                        boolean isUserAdmin = isAdmin.get(loginUsername);
                        if (isUserAdmin) {
                            System.out.println("Accesso come Admin effettuato con successo per l'utente: " + loginUsername);
                        } else {
                            System.out.println("Accesso come Utente Normale effettuato con successo per l'utente: " + loginUsername);
                        }
                        logged = true;
                    } else {
                        System.out.println("Credenziali non valide. Riprova.");
                    }
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}

