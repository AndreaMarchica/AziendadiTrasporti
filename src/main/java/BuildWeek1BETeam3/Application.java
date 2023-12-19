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




        System.out.println("Hello World!");

        em.close();
        emf.close();
    }
}
