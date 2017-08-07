package wechat.model;

/**
 * 预约时需要的日期 是否已经被预定
 */
public class Day {
   private boolean dayIsReserved;//日场是否被预约
    private boolean nightIsReserved;//夜场是否被预约
    private int day;//日期

    public boolean getDayIsReserved() {
        return dayIsReserved;
    }

    public void setDayIsReserved(boolean dayIsReserved) {
        this.dayIsReserved = dayIsReserved;
    }

    public boolean getNightIsReserved() {
        return nightIsReserved;
    }

    public void setNightIsReserved(boolean nightIsReserved) {
        this.nightIsReserved = nightIsReserved;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
