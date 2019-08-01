package menu;

import javax.net.ssl.SNIHostName;

public class Order {
	private int num;
	private Meal[] meals;
	public int getNum() {
		return num;
	}
	public Meal[] getMeals() {
		return meals;
	}
	public Order(int n,Meal[] j) {
		meals=j;num=n;
	}
	public synchronized int getprice() {
		int j=0;
		for (int i = 0; i < meals.length; i++) {
			j+=meals[i].getPrice();
		}
		return j;
	}
	@Override
	public synchronized String toString() {
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append(num+":");
		for (int i = 0; i < meals.length; i++) {
			sBuffer.append(meals[i].getMark());
		}
		sBuffer.append(":"+getprice());
		return sBuffer.toString();
	}
}
