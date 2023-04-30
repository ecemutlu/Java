import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    static JTextArea textArea = new JTextArea("");
    static ArrayList<Integer> primeNumbers = new ArrayList<>();
    static int lastPrime = 1;

    private static int getNextPrime() {
        int i = lastPrime + 1;
        if (i == 2)
            return i;
        while (true) {
            boolean prime = true;
            for (int j = 0; j < primeNumbers.size(); j++) {
                if (i % primeNumbers.get(j) == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
                break;
            else
                i++;
        }
        return i;
    }

    private static void addComponentsToPane(Container pane) {
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout());
        JButton btnGenerate = new JButton("Generate next prime!");
        btnGenerate.setPreferredSize(new Dimension(200, 30));
        panelTop.add(btnGenerate);

        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lastPrime = getNextPrime();
                    primeNumbers.add(lastPrime);
                    if (primeNumbers.size() > 20)
                        throw new BigPrimeException();
                    textArea.append(lastPrime + "\n");
                } catch (BigPrimeException ex) {
                    JOptionPane.showMessageDialog(pane, ex.getMessage());
                }
            }
        });

        pane.add(panelTop, BorderLayout.PAGE_START);
        pane.add(textArea, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Question 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setSize(new Dimension(300, 300));
        frame.setVisible(true);
    }
}
