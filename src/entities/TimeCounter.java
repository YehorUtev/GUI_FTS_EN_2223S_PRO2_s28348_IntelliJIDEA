package entities;

public class TimeCounter implements Runnable {
    private int seconds;
    private int minutes;
    private int hours;
    private boolean isRunning;

    public void run() {
        this.isRunning = true;
        seconds = 0;
        minutes = 0;
        hours = 0;
        while (isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            seconds++;
            if(seconds == 60){
                seconds = 0;
                minutes++;
            }
            if(minutes == 60){
                seconds = 0;
                minutes = 0;
                hours++;
            }
            System.out.println(this);
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    }
}
