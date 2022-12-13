import java.util.concurrent.atomic.AtomicInteger;
public class Compte {
	private static final AtomicInteger count = new AtomicInteger(1);
    private int id = 0;
    private double solde = 0;
    private String clientName;

    public Compte () {
    }

    public Compte ( String clientName ) {
        this.id         = count.incrementAndGet(); //id incrémente avec l'ajout des clients
        this.clientName = clientName;
    }
    public Compte(String clientName,double mt) {
    	  this.id         = count.incrementAndGet(); //id incrémente avec l'ajout des clients
          this.clientName = clientName;
          this.solde=mt;
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public double getSolde () {
        return solde;
    }

    public void setSolde ( double solde ) {
        this.solde = solde;
    }

    public String getClientName () {
        return clientName;
    }

    public void setClientName ( String clientName ) {
        this.clientName = clientName;
    }
  
}
