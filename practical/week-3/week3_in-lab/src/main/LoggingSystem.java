package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// === LogLevel Enum ===
enum LogLevel {
    INFO, DEBUG, ERROR
}

// === Command Pattern ===
// Command Interface
interface Command {
    void execute(String message, LogLevel level);
}

// LogCommand Class
class LogCommand implements Command {
    private final LogHandler handler;

    public LogCommand(LogHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute(String message, LogLevel level) {
        handler.handleRequest(message, level);
    }
}

// === Chain of Responsibility Pattern ===
// Abstract LogHandler Class
abstract class LogHandler {
    protected LogHandler nextHandler;

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String message, LogLevel level) {
        if (nextHandler != null) {
            nextHandler.handleRequest(message, level);
        }
    }

    protected abstract void log(String message);
}

// InfoHandler Class
class InfoHandler extends LogHandler {
    @Override
    public void handleRequest(String message, LogLevel level) {
        if (level == LogLevel.INFO) {
            log(message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(message, level);
        }
    }

    @Override
    protected void log(String message) {
        System.out.println("[INFO] " + message);
    }
}

// DebugHandler Class
class DebugHandler extends LogHandler {
    @Override
    public void handleRequest(String message, LogLevel level) {
        if (level == LogLevel.DEBUG) {
            log(message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(message, level);
        }
    }

    @Override
    protected void log(String message) {
        System.out.println("[DEBUG] " + message);
    }
}

// ErrorHandler Class
class ErrorHandler extends LogHandler {
    @Override
    public void handleRequest(String message, LogLevel level) {
        if (level == LogLevel.ERROR) {
            log(message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(message, level);
        }
    }

    @Override
    protected void log(String message) {
        System.out.println("[ERROR] " + message);
    }
}

// === Iterator Pattern ===
// Logger Class
class Logger {
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void processCommands(String message, LogLevel level) {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            Command command = iterator.next();
            command.execute(message, level);
        }
    }
}

// === Client Class ===
public class LoggingSystem {
    public static void main(String[] args) {
        // Create Handlers
        LogHandler infoHandler = new InfoHandler();
        LogHandler debugHandler = new DebugHandler();
        LogHandler errorHandler = new ErrorHandler();

        // Chain Handlers
        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(errorHandler);

        // Create Logger and add commands
        Logger logger = new Logger();
        logger.addCommand(new LogCommand(infoHandler));

        // Log Messages with Different Severity Levels
        System.out.println("=== Logging System ===\n");

        logger.processCommands("System started successfully.", LogLevel.INFO);
        logger.processCommands("Debugging configuration issue.", LogLevel.DEBUG);
        logger.processCommands("Application crashed unexpectedly!", LogLevel.ERROR);
    }
}

