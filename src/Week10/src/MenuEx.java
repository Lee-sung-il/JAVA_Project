package Week10.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEx extends JFrame implements ActionListener {
    private JMenuBar mb = new JMenuBar();
    private JMenu screenMenu = new JMenu("Screen");
    private JMenuItem[] menuItems = new JMenuItem[4];
    private String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};
    private JLabel imgLabel = new JLabel();

    MenuEx() {
        this.setTitle("Menu 만들기 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(250, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i] = new JMenuItem(itemTitle[i]);
            screenMenu.add(menuItems[i]);
        }
        mb.add(screenMenu);
        mb.add(new JMenu("Source"));
        mb.add(new JMenu("Project"));
        mb.add(new JMenu("Run"));
        this.setJMenuBar(mb);
        this.add(imgLabel);
    }

    public void eventHandler() {
        //메뉴아이템
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].addActionListener(this);
        }
    }

    public static void main(String[] args) {
        new MenuEx();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Load") {
            if (imgLabel.getIcon() != null) {
                return;
            }
            imgLabel.setIcon(new ImageIcon("images/img.jpg"));
        } else if (e.getActionCommand() == "Hide") {
            imgLabel.setVisible(false);

        } else if (e.getActionCommand() == "ReShow") {
            imgLabel.setVisible(true);

        } else if (e.getActionCommand() == "Exit") {
            System.exit(0);

        }
    }
}
