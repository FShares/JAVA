import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
   姓名	JTextField		密码	JPasswordField
   性别	JRadioButton	党否	JCheckBox
   年龄	JSpinner		颜色 JColorChooser
   加分	JSlider		系别	JComboBox
   选课	JList			确认	JButton
   保存	JFileChooser	结果	JTextArea
 */
public class main extends JFrame{
    private JFrame frame = new JFrame("学生信息管理系统") ;
    private JButton submit = new JButton("登陆");
    private JButton reset = new JButton("重置");
    private JLabel nameLab = new JLabel("用户名：") ;
    private JLabel passLab = new JLabel("密   码：") ;
    private JLabel infoLab = new JLabel("学生信息录入系统") ;
    private JTextField nameText = new JTextField(10) ;
    private JPasswordField passText = new JPasswordField() ;
    private JPanel pan = new JPanel() ;

    // 默认构造函数
    public main() {
            Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,20) ;
            infoLab.setFont(fnt) ;	// 设置标签的显示文字
            submit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource()==submit){
                        String tname = nameText.getText() ;
                        String tpass = new String(passText.getPassword()) ;
                        LoginCheck log = new LoginCheck(tname,tpass) ;
                        if(log.validate()){
                            infoLab.setText("登陆成功，欢迎光临！") ;
                        }else{
                            infoLab.setText("登陆失败，错误的用户名或密码！") ;
                        }
                    }
                }
            }) ;
            reset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource()==reset){
                        nameText.setText("") ;
                        passText.setText("") ;
                        infoLab.setText("用户登陆系统") ;
                    }
                }
            }) ;

            frame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(1) ;
                }
            }) ;	// 加入事件
            frame.setLayout(null) ;
            nameLab.setBounds(5,105,60,20) ;
            passLab.setBounds(5,130,60,20) ;
            infoLab.setBounds(350,0,220,30) ;
            nameText.setBounds(65,105,100,20) ;
            passText.setBounds(65,130,100,20) ;
            submit.setBounds(165,105,60,20) ;
            reset.setBounds(165,130,60,20) ;
            frame.add(nameLab) ;
            frame.add(passLab) ;
            frame.add(infoLab) ;
            frame.add(nameText) ;
            frame.add(passText) ;
            frame.add(submit) ;
            frame.add(reset) ;
            frame.setSize(800,600) ;
            frame.setBackground(Color.WHITE) ;
            frame.setLocation(300,200) ;
            frame.setVisible(true) ;
    }

    public static void main(String[] args) {
        main frame = new main();
    }
}