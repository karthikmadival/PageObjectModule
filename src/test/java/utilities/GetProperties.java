package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
	
	private Properties properties;
	private final String propertyFilePath= "./Resources/TestData.properties";

	public void configFileReader(){
	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(propertyFilePath));
		properties = new Properties();
		try {
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	}		
	
}
	
	public String getPropertyValue(String key){
		return properties.getProperty(key);
		
	}
}
