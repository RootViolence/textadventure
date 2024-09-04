
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registro {

    // Método para registrar um novo usuário
    public static void registrar(String login, String senha) throws SQLException {

        // Consulta para verificar se o login já existe
        String consultarLogins = "SELECT * FROM usuarios WHERE login = ?";

        try (Connection conn = db.conectar();
             PreparedStatement stmt = conn.prepareStatement(consultarLogins)) {

            // Definindo o login
            stmt.setString(1, login);

            // Executando a consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Usuário já existe
                    System.out.println("Infelizmente este usuário já existe.");
                } else {
                    // String sql insert para inserir usuario novo
                    String sql = "INSERT INTO usuarios (login, senha, cena_id) VALUES (?, ?, 1)";

                    try (PreparedStatement insertStmt = conn.prepareStatement(sql)) {
                        // Inserindo login e senha
                        insertStmt.setString(1, login);
                        insertStmt.setString(2, senha);
                        int rowsAffected = insertStmt.executeUpdate();

                        if (rowsAffected > 0) {
                            // Usuário registrado
                            System.out.println("Usuário registrado com sucesso!");
                        } else {
                            System.out.println("Erro ao registrar o usuário.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro na realização do registro.");
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
