package com.DragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JQuery_DragAndDrop extends BaseTest {
	
	WebElement draggable;
	WebElement droppable;
	
	public void frameIdentification()
	{
		By webPageFrameProperty=By.className("demo-frame");
		WebElement webPageFrame=driver.findElement(webPageFrameProperty);
		
		driver.switchTo().frame(webPageFrame);
	}
	
	public void GetText()
	{
		By draggableProperty=By.id("draggable");
		draggable=driver.findElement(draggableProperty);
		String draggableText=draggable.getText();
		System.out.println(" The draggable text is: "+draggableText);
		
		By droppableProperty=By.id("droppable");
		droppable=driver.findElement(droppableProperty);
		String droppableText=droppable.getText();
		System.out.println(" The droppable text is: "+droppableText);
	}
	
	public void dragAndDropOperation()
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(draggable, droppable).build().perform();
	}
	
	public static void main(String[] args)
	{
		JQuery_DragAndDrop dragAndDrop=new JQuery_DragAndDrop();
		dragAndDrop.applicationLaunch();
		dragAndDrop.frameIdentification();
		dragAndDrop.GetText();
		dragAndDrop.dragAndDropOperation();
//		dragAndDrop.applicationClose();
	}

}
