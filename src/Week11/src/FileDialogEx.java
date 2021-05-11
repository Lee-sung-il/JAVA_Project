package Week11.src;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileDialogEx extends JFrame implements ActionListener {
    private JMenuBar mb = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem openItem = new JMenuItem("Open");
    private JMenuItem saveItem = new JMenuItem("Save");

    //private JLabel imgLabel = new JLabel();
    private JTextArea ta = new JTextArea();
    private JFileChooser fc = new JFileChooser();

    FileDialogEx() {
        this.setTitle("Menu 와 JFileChooser 활용예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(350, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        this.setJMenuBar(mb);
        mb.add(fileMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);

//        this.add(imgLabel);
        this.add(ta);
    }

    public void eventHandler() {
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
    }

    public static void main(String[] args) {
        new FileDialogEx();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images",
//                    "jpg", "gif");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt", "txt");
            fc.setFileFilter(filter);
            int ret = fc.showOpenDialog(null); //파일 다이얼로그 출력
            if (ret != JFileChooser.APPROVE_OPTION) { // 사용자가 창을 강제로 닫았거나 취소 버튼을 누른경우
                JOptionPane.showMessageDialog(null, "파일을 선택하지 않습니다", "경고",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
            String filePath = fc.getSelectedFile().getPath(); // 파일 경로명 리턴
            //imgLabel.setIcon(new ImageIcon(filePath)); //이미지 출력
            try {
                BufferedReader rd = new BufferedReader(new FileReader(filePath));
                ta.setText("");
                String line;
                while ((line = rd.readLine()) != null) {
                    ta.append(line + "\n");
                }
                rd.close();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "열기오류");
            }
            //  pack(); // 이미지의 크기에 맞추어 프레임 크기 조절
        } else if (e.getSource() == saveItem) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt",
                    "txt");
            fc.setFileFilter(filter);
            fc.setCurrentDirectory(new File(".\\"));
            int ret = fc.showSaveDialog(null);
            if (ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "파일을 선택하지 않습니다.", "경고",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            String filePath = fc.getSelectedFile().getPath();

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
                bw.write(ta.getText());
                bw.close();
            }catch (Exception e2) {
                JOptionPane.showMessageDialog(this,"저장 오류");
            }

        }
    }
}
