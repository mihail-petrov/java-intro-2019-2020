package homework.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
	protected Properties properties = new Properties();

	public ConfigFile(String fileName) throws IOException {
		properties.load(new FileReader(fileName));
	}
}
