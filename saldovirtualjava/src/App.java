import java.util.Scanner;
import java.util.ArrayList;

public class App {
    
    public static void exibeMenu() {
        System.out.println("************************");
        System.out.println("**** Digite sua opção ****");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Transferir valor");
        System.out.println("3 - Receber valor");
        System.out.println("4 - Sair");
        System.out.println("5 - Exibe histórico completo");
    }

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Double> historicoTransferencia = new ArrayList<>();
        ArrayList<Double> historicoRecebimento = new ArrayList<>();
        double valorTransferido;

        System.out.print("Seu nome: ");
        String nome = entrada.next();

        System.out.print("Informe saldo inicial: ");
        double saldo = entrada.nextDouble();

        System.out.println("Entrando na sua conta, " + nome + ", aguarde...");
        Thread.sleep(2000);

        while (true) {
            exibeMenu();
            System.out.print("Digite a opção desejada: ");
            int opcaoDigitada = entrada.nextInt();

            if (opcaoDigitada == 1) {
                System.out.println("Seu saldo atual: R$" + saldo);
            } else if (opcaoDigitada == 2) {
                System.out.print("Digite o valor a transferir: ");
                valorTransferido = entrada.nextDouble();

                if (valorTransferido > saldo) {
                    System.out.println("Saldo insuficiente para transferência.");
                } else {
                    saldo -= valorTransferido;
                    historicoTransferencia.add(valorTransferido);
                    System.out.println("Transferência de R$" + valorTransferido + " realizada com sucesso!");
                    System.out.println("Novo saldo: R$" + saldo);

                    Thread.sleep(2000);
                    System.out.println("Exibindo histórico...");
                    Thread.sleep(1500);
                    System.out.print("histórico de transferências: " + historicoTransferencia);
                }
            } else if (opcaoDigitada == 3) {
                System.out.print("Digite o valor a receber: ");
                double valorAReceber = entrada.nextDouble();
                saldo += valorAReceber;
                historicoRecebimento.add(valorAReceber);
                System.out.println("Novo saldo: R$" + saldo);

                Thread.sleep(2000);
                System.out.println("Exibindo histórico...");
                Thread.sleep(1500);
                System.out.print("histórico de recebimento: " + historicoRecebimento);
            } else if (opcaoDigitada == 4) {
                System.out.println("Saindo do sistema...");
                Thread.sleep(2000);
                System.out.println("Saiu!");
                break;
            } else if (opcaoDigitada == 5) {
                if (historicoTransferencia.isEmpty() && historicoRecebimento.isEmpty()) {
                    System.out.println("Sem transferências ou recebimentos!");
                } else {
                    System.out.println("Histórico transferências: " + historicoTransferencia);
                    System.out.println("Histórico recebimento: " + historicoRecebimento);
                }
            } else {
                System.out.println("Opção inválida");
            }

            Thread.sleep(2000);
        }

        entrada.close();
    }
}
