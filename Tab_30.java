import javax.swing.*;
import java.awt.*;


public class Tab_30 extends JPanel implements TabInterface{
	
	private String[] panelNumbers = {
		      "26", "27", "29", "31",
		      "32", "33", "34", "35",
		      "37", "38", "39",
		  };
	
	private JPanel[] panels = new JPanel[15];
	
	public Tab_30() {

	    setLayout(new GridLayout(3, 4));
	    for (int i = 0; i < panelNumbers.length; i++) {
	      try {
	        Class<?> panelClass = Class.forName("Panel_" + panelNumbers[i]);
	        JPanel panel = (JPanel) panelClass.getDeclaredConstructor().newInstance();
	        panels[i] = panel;
	        add(panel);
	      } catch (Exception e) {
	        addError(panelNumbers[i]);
	      }
	    }
	  }

	private void addError(String panelNumber) {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Panel " + panelNumber + " Error");
    panel.add(label);
    add(panel);
  }
	
	@Override
	public String getName() {
		return "Somesh";
	 }
}
