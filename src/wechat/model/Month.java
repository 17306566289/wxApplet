package wechat.model;

import java.util.List;

/**
 * 日历显示一个月的数据
 */
public class Month {
    private String blank;//前面有多少空白
    private String pastDayList;//已经过去的日期
    private List<Day> dayList;//日期列表

    public String getPastDayList() {
        return pastDayList;
    }

    public void setPastDayList(String pastDayList) {
        this.pastDayList = pastDayList;
    }

    public String getBlank() {
        return blank;
    }

    public void setBlank(String blank) {
        this.blank = blank;
    }

    public List<Day> getDayList() {
        return dayList;
    }

    public void setDayList(List<Day> dayList) {
        this.dayList = dayList;
    }
}
