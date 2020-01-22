import javax.swing.*;
import java.awt.*;


public class Tab_0 extends JPanel implements TabInterface {

  //The gitIds of the students involved
  private String[] panelNumbers = {
      "0", "60", "71", "38",
      "54", "74", "09", "76",
      "33", "07", "03", "68",
  };

  private JPanel[] panels = new JPanel[15];

  public Tab_0() {

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
    return "Javier";
  }

}
