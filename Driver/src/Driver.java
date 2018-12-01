import java.util.ArrayList;
public class Driver {
    public static void main (String[] args){
    	System.out.println("*****************************************");   
    	System.out.println("******Dining Philosophers Problem*******");
    	System.out.println("*****************************************");

    	DiningServer diningTable 	= new DiningServer();
        ArrayList<Philosopher> list = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
        	Philosopher person = new Philosopher(diningTable, i); 
        	list.add(person);
        }

        diningTable.initialize(list);
        for (Philosopher person: list) {
        	Thread thread = new Thread(person);
        	thread.start();
        }
    }
}