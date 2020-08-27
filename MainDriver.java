/*
Language: Java
IDE: Eclipse

Program creates a database of person records using Java. Records
can be deleted, added, viewed, and viewed by age range. A binary
file is used for storage.

*/

import java.util.*;
public class MainDriver {
	
		public static void main(String[] args) {
			String useryes = "y";
			String userno = "n";
			int exit = 0;
			Scanner r1 = new Scanner(System.in);
			String filePath = "records.r"; //Binary file.
			RecordsDatabase C = new RecordsDatabase(); //Add, delete, view, find a record within a range.
			
			//Add some records to the database to start with.
			Person mikede = new Person("Michael DeSanta", new Date(05, 14, 1965), new Date(03, 17, 2017));
			Person frankc = new Person("Franklin Clinton", new Date(03, 15, 1988), null);
			Person trevp = new Person("Trevor Philips", new Date(01, 20, 1965), new Date(01, 20, 2002));
			Person amand = new Person("Amanda DeSanta", new Date(10, 15, 1970), null);
			Person niko = new Person("Niko Bellic", new Date(02, 02, 1978), null);
			Person roman = new Person("Roman Bellic", new Date(10, 10, 1977), new Date(11, 15, 2008));
			C.addanObject(mikede, filePath);
			C.addanObject(frankc, filePath);
			C.addanObject(trevp, filePath);
			C.addanObject(amand, filePath);
			C.addanObject(niko, filePath);
			C.addanObject(roman, filePath);
			
		while(exit != -1) {
			//Ask user what they would like to do.
			System.out.println("\nWould you like to add a record? (y/n): ");
			String userAddMaybe = r1.nextLine();
			if(userAddMaybe.equals(useryes)) { //Add a person's record.
				System.out.println("Enter Name: ");
				String name = r1.nextLine();
				System.out.println("Enter birth date: ");
				Date birthDate = new Date();
				birthDate.readInput();
				Date deathDate = new Date();
				System.out.println("Is there a death date? (y/n)");
				String userIon = r1.nextLine();
					if(userIon.equals(useryes)) {
						deathDate.readInput();
					}
					else if(userIon.equals(userno)) {
						deathDate = null;
					}
				Person newP = new Person(name, birthDate, deathDate);
				C.addanObject(newP, filePath);
			}
			
			System.out.println("Would you like to display a record? (y/n): ");
			String userAddMaybe2 = r1.nextLine();
			if(userAddMaybe2.equals(useryes)) { //View a person's record.
				System.out.println("Enter Name: ");
				String name = r1.nextLine();
				System.out.println("Enter birth date: ");
				Date birthDate = new Date();
				birthDate.readInput();
				Date deathDate = new Date();
				System.out.println("Is there a death date? (y/n)");
				String userIon2 = r1.nextLine();
					if(userIon2.equals(useryes)) {
						deathDate.readInput();
					}
					else if(userIon2.equals(userno)) {
						deathDate = null;
					}
					else {
						System.out.println("ERROR. Bad entry.");
					}
				Person newP2 = new Person(name, birthDate, deathDate);
				C.viewanObject(newP2);
			}
			
			System.out.println("Would you like to delete a record? (y/n): ");
			String userAddMaybe3 = r1.nextLine();
			if(userAddMaybe3.equals(useryes)) { //Delete a record.
				System.out.println("Enter Name: ");
				String name = r1.nextLine();
				System.out.println("Enter birth date: ");
				Date birthDate = new Date();
				birthDate.readInput();
				Date deathDate = new Date();
				System.out.println("Is there a death date? (y/n)");
				String userIon3 = r1.nextLine();
					if(userIon3.equals(useryes)) {
						deathDate.readInput();
					}
					else if(userIon3.equals(userno)) {
						deathDate = null;
					}
					else {
						System.out.println("ERROR. Bad entry.");
					}
				Person newP3 = new Person(name, birthDate, deathDate);
				C.deleteObject(filePath, newP3);
			}
			
			System.out.println("Would you like to locate records within a certain age range? (y/n): ");
			String userAddMaybe4 = r1.nextLine();
			if(userAddMaybe4.equals(useryes)) { //View records within an age range.
				System.out.println("Please enter the current year: ");
				String Cyear = r1.nextLine();
				int currentYear = Integer.parseInt(Cyear);
				
				System.out.println("Enter starting age: ");
				String startA = r1.nextLine();
				int startFinal = Integer.parseInt(startA);
				int endingrangeYear = currentYear - startFinal;
				
				System.out.println("Enter ending age: ");
				String endA = r1.nextLine();
				int endFinal = Integer.parseInt(endA);
				int startingrangeYear = currentYear - endFinal;
				
				
				C.ageRange(startingrangeYear, endingrangeYear);
			}
			
			System.out.println("\nEnter 0 to keep going or -1 to end the program: ");
			String exit1 = r1.nextLine();
			exit = Integer.parseInt(exit1);
				if (exit == -1) {
						r1.close();
				}
		}
		}
}
			
			
