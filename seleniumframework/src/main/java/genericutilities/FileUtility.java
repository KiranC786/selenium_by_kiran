package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String properties(String key)throws IOException {
	
	FileInputStream file =new FileInputStream("./src/test/resorce/Testdata/demoapplication.xlsx");
	Properties properties = new Properties();
	properties.load(file);
	return properties.getProperty(key);
	
	
}
}
