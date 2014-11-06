package ru.ncedu.dunko.controller;

import org.apache.commons.cli.*;

import ru.ncedu.dunko.controller.states.*;
import ru.ncedu.dunko.model.helper.*;
import ru.ncedu.dunko.view.*;

public class Controller {
	private State state = new StartState();
	
	private ConsoleView consoleView = new ConsoleView(System.in,System.out);
    private CommandLineParser parser = new BasicParser();
    private CommandLine cl;
    private UserHelper userHelper = new UserHelper(this.consoleView);
    
	public void parseCommand() {
		state.analyseCommand(this);
	}

	public CommandLine getCommandLine() {
		return this.cl;
	}

	public ConsoleView getConsoleView() {
		return this.consoleView;
	}
	
	public CommandLineParser getParser() {
		return this.parser;
	}
	
	public UserHelper getUserHelper() {
		return this.userHelper;
	}
	
	public void setState(State state) {
		this.state = state;
	}
}
