import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        int opc;
        String email;
        String password;

        do {
            System.out.println("Seja bem-vindo, por favor selecione uma opção \n1 - Cadastrar usuário \n2 - Login \n3 - Sair");
            opc = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opc) {
                case 1:
                    user.SignUp();
                    break;
                case 2:
                    System.out.println("Digite seu e-mail:");
                    email = scanner.nextLine();

                    System.out.println("Digite sua senha:");
                    password = scanner.nextLine();

                    user.Login(email, password);
                    break;
                case 3:
                    System.out.println("Saindo, até mais!");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opc != 3);
    }
}
