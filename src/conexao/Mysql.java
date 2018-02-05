package conexao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class Mysql {

    private static Mysql singleton = null;
    private static Connection con = null;
    private static boolean unica = true;
    private PreparedStatement stmt = null;
    // padrao de projeto que cria uma �nica instancia da classe BDMySql

    public static Mysql getInstance() {
        if (unica) {
            singleton = new Mysql();
        }
        return singleton;
    }
   // DataSource source;

    // construtor que conecta ao banco
    private Mysql() {
        try {
           // InitialContext java = new InitialContext();
            
            System.out.println("Conexão feita com sucesso!");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
         //   String url = "jdbc:mysql://mysql110039-certificadosonline.jelasticlw.com.br/certificado";
            String user = "root";
            String senha="1010010";
            String url = "jdbc:mysql://localhost:3306/certificados";
            con = DriverManager.getConnection(url,user,senha);

        } catch (SQLException e) {
            System.out.println("Nao foi possível realizar a conexão."+e.getLocalizedMessage());
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
     public  Connection createConexao() {
        Connection conexao;
        try {
            Properties p = new Properties();
            p.load(new FileInputStream(System.getProperty("user.home") + "/mydb.cfg"));
            String host = p.getProperty("host").toString();
            String user = p.getProperty("username").toString();
            String password = p.getProperty("password").toString();
            String driver = p.getProperty("driver").toString();
            Class.forName(driver);
            conexao = DriverManager.getConnection(host, user, password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Connection getConexao() {
        return con;
    }
    
    public boolean salvar(String sql){
        try {
            stmt = getConexao().prepareStatement(sql);
            return stmt.execute();
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Mysql.getInstance();
    }

}
