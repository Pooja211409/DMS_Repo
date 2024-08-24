package com.cjc.main.utility;

import java.util.Random;

public class CredentialGeneratorUtility {
  
	public static final Random USERNAME_RANDOM=new Random(1000);
	public static final Random PASSWORD_RANDOM=new Random(1000);
//	Pattern :firstname3245  (random four digit)
	public static String getUsername(String firstName)
	{
		return firstName+USERNAME_RANDOM.nextInt(9999);
	}
	
//	Pattern :firstname@3245  (random four digit)
	public static String getPassword(String firstName)
	{
		return firstName+"@"+PASSWORD_RANDOM.nextInt(9999);
	}
	
}
