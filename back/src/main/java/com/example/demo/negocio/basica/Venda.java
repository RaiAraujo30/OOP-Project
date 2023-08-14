package negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String item;
    private String cliente;
    private String funcionario;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public Venda(String item, String cliente, String funcionario) {
        this.item = item;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }
    
    
    
}