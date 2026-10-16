import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BancoDados{
    private static final String URL = "jdbc:sqlite:locadora.db";

    // Abre a conexão com o banco de dados SQLite
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    // Cria a tabela automaticamente se ela não existir
    public static void inicializarBanco() {
        String sql = "CREATE TABLE IF NOT EXISTS dados_locadora (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "conteudo TEXT)";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Salva qualquer texto no banco de dados
    public static void salvarTexto(String texto) {
        String sql = "INSERT INTO dados_locadora (conteudo) VALUES (?)";
        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, texto);
            pstmt.executeUpdate();
            System.out.println("Salvo com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}