package DataLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 * JAVADOC ME
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class Utils {

    public static void runSQLScript(String filename) throws FileNotFoundException, IOException {
        String path = Paths.get(".." + File.separator + "assets" + File.separator + "sql_scripts").toAbsolutePath().normalize().toString();

        ScriptRunner runner = new ScriptRunner(DBConnector.getConnection());
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(path + File.separator + filename))) {
            runner.runScript(reader);
        }
    }

    public static void establishDBConnection() {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://207.154.222.88:3306/bankingTest?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String USER = "bank_tester"; // test user
        String PASSWORD = "passw0rd";
        Connection conn = null;

        try {
            if (conn == null || conn.isClosed()) {
                Class.forName(DRIVER).newInstance();
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                DBConnector.setConn(conn);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println("ERROR 42");
        }
    }
}
