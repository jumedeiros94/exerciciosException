package exercicio02;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConversorDeMoedas {
    private static final BigDecimal COTACAO_DOLAR_AMERICANO = new BigDecimal("5.25");
    private static final BigDecimal COTACAO_DOLAR_CANADENSE = new BigDecimal("4.15");
    private static final BigDecimal COTACAO_EURO = new BigDecimal("6.15");
    private static final BigDecimal COTACAO_LIBRA_ESTERLINA = new BigDecimal("7.50");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Boas vindas ao conversor de moedas");

        while (continuar) {
            System.out.println("Qual a moeda que você quer converter?");
            System.out.println("1. Dólar americano");
            System.out.println("2. Dólar canadense");
            System.out.println("3. Euro");
            System.out.println("4. Libra Esterlina");

            int opcaoMoeda = scanner.nextInt();
            BigDecimal cotacao;
            String nomeMoeda;

            switch (opcaoMoeda) {
                case 1:
                    cotacao = COTACAO_DOLAR_AMERICANO;
                    nomeMoeda = "Dólar americano";
                    break;
                case 2:
                    cotacao = COTACAO_DOLAR_CANADENSE;
                    nomeMoeda = "Dólar canadense";
                    break;
                case 3:
                    cotacao = COTACAO_EURO;
                    nomeMoeda = "Euro";
                    break;
                case 4:
                    cotacao = COTACAO_LIBRA_ESTERLINA;
                    nomeMoeda = "Libra Esterlina";
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de moeda inválido");
            }

            System.out.println("O programa só sabe converter dinheiro para Real (R$)");

            BigDecimal valorAConverter;

            while (true) {
                System.out.println("Digite o valor a ser convertido:");
                try {
                    valorAConverter = scanner.nextBigDecimal();
                } catch (NumberFormatException e) {
                    System.out.println("Para moeda, o valor monetário deve ser um número decimal");
                    continue;
                }

                if (valorAConverter.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Valor inválido, por favor, tente novamente");
                } else {
                    break;
                }
            }

            BigDecimal valorConvertido = valorAConverter.multiply(cotacao);

            System.out.printf("%s na cotação de hoje está em %.2f, o valor que pediu para converter de %.2f em reais é R$%.2f%n",
                    nomeMoeda, cotacao, valorAConverter, valorConvertido);

            System.out.println("Deseja fazer outra conversão? (S/N)");
            String resposta = scanner.next();

            if (resposta.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }
    } }