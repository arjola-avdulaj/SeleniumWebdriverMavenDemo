package common;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;


public class Utility
{
    public static void captureScreenshot(WebDriver driver,String screenshotName)
    {
        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            String fileDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());


            FileHandler.copy(source, new File("./Screenshots/"+screenshotName+fileDate+".png"));
        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }
}
