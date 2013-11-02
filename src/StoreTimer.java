import java.util.Timer;
import java.util.TimerTask;

public class StoreTimer{
    private final Timer timer;

    public StoreTimer() 
    {
    	timer = new Timer();
    }

    public void addTask(TimerTask t, long delay, long period) 
    {
        timer.schedule(t, delay, period);
    }
    
    public void addTask(TimerTask t, long delay) 
    {
        timer.schedule(t, delay);
    }
    
    public void cancel(TimerTask t)
    {
    	t.cancel();
    }
    
    public void removeTasks()
    {
    	timer.purge();
    }

}
