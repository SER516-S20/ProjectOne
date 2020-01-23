import javax.swing.*;
import java.awt.*;


public class Tab_21 extends JPanel implements TabInterface {

  //The gitIds of the students involved
  private String[] panelNumbers = {
      "13", "14", "15", "16",
      "17", "18", "19", "20",
      "22", "23", "24", "25"
  };

  private JPanel[] panels = new JPanel[12];

  public Tab_21() {

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
    return "Amudhan";
  }

}
