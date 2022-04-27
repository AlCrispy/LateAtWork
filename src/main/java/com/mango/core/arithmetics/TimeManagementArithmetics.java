package main.java.com.mango.core.arithmetics;

import main.java.com.mango.core.entity.TimeSpace;
import main.java.com.mango.core.entity.WorkTimeResponse;

import java.util.List;

public class TimeManagementArithmetics {

    public WorkTimeResponse performArithmeticsForExactEndWorkTime(String timeWorkStart, String timeLunchStart, String timeLunchEnd) {
        TimeSpace workStart = new TimeSpace(timeWorkStart);
        TimeSpace lunchStart = new TimeSpace(timeLunchStart);
        TimeSpace lunchEnd = new TimeSpace(timeLunchEnd);
        WorkTimeResponse workTimeResponse = calcFinishTime(workStart, lunchStart, lunchEnd);
        return workTimeResponse;
    }

    private WorkTimeResponse calcFinishTime(TimeSpace workStart, TimeSpace lunchStart, TimeSpace lunchEnd) {
        WorkTimeResponse workTimeResponse = new WorkTimeResponse();
        workStart = cornerCaseWorkStart(workStart, workTimeResponse);
        lunchStart = cornerCaseLunchStart(lunchStart, workTimeResponse);
        lunchEnd = cornerCaseLunchEnd(lunchEnd, workTimeResponse);

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


        workTimeResponse.setMorningWorkTime("Morning work time: " + morningWorked);
        workTimeResponse.setRemainingTimeToWork("Time remaining to work: " + timeRemainingToWork);
        workTimeResponse.setWorkUntil("Your working day last until: " + workUntil);

        return workTimeResponse;
    }

    private TimeSpace cornerCaseLunchEnd(TimeSpace lunchEnd, WorkTimeResponse workTimeResponse) {
        if(lunchEnd.getIntMinutes() > 30 && lunchEnd.getIntHours() >= 14) {
            lunchEnd = roundToNearestQuarter(lunchEnd);
            List adjustmentList = workTimeResponse.getAdjustment();
            adjustmentList.add("End of lunch postponed to nearest quarter!");
            workTimeResponse.setAdjustment(adjustmentList);
        }
        return lunchEnd;
    }

    private TimeSpace cornerCaseLunchStart(TimeSpace lunchStart, WorkTimeResponse workTimeResponse) {
        if( lunchStart.getIntHours() < 12 ) {
            lunchStart.setIntHours(12);
            lunchStart.setIntMinutes(0);
            List adjustmentList = workTimeResponse.getAdjustment();
            adjustmentList.add("Start of lunch postponed to 12 o'clock!");
            workTimeResponse.setAdjustment(adjustmentList);
        }
        return lunchStart;
    }

    private TimeSpace cornerCaseWorkStart(TimeSpace workStart, WorkTimeResponse workTimeResponse) {
        if(workStart.getIntMinutes() < 15 && workStart.getIntHours() < 8) {
            workStart.setIntHours(8);
            workStart.setIntMinutes(15);
            List adjustmentList = workTimeResponse.getAdjustment();
            adjustmentList.add("Start of work postponed 8 and a quarter!");
            workTimeResponse.setAdjustment(adjustmentList);
        }
        if (workStart.getIntMinutes() > 30 && workStart.getIntHours() >= 9 || workStart.getIntHours() > 9){
            workStart = roundToNearestQuarter(workStart);
            List adjustmentList = workTimeResponse.getAdjustment();
            adjustmentList.add("Start of work postponed to nearest quarter!");
            workTimeResponse.setAdjustment(adjustmentList);
        }
        return workStart;
    }

    private TimeSpace roundToNearestQuarter(TimeSpace workStart) {
        int intMinutes = workStart.getIntMinutes();
        if(intMinutes <= 15) {
            workStart.setIntMinutes(15);
        } else if (intMinutes <= 30 && intMinutes > 15) {
            workStart.setIntMinutes(30);
        } else if (intMinutes <= 45  && intMinutes > 30) {
            workStart.setIntMinutes(45);
        } else {
            workStart.setIntMinutes(0);
            workStart.setIntHours(workStart.getIntHours() + 1);
        }
        return workStart;
    }
}
