package Schedule;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Trieda sa využíva ako úložisko času vloženého na vstupe pre daného zákazníka.
 */
public class TimeRange {
    private int startTime;
    private int endTime;

    public TimeRange(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return (endTime-startTime)*60;
    }
}
