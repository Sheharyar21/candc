import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;  // Using Frame class in package java.awt
import java.awt.GridLayout;

import javax.swing.*;  


	import java.net.*;
	import java.io.*;
	public class MultithreadedSocketServer extends Frame  {

		
	
	  public static void main(String[] args) throws Exception {
		  JFrame mainFrame;
		  JPanel controlPanel;
		  JLabel newLabel = new JLabel();
		  
		    mainFrame = new JFrame("Server");
		      mainFrame.setSize(600	,600);
		      
		      mainFrame.setLayout(new GridLayout(3, 1));
		      
		      controlPanel = new JPanel();
		      controlPanel.setLayout(new FlowLayout());
mainFrame.setLayout(null);
newLabel.setText("<html>Welcome to the Server Recieve data  by the clients<br> </html>");
newLabel.setBounds(150,120,430,90);

		      
			JLabel OutputError = new JLabel();
			JButton b=new JButton("click");//creating instance of JButton  
	    	b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
	    		JLabel Heading = new  JLabel(""); 
	    		Heading.setBounds(200,0,350,100);
	    		JTextArea Output = new JTextArea("<html>");
	    		
	    		
	    		
	    try{
	    
	    		
	    	
	    	JFrame f=new JFrame();//creating instance of JFrame  
	          
	    	
	      ServerSocket server=new ServerSocket(8888);
	      int counter=0;
	      
	//      System.out.println("Server Started ....");
	      Heading.setText("Server Started ....\n");
	      Heading.setSize(350, 100);
	      
	      Heading.setFont(new Font("Calibri", Font.BOLD, 20));
	  	mainFrame.add(controlPanel);
	    mainFrame.add(Heading);
	    mainFrame.add(newLabel);
	    mainFrame.setVisible(true); 
	    int i=0;
	    
	    
	      while(true){
	    	 	
	         
	    	//  Output.setText (" >> " + "Client No:" + counter + " started!\n");
	            Output.setBounds(150, 120, 350, 400);
	        counter++;
	        Socket serverClient=server.accept(); 
	        
	    	
	       
	        Output.setForeground(new Color(0x00FF00)); 
	        Output.setFont(new Font("MV Boli",Font.PLAIN,10)); 
	        Output.setBackground(Color.black); 
	        Output.setOpaque(true); 
		
	        
	      //  Output.setText ("\n\n >> " + "Client No:" + counter + " started!" + "\n");
	     
	   
	        ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
	     String xyz =   sct.run(mainFrame);
	     
	     Output.setText (sct.xyz);    
	     mainFrame.add(Output);
	     
	   
	     
	      }
	    }catch(Exception e){
	    OutputError.setText(e.toString());
	    }
	    

	   // mainFrame.add(Output);
	  
	  }
	  
	}

	


