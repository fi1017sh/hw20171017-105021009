import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=300,frmH=150,screenW,screenH;
    private Container cp;
    private JLabel jlid = new JLabel("ID:");
    private JLabel jlpw = new JLabel("Password:");
    private JTextField jtfid = new JTextField();
    private JPasswordField jtfpw = new JPasswordField();
    private JButton jbe = new JButton("Exit");
    private JButton jbl = new JButton("Login");

    public LoginFrame(){
        initComp();
    }

    private void initComp(){
        screenW = d.width;
        screenH = d.height;
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));

        jlid.setHorizontalAlignment(JLabel.RIGHT);
        jlpw.setHorizontalAlignment(JLabel.RIGHT);

        jbe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//記得改帳號(h304)密碼(23323456)
            if(jtfid.getText().equals("a")&&new String(jtfpw.getPassword()).equals("a")){
                MainFrame mf = new MainFrame(LoginFrame.this);
                mf.setVisible(true);
                LoginFrame.this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(LoginFrame.this,"Error!");
            }
            }
        });

        cp.add(jlid);
        cp.add(jtfid);
        cp.add(jlpw);
        cp.add(jtfpw);
        cp.add(jbe);
        cp.add(jbl);
    }
}
