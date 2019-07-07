import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String title) {
        super(title);
        // Set layout manager
        setLayout(new BorderLayout());

        // Create Swing components
        JButton button = new JButton("Get Question");
        JLabel questionTextDesc = new JLabel("Question");
        JLabel questionTextChange = new JLabel("QuestionArea");
        JLabel answerTextDesc = new JLabel("Answer");
        JLabel answerTextChange = new JLabel("AnswerArea");

        // Add Swing Components to content pane
        Container c = getContentPane();
        JPanel qArea = new JPanel(new BorderLayout()); // Question Section
        JPanel aArea = new JPanel(new BorderLayout()); // Answer Section
        JPanel bArea = new JPanel(new BorderLayout()); // Button Section

        bArea.add(button, BorderLayout.SOUTH);
        qArea.add(questionTextDesc, BorderLayout.LINE_START);
        qArea.add(questionTextChange, BorderLayout.AFTER_LINE_ENDS);
        aArea.add(answerTextDesc, BorderLayout.LINE_START);
        aArea.add(answerTextChange, BorderLayout.AFTER_LINE_ENDS);
        c.add(qArea, BorderLayout.NORTH);
        c.add(aArea, BorderLayout.CENTER);
        c.add(bArea, BorderLayout.PAGE_END);

        questionTextDesc.setFont(new Font("Question", Font.BOLD, 40));
        questionTextChange.setFont(new Font("Question", Font.PLAIN, 40));
        questionTextDesc.setText("Question:");
        questionTextChange.setText("This is where the question will be?");

        answerTextDesc.setFont(new Font("Answer", Font.BOLD, 40));
        answerTextChange.setFont(new Font("Answer", Font.PLAIN, 40));
        answerTextDesc.setText("Answer:");
        answerTextChange.setText("This is where the answer will be?");
    }
}
