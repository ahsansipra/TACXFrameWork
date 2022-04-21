package commonUtils;

import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Utils {

    public static String randomStringGenerator(int length){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
  //      int length = 7;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        System.out.println("Random String is: " + randomString);
        return randomString;
    }

    public static boolean isListContainsValue(List<WebElement> elements, String value) {
        for (WebElement workout : elements) {
            if (workout.getText().contains(value)) {
                return true;
            }
        }
        return false;
    }

    public static String getProperties(String key) throws IOException {
        Properties prop = new Properties();
        InputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}
