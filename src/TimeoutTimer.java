import java.util.TimerTask;
class TimeoutTimer extends TimerTask 
{
        
        /** Start time in milliseconds. */
        private long startTime = 0; //start value
        /** Number of milliseconds to wait till timeout occurs. */
        private long timeout = 0;
        /** Real timeout which is increased during stop() calls. */
        private long realTimeout = 0;
        /** Time when stop() was called. */
        private long stopTime = 0;
        
        
        /**
         *  Constructor.
         *
         * @param jobThread Thread to observe.
         */
        public TimeoutTimer(long timeout) {
            startTime = System.currentTimeMillis();
            this.timeout = timeout;
            realTimeout = timeout;
        }//JobTimer()
        
        /**
         * Overwrites super.
         */
        public void run() {
            long time = (System.currentTimeMillis() - startTime);
//System.out.println("timer: "+time);
            if (time > realTimeout) 
            { //timoute occured?
//System.out.println("Timeout after "+timeout+" milliseconds.");
                //todo: kill jobThread?
               //cancel(); //stop and quit timer
               
               
            }
        }//run()
    
        /**
         * Stop timeout counting.
         */
        public void stop() {
            stopTime = System.currentTimeMillis();
        }
        
        /**
         * Continue timeout counting.
         */
        public void proceed() {
            realTimeout += System.currentTimeMillis() - stopTime;
        }
        
        public long getTime()
        {
        	return (System.currentTimeMillis() - startTime);
        }
        
        public long getRealTime()
        {
        	return realTimeout;
        }
        
        public void setStartTime()
        {
        	startTime = System.currentTimeMillis();
        	realTimeout = timeout;
        }
    
    }//TimeoutTimer