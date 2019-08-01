package menu;
public class Meal {
	private String name;
	private int price;
	private int time;
	private char mark;
	public Meal(String name_,int price_,int time_) {
		name=name_;price=price_;time=time_;mark=name.charAt(0);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getTime() {
		return time;
	}

	public char getMark() {
		return mark;
	}

	@Override
	public String toString() {return name+":"+price;
	}
}
