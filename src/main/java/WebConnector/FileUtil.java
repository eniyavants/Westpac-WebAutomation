package WebConnector;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil extends webConnector {

    public static void CaptureScreenShot(String fileName, String extension) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        FileUtils.copyFile(scrFile, new File("src/test/Screenshot/" + fileName + " " + timestamp + extension));
    }
}
