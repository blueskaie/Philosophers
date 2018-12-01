import java.util.ArrayList;
import java.util.concurrent.locks.*;
public class DiningServer{
    ArrayList<Philosopher> m_philosophers = new ArrayList<>();
    public 	Lock lock 		= new ReentrantLock();
    public void initialize(ArrayList<Philosopher> theEnlightened){
    	m_philosophers = theEnlightened;
    }

    public void takeChopsticks(int philIndex){
        lock.lock();
        try {
        	Philosopher cur_philosopher = m_philosophers.get(philIndex);
        	cur_philosopher.state 		= State.HUNGRY;
            displayState(philIndex, "HUNGRY");
            test(philIndex);
    	}catch(Exception e){}
        finally {
            lock.unlock();
        }
    }
  
    public void returnChopsticks(int philIndex){
    	
    	Philosopher cur_philosopher = m_philosophers.get(philIndex);
    	cur_philosopher.state 		= State.THINKING;
    	
        displayState(philIndex, "THINKING");
        test((philIndex + 4) % 5);
        test((philIndex + 1 ) % 5);
    }
 
    public void test(int philIndex){
    	
    	Philosopher cur_philosopher 		= m_philosophers.get(philIndex);
    	Philosopher previous_philosopher	= m_philosophers.get((philIndex + 4) % 5);
    	Philosopher next_philosopher 		= m_philosophers.get((philIndex + 1 ) % 5);
    	
    	boolean Condition = (previous_philosopher.state != State.EATING)&&(cur_philosopher.state == State.HUNGRY)&&(next_philosopher.state != State.EATING);
        if(Condition == true){
        	m_philosophers.get(philIndex).state = State.EATING; 
            displayState(philIndex, "EATING");
        }
    }
    public void displayState(int philID, String msg) {
    	System.out.println("Philosopher " + philID + " is " + msg);
    }
}