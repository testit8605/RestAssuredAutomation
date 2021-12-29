package rsetAssuredTest;

import org.apache.commons.lang3.RandomStringUtils;

public class restUtils 
{
	
	public static String getName()
	{
		String gereratedString = RandomStringUtils.randomAlphabetic(1);
		return ("john"+gereratedString);
	}
	
	public static String getJob()
	{
		String gereratedString = RandomStringUtils.randomAlphabetic(2);
		return ("Software"+gereratedString);
	}
	

}
