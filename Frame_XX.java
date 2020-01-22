import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; 
import java.io.File;
import java.lang.reflect.Method;

/**
 * Class to create Frame and add all the tabs in the frame
 * @author: Anonymous
*/
public class Frame_XX extends JFrame {
    
    //title of the Frame
    private static final String FRAME_TITLE = "NAME XX";

    //name of all the tab class names that needs to be added
    private static final String[] TAB_NAMES =  {"21", "27", "45"};

    //stores the tabIndex of the previously selected tab
    private int previousTabIndex = -1;

    
    Frame_XX() {
        
        //setup Frame UI
        this.setTitle(FRAME_TITLE);
        this.setMinimumSize(new Dimension(600, 500));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
      
        addTabs(tabbedPane);

        this.getContentPane().add(tabbedPane);
 
        //Display the Frame
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Adds all the tabs in the TAB_NAMES
     * @param tabPane is the panel containing tabs
     */
    private static void addTabs(JTabbedPane tabPane){

        for(int i=0; i<TAB_NAMES.length; i++){
            try{
                Class<?> tabClass = Class.forName("Tab_" + TAB_NAMES[i]);
                Method tabMethod = tabClass.getMethod("getName");
                Object newTab = tabClass.getDeclaredConstructor().newInstance();
                String tabName = tabMethod.invoke(newTab).toString();
                tabPane.addTab(tabName, (JPanel)newTab);
            } catch (Exception e){
                JPanel newTab = new JPanel();
                JPanel namePanel = new JPanel();
                namePanel.add(new JLabel("Class Missing " + TAB_NAMES[i]));
                newTab.add(namePanel);
                tabPane.addTab(TAB_NAMES[i], newTab);
            }
        }
    }
 
    // delete before submission //
    public static void main(String[] args) {

        new Frame_XX();
    }
}
