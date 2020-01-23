import java.awt.*;
import javax.swing.*;
import java.lang.reflect.Method;

public class Frame_36 extends JFrame {

  private static final String FRAME_TITLE = "Sayali Tanawade";
  private static final String[] TAB_NAMES = {"0", "27", "45"}; // IDs of your classmates doing Tabs

  Frame_36() {
    this.setTitle(FRAME_TITLE);
    this.setMinimumSize(new Dimension(800, 600));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTabbedPane tabbedPane = new JTabbedPane();
    addTabs(tabbedPane);
    this.getContentPane().add(tabbedPane);

    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  private static void addTabs(JTabbedPane tabPane) {

    for (int i = 0; i < TAB_NAMES.length; i++) {
      try {
        Class<?> tabClass = Class.forName("Tab_" + TAB_NAMES[i]);
        Method tabMethod = tabClass.getMethod("getName");
        Object newTab = tabClass.getDeclaredConstructor().newInstance();
        String tabName = tabMethod.invoke(newTab).toString();
        tabPane.addTab(tabName, (JPanel) newTab);
      } catch (Exception e) {
        JPanel newTab = new JPanel();
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Class Missing " + TAB_NAMES[i]));
        newTab.add(namePanel);
        tabPane.addTab(TAB_NAMES[i], newTab);
      }
    }
  }

  public static void main(String[] args) {
    new Frame_36();
  }
}
