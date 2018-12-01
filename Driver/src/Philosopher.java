import java.util.Random;
public class Philosopher implements Runnable{
    
	private DiningServer 	m_table;
    private int 			m_id;
    public  State 			state;
 
    public Philosopher (DiningServer table, int ID){
    	m_table	=	table;
    	m_id	=	ID;
    }
    
    public void run(){
        while (true){
            state = State.THINKING;
            Delay();
            state = State.HUNGRY;
            m_table.takeChopsticks(m_id);
            Delay();
            m_table.returnChopsticks(m_id);
        }
    }
    
    public void Delay() {
        try{
            Random wait = new Random();
            int min = 2000, max = 5000;
            int waitNum = wait.nextInt((max - min) + 1) + min;
            Thread.sleep(waitNum);
        }catch (InterruptedException e){}
    }
}
