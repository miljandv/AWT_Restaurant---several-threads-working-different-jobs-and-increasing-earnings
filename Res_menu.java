package menu;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Res_menu {
	List list;
	Meal[] meals;
	public int get_num() {return meals.length;}
	public Res_menu(List l,Meal[] j) {list=l;meals=j;
	for (int i = 0; i < j.length; i++) {
		list.add(meals[i].toString());
	}
	}
	public synchronized Meal getmealbyindex(int i) {try {
		if(i<0 || i>meals.length)throw new IndexOutOfBoundsException();
		else return meals[i];
	}catch (IndexOutOfBoundsException e) {System.err.println("Index out of bounds");}
	return null;
	}
}
