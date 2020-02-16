import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class Pick extends JFrame {

	private JPanel contentPane;
	private JButton b_start,b_stop;
	private JLabel label1;
	private Rolling rol;
	private Single_info si;
	private JTextField user_name = new JTextField(); // 抽奖对象滚动的文本域
	public Pick() 
	{
		super("Super Lottery");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		user_name.setEditable(false);	//文本不可修改
		
		Container container = getContentPane();
		container.setLayout(null);
		b_start = new JButton("开  始");
		b_start.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 b_start_ActionPerformed(e);
			}
		});
		b_start.setBounds(40, 120, 150, 75);
		container.add(b_start);
        b_stop = new JButton("暂  停");
        b_stop.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		b_stop_ActionPerformed(e);
        	}
        });
        b_stop.setBounds(200, 120, 150, 75);
        container.add(b_stop);
        
        user_name.setBounds(40, 60, 310, 40);
        container.add(user_name);
        
        JPanel JP=new JPanel();
        label1 = new JLabel((Read_info.mainhead.equals(""))?"滚动名单":(Read_info.mainhead));
        JP.setBounds(0, 20, 380, 40);
        JP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        label1.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        JP.add(label1);
        container.add(JP);
        
        setSize(380,240);
		setVisible(true);	
		
		for(Object now:Read_info.user) 
			((Single_info)now).chosen=false;
		Read_info.result.clear();
	}
	int chooseTime = 0; // 按下停止按钮的次数,也就是抽奖的次数
	public void b_start_ActionPerformed(ActionEvent e)
    {
		//判断存储两个标记的向量中是否为空
       	if ((!Read_info.repetition)&&(chooseTime >= Read_info.user.size()))
        {
       		JOptionPane.showMessageDialog(null, "没有对象可以被抽取，请重新运行程序或点击查看中奖结果！","错误",JOptionPane.ERROR_MESSAGE);
       		this.dispose();
            //b_start.setEnabled(false);
           // b_stop.setEnabled(false);             
        }
        else//执行....
        {
        	rol=new Rolling(this);
            b_start.setEnabled(false);
            b_stop.setEnabled(true);
        }
    }
	
	public void change_name(Single_info sin)
	{
		user_name.setText(sin.ID);
		this.si=sin;
	}

	public void b_stop_ActionPerformed(ActionEvent e)
	{
		chooseTime++;//第几次按停止按钮
		rol.isrun=false;
		if(!Read_info.repetition) this.si.chosen=true;
		Read_info.result.add(this.si);
		b_start.setEnabled(true);
		b_stop.setEnabled(false);
		if(!Read_info.repetition)
		if(chooseTime==Read_info.user.size())
		{
			JOptionPane.showMessageDialog(null, "完成！");
			this.dispose();
		}
	}

}
