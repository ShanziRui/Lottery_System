import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Read_info 
{
	public static Vector user = new Vector();
	public static Vector result = new Vector();
	public static String mainhead="";
	public static boolean repetition;
	
	public Read_info(File f)
	{
		
        //从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取
        BufferedReader reader = null;
        try
        {
        	//读取字符流
            reader = new BufferedReader(new FileReader(f));
            //循环读取
            while (true)
            {
            	//读取一个文本行
                String data = reader.readLine();
                
                if (data == null)//读完了数据
                {
                	JOptionPane.showMessageDialog(null, "数据读取完成！");
                    break;
                }
                                
                //通过“:”这个符号将 字符串分离为两部分，再存放到向量里面
                String sp[]=data.split(":");
                if (sp[1] == null)
                {
                	JOptionPane.showMessageDialog(null, "数据格式不正确，请重新加载!","错误",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Single_info now=new Single_info(sp[0],sp[1]);
                user.add(now);

            } 
        }
        catch(Exception ex)
        {
        	JOptionPane.showMessageDialog(null, "读取文件有误!","错误",JOptionPane.ERROR_MESSAGE);
        }
	}
}
