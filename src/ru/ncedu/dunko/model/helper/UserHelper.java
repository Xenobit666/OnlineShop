package ru.ncedu.dunko.model.helper;

import ru.ncedu.dunko.model.DAO.*;
import ru.ncedu.dunko.model.POJO.*;
import ru.ncedu.dunko.view.*;

public class UserHelper {
	
	private ConsoleView consoleView = null;
	private ProductDAO productDAO = new ProductDAO();
	private Product product = null;
	
	public UserHelper(ConsoleView consoleView) {
		this.consoleView = consoleView;
	}
	
	public void getProductByID(int id) {
		product = productDAO.getProductByID(id);
		consoleView.printProduct(product);
	}


}
