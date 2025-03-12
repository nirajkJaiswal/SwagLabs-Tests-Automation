package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataProvider {

	public static Properties appConfig= new Properties();
	public static Properties InputData= new Properties();
	public static Properties outputData= new Properties();

	public DataProvider() {
		File directory = new File("./");
		String dirPath = directory.getAbsolutePath();
		try (FileInputStream fis = new FileInputStream(dirPath + "\\configs\\configuration.properties")) {
			appConfig.load(fis);

		} catch (Exception e) {
			Log.Error("Config file missing ");
		}
		try (FileInputStream fis = new FileInputStream(dirPath + "\\data\\inputData.properties")) {
			InputData.load(fis);

		} catch (Exception e) {
			Log.Error("Config file missing ");
		}
		try (FileInputStream fis = new FileInputStream(dirPath + "\\data\\outputData.properties")) {
			outputData.load(fis);

		} catch (Exception e) {
			Log.Error("Config file missing ");
		}
	}

}
