package BuildWeek1BETeam3.entities.DAO;

import BuildWeek1BETeam3.entities.Abbonamento;
import BuildWeek1BETeam3.entities.Tessera;
import BuildWeek1BETeam3.entities.TitoloDiViaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TesseraDAO {
    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(tessera);

            transaction.commit();

            System.out.println("tessera salvata nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Tessera getById(UUID id){
        Tessera found = em.find(Tessera.class, id);
        if(found == null){
            System.out.println("nessuna tessera trovata con quell'id");
        }
        return found;
    }

    public static List<Tessera> getAll(){
        TypedQuery<Tessera> query = em.createQuery("SELECT t from Tessera t", Tessera.class);
        return query.getResultList();
    }


    public void delete(UUID id){
        Tessera found = this.getById(id);

        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("tessera rimossa dal database");
        }else{
            System.out.println("tessera non trovata, sicuro che l'id sia corretto?");
        }
    }

    public Abbonamento isAbbonamentoValido(UUID tesseraId) {
        try {
        TypedQuery<Abbonamento> query = em.createNamedQuery("abbonamentiValidi", Abbonamento.class);
        query.setParameter("tesseraId", tesseraId);
        return query.getSingleResult();}
        catch (NoResultException noResultException) {
            return null;
        }
    }


}
