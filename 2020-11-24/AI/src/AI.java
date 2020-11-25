import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;

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
class MainCanvas extends Canvas implements Runnable
{
	int hero_x, hero_y, boss_x, boss_y;
	Thread thread;
    Random rd = new Random();
	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Image img[][] = new Image[4][3]; 
	int	flag = 0;
    Image currentImg , BossImg;
    Image ok_key;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			/*
			0 DOWN
			1 LEFT
			2 UP
			3 RIGHT
			*/

             for(int i=0; i < img.length ; i++){
				 for(int j=0; j < img[i].length ; j++){
			       img[i][j]= Image.createImage("/sayo"+ i + j +".png");
				 }
			 }

			 hero_x=120;
			 hero_y=100;
	         boss_x=0;
			 boss_y=0;
  

			 currentImg=img[0][0];
             ok_key=Image.createImage("/sayo_yarare.png");
			 BossImg=Image.createImage("/benzaiten.png");

			 thread=new Thread(this);
			 thread.start();



		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

    public void run(){
	 while(true){
		 int number = rd.nextInt(10);
		 
	      try{
		    Thread.sleep(200);
			  }catch(InterruptedException e){
		     e.printStackTrace();
		  }
		  if(number%3==0){
			  if(boss_x < hero_x)   boss_x++;
			  else                  boss_x--; 

			  if(boss_y < hero_y)   boss_y++;
			  else                  boss_y--;
          }
		  repaint();
	   }
	}


	public void paint(Graphics g){
		g.setColor(72,209,204);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,hero_x,hero_y,0);//120：X坐标、100：Y坐标
		g.drawImage(BossImg,boss_x,boss_y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		//System.out.println(action);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
             
              changePicAndDirection(1);
			hero_x=hero_x-2;
		}
		if(action==UP){

	changePicAndDirection(2);

			hero_y=hero_y-2;
		}
		if(action==RIGHT){
			changePicAndDirection(3);

             
			hero_x=hero_x+2;
		}
		if(action==DOWN){
			 changePicAndDirection(0);
			     hero_y=hero_y+2;
		}


        if(action == 8){
		  currentImg=ok_key;
		}


	}
    public void changePicAndDirection(int direction){

	  currentImg = img[direction][0];
	  flag++;
	  if(flag==3) flag=0;

	}


}