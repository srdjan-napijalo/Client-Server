package calc_server;
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.StringTokenizer; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calc_Server 
{ 
	public static void main(String args[]) 
	{ 

		ServerSocket ss; 
            try {
                ss = new ServerSocket(4444);
                Socket s = ss.accept(); 
		DataInputStream dis = new DataInputStream(s.getInputStream()); 
		DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

		while (true) 
		{ 
			
			String input = dis.readUTF(); 

			System.out.println("Operandi prihvaceni:" + input); 
			

			 
			StringTokenizer st = new StringTokenizer(input); 

			int oprnd1 = Integer.parseInt(st.nextToken()); 
			int oprnd2 = Integer.parseInt(st.nextToken()); 
                        int rez= oprnd1 + oprnd2;
			System.out.println("Salje se rezultat..."); 
                        System.out.println("");

			
			dos.writeUTF(Integer.toString(rez)); 
		} 
	}catch(IOException ex){System.out.println("Greska!");
      }
   } 
} 
