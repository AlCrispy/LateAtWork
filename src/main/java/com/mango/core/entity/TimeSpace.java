package main.java.com.mango.core.entity;

public class TimeSpace {

    String hours;
    String minutes;
    int intHours;
    int intMinutes;

    public TimeSpace() {
        hours = "00";
        minutes = "00";
        intHours = 0;
        intMinutes = 0;
    }

    public TimeSpace(String time) {
        String[] timeArray = time.split(":|\\.|,");
        setIntHours(Integer.parseInt(timeArray[0]));
        setIntMinutes(Integer.parseInt(timeArray[1]));
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        if(hours.length() == 1 && Integer.parseInt(hours) < 10){
            hours = "0" + hours;
        }
        this.hours = hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        if(minutes.length() == 1 && Integer.parseInt(minutes) < 10){
            minutes = "0" + minutes;
        }
        this.minutes = minutes;
    }

    public int getIntHours() {
        return intHours;
    }

    public void setIntHours(int intHours) {
        setHours(String.valueOf(intHours));
        this.intHours = intHours;
    }

    public int getIntMinutes() {
        return intMinutes;
    }

    public void setIntMinutes(int intMinutes) {
        setMinutes(String.valueOf(intMinutes));
        this.intMinutes = intMinutes;
    }
}
