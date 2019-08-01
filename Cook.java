package menu;

import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class Cook extends Thread {
	private String name;
	private Counter counter;
	private Panel p;
	private int percent;
	private Order order;
	private Label[] labels=new Label[2];
	private TextField tf=new TextField(5);
	public Cook(String name_,Counter counter_,Panel panel_) {
		name=name_;counter=counter_;p=panel_;
		labels[0]=new Label(toString());
		labels[1]=new Label(percent+"% ");
		p.add(labels[0]);
		p.add(tf);
		p.add(labels[1]);
		start();
	}
	private int working;
	public void run() {try {
		while(!interrupted()) {
			synchronized (this) {if(working==0)wait();}
			order=counter.getOrder();
			percent=0;tf.setText(order.toString());
			int chunk=100/order.getMeals().length;
			for (int i = 0; i < order.getMeals().length; i++) {
				sleep(order.getMeals()[i].getTime());
				percent+=chunk;percent=percent==99?100:percent;
				labels[1].setText(percent+"%");
			}
			counter.pay(order);
		}
	}catch (InterruptedException e) {}
	}
	public String toString() {return "Cook_"+name;
	}
	public synchronized void w_start() {working=1;notify();}
	public synchronized void w_stop() {working=0;}
	public synchronized void w_finish() {interrupt();}
}






