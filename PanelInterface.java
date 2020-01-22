import javax.swing.*;
import java.awt.*;

public abstract class PanelInterface extends JPanel {

    private JLabel label;
    private String myName;

    public PanelInterface(String name) {

        label = new JLabel(name);
        label.setFont(new Font("TimesRoman", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.decode("#800000"));// Maroon
        this.setBackground(Color.decode("#FFD700"));// Gold
        this.setLayout(new BorderLayout());
        this.add(label);
    }

}
