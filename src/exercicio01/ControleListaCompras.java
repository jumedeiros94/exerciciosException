package exercicio01;

import java.util.Scanner;

public class ControleListaCompras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaCompras listaCompras = new ListaCompras();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha o tipo de alimento: VERDURA, LEGUMES, GRAOS, OUTROS");
            String tipoAlimento = scanner.nextLine().toUpperCase();
            TipoAlimento tipo;
            try {
                tipo = TipoAlimento.valueOf(tipoAlimento);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Tipo de alimento inválido");
            }

            System.out.println("Informe a quantidade:");
            String quantidadeStr = scanner.nextLine();
            if (quantidadeStr.isEmpty()) {
                throw new UnsupportedOperationException("Não é permitido inserir valor vazio");
            }
            double quantidade = 0;
            try {
                quantidade = Double.parseDouble(quantidadeStr);
                if (quantidade < 0) {
                    System.out.println("Não é possível inserir número negativos");
                    continue;
                }
                if (tipo == TipoAlimento.VERDURA || tipo == TipoAlimento.GRAOS) {
                    if (quantidadeStr.contains(".")) {
                        quantidade = Double.parseDouble(quantidadeStr);
                    } else if (tipo == TipoAlimento.VERDURA) {
                        throw new NumberFormatException("Para verdura, a quantidade deve ser informada com ponto");
                    } else if (tipo == TipoAlimento.GRAOS) {
                        throw new NumberFormatException("Para grãos, a quantidade deve ser informada com ponto");
                    }
                } else if (tipo == TipoAlimento.LEGUMES || tipo == TipoAlimento.OUTROS) {
                    if (quantidadeStr.contains(".")) {
                        if (tipo == TipoAlimento.LEGUMES) {
                            throw new NumberFormatException("Para legume, a quantidade deve ser informada em unidades inteiras");
                        } else if (tipo == TipoAlimento.OUTROS) {
                            throw new NumberFormatException("Para outros, a quantidade deve ser informada em unidades inteiras");
                        }
                    } else {
                        quantidade = Integer.parseInt(quantidadeStr);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Informe o nome do alimento:");
            String nome = scanner.nextLine();
            if (nome.isEmpty()) {
                throw new UnsupportedOperationException("Não é permitido inserir nome vazio");
            }

            Item item = new Item(nome, quantidade, tipo);
            listaCompras.adicionarItem(item);

            System.out.println("Deseja continuar? [S/N]");
            String resposta = scanner.nextLine().toUpperCase();
            continuar = resposta.equals("S");
        }

        System.out.println("Lista de compras:");
        for (Item item : listaCompras.getItens()) {
            System.out.println(item);
        }

        int qtdVerdura = 0;
        int qtdLegumes = 0;
        int qtdGraos = 0;
        int qtdOutros = 0;

        for (Item item : listaCompras.getItens()) {
            switch (item.getTipo()) {
                case VERDURA:
                    qtdVerdura++;
                    break;
                case LEGUMES:
                    qtdLegumes++;
                    break;
                case GRAOS:
                    qtdGraos++;
                    break;
                case OUTROS:
                    qtdOutros++;
                    break;
            }
        }

        System.out.println("\nQuantidade de cada tipo de alimento:");
        System.out.println("Verdura: " + qtdVerdura + " KG");
        System.out.println("Legumes: " + qtdLegumes + " KG");
        System.out.println("Grãos: " + qtdGraos + " KG");
        System.out.println("Outros: " + qtdOutros + " KG");

        scanner.close();
    }
}

