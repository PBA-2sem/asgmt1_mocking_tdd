package DataLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 * JAVADOC ME
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class Utils {

    public static void runSQLScript(DBConnector dbconnector, String filename) throws FileNotFoundException, IOException {
        String path = Paths.get(".." + File.separator + "assets").toAbsolutePath().normalize().toString();

        ScriptRunner runner = new ScriptRunner(dbconnector.getConnection());
        InputStreamReader reader = new InputStreamReader(new FileInputStream(path + File.separator + filename));
        runner.runScript(reader);
        reader.close();
    }

}
