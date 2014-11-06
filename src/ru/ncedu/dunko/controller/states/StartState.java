package ru.ncedu.dunko.controller.states;

import org.apache.commons.cli.*;

import ru.ncedu.dunko.controller.*;
import ru.ncedu.dunko.view.*;

public class StartState implements State {
	
	private CommandLine cl;
    private ConsoleView consoleView;
    private Options options = new Options();
    HelpFormatter formatter = new HelpFormatter();
        
    public StartState(){
    	options.addOption("exit", false, "Exit app");
    	options.addOption("test", false, "Test of command line");
    	options.addOption("help", false, "List of commands");
    	options.addOption("state", false, "Current state");
    	options.addOption("start", false, "Proceed to shopping");
    }
    
    @Override
    public String toString() {
    	return "Start state";
    }
    
	@Override
	public void analyseCommand(Controller controller) {
		cl = controller.getCommandLine();
        consoleView = controller.getConsoleView();
        
		try {
            System.out.print("Awaiting your command: ");
            cl = controller.getParser()
            		.parse(options, consoleView.readSplitLine());
        } catch (ParseException e) {
            consoleView.println("Invalid command, please try again");
            consoleView.println("For the list of commands type '-help'");
            return;
        }
        
		if (cl.hasOption("exit")) {
			consoleView.println("Exiting application");
            System.exit(0);
        }
		
		if (cl.hasOption("test")) {
			consoleView.println("Everything seems to work...");
			return;
		}
		
		if (cl.hasOption("help")) {
			formatter.printHelp("Help", options);
			return;
		}
		
		if (cl.hasOption("state")) {
			consoleView.println(toString());
		}
		
		if (cl.hasOption("start")) {
			consoleView.println("Started shopping");
			controller.setState(new ClientRunState());
		}
	}
}