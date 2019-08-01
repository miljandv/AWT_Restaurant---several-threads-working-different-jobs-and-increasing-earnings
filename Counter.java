package menu;

import java.awt.Label;
import java.awt.List;
import java.awt.PopupMenu;
import java.util.LinkedList;

public class Counter {
	private int totalmoney;
	private Label earningslabel=new Label();
	private LinkedList<Order> notyetpaidLinkedList=new LinkedList<>();
	private LinkedList<Order> paidLinkedList=new LinkedList<>();
	private List lp,ln;
	public Counter(List lnn,List lll){lp=lnn;ln=lll;earningslabel.setAlignment(Label.CENTER);}
	public synchronized int getearnings() {return totalmoney;}
	public synchronized void add(Order p) {notyetpaidLinkedList.add(p);ln.add(p.toString());notify();}
	public synchronized Order getOrder() throws InterruptedException {while(notyetpaidLinkedList.isEmpty())wait();
	Order p=notyetpaidLinkedList.getLast();
	ln.remove(p.toString());
	return p;
	}
	public synchronized void pay(Order pp) {
ll:		for (int k = 0; k < notyetpaidLinkedList.size(); k++) {
			if (notyetpaidLinkedList.get(k).toString().equals(pp.toString())) {
				totalmoney+=notyetpaidLinkedList.get(k).getprice();earningslabel.setText(""+totalmoney);break ll;
			}
		}
		ln.remove(pp.toString());	
		lp.add(pp.toString());
		}
	public synchronized List getln() {return ln;}
	public synchronized List getlp() {return lp;}
	public Label getLabel() {return earningslabel;}
}
