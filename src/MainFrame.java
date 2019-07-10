import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    public MainFrame(String title) {
        super(title);

        String t = "TestSet";
        Cards cards = new Cards(t);

        // Set layout manager
        setLayout(new BorderLayout());

        // Create Swing components
        JButton button = new JButton("Get Question");
        JButton button2 = new JButton("Add Fact (Restart to reload)");
        JButton button1 = new JButton("View Answer");

        JLabel questionTextDesc = new JLabel("Question");
        JLabel questionTextChange = new JLabel("QuestionArea");
        JLabel answerTextDesc = new JLabel("Answer");
        JLabel answerTextChange = new JLabel("AnswerArea");

        JTextField in1 = new JTextField("");
        JTextField in2 = new JTextField("");

        // Add Swing Components to content pane
        Container c = getContentPane();
        JPanel qArea = new JPanel(new BorderLayout()); // Question Section
        JPanel aArea = new JPanel(new BorderLayout()); // Answer Section
        JPanel bArea = new JPanel(new BorderLayout()); // Button Section

        bArea.add(button, BorderLayout.LINE_START);
        bArea.add(button1, BorderLayout.LINE_END);
        bArea.add(button2, BorderLayout.CENTER);

        qArea.add(in1,BorderLayout.AFTER_LAST_LINE);
        qArea.add(questionTextDesc, BorderLayout.LINE_START);
        qArea.add(questionTextChange, BorderLayout.AFTER_LINE_ENDS);

        aArea.add(answerTextDesc, BorderLayout.LINE_START);
        aArea.add(answerTextChange, BorderLayout.AFTER_LINE_ENDS);
        aArea.add(in2, BorderLayout.AFTER_LAST_LINE);

        c.add(qArea, BorderLayout.NORTH);
        c.add(aArea, BorderLayout.CENTER);
        c.add(bArea, BorderLayout.SOUTH);

        questionTextDesc.setFont(new Font("Question", Font.BOLD, 40));
        questionTextChange.setFont(new Font("Question", Font.PLAIN, 40));
        questionTextDesc.setText("Question:");
        questionTextChange.setText("This is where the question will be.");

        answerTextDesc.setFont(new Font("Answer", Font.BOLD, 40));
        answerTextChange.setFont(new Font("Answer", Font.PLAIN, 40));
        answerTextDesc.setText("Answer:");
        answerTextChange.setText("This is where the answer will be.");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fact f;
                f = cards.getFact();
                questionTextChange.setText(f.getQuestion());
                answerTextChange.setText(f.getAnswer());
                answerTextChange.setVisible(false);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextChange.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = in1.getText();
                String a = in2.getText();
                cards.addFact(q, a);
            }
        });

    }
}
