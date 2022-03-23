import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ServerClientThread extends Thread {
  Socket serverClient;
  int clientNo;

  String xyz = "";
  int squre;
  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
    
  }
  public String run(JFrame mainFrame){
	  
	  JLabel jlab = new JLabel("<html>",JLabel.CENTER);
	  JLabel jlab1 = new JLabel("<html>",JLabel.CENTER);
		JLabel Output = new JLabel("",JLabel.CENTER); 
		
		
		 String s;
	        Process p;
	        
    try{
    	
    	
    	
    	
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage="", serverMessage="";
      while(!clientMessage.equals("bye")){
        clientMessage=inStream.readUTF();
        jlab1.setText(  jlab1.getText()+ "From Client-" +clientNo+ ": Number is :"+clientMessage+ "<br></html>");
       
        jlab1.setHorizontalTextPosition(JLabel.CENTER); 
        jlab1.setVerticalTextPosition(JLabel.TOP); 
        jlab1.setForeground(new Color(0x00FF00)); 
        jlab1.setFont(new Font("MV Boli",Font.PLAIN,20)); 
        jlab1.setIconTextGap(-25);
        
        jlab1.setBackground(Color.black); 
        jlab1.setOpaque(true); 
        jlab1.setVerticalAlignment(JLabel.CENTER); 
        jlab1.setHorizontalAlignment(JLabel.CENTER); 
        
       
        
        
      //  System.out.println("From Client-" +clientNo+ ": Number is :"+clientMessage);
  //      squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
    //    serverMessage="From Server to Client-" + clientNo + " Square of " + clientMessage + " is " +squre;
   jlab1.setText(serverMessage);
  
   try {
   p = Runtime.getRuntime().exec(clientMessage);
   BufferedReader br = new BufferedReader(
       new InputStreamReader(p.getInputStream()));
   while ((s = br.readLine()) != null)
   {
	   xyz = xyz +  "\n" + s;
	   break;
   }
   
   	serverMessage = "\nline"+xyz;

   System.out.println ("exit: " + p.exitValue());
   p.destroy();
  System.out.print(serverMessage);
   
   } catch (Exception e) {}
   
   
   

   mainFrame.add(jlab1);
        mainFrame.setVisible(true);
        
        outStream.writeUTF(serverMessage);
        outStream.flush();
       
      }
      inStream.close();
      outStream.close();
      serverClient.close();
      return serverMessage;
    }catch(Exception ex){
      System.out.println(ex);
    }finally{
    	jlab.setText("\n\nClient -" + clientNo + " exit!! ");
    	mainFrame.add(jlab);
      System.out.println("Client -" + clientNo + " exit!! ");
    }
	return "";
    
  }
}