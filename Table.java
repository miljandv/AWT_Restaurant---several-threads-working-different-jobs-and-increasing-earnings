package menu;

public class Table extends Thread {
	private static int ID_;
	private int ID=ID_++;
	private Res_menu menu1;
	private Counter pult;
	private int working;
	public Table(Res_menu m, Counter p) {menu1=m;pult=p;start();}
	public void run() {try {
		while(!interrupted()) {
		synchronized (this) {if(working==0)wait();}	
		int k=(int) (Math.random()*4);k=k==0?1:k;
		Meal j[]=new Meal[k];
			for (int i = 0; i < k; i++) {				
				j[i]=menu1.getmealbyindex((int)(Math.random()*menu1.get_num()));
			}
				pult.add(new Order(ID, j));	
			sleep((long) (Math.random()*3+4));
		}
	}catch (InterruptedException e) {}
	}
	public synchronized void w_start() {working=1;notify();}
	public synchronized void w_stop() {working=0;}
	public synchronized void w_finish() {interrupt();}
}
