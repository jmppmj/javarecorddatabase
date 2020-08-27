import java.io.*;

public class RecordsDatabase implements Serializable {
	private int size = 1000;
	private int y = 0;
	private int x = 0;
	Person[] personObjects = new Person[size]; //Array holds 1000 records.
	
	public RecordsDatabase() {
	}

	//Add a person object.
	public void addanObject(Person personToAdd, String path) {
        try{
        	FileOutputStream f_out = new FileOutputStream(path); //Write a new object to output stream.
        	ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
        	obj_out.writeObject(personToAdd);
			for (x = 0; x < size; x++) {
				if(personObjects[x] == null) {
					personObjects[x] = personToAdd;
					break;
				}
			}
			obj_out.close();
        }
     	catch (FileNotFoundException e) {
        	System.out.println("No file found.");
     	}
     	catch (IOException e) {
        	System.out.println("I/O issue.");
     	}
        System.out.println("Add complete. " + personToAdd.toString()); 
	}
	
	//Display a person object.
	public void viewanObject(Person personToView) {
        for(Person personT : personObjects){
            if(personT.equals(personToView)){
               System.out.println("Located: " + personT.toString());
               break;
            }
        }
	}
	
	//Delete a person object.
	public void deleteObject(String path1, Person persontoDelete) {
		Person replace1 = new Person();
		Person[] personObjectstemp = new Person[size];
		try {
			FileOutputStream f_out = new FileOutputStream(path1); //Write output stream without the deleted object.
			ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
			for(y = 0; y < size; y++) {
				if(personObjects[y] != null) {
					replace1 = personObjects[y];
					if (!replace1.equals(persontoDelete)) {
						obj_out.writeObject(replace1);
						personObjectstemp[y] = replace1;
					}
				}
			}
			personObjects = personObjectstemp;
			System.out.println("Sucessfully deleted: " + persontoDelete.toString());
			obj_out.close();
		}	
     	catch (FileNotFoundException e) {
        	System.out.println("No file found.");
     	}
     	catch (IOException e) {
        	System.out.println("I/O issue.");
     	}
	}
	
	//Find records within an age range (includes dead people).
	public void ageRange(int rangestart, int rangeend) {
		System.out.println("Records in range " + rangestart + " to " + rangeend + " include: ");
		for(y = 0; y < size; y++) {
			if(personObjects[y] != null) {
				Person testP = personObjects[y];
				Date firstt = testP.getBirthDate();
				int testyear = firstt.getYear();
				if ((testyear >= rangestart) && (testyear <= rangeend)) {
					System.out.println(testP.toString());
				}
			}
		}
	}
}


