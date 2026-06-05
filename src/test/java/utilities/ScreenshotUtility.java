package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	private static final String testName = null;

	public static String captureScreenshot(WebDriver driver, String screenshotName) {

        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File(
                    "screenshots/" + testName + ".png");

            dest.getParentFile().mkdirs();

            Files.copy(src.toPath(),
                    dest.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved: "
                    + dest.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
		return screenshotName;
    }

}
