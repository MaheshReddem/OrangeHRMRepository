package com.ScreenShotExample;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class CaptureScreenShotTest extends BaseTest {
	
	@Test
	public void capturing_screenShotTest() throws IOException
	{
		File scrShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrShot, new File("E:\\MyWorkSpace\\WebApplications_Livetech\\ScreenShots\\TsrtcHomePage.png"));
		
//		File destFile=new File("E:\\MyWorkSpace\\WebApplications_Livetech\\ScreenShots\tsrtc.png");
//		FileUtils.copyFile(srcfile, destFile);
		
		
	}
	
	

}
