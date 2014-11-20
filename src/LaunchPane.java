import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import com.ptc.pfc.pfcGlobal.*;
import com.ptc.pfc.pfcSession.*;

public class LaunchPane {

    public static void start(){
        try {
            Session session = pfcGlobal.GetProESession();
            Properties prop = new Properties();
            String propFileName = "LaunchPane.properties";
            InputStream inputStream = LaunchPane.class.getClassLoader().getResourceAsStream(propFileName);
            prop.load(inputStream);
            if (inputStream == null) {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            String icon = prop.getProperty("icon");
            if (icon != null && icon.isEmpty()) icon = null;
            session.NavigatorPaneBrowserAdd(prop.getProperty("name"), icon, prop.getProperty("url"));
        } catch (Throwable x) {

        }
    }

    public static void stop() {

    }
}