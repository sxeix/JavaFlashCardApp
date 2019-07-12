import javax.swing.*;
import java.awt.Color;

public class Main {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new MainFrame("James' Flash Card Application");
                frame.setSize(1366,768); // 1366x768
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setBackground(Color.lightGray);
                frame.setVisible(true);
            }
        });


    }
}
