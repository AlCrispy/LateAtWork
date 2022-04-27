package main.java.com.mango.core.entity;

public class WorkTimeResponse {
    String morningWorkTime;
    String remainingTimeToWork;
    String workUntil;

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
}
