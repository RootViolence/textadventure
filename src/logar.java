import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Metodo para fazer login

public class logar {

    public static void realizarLogin(String login, String senha) {
        // Consulta mysql
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

        try (Connection conn = db.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Conferindo login e senha
            stmt.setString(1, login);  // Primeiro parâmetro (login)
            stmt.setString(2, senha);  // Segundo parâmetro (senha)

            // Executando a consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Encontrado
                    System.out.println("Login bem-sucedido!");
                    System.out.println("ID: " + rs.getInt("id_usuario") + ", Nome: " + rs.getString("login"));
                } else {
                    // Não encontrado
                    System.out.println("Login ou senha incorretos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro na realização do login.");
        }
    }
}

