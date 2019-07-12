import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(String title) {
        super(title);

        String t = "TestSet";
        Cards cards = new Cards(t);

        // Set layout manager
        // setLayout(new BorderLayout());
        setLayout(new GridBagLayout());

        // Create Swing components
        JButton button = new JButton("Get Question");
        JButton button2 = new JButton("Add Fact");
        JButton button1 = new JButton("View Answer");

        JLabel questionTextDesc = new JLabel("Question");
        JLabel questionTextChange = new JLabel("QuestionArea");
        JLabel answerTextDesc = new JLabel("Answer");
        JLabel answerTextChange = new JLabel("AnswerArea");


        JLabel newQuestion = new JLabel("New Question:    ");
        JTextField in1 = new JTextField(100); // must remember to set the size of these
        JLabel newAnswer = new JLabel("New Answer:    ");
        JTextField in2 = new JTextField(100);

        // test stuff
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;

        // buttons
        gc.anchor = GridBagConstraints.CENTER;
        add(button, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(button1, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(button2, gc);

        // question areas and text
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        add(questionTextDesc, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(questionTextChange, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 2;
        add(newQuestion, gc);
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridx = 1;
        gc.gridy = 2;
        add(in1, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(answerTextDesc, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(answerTextChange, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 4;
        add(newAnswer, gc);
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridx = 1;
        gc.gridy = 4;
        add(in2, gc);




/**
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
 **/
        questionTextDesc.setFont(new Font("Question", Font.BOLD, 40));
        questionTextChange.setFont(new Font("Question", Font.PLAIN, 40));
        questionTextDesc.setText("Question:");
        questionTextChange.setText("This is where the question will be.");

        answerTextDesc.setFont(new Font("Answer", Font.BOLD, 40));
        answerTextChange.setFont(new Font("Answer", Font.PLAIN, 40));
        answerTextDesc.setText("Answer:");
        answerTextChange.setText("This is where the answer will be.");

        newQuestion.setFont(new Font("New Question", Font.BOLD, 20));
        newAnswer.setFont(new Font("New Answer", Font.BOLD, 20));



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
