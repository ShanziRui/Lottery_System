import java.util.*;
public class Rolling extends Thread
{	
	private Pick pi;
	public boolean isrun;
	public void start()
	{
		isrun=true;
		super.start();
	}
	public Rolling(Pick pic)
	{
		this.pi=pic;
		start();
	}
	public void run()
	{
		while(isrun)
		{
			for(Object now:Read_info.user)
				if(!((Single_info)now).chosen)
				{
					if(!isrun) break;
					this.pi.change_name(((Single_info)now));
					try
					{
						this.sleep(25);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					if(!isrun) break;
				}
		}
	}
}