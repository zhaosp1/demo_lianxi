package swing;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO
 * java swing+线程实现时钟
 */
public class DigitalWatch implements Runnable{
  JFrame jFrame;
  Thread t=null;
  int hours=0,minutes=0,seconds=0;
  String time="";
  JButton jButton;

  DigitalWatch(){
    jFrame=new JFrame();
    jFrame.setTitle("Swing时钟");

    jButton=new JButton();
    jButton.setBounds(100,100,100,30);

    jFrame.add(jButton);
    jFrame.setSize(600,600);
    jFrame.setLayout(null);
    jFrame.setVisible(true);

    t=new Thread(this);
    t.start();
  }

  @Override
  public void run() {
    try {
      while (true){
        Calendar cal=Calendar.getInstance();
        hours=cal.get(Calendar.HOUR_OF_DAY);
        minutes=cal.get(Calendar.MINUTE);
        seconds=cal.get(Calendar.SECOND);

        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        Date date=new Date();
        time=sdf.format(date);
        printTime();
        t.sleep(1000);
      }
    }catch (Exception e){

    }
  }

  public void printTime(){
    jButton.setText(time);
  }

  public static void main(String[] args) {
    new DigitalWatch();
  }
}
