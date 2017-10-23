import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame{
    private JPanel jpl = new JPanel(new GridLayout(3,3));
    private Container cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int fmW=500,fmH=600,screenW,screenH;
    private JButton jbtns[] = new JButton[10];
    private JButton jbd = new JButton(".");
    private JButton jbc = new JButton("c");
    private JTextField jtf = new JTextField();
    Random ran = new Random();

    private LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame = login;
        initComp();
    }

    private void initComp(){
        screenW = dim.width;
        screenH = dim.height;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
        this.setBounds(screenW/2-fmW/2,screenH/2-fmH/2,fmW,fmH);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jtf,BorderLayout.NORTH);
        cp.add(jpl,BorderLayout.CENTER);
        jtf.setEditable(false);
        for(int i=0;i<10;i++){
            jbtns[i]=new JButton(Integer.toString(ran.nextInt(10)));
            jpl.add(jbtns[i]);
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton = (JButton)e.getSource();
                    jtf.setText(jtf.getText()+tmpButton.getText());
                }
            });
        }
        jpl.add(jbd);
        jpl.add(jbc);
        jbd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmpButton = (JButton)e.getSource();
                jtf.setText(jtf.getText()+tmpButton.getText());
            }
        });
        jbc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
            }
        });
    }
}
