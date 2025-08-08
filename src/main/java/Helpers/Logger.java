package Helpers;

import org.apache.logging.log4j.LogManager;

public class Logger {
    // внутренний Log4j-логгер
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("ApplicationLogger");

    private Logger() {
        // запрет создания экземпляров
    }

    /** Логирует сообщение на уровне INFO */
    public static void log(String message) {
        logger.info(message);
    }

    /** Логирует сообщение на уровне DEBUG */
    public static void debug(String message) {
        logger.debug(message);
    }

    /** Логирует сообщение на уровне ERROR */
    public static void error(String message, Throwable t) {
        logger.error(message, t);
    }
}
