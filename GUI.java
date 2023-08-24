import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUI {
	public static void main(String args[]){
		SwingUtilities.invokeLater(() -> {
			
			
			JLabel label1 = new JLabel();
			label1.setText("Welcome To A&J Airline Ticket Booking Service");
			label1.setHorizontalTextPosition(JLabel.CENTER);
			label1.setVerticalTextPosition(JLabel.TOP);
			label1.setForeground(new Color(0xF8F8B2));
			label1.setFont(new Font("Cooper Black", Font.BOLD, 46));
			Dimension size = label1.getPreferredSize();
		    label1.setBounds(50, 100, size.width, size.height);
		    
		    
		    JButton signUpButton = new JButton("Sign Up");
		    JButton signInButton = new JButton("Sign In");
		    signUpButton.setAlignmentX(45.5f);
		    signInButton.setAlignmentX(30.5f);
		    
		    
		   
	       JFrame frame = new JFrame();
	       frame.setTitle("Flight Booking Service");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setLayout(new FlowLayout());
	       
	       
	       JPanel contentPanel = new JPanel() {
	    	   /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			BufferedImage bgImage;
	    	   {
	    		   try {
		    		   bgImage = ImageIO.read(getClass().getResource("airplane_window.jpg"));
		    			   
		    	   } catch (IOException e) {
		    		   
		    		   e.printStackTrace();
		    	   }
	    	   }
	    	  @Override
	    	  protected void paintComponent(Graphics g) {
	    		  super.paintComponent(g);
	    		  g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
	    	  }
	       };
	       
	       ImageIcon favicon = new ImageIcon("logo1.png");
	       frame.setIconImage(favicon.getImage());
	       
	       
	      
	       frame.setContentPane(contentPanel);
	       frame.add(signUpButton);
	       frame.add(signInButton);
	       frame.add(label1);
	       frame.pack();
	       frame.setSize(4500, 5500);
	       frame.setVisible(true);


		});
	}

}
