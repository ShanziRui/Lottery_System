import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HomePage extends JFrame 
{
	private JButton settingButton,operateButton,resultButton,exitButton;
	private JLabel label;
	public HomePage()
	{
		super("欢迎来到超级抽奖器");	//定义界面的名字
		Container container = getContentPane();
		container.setLayout(null);		//null才可以调用setbounds，自定义位置和大小
		
		//创建设置按钮
		settingButton = new JButton("设置");
		settingButton.setBounds(10, 18, 150, 70);
		settingButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new SettingPage();
			}
		});
		container.add(settingButton);
		
		//创建运行按钮
		operateButton = new JButton("运行");
		operateButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Pick();
			}
		});
		operateButton.setBounds(168, 18, 150, 70);
		container.add(operateButton);
		
		//创建结果按钮
		resultButton = new JButton("结果");
		resultButton.setBounds(330, 18, 150, 70);
		resultButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				getresult();
			}
		});
		container.add(resultButton);
		
		exitButton = new JButton("退出");
		exitButton.setBounds(405, 180, 75, 30);
		exitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		container.add(exitButton);
		
		//创建注释标签(无法换行)
		JLabel label1 = new JLabel("说  明：点击设置按钮导入文本文件，文件内容必须以“：”隔开姓名与编号，并设");
		label1.setBounds(10, 100, 480, 30);
		container.add(label1);
		label = new JLabel("置标题和抽奖方式；点击运行按钮开始抽奖；点击结果按钮显示中奖顺序。");
		label.setBounds(56, 128, 480, 16);
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("清空结果");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Read_info.result.clear();
			}
		});
		btnNewButton.setBounds(313, 181, 88, 29);
		getContentPane().add(btnNewButton);
		
		//设置面板的大小
		setSize(500,240);
		setVisible(true);
	}
	
	private void getresult()
	{
		String SR="";
		int t=0;
		for(Object now:Read_info.result) 
			SR+=(String.format("%4d", ++t))+". "+((Single_info)now).name+":"+((Single_info)now).ID+"\n";
		JOptionPane.showMessageDialog(null, SR);
	}
	
	public static void main(String[] args)
	{
		HomePage application = new HomePage();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
