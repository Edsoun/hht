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
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	Image img,img1,img2,img3,currentImg;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
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
		g.drawImage(currentImg,x,y,z);//120��X���ꡢ100��Y����
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){

              if(currentImg==img1){
			  this.x--;
			  }

			/*
			ʵ��ת�����
			*/
			/*
			���������¸�ֵ����
			*/
			currentImg=img1;
			System.out.println("����ת");
			repaint();
		}
		if(action==UP){
			/*
			ʵ��ת�����
			*/
			/*
			���������¸�ֵ����
			*/

              if(currentImg==img2){
			     this.y--;
			  }

			currentImg=img2;
			System.out.println("����ת");
			repaint();
		}
		if(action==RIGHT){
			/*
			ʵ��ת�����
			*/
			/*
			���������¸�ֵ����
			*/
             if(currentImg==img3){
			     this.x++;
			  }

			currentImg=img3;
			System.out.println("����ת");
			repaint();
		}
		if(action==DOWN){
			/*
			ʵ��ת�����
			*/
			/*
			���������¸�ֵ����
			*/
			 if(currentImg==img){
			     this.y++;
			  }
			currentImg=img;
			System.out.println("����ת");
			repaint();
		}
	}
}