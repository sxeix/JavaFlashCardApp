import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new MainFrame("James' Flash Card Application");
                frame.setSize(852,480);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });


    }
}
