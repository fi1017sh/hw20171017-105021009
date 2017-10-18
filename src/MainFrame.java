import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private int fmW=500,fmH=600,screenW,screenH;
    private Container cp;
    private JPanel jpc = new JPanel(new GridLayout(3,3));
    private JPanel jps = new JPanel(new GridLayout(1,3));
    private JTextField jtf = new JTextField();
    private JButton jbs[]=new JButton[9];
    private JButton jb0 = new JButton("0");
    private JButton jbd = new JButton(".");
    private JButton jbc = new JButton("C");

    private LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame = login;
        initComp();
    }
    private void initComp(){
        screenW = d.width;
        screenH = d.height;
        this.setBounds(screenW/2-fmW/2,screenH/2-fmH/2,fmW,fmH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
        jps.add(jb0);
        jps.add(jbd);
        jps.add(jbc);
        jtf.setText(jb0.getText());
        jtf.setText(jbd.getText());
        jtf.setText(jbc.getText());
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jtf,BorderLayout.NORTH);
        for(int i=0;i<=9;i++){
            jbs[i]=new JButton(Integer.toString(i));
            jpc.add(jbs[i]);
            jbs[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmp = (JButton)e.getSource();
                    jtf.setText(jtf.getText()+tmp.getText());
                }
            });
        }
        cp.add(jps,BorderLayout.SOUTH);

    }
}
