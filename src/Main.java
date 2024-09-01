import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar backup ou new game.
        System.out.println("Gostaria de começar um novo jogo, ou começar de onde parou? 1 para novo jogo, 2 para resgatar um save: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        // Verifica a escolha do usuário
        if (escolha < 1 || escolha > 2) {
            // Tratamento para caso usuario nao escolher 1 ou 2
            System.out.println("Não válido, tente novamente com 1 para novo jogo ou 2 para resgatar um save.");
        } else if (escolha == 2) {
            // Resgatar backup
            System.out.println("Login: ");
            String login = sc.nextLine();
            System.out.println("Senha: ");
            String senha = sc.nextLine();

            logar Logar = new logar();
            logar.realizarLogin(login, senha);

        } else {
            // Novo jogo
            System.out.println("Seu login?: ");
            String login = sc.nextLine();
            System.out.println("Sua senha: ");
            String senha = sc.nextLine();

            Registro registro = new Registro();
            try {
                registro.registrar(login, senha);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
