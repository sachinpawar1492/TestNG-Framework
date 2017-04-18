package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadObjects {
	Properties prop = new Properties();
	public Properties getObjectRepository(){
		try{
			//Read object repository file
			InputStream streamObj = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\objects\\Objects.properties"));
		
			//Load all objects
			prop.load(streamObj);
		
			return prop;
		}
		catch(Exception e){
			throw new AssertionError(e.getMessage());
		}
	}
}
