package ru.ncedu.dunko;

import ru.ncedu.dunko.controller.*;

public class MainOS {

	public static void main(String[] args) {
		Controller controller = new Controller();
		while (true) {
			controller.parseCommand();
		}		
	}
}
