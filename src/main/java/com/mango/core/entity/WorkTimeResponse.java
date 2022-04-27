package main.java.com.mango.core.entity;

import java.util.LinkedList;
import java.util.List;

public class WorkTimeResponse {
    String morningWorkTime;
    String remainingTimeToWork;
    String workUntil;

    List adjustment = new LinkedList();

    public String getMorningWorkTime() {
        return morningWorkTime;
    }

    public void setMorningWorkTime(String morningWorkTime) {
        this.morningWorkTime = morningWorkTime;
    }

    public String getRemainingTimeToWork() {
        return remainingTimeToWork;
    }

    public void setRemainingTimeToWork(String remainingTimeToWork) {
        this.remainingTimeToWork = remainingTimeToWork;
    }

    public String getWorkUntil() {
        return workUntil;
    }

    public void setWorkUntil(String workUntil) {
        this.workUntil = workUntil;
    }

    public List getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(List adjustment) {
        this.adjustment = adjustment;
    }
}
