package exercicio01;

public class Item {
    private String nome;
    private double quantidade;
    private TipoAlimento tipo;

    public Item(String nome, double quantidade, TipoAlimento tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public TipoAlimento getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nome + " - " + quantidade;
    }
}



