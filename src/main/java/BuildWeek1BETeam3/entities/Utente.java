package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_utente;

    @Column ( name = "nome_utente")
    public String nome_utente;

    @Column(name = "password_utente", nullable = false)
    private String password;

    @Column(name = "admin")
    private boolean isAdmin;

    @Column ( name = "cognome_utente")
    public  String cognome_utente;

    @OneToOne(mappedBy = "utente")
    private Tessera tessera;


    public Utente(String nome_utente, String cognome_utente, String passwordUtente, boolean isAdmin) {
        this.nome_utente = nome_utente;
        this.cognome_utente = cognome_utente;
        this.password = passwordUtente;
        this.isAdmin = isAdmin;
    }

    public Utente() {
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id_utente=" + id_utente +
                ", nome_utente='" + nome_utente + '\'' +
                ", cognome_utente='" + cognome_utente + '\'' +
                '}';
    }

    public UUID getId_utente() {
        return id_utente;
    }

    public String getNome_utente() {
        return nome_utente;
    }

    public void setNome_utente(String nome_utente) {
        this.nome_utente = nome_utente;
    }

    public String getCognome_utente() {
        return cognome_utente;
    }

    public void setCognome_utente(String cognome_utente) {
        this.cognome_utente = cognome_utente;
    }
}
