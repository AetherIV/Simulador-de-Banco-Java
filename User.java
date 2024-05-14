import java.util.Objects;
import java.util.Scanner;

public class User {
    Scanner scanner = new Scanner(System.in);

    protected String Name;
    private String Email;
    private String Password;

    public void SignUp() {
        System.out.println("Digite seu nome completo:");
        Name = scanner.nextLine();

        System.out.println("Digite um e-mail válido:");
        Email = scanner.nextLine();

        System.out.println("Crie uma senha forte (Pelo menos 8 caracteres):");
        Password = scanner.nextLine();

        while (Password.isEmpty() || Password.length() < 8) {
            System.out.println("Senha inválida, digite novamente:");
            Password = scanner.nextLine();
        }
    }

    public void Login(String email, String password) throws InterruptedException {
        if (email.isEmpty() || !Objects.equals(this.Email, email)) {
            System.out.println("E-mail inválido, tente novamente");
            Thread.sleep(2000);
            return;
        }

        if (password.isEmpty() || !Objects.equals(this.Password, password)) {
            System.out.println("Senha inválida, tente novamente");
            Thread.sleep(2000);
            return;
        }

        System.out.printf("Login efetuado com sucesso, seja bem-vindo %s\n", Name);
        Thread.sleep(2000);
        Bank bank = new Bank(this);
        bank.Banco();
    }

    public String getName() {
        return Name;
    }
}
