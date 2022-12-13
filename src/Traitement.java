



import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Traitement  extends Thread{
	private Socket sc;
	private static List<Compte> CompteList = new ArrayList<>();

	public Traitement(Socket sc) {
		this.sc = sc;
	}

	public void run() {
		try {
			InputStream input = sc.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			OutputStream output = sc.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);

		

			while (true) {
				String in = "";
				in = reader.readLine();
			if (in.startsWith("CREATION")) {
					String name = in.substring(10);//on commence de calculer par 10
					
					boolean test=true;
					for (Compte c: CompteList) {
						if(c.getClientName() .equals(name)) {
							test=false;
							}
						
					}

					if (test==true) {
						Compte NewAccount = new Compte(name);
						CompteList.add(NewAccount);
						 writer.println("Le compte est créé avec succés");
					} 
					else {

						writer.println("Le compte déja existe");
						}
			
					
			
			
					while(true) {
						String cmd=reader.readLine();
			 if(cmd.startsWith("CREDIT")) {
						
						String message=cmd.substring(8);
						double montant=Double.parseDouble(message);
						for(Compte c: CompteList) {
							if(c.getClientName().equals(name)) {
								c.setSolde(montant+c.getSolde());
								writer.println("Compte crédité avec succès");
								
							}
						
						
					else  {
						
						writer.println("erreur");}
					         
						}
			 }
					while(true) {
			String d=reader.readLine();
			 if(d.startsWith("DEBIT")) {
				 String msg=d.substring(7);
				 double mt=Double.parseDouble(msg);
				 for (Compte c: CompteList) {
					 if (c.getClientName().equals(name)) {
						 c.setSolde(c.getSolde()-mt);
						 writer.println("Compte  a été debité avec succès");
						 
					 }
					 else {
						 writer.println("ERREUR");
					 }
				 }
			 
					}
			 while(true) {
				 String tab=reader.readLine();
				 if(tab.startsWith("SOLDE")) {
					 //Double solde=Double.parseDouble(tab);
					 for (Compte c: CompteList) {
						 if (c.getClientName().equals(name)) {
							 writer.println(String.valueOf(c.getSolde()));
							 
						 }
						 else {
							 writer.println("Le compte n'existe pas");
					 }
						 }
					 
				 }
			 }
			 }
					}
					
					
						    
						    	
			}
					}
					
					
					
					
						
					
			
		}
					
					
					
					
					
					
					
			
			
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
			catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
			
		}

	private Double substring(int i) {
		// TODO Auto-generated method stub
		return null;
	}
				

	}

	

