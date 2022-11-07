package net.wenzuo.mybatisplusgenerator;

import de.codeshelf.consoleui.prompt.ConsolePrompt;
import org.fusesource.jansi.AnsiConsole;

/**
 * @author Catch
 * @since 2022-11-07
 */
public class Main {

    public static final ConsolePrompt PROMPT = new ConsolePrompt();

    public static void main(String[] args) throws InterruptedException {
        AnsiConsole.systemInstall();
        Config.loadConfig();

    }

}
