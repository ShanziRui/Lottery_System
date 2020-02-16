import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class SettingPage extends JFrame {

	private JTextField text1;
	private JFileChooser filechooser = new JFileChooser(); // 文件选择器
	private JLabel image;
	private JCheckBox CB_repetition;
	private void file_work()
	{
		int i = filechooser.showOpenDialog(this); // 显示打开文件对话框
        /*
        * 确实所选择的是对话框上的确定按钮
        */
        if (i == JFileChooser.APPROVE_OPTION)
        {
        	new Read_info(filechooser.getSelectedFile());
        }
        else
        	JOptionPane.showMessageDialog(null, "请导入文件！","警告",JOptionPane.ERROR_MESSAGE);
	}
	
	public SettingPage() 
	{
		super("设置");	//面板标题
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(null);
		
		//创建标签，标签后textfield的文字内容由用户自定义
		JLabel lbl1 = new JLabel("主 标 题：");
		lbl1.setBounds(10, 10 , 75, 20);
		container.add(lbl1);
		text1 = new JTextField();
		text1.setBounds(85, 10, 150, 20);
		container.add(text1);
		text1.getText();
		
		//创建按钮，点击返回上一界面
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		btnNewButton.setBounds(123, 98, 117, 29);
		getContentPane().add(btnNewButton);
		
		//创建标签，紧跟选择按钮
		JLabel lblNewLabel_1 = new JLabel("抽奖方式：");
		lblNewLabel_1.setBounds(10, 70, 89, 16);
		getContentPane().add(lblNewLabel_1);
		CB_repetition = new JCheckBox("允许重复抽奖");
		CB_repetition.setBounds(95, 66, 128, 23);
		getContentPane().add(CB_repetition);
		
		//创建按钮，保存用户设置信息
		JButton btnSave = new JButton("保存");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Read_info.mainhead=text1.getText();
				Read_info.repetition=CB_repetition.isSelected();
				dispose();
			}
		});
		btnSave.setBounds(10, 98, 117, 29);
		getContentPane().add(btnSave);
		getRootPane().setDefaultButton(btnSave);//将默认按钮设置为SAVE按钮
		
		//创建标签、按钮，导入抽奖信息
		JLabel lblInfoList = new JLabel("抽奖名单：");
		lblInfoList.setBounds(10, 42, 65, 16);
		getContentPane().add(lblInfoList);
		JButton btnChooseFile = new JButton("选择文本文件");
		btnChooseFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				file_work();
			}
		});
		btnChooseFile.setBounds(85, 37, 150, 29);
		getContentPane().add(btnChooseFile);
		
		setSize(246,155);
		setVisible(true);
	}
}
