package ru.ncedu.dunko.model.POJO;

public class Category {
	int category_id;
	String category_name;
	int main_category_id;
	
	public Category() {}
	
	public Category(int category_id, String category_name) {
		this.category_id = category_id;
		this.category_name = category_name;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getMain_category_id() {
		return main_category_id;
	}
	public void setMain_category_id(int main_category_id) {
		this.main_category_id = main_category_id;
	}
}
