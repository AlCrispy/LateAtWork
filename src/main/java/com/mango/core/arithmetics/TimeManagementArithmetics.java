package main.java.com.mango.core.arithmetics;

import main.java.com.mango.core.entity.TimeSpace;
import main.java.com.mango.core.entity.WorkTimeResponse;

public class TimeManagementArithmetics {

    public WorkTimeResponse performArithmeticsForExactEndWorkTime(String timeWorkStart, String timeLunchStart, String timeLunchEnd) {
        TimeSpace workStart = new TimeSpace(timeWorkStart);
        TimeSpace lunchStart = new TimeSpace(timeLunchStart);
        TimeSpace lunchEnd = new TimeSpace(timeLunchEnd);
        WorkTimeResponse workTimeResponse = calcFinishTime(workStart, lunchStart, lunchEnd);
        return workTimeResponse;
    }

    private WorkTimeResponse calcFinishTime(TimeSpace workStart, TimeSpace lunchStart, TimeSpace lunchEnd) {
        TimeSpace morningWorked = new TimeSpace();
        morningWorked.setHours("8");
        morningWorked.setMinutes("30");

        int hoursDiff = lunchStart.getIntHours() - workStart.getIntHours();
        int minutesDiff = lunchStart.getIntMinutes() - workStart.getIntMinutes();
        if (minutesDiff < 0) {
            minutesDiff = 60 + minutesDiff;
            hoursDiff -= 1;
        }
        morningWorked.setIntHours(hoursDiff);
        morningWorked.setIntMinutes(minutesDiff);
        System.out.println("Morning work time: " + morningWorked);

        TimeSpace timeRemainingToWork = new TimeSpace();
        hoursDiff = 8 - morningWorked.getIntHours();
        if (morningWorked.getIntMinutes() > 0) {
            minutesDiff = 60 - morningWorked.getIntMinutes();
            hoursDiff -= 1;
        }
        timeRemainingToWork.setIntHours(hoursDiff);
        timeRemainingToWork.setIntMinutes(minutesDiff);
        System.out.println("Time remaining to work: " + timeRemainingToWork);

        TimeSpace workUntil = new TimeSpace();
        hoursDiff = lunchEnd.getIntHours() + timeRemainingToWork.getIntHours();
        minutesDiff = lunchEnd.getIntMinutes() + timeRemainingToWork.getIntMinutes();
        if (minutesDiff >= 60) {
            minutesDiff -= 60;
            hoursDiff += 1;
        }
        workUntil.setIntHours(hoursDiff);
        workUntil.setIntMinutes(minutesDiff);
        System.out.println("Work until: " + workUntil);

        WorkTimeResponse workTimeResponse = new WorkTimeResponse();
        workTimeResponse.setMorningWorkTime("Morning work time: " + morningWorked);
        workTimeResponse.setRemainingTimeToWork("Time remaining to work: " + timeRemainingToWork);
        workTimeResponse.setWorkUntil("Your working day last until: " + workUntil);

        return workTimeResponse;
    }
}
