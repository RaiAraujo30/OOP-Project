package negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String Nomedamarca;

    

    public String getNomedamarca() {
        return Nomedamarca;
    }

    public void setNomedamarca(String nomedamarca) {
        Nomedamarca = nomedamarca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    

    
    
}