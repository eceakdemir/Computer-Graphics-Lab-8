
// ZEhra Ece AKdemir

package lab8;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.*; 

public class Rotations extends Frame implements ActionListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	static final int windowWidth = 800;
	static final int windowHeight = 800;
	int[] x = {500,700,700,500};
	int[] y = {300,300,200,200};
	
	Rotations()
	{
		MenuBar menu_bar = new MenuBar();
			
		Menu def = new Menu("File");
		def.add(new MenuItem("Set Default"));
		def.addActionListener(this);
		menu_bar.add(def);
		setMenuBar(menu_bar);
		
		Panel panel=new Panel();  
		panel.setBounds(0,60,windowWidth,30);  
		
		Button button_u = new Button();
		button_u.setLabel("Left Bottom - Clockwise");
		button_u.addActionListener(this);
		Button button_d = new Button();
		button_d.setLabel("Origin - Clockwise");
		button_d.addActionListener(this);
		Button button_r = new Button();
		button_r.setLabel("Origin - C.Clockwise");
		button_r.addActionListener(this);
	
		panel.add(button_d);
		panel.add(button_r);
		panel.add(button_u);
		panel.setBackground(Color.black); 
		add(panel);
		setLayout(null);
		addWindowListener(new MyFinishWindow());
		addMouseListener(this);
		Color turquoise = new Color(48, 214, 200);
		setBackground(turquoise);	
	}
	
	public class MyFinishWindow extends WindowAdapter
	   {
	     public void windowClosing(WindowEvent e)
	     { System.exit(0);	     }
	   }
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(0, 400, 800, 400);
		g2d.drawLine(400, 0, 400, 800);
		g2d.setColor(Color.black);
		drawQuadrangle(g2d, x, y);

	}
	
	public void drawTriangle(Graphics2D g2d, int[] x, int[] y) {
		g2d.drawPolygon(x, y, 3);
		g2d.setColor(Color.gray);
		g2d.fillPolygon(x, y, 3);
	}
	
	public void drawQuadrangle(Graphics2D g2d, int[] x, int[] y) {
		g2d.drawPolygon(x, y, 4);
		g2d.setColor(Color.gray);
		g2d.fillPolygon(x, y, 4);
	}
	
	public static void main(String[] argv)
	{
		Rotations f = new Rotations();
		f.setTitle("Rotations");
		
		f.setSize(windowWidth, windowHeight);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String str = arg0.getActionCommand();
		int temp;
		if(str.equals("Set Default")) {
			int[] a = {500,700,700,500};
			int[] b = {300,300,200,200};
			x = a;
			y = b;
		}
		else if(str.equals("Left Bottom - Clockwise")) {
			x[3]=x[0];
			y[3]=y[0];
			y[0]+=200;
			x[1]-=100;
			y[1]+=200;
			x[2]-=100;
			y[2]+=100;
		}
		else if(str.equals("Origin - Clockwise")) {
			for(int i=0; i<4; i++){
				temp = y[i];
				y[i] = x[i];
				x[i] = temp + 2*(400 - temp);
			}
		}
		else if(str.equals("Origin - C.Clockwise")) {
			for(int i=0; i<4; i++){
				temp = x[i];
				x[i] = y[i];
				y[i] = temp + 2*(400 - temp);
			}
		}

		repaint();
	}
	public void mouseClicked(MouseEvent arg0) {
		//x = arg0.getX();
		//y = arg0.getY();

		repaint();
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}