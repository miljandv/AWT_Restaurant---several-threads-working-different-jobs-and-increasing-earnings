package menu;

import java.awt.*;
import java.awt.event.*;

public class Restaurant extends Frame implements ActionListener {
	class we extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent arg0) {dispose();}
	}
	class ddd extends Dialog{
		class wed extends WindowAdapter{
			@Override
			public void windowClosing(WindowEvent e) {
			setVisible(false);}
		}
		Label l;
		public ddd(Restaurant r,Label label) {
			super(r, "Register", false);
			setBounds(610,210,160,100);l=label;
			add(l);
			addWindowListener(new wed());
			setVisible(false);
		}
	}
	private ddd dia;
	Button b[]=new Button[3];
	Label l[]=new Label[3];
	Res_menu menu1;
	Counter counter;
	Table[] table=new Table[3];
	List meniList =new List();
	Cook[] cooks=new Cook[2];
	List lnList=new List();
	List lpList=new List();
	Restaurant(){
		super("Restaurant");setBounds(500,100,400,300);
		Meal[] jjj=new Meal[3];addWindowListener(new we());
		jjj[0]=new Meal("Pizza",150, 1141);
		jjj[1]=new Meal("Burger",150, 1511);
		jjj[2]=new Meal("Spaghetti",100, 1311);
		counter=new Counter(lpList,lnList);
		menu1=new Res_menu(meniList,jjj);
		for (int i = 0; i < table.length; i++) {
			table[i]=new Table(menu1, counter);
		}
		Panel cnt=new Panel(new GridLayout(1,3));
		cnt.add(meniList);
		cnt.add(counter.getln());
		cnt.add(counter.getlp());
		Panel kv=new Panel(new GridLayout(2,1));
		Panel[] pkv=new Panel[2];
		pkv[0]=new Panel(new GridLayout(1,3));
		pkv[1]=new Panel(new GridLayout(1,3));
		cooks[0]=new Cook("Mark", counter, pkv[0]);
		cooks[1]=new Cook("Steven", counter, pkv[1]);
		kv.add(pkv[0]);
		kv.add(pkv[1]);
		dia=new ddd(this,counter.getLabel());
		b[0]=new Button("Start");
		b[1]=new Button("Stop");
		b[2]=new Button("Cash register");
		l[0]=new Label("Menu");
		l[1]=new Label("Bill");
		l[2]=new Label("Paid");
		Panel p2=new Panel(new GridLayout(1,3));
		Panel p1=new Panel(new GridLayout(1,3));
		for (int i = 0; i < l.length; i++) {
			l[i].setAlignment(Label.CENTER);
			p2.add(l[i]);
		}
		p1.add(b[0]);b[0].addActionListener(this);
		p1.add(b[1]);b[1].addActionListener(this);
		p1.add(b[2]);b[2].addActionListener(this);
		Panel main=new Panel(new BorderLayout());
		Panel main2=new Panel(new BorderLayout());
		main.add(p2,BorderLayout.NORTH);
		main2.add(cnt,BorderLayout.CENTER);
		main2.add(kv,BorderLayout.SOUTH);
		main.add(p1,BorderLayout.SOUTH);
		main.add(main2,BorderLayout.CENTER);
		add(main);
		setVisible(true);
	}
	public static void main(String[] args) {
		Restaurant r=new Restaurant();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Start")) {for (int i = 0; i < table.length; i++) {
			table[i].w_start();
		}
		for (int i = 0; i < cooks.length; i++) {
			cooks[i].w_start();
		}
		}
		else if(arg0.getActionCommand().equals("Stop")) {for (int i = 0; i < table.length; i++) {
			table[i].w_stop();
		}
		for (int i = 0; i < cooks.length; i++) {
			cooks[i].w_stop();
		}}
		else if(arg0.getActionCommand().equals("Cash register")){dia.setVisible(true);dia.l.setText(""+counter.getearnings());}
	}
}
