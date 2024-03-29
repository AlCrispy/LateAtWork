package main.java.com.mango.core.arithmetics;

import main.java.com.mango.core.entity.TimeSpace;
import main.java.com.mango.core.entity.WorkTimeResponse;

import java.util.List;

public class TimeManagementArithmetics {

    public static final int FULL_DAY_HOURS = 8;
    public static final int FULL_MINUTE = 60;
    public static final int ONE_HOUR = 1;
    public static final int TWELVE_O_CLOCK = 12;
    public static final int HALF_AN_HOUR = 30;
    public static final int QUARTER_HOUR = 15;
    private static final int MORNING_EIGHT = 8 ;

    public static final int MORNING_NINE = 9;
    public static final int RESET_MINUTES = 0;

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
        lunchEnd = cornerCaseLunchEnd(lunchStart, lunchEnd, workTimeResponse);

        TimeSpace morningWorked = new TimeSpace();
        morningWorked.setHours("8");
        morningWorked.setMinutes("30");

        int hoursDiff = lunchStart.getIntHours() - workStart.getIntHours();
        int minutesDiff = lunchStart.getIntMinutes() - workStart.getIntMinutes();
        if (minutesDiff < 0) {
            minutesDiff = FULL_MINUTE + minutesDiff;
            hoursDiff -= ONE_HOUR;
        }
        morningWorked.setIntHours(hoursDiff);
        morningWorked.setIntMinutes(minutesDiff);
        System.out.println("Morning work time: " + morningWorked);

        TimeSpace timeRemainingToWork = new TimeSpace();
        hoursDiff = FULL_DAY_HOURS - morningWorked.getIntHours();
        if (morningWorked.getIntMinutes() > 0) {
            minutesDiff = FULL_MINUTE - morningWorked.getIntMinutes();
            hoursDiff -= ONE_HOUR;
        }
        timeRemainingToWork.setIntHours(hoursDiff);
        timeRemainingToWork.setIntMinutes(minutesDiff);
        System.out.println("Time remaining to work: " + timeRemainingToWork);

        TimeSpace workUntil = new TimeSpace();
        hoursDiff = lunchEnd.getIntHours() + timeRemainingToWork.getIntHours();
        minutesDiff = lunchEnd.getIntMinutes() + timeRemainingToWork.getIntMinutes();
        if (minutesDiff >= FULL_MINUTE) {
            minutesDiff -= FULL_MINUTE;
            hoursDiff += ONE_HOUR;
        }
        workUntil.setIntHours(hoursDiff);
        workUntil.setIntMinutes(minutesDiff);
        System.out.println("Work until: " + workUntil);


        workTimeResponse.setMorningWorkTime("Morning work time: " + morningWorked);
        workTimeResponse.setRemainingTimeToWork("Time remaining to work: " + timeRemainingToWork);
        workTimeResponse.setWorkUntil("Your working day last until: " + workUntil);

        return workTimeResponse;
    }

    private TimeSpace cornerCaseLunchEnd(TimeSpace lunchStart, TimeSpace lunchEnd, WorkTimeResponse workTimeResponse) {
        List adjustmentList = workTimeResponse.getAdjustment();
        TimeSpace lunchTime = new TimeSpace();
        lunchTime.setIntMinutes(60 - lunchStart.getIntMinutes() + lunchEnd.getIntMinutes());
        if (lunchLessOfThreeQuarter(lunchTime)) {
            int minutesDifference = 45 - lunchTime.getIntMinutes();
            if (lunchEnd.getIntMinutes() + minutesDifference >= 60){
                lunchEnd.setIntMinutes(lunchEnd.getIntMinutes() + minutesDifference - 60);
                lunchEnd.setIntHours(lunchEnd.getIntHours() + 1);
            }
            lunchEnd.setIntMinutes(lunchEnd.getIntMinutes() + minutesDifference);
            adjustmentList.add("End of lunch postponed to match 45 minutes of lunchtime!");
        }
        if(lunchEnd.getIntMinutes() > HALF_AN_HOUR && lunchEnd.getIntHours() >= 14 || lunchEnd.getIntHours() > 14) {
            lunchEnd = roundToNearestQuarter(lunchEnd);
            adjustmentList.add("End of lunch postponed to nearest quarter!");
        }
        workTimeResponse.setAdjustment(adjustmentList);
        return lunchEnd;
    }

    private boolean lunchLessOfThreeQuarter(TimeSpace lunchTime) {
        if (lunchTime.getIntMinutes() < 45) {
            return true;
        }
        return false;
    }

    private TimeSpace cornerCaseLunchStart(TimeSpace lunchStart, WorkTimeResponse workTimeResponse) {
        if( lunchStart.getIntHours() < TWELVE_O_CLOCK) {
            lunchStart.setIntHours(TWELVE_O_CLOCK);
            lunchStart.setIntMinutes(RESET_MINUTES);
            List adjustmentList = workTimeResponse.getAdjustment();
            adjustmentList.add("Start of lunch postponed to 12 o'clock!");
            workTimeResponse.setAdjustment(adjustmentList);
        }
        return lunchStart;
    }

    private TimeSpace cornerCaseWorkStart(TimeSpace workStart, WorkTimeResponse workTimeResponse) {
        if(workStart.getIntMinutes() < QUARTER_HOUR && workStart.getIntHours() < MORNING_EIGHT) {
            workStart.setIntHours(MORNING_EIGHT);
            workStart.setIntMinutes(QUARTER_HOUR);
            List adjustmentList = workTimeResponse.getAdjustment();
            adjustmentList.add("Start of work postponed 8 and a quarter!");
            workTimeResponse.setAdjustment(adjustmentList);
        }
        if (workStart.getIntMinutes() > HALF_AN_HOUR && workStart.getIntHours() >= MORNING_NINE || workStart.getIntHours() > MORNING_NINE){
            workStart = roundToNearestQuarter(workStart);
            List adjustmentList = workTimeResponse.getAdjustment();
            adjustmentList.add("Start of work postponed to nearest quarter!");
            workTimeResponse.setAdjustment(adjustmentList);
        }
        return workStart;
    }

    private TimeSpace roundToNearestQuarter(TimeSpace workStart) {
        int intMinutes = workStart.getIntMinutes();
        if(intMinutes <= QUARTER_HOUR) {
            workStart.setIntMinutes(QUARTER_HOUR);
        } else if (intMinutes <= HALF_AN_HOUR && intMinutes > QUARTER_HOUR) {
            workStart.setIntMinutes(HALF_AN_HOUR);
        } else if (intMinutes <= 45  && intMinutes > HALF_AN_HOUR) {
            workStart.setIntMinutes(45);
        } else {
            workStart.setIntMinutes(RESET_MINUTES);
            workStart.setIntHours(workStart.getIntHours() + ONE_HOUR);
        }
        return workStart;
    }
}
