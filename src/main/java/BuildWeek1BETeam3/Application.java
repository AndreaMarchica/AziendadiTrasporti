package BuildWeek1BETeam3;

import BuildWeek1BETeam3.entities.*;
import BuildWeek1BETeam3.entities.DAO.MezzoDiTrasportoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendadiTrasporti");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            EntityManager entityManager= emf.createEntityManager();
            LocalDate dataInizioPeriodo= LocalDate.now();
            LocalDate dataFinePeriodo = LocalDate.now().plusDays(5);
           entityManager
                    .createNamedQuery("Biglietto.findVidimatiByPeriodo", Biglietto.class)
                    .setParameter("inizioPeriod", dataInizioPeriodo)
                    .setParameter("finePeriodo", dataFinePeriodo)
                    .getResultList().forEach(System.out::println);

        }
        catch(Exception err){
            System.out.println(err);
        }


        try {
            EntityManager entityManager= emf.createEntityManager();
            Tram tram = new Tram();
            UUID tramId= tram.getId();
            Autobus autobus = new Autobus();
            UUID autobusId= autobus.getId();
            Tratta tratta= new Tratta();
            UUID trattaId= tratta.getUuid();
            entityManager
                    .createNamedQuery("Tratta.countPercorsiPerMezzo", Tratta.class)
                    .setParameter("trattaId", trattaId)
                    .setParameter("tramId", tramId)
                    .setParameter("autobusId", autobusId)
                    .getResultList().forEach(System.out::println);
        }
        catch(Exception err){
            System.out.println(err);
        }


<<<<<<< HEAD

=======
            }
        });
//
//
//        //         **************************************** CREAZIONE DEI TITOLI DI VIAGGIO *******************************
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

        RivenditoreAutomatico aRiv1 = new RivenditoreAutomatico("EUR", true);
        RivenditoreAutomatico aRiv2 = new RivenditoreAutomatico("Garbatella", false);
        RivenditoreAutomatico aRiv3 = new RivenditoreAutomatico("Centocelle", true);
        RivenditoreAutorizzato riv4 = new RivenditoreAutorizzato("Trastevere");
        RivenditoreAutorizzato riv5 = new RivenditoreAutorizzato("Palatino");

        ped.save(aRiv1);
        ped.save(riv5);
        //           ****************************************SALVATAGGIO NEL DB ****************************************

        tvd.save(ped.getById(UUID.fromString("08105258-0440-43fc-9a92-8e7587215e1d")).stampaBiglietto());
>>>>>>> Larionov

        System.out.println("Hello World!");

        em.close();
        emf.close();
<<<<<<< HEAD
=======


        System.out.println("**************************************");
        System.out.println("Hello Moto!");
        System.out.println("**************************************");


>>>>>>> Larionov
    }
}
