package com.sample.www.Exercises;

import common.TestBase;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    @Test
    public void navigateTool() throws InterruptedException {
        test = extent.createTest("Verify URL", "Case 1: User needs to verify if Go Ibibo homepage works as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");

       /* openURL("https://www.wikipedia.org/");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");

        Thread.sleep(3000);
        searchBar();
        //logger.getName();*/

        driver.manage().window().maximize();

        String baseUrl="https://qatechhub.com/";

        driver.get(baseUrl);

        String title2 = "QA Automation Tools Trainings and Tutorials | QA Tech Hub";
        if(driver.getTitle().equals(title2)){
            System.out.println("PASS");
        }
        else System.out.println("FAIL");

        driver.navigate().to("https://www.facebook.com/");
        //print url
        String strUrl1 = driver.getCurrentUrl();
        System.out.println(strUrl1);


        driver.navigate().back();
        Thread.sleep(4000);
        String strUrl2 = driver.getCurrentUrl();
        System.out.println(strUrl2);

        driver.navigate().forward();
        String strUrl3 = driver.getCurrentUrl();
        System.out.println(strUrl3);

        Thread.sleep(4000);

        driver.close();

    }

}
