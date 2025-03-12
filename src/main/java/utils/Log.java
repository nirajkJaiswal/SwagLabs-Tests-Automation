package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	public static final Logger logger = LogManager.getLogger();

	public static void Info(String message) {
		logger.info(message);
	}

	public static void Warn(String message) {
		logger.warn(message);
	}

	public static void Error(String message) {
		logger.error(message);
	}

	public static void Debug(String message) {
		logger.debug(message);
	}
}
