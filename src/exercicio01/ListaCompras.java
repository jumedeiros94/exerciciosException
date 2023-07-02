package exercicio01;

import java.util.ArrayList;
import java.util.List;

public class ListaCompras {

    private List<Item> itens;

    public ListaCompras() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }
}

