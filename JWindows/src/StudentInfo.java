import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import java.awt.Color;

/*
   姓名	JTextField		密码	JPasswordField
   性别	JRadioButton	党否	JCheckBox
   年龄	JSpinner		颜色 JColorChooser
   加分	JSlider		系别	JComboBox
   选课	JList			确认	JButton
   保存	JFileChooser	结果	JTextArea
 */
public class StudentInfo {
    private JFrame frmStudentInformationInput;
    private JTextField textField;
    private JPasswordField passwordField;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentInfo window = new StudentInfo();
                    window.frmStudentInformationInput.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Create the application.
     */
    private StudentInfo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmStudentInformationInput = new JFrame();
        frmStudentInformationInput.setResizable(false);
        frmStudentInformationInput.setTitle("Components usage in inputting the information of students");
        frmStudentInformationInput.setBounds(100, 100, 800, 600);
        frmStudentInformationInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmStudentInformationInput.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("学生信息录入系统");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("黑体", Font.BOLD, 35));
        lblNewLabel.setBounds(100, 0, 590, 64);
        lblNewLabel.setForeground(Color.BLUE);
        frmStudentInformationInput.getContentPane().add(lblNewLabel);
        //时间刷新
        final Label label_4 = new Label();
        label_4.setBounds(90, 493, 242, 23);
        frmStudentInformationInput.getContentPane().add(label_4);
        //JSplitPane 容器
        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.8);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setBounds(90, 63, 590, 424);
        frmStudentInformationInput.getContentPane().add(splitPane);

        final JTextArea textArea = new JTextArea();
        splitPane.setRightComponent(textArea);

        JPanel panel = new JPanel();
        splitPane.setLeftComponent(panel);
        panel.setBorder(BorderFactory.createTitledBorder("请输入学生信息"));
        panel.setLayout(null);

        JLabel label = new JLabel("姓名");
        label.setBounds(10, 44, 31, 15);
        panel.add(label);

        JLabel label_1 = new JLabel("密码");
        label_1.setBounds(10, 72, 31, 15);
        panel.add(label_1);

        textField = new JTextField();
        textField.setBounds(45, 41, 252, 21);
        panel.add(textField);
        textField.setColumns(10);

        JLabel label_2 = new JLabel("性别");
        label_2.setBounds(10, 125, 31, 15);
        panel.add(label_2);

        final JRadioButton radioButton = new JRadioButton("男");
        radioButton.setBounds(43, 120, 55, 23);
        panel.add(radioButton);

        final JRadioButton radioButton_1 = new JRadioButton("女");
        radioButton_1.setBounds(87, 120, 55, 23);
        panel.add(radioButton_1);

        ButtonGroup bg=new ButtonGroup();				//创建控件组
        bg.add(radioButton);							//放入控件，让两个radiobutton（性别）互斥
        bg.add(radioButton_1);

        JLabel label_3 = new JLabel("党否");
        label_3.setBounds(150, 125, 31, 15);
        panel.add(label_3);

        final JCheckBox checkBox = new JCheckBox("");
        checkBox.setBounds(180, 120, 31, 23);
        panel.add(checkBox);

        final JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"计算机科学与技术秕","软件工程系","数学系","物理光学系","音乐系"}));
        comboBox.setBounds(376, 41, 189, 21);
        panel.add(comboBox);

        JLabel label_5 = new JLabel("\u7CFB\u522B");
        label_5.setBounds(335, 44, 31, 15);
        panel.add(label_5);

        JLabel label_6 = new JLabel("\u9009\u8BFE");
        label_6.setBounds(335, 72, 31, 15);
        panel.add(label_6);

        passwordField = new JPasswordField();
        passwordField.setBounds(45, 69, 252, 21);
        panel.add(passwordField);

        final JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(0, 0, 120, 1));
        spinner.setBounds(250, 122, 47, 22);
        panel.add(spinner);

        final JList list = new JList();
        list.setModel(new AbstractListModel() {
            String[] values = new String[]{"数据结构", "算法设计", "操作系统", "网络原理", "JAVA设计", "数据库原理","分布式系统设计","Python开发","C#程序设计"};
            public int getSize() {
                return values.length;
            }
            public Object getElementAt(int index) {
                return values[index];
            }
        });
        JScrollPane jScrollPane = new JScrollPane(list);  //用JScrollPane接收list值，实现滚动条
        jScrollPane.setBounds(376, 71, 189, 131);
        panel.add(jScrollPane);

        final JSlider slider = new JSlider();
        slider.setSnapToTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setBounds(42, 226, 288, 46);
        panel.add(slider);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        addSlider(slider, "数值刻度标签");

        JLabel label_7 = new JLabel("\u5E74\u9F84");
        label_7.setBounds(224, 125, 31, 15);
        panel.add(label_7);

        final Label label_9 = new Label("");
        label_9.setBackground(Color.LIGHT_GRAY);
        label_9.setBounds(187, 154, 69, 66);
        panel.add(label_9);

        JButton btnNewButton = new JButton("\u9009\u62E9\u989C\u8272");
		/*
		 * 选择颜色按钮监听事件*/
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorchooser = new JColorChooser(); 					//打开自带颜色选择器
                Color color =colorchooser.showDialog(null,"颜色选择 ",Color.BLACK);
                label_9.setBackground(color);						//用label接收颜色
            }
        });
        btnNewButton.setBounds(62, 172, 95, 30);
        panel.add(btnNewButton);

        JLabel label_8 = new JLabel("\u52A0\u5206");
        label_8.setBounds(10, 240, 31, 15);
        panel.add(label_8);

        JButton button = new JButton("\u7ED3\u679C");
		/*
		 * 结果按钮监听事件*/
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //创建变量存放各个数值
                String name,password,sex,dy,age,dept,lesson = "",color;
                int score;
                //姓名
                if(textField.getText().length()!=0){
                    name = textField.getText();
                }else{
                    JOptionPane.showMessageDialog(null, "请输入姓名！","友情提醒！", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                //密码
                if(passwordField.getText().length()!=0){
                    password = passwordField.getText();
                }else{
                    JOptionPane.showMessageDialog(null, "请输入密码！","友情提醒！", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                //性别
                if(radioButton.isSelected()){
                    sex = radioButton.getText();
                }else if(radioButton_1.isSelected()){
                    sex = radioButton_1.getText();
                }else{
                    JOptionPane.showMessageDialog(null, "请选择性别！","友情提醒！", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                //党员
                if(checkBox.isSelected()){
                    dy="是";
                }else{
                    dy="否";
                }
                //年龄
                age=spinner.getValue().toString();
                //颜色
                color="R:"+String.valueOf(label_9.getBackground().getRed())+"  "+"G:"+String.valueOf(label_9.getBackground().getGreen())+"  "+"B:"+String.valueOf(label_9.getBackground().getBlue());
                //系别
                dept=comboBox.getSelectedItem().toString();
                //课程
                if(list.getSelectedValues().length==0){
                    JOptionPane.showMessageDialog(null, "请选择课程！","友情提醒！", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else{
                    int i;
                    for(i=0;i<list.getSelectedValues().length;i++){
                        lesson+=list.getSelectedValues()[i].toString()+"  ";
                    }
                }
                //加分
                score=slider.getValue();
                //将获取到的值放入textArea
                textArea.setText("姓名:"+name+"  "+"密码:"+password+"  "+"性别:"+sex+"  "+"党员:"+dy+"  "+"年龄:"+age+"  "+"颜色:"+color+"  "+"系别:"+dept+"\n"+"课程:"+lesson+"  "+"加分:"+score);
            }
        });
        button.setBounds(376, 226, 81, 30);
        panel.add(button);

        final JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(50);
        progressBar.setStringPainted(true);
        progressBar.setBounds(403, 493, 186, 23);
        frmStudentInformationInput.getContentPane().add(progressBar);

        JButton button_1 = new JButton("\u4FDD\u5B58");
		/*
		 *保存按钮监听事件*/
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(textArea.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "请填写学生信息！","友情提醒！", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else{
                    try{
                        File file=new File("studentInfo.txt");						//打开文件
                        if(!file.exists()){
                            file.createNewFile();
                        }
                        FileWriter fileWritter = new FileWriter(file.getName(),true);	//写入文件
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);	//写入流
                        bufferWritter.write(textArea.getText());
                        bufferWritter.newLine();			//每一条记录换行

                        new Thread(new Runnable() {					//创建线程
                            public void run() {						// 重构父类的方法
                                for (int i = 0; i <= 100; i++) {
                                    try {
                                        Thread.sleep(1);			//循环0-100，每次线程休眠1毫秒
                                        progressBar.setValue(i);	//进度条实现
                                    } catch (InterruptedException ie){

                                    }
                                }
                            }
                        }).start();

                        bufferWritter.close();
			            /*
			             * 写入成功后初始化界面*/
                        textField.setText("");
                        passwordField.setText("");
                        label_9.setBackground(Color.LIGHT_GRAY);
                        slider.setValue(50);
                        textArea.setText("");
                        spinner.setValue(0);

                        JOptionPane.showMessageDialog(null, "写入成功！","友情提醒！", JOptionPane.INFORMATION_MESSAGE);
                        progressBar.setValue(0);

                    }catch(IOException e1){
                        e1.printStackTrace();
                    }
                }
            }
        });
        button_1.setBounds(484, 226, 81, 30);
        panel.add(button_1);

        JButton btntxt = new JButton("\u6253\u5F00TXT\u6587\u4EF6");
        btntxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Process process = Runtime.getRuntime().exec("cmd.exe /c notepad ./studentInfo.txt");	//进程调用cmd打开txt文档
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btntxt.setBounds(406, 266, 123, 38);
        panel.add(btntxt);

        class Time extends Thread {// 创建内部类
            public void run() {// 重构父类的方法
                while (true) {
                    DateFormat  df  = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// 创建日期对象,并格式化显示格式
                    label_4.setText(df.format(new Date()));// 获取当前时间，并显示到时间标签中
                    try {
                        Thread.sleep(1000);// 令线程休眠1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Time t = new Time();
        t.start();
    }

    private void addSlider(JSlider slider, String string) {
        // TODO Auto-generated method stub

    }
}
