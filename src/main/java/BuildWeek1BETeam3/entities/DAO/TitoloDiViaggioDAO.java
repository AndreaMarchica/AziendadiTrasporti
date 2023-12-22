package BuildWeek1BETeam3.entities.DAO;

import BuildWeek1BETeam3.entities.PuntoDiEmissione;
import BuildWeek1BETeam3.entities.TitoloDiViaggio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TitoloDiViaggioDAO {
    private final EntityManager em;

    public TitoloDiViaggioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(titoloDiViaggio);

            transaction.commit();

            System.out.println("titolo di viaggio salvato nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public TitoloDiViaggio getById(UUID id){
        TitoloDiViaggio found = em.find(TitoloDiViaggio.class, id);
        if(found == null){
            System.out.println("nessun titolo di viaggio trovato con quell'id");
        }
        return found;
    }


    public void delete(UUID id){
        TitoloDiViaggio found = this.getById(id);

        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("titolo di viaggio rimosso dal database");
        }else{
            System.out.println("titolo di viaggio non trovato, sicuro che l'id sia corretto?");
        }
    }

    public List<TitoloDiViaggio> getAll(){
        TypedQuery<TitoloDiViaggio> query = em.createQuery("SELECT t from TitoloDiViaggio t", TitoloDiViaggio.class);
        return query.getResultList();
    }

    public Long findNumberTitoliByPeriod(LocalDate startDate, LocalDate endDate, UUID puntoDiEmissioneID){
        TypedQuery<Long> query = em.createNamedQuery("findNumberTitoliByPeriod", Long.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        query.setParameter("puntodiemissione", puntoDiEmissioneID);
        return query.getSingleResult();
    }

    public List<TitoloDiViaggio> getAllVidimati(){
        TypedQuery<TitoloDiViaggio> query = em.createNamedQuery("getAllVidimati", TitoloDiViaggio.class);
        return query.getResultList();
    }

}
