package BuildWeek1BETeam3;

import BuildWeek1BETeam3.entities.DAO.TrattaDAO;
import BuildWeek1BETeam3.entities.DAO.UtenteDAO;
import BuildWeek1BETeam3.entities.Tratta;
import BuildWeek1BETeam3.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaDiTrasporti");

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendadiTrasporti");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        TrattaDAO td = new TrattaDAO(em);
        UtenteDAO ud = new UtenteDAO(em);

//        ****************************************CREAZIONE DELLE TRATTE*********************************************

        Tratta Linea1 = new Tratta("Piazza della Libertà", "via Svevo", 20);
        Tratta Linea3 = new Tratta("Conconello", "Piazza della Libertà", 45);
        Tratta Linea4 = new Tratta("Villa Carsia", "Piazza Oberdan", 30);
        Tratta Linea5 = new Tratta("Piazza del Perugino", "Roiano", 30);
        Tratta Linea6 = new Tratta("San Giovanni(Piazzalre Gioberti)", "Grignano", 25);
        Tratta Linea7 = new Tratta("Muggia", "Lazzaretto", 60);
        Tratta Linea8 = new Tratta("Roiano", "Via Valmaura", 45);
        Tratta Linea9 = new Tratta("piazzale Gioberti", "largo Irneri", 30);
        Tratta Linea10 = new Tratta("piazza Tommaseo", "Via Valmaura", 40);

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




        em.close();
        emf.close();
        System.out.println("Hello World!");
    }
}
