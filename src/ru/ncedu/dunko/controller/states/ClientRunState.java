package ru.ncedu.dunko.controller.states;

import org.apache.commons.cli.*;

import ru.ncedu.dunko.controller.*;
import ru.ncedu.dunko.model.helper.*;
import ru.ncedu.dunko.view.ConsoleView;

public class ClientRunState implements State {
	
	private CommandLine cl;
    private ConsoleView consoleView;
    private UserHelper userHelper;
    private Options options = new Options();
    HelpFormatter formatter = new HelpFormatter();
    
    public ClientRunState(){
    	options.addOption("exit", false, "Exit app");
    	options.addOption("help", false, "List of commands");
    	options.addOption("state", false, "Current state");
    	options.addOption("get", true, "Get smth by id");
    }
    
    @Override
    public String toString() {
    	return "Client working state";
    }
    
	@Override
	public void analyseCommand(Controller controller) {
		cl = controller.getCommandLine();
        consoleView = controller.getConsoleView();
        userHelper = controller.getUserHelper();
        
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
		
		if (cl.hasOption("help")) {
			formatter.printHelp("Help", options);
			return;
		}
		
		if (cl.hasOption("state")) {
			consoleView.println(toString());
		}
		
		if (cl.hasOption("get")) {
			if (cl.getOptionValue("get").equalsIgnoreCase("product")) {
				consoleView.println("Please specify product id:");
				int id = Integer.parseInt(consoleView.readLine());
				userHelper.getProductByID(id);
                return;
			} else {
				consoleView.println("Please try again");
				return;
			}
		}
	}
}
