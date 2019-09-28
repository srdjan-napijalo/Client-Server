package calc_client;
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.InetAddress; 
import java.net.Socket; 
import java.net.UnknownHostException; 
import java.util.Scanner; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calc_Client 
{ 
	public static void main(String[] args) {
	
		InetAddress ip; 
            try {
                ip = InetAddress.getLocalHost();      
                int port = 4444; 
		Scanner sc = new Scanner(System.in); 
		Socket s = new Socket(ip, port); 
		DataInputStream dis = new DataInputStream(s.getInputStream()); 
		DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

		while (true) 
		{  
			System.out.println("Unesite prvi operand"); 
			String inp = sc.nextLine();
                        System.out.println("");
                        System.out.println("Unesite drugi operand");
                        String inp2= sc.nextLine();
                        System.out.println("");
                        String input = " "+inp+"   "+inp2;


			dos.writeUTF(input);
                        

			String rez = dis.readUTF(); 
			System.out.println("Rezultat=" + rez); 
                        System.out.println("");
		} 
            }catch (IOException ex){ System.out.println("Doslo je do greske...");
        } 
    }
} 
