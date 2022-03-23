 
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.io.*;
public class TCPClient extends Frame {
  public static void main(String[] args) throws Exception {
  try{
	  JFrame mainFrame;
	  JPanel controlPanel;
	  JTextField t1;
	  JLabel newLabel = new JLabel();
	  JLabel newh = new JLabel("Client",JLabel.CENTER);
	  
	  JButton newbutton = new JButton("Run Command");
	  
	    mainFrame = new JFrame("Client");
	      mainFrame.setSize(500	,500);
	      newh.setFont(new Font("Calibri", Font.BOLD, 20));
mainFrame.setLayout(null);
		     mainFrame.add(newh);
		     newh.setBounds(0,0,430,90);
	      t1=new JTextField(3);  
	
	      
	      
	      t1.setSize(450,50);
	      t1.setBounds(40,120,400,30);
	      newLabel.setText("<html>Welcome to the Client Enter command the clients<br> options are to just run some commands  and press<br> run command to show the output on the server</html>");
	      newLabel.setBounds(80,40,430,90);
	      
	      mainFrame.add( newLabel);
	   
	      
	   
	      
	      mainFrame.add(t1);
	      newbutton.setBounds(160,180,120,40);
	      mainFrame.add( newbutton);
	      
	      mainFrame.setVisible(true);
	      
	      newbutton.addActionListener(e ->
	      {
	    	  
    		  
		      
    Socket socket;
	try {
		socket = new Socket("127.0.0.1",8888);
	    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage="",serverMessage="";
    while(!clientMessage.equals("bye")){
     // System.out.println("Enter number :");
      clientMessage = t1.getText();
      
      
      outStream.writeUTF(clientMessage);
      outStream.flush();
      serverMessage=inStream.readUTF();
      System.out.println(serverMessage);
      
      break;
    }
    outStream.close();
    outStream.close();
    socket.close();
    
	}
	catch(Exception e1){
	  
	  }
	
	
    
    
	    	    // your code here
	    	});
	
  }catch(Exception e){
    System.out.println(e);
  }
  }
}