import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {

    private Scanner scanner = new Scanner(System.in);
    private User user;

    private double saldo;
    private int numConta;
    private int numAgencia;

    public Bank(User user) {
        this.user = user;
        geraInfoBanco();
    }

    private void geraInfoBanco() {
        int min = 1000;
        int max = 9999;
        numAgencia = ThreadLocalRandom.current().nextInt(min, max + 1);
        numConta = ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void Banco() throws InterruptedException {
        int opc;

        do {
            System.out.printf("Seja bem-vindo %s\nPor favor, selecione uma opção\n1 - Depositar\n2 - Sacar\n3 - Verificar saldo\n4 - Sair\n\nNúmero da agência: %d\nNúmero da conta: %d\n", user.getName(), numAgencia, numConta);
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    depositar();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    verificarSaldo();
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar nosso banco.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opc != 4);
    }

    public void depositar() throws InterruptedException {
        System.out.println("Digite o valor que deseja depositar:");
        double valor = scanner.nextDouble();
        saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
        Thread.sleep(3000);
    }

    public void sacar() throws InterruptedException {
        System.out.println("Digite o valor que deseja sacar:");
        double valor = scanner.nextDouble();
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
            sacar();
        }
        Thread.sleep(3000);
    }

    public void verificarSaldo() throws InterruptedException {
        System.out.println("Seu saldo é: " + saldo);
        Thread.sleep(3000);
    }
}
