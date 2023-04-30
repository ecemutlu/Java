import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Main {

    static DefaultListModel<String> model1 = new DefaultListModel<>();
    static JList<String> list1 = new JList<>(model1);
    static DefaultListModel<String> model2 = new DefaultListModel<>();
    static JList<String> list2 = new JList<>(model2);

    private static void processSelectedFile(String fileName){
        char[] charArray = fileName.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])){
                model1.addElement(fileName);
                break;
            }
        }
        String lcFileName = fileName.toLowerCase(Locale.ROOT);
        if (lcFileName.endsWith(".txt")
                || lcFileName.endsWith(".doc")
                || lcFileName.endsWith(".docx")
                || lcFileName.endsWith(".pdf"))
            model2.addElement(fileName);
    }

    private static void addComponentsToPane(Container pane) {
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout());
        JButton btnChooseFile = new JButton("Choose File");
        btnChooseFile.setPreferredSize(new Dimension(150, 30));
        panelTop.add(btnChooseFile);

        btnChooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(pane);
                if (result== JFileChooser.APPROVE_OPTION)
                    processSelectedFile(fileChooser.getSelectedFile().getName());
            }
        });

        JPanel panelList1 = new JPanel();
        panelList1.setLayout(new BoxLayout(panelList1, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Files that contain number in name");
        panelList1.add(label);
        list1.setVisibleRowCount(10);
        panelList1.add(new JScrollPane(list1));

        JPanel panelList2 = new JPanel();
        panelList2.setLayout(new BoxLayout(panelList2, BoxLayout.Y_AXIS));
        label = new JLabel("Files that are documents");
        panelList2.add(label);
        list2.setVisibleRowCount(10);
        panelList2.add(new JScrollPane(list2));

        pane.add(panelTop, BorderLayout.PAGE_START);
        pane.add(panelList1, BorderLayout.LINE_START);
        pane.add(panelList2, BorderLayout.LINE_END);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Question 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
}
