package utilities;

import org.testng.annotations.DataProvider;

public class Dataset {
	
	@DataProvider(name = "InvalidCredensial")
	public static Object dataset() {
		Object [][] objects = {{"0111111111","password","Please enter a valid phone number."},
				{"01378154154","password","Incorrect username or password."}	
	};
		return objects;
	}
}