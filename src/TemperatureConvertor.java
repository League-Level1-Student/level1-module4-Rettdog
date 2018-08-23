import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureConvertor implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button;
	JTextField text1;
	JTextField text2;
	public static void main(String[] args) {
		TemperatureConvertor temp = new TemperatureConvertor();
		temp.start();
	}
	public void start() {
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton();
		text1 = new JTextField(10);
		text2 = new JTextField(10);
		//text1.setText("°F");
		button.setText("Fahrenheit - Convert - Celsius");
		//text2.setText("°C");
		panel.add(text1);
		panel.add(button);
		panel.add(text2);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		text1.addActionListener(this);
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(text1)) {
			text1.setText("");		
		}else if(e.getSource().equals(button)) {
			//System.out.println(text1.getText());
			int f =Integer.parseInt(text1.getText());
			//System.out.println(f);
			text2.setText(convert(f)+"");
		}
		
	}
	public static double convert(int fahrenheit) {
		//System.out.println(fahrenheit);
		int minus = fahrenheit-32;
		//System.out.println(minus);
		double fraction = 0.55;
		//System.out.println(fraction);
		return fraction*minus;
	}
}
