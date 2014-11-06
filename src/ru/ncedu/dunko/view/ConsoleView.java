package ru.ncedu.dunko.view;

import java.io.*;
import java.util.*;

import ru.ncedu.dunko.model.POJO.Product;

public class ConsoleView {
	private PrintStream ps;
    private Scanner sc;
    
    public ConsoleView(InputStream in, PrintStream ps) {
    	this.ps = ps;
    	this.sc = new Scanner(in);
    	ps.println("Welcome to MyOnlineShop!");
    	ps.println("Don't know what to do next?"
    			+ " Type '-help' to get a list of commands!");
    }
    
    public String[] readSplitLine() {
    	String s = sc.nextLine();
        String[] split = s.split("\\s+");
        return split;
    }
    
    public String readLine() {
    	return sc.nextLine();
    }
    
    public void println(String s) {
        ps.println(s);
    }

    public void println() {
        ps.println();
    }

    public void printf(String format, String s) {
        ps.printf(format, s);
    }

    public void printf(String format, long s) {
        ps.printf(format, s);
    }

    public void print(String s) {
        ps.print(s);
    }

	public void printProduct(Product product) {
		println("id:"+product.getProduct_id());
		println("name:"+product.getProduct_name());
		println("price:"+product.getPrice());
		println("category id:"+product.getCategory_id());
	}
}
