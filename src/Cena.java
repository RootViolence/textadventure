import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cena {
    public static void save(String login) {
        // inserindo a string sql para procurar dentro do banco de dados a cena que o usuario está de acordo com o login do mesmo
        String sql = "SELECT cena_id FROM usuarios WHERE login = ?";
        // tentando conectar com o banco de dados
        try (Connection conn = db.conectar();
             // preparando a string sql
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // inserindo o login dentro da string sql
            stmt.setString(1, login);
            // executar a string agora preparada com o login do usuario
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // colocando a cena que o usuario se encontra dentro da variavel cenaUsuario
                    int cenaUsuario = (rs.getInt("cena_id"));
                    // escolhendo e definindo a cena que o usuario está e mostrando-a para o usuario
                    switch (cenaUsuario) {
                        case 1:
                            System.out.println(" Em uma manhã de domingo, no interior, o fazendeiro Joh de LaMango estava cuidando de sua horta de milho. Ele notou pegadas grandes e pés de milho quebrados, o que o deixou estressado. Ele colocou armadilhas de urso por toda a fazenda e foi descansar.");
                        case 2:
                            System.out.println(" Na madrugada, Joh ouviu barulhos de galhos se quebrando e decidiu investigar sozinho. Quando chegou ao quintal, encontrou Shrek fugindo com um saco cheio de mangas, após ter colhido todas as mangas do único pé de manga da fazenda. Joh o perseguiu até que Shrek ficou preso em uma armadilha de urso. A polícia chegou e prendeu Shrek.");
                        case 3:
                            System.out.println(" Joh decidiu interrogá-lo pessoalmente. Shrek permaneceu em silêncio durante todas as tentativas de interrogatório. Depois de vários dias, Joh desistiu e Shrek foi levado para uma prisão próxima. No entanto, em um domingo, enquanto a maioria dos seguranças estava fora, Shrek conseguiu fugir e foi visto novamente roubando mangas e milhos. As buscas por Shrek começaram e continuam até os dias de hoje.");
                        case 4:
                            System.out.println(" Joh decidiu organizar uma equipe de busca para encontrar Shrek. Após semanas de buscas intensivas, a equipe conseguiu localizar Shrek em uma caverna. Shrek foi finalmente capturado e levado de volta à prisão. Desde então, a fazenda de Joh ficou em paz, e Shrek foi mantido sob vigilância constante.");
                        case 5:
                            System.out.println(" Joh optou por buscar uma solução pacífica. Ele tentou negociar com Shrek, oferecendo-lhe um suprimento regular de mangas e milhos em troca de paz. Shrek concordou, e desde então, ele tem sido um visitante regular na fazenda, ajudando a cuidar da horta em troca dos alimentos. A paz foi restaurada e ambos, Shrek e Joh, mantiveram uma relação de respeito mútuo.");
                        default:
                            System.out.println("Erro na contabilização da cena.");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}