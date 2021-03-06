import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x=120, y=100, z=0;

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Image img,img1,img2,img3,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo04.png");
			img3=Image.createImage("/sayo06.png");
			currentImg=img;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,z);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){

              if(currentImg==img1){
			  this.x--;
			  }

			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			currentImg=img1;
			System.out.println("向左转");
			repaint();
		}
		if(action==UP){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/

              if(currentImg==img2){
			     this.y--;
			  }

			currentImg=img2;
			System.out.println("向上转");
			repaint();
		}
		if(action==RIGHT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
             if(currentImg==img3){
			     this.x++;
			  }

			currentImg=img3;
			System.out.println("向右转");
			repaint();
		}
		if(action==DOWN){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			 if(currentImg==img){
			     this.y++;
			  }
			currentImg=img;
			System.out.println("向下转");
			repaint();
		}
	}
}