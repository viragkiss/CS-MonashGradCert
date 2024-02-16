import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileIO{

	public static void readFile(Room room, String fileName){
		
		ArrayList<Portal> portals = new ArrayList<Portal>();

		try{
			Scanner console = new Scanner(System.in);
            FileReader reader = new FileReader(fileName);
			try{
				Scanner fileInput = new Scanner(reader);
	            int count = 0;
	            while (fileInput.hasNextLine()){
					count++;
	                String[] lineContents = fileInput.nextLine().split(",");
	                String direction = lineContents[0];
					
					// make directions' first letter uppercase if not already uppercase
					String l = lineContents[0].substring(0,1);
					if(Character.isLowerCase(l.charAt(0))){
						direction = l.toUpperCase() + lineContents[0].substring(1);
					}

	                int pOpen = 0; int pExit = 0; int pPolice = 0;
	                try{
	                	pOpen = Integer.parseInt(lineContents[1]);
	                	pExit = Integer.parseInt(lineContents[2]);
	                	pPolice = Integer.parseInt(lineContents[3]);
	                }
	                catch (Exception e){
	                	System.out.println("Error reading porbabilities on line " + count + ". Skipping...");
	                }
	                // try adding portal
	                try{
	                	portals.add(new Portal(direction, pOpen, pExit, pPolice));
	                }
	                catch(Exception e){
	                	System.out.println("Error creating and adding new portal. Check if data is valid and complete.");
	                	// expected error: invalid or incomplete data - ArrayOutOfBounds / NumberFormatException / etc.
	                }
	            }

	            room.setPortals(portals); // add to room
	            //room.display(); // display room to test
	        }
	        finally{
	            try{
	            	reader.close();
	            }
	            catch (Exception e){
	                System.out.println("Error closing file. Exiting...");
	            }
	    	}
	    }
	    catch(Exception e){
	    	System.out.println("Error in reading from file. Exiting...");
	    }
	}

	public static void writeFile(String fileName, Player player, boolean win){

		try{
			PrintWriter writer = new PrintWriter(fileName);
			String outcome = win ? " won " : " lost ";
            String value = player.getName() + outcome + "with " +player.getCoins() + " coin(s) and "+player.getSizeOfInventory()+" cloak(s).";
			writer.println(value);

        	try{
                writer.close();
            }
            catch (Exception e){
                System.out.println("Error in closing file. Exiting...");
            }
        }
		catch (Exception e){
			System.out.println("Error in writing to file. Exiting...");
		}
	}
}
