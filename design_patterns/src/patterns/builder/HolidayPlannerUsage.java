package patterns.builder;

import java.time.LocalTime;

public class HolidayPlannerUsage {

    public static void main(String[] args) {
        LocalTime lunchTime=LocalTime.of(13,0,0);
        LocalTime dinnerTime=LocalTime.of(20,0,0);
        HolidayPlanner planner=new HolidayPlanner.HolidayPlannerBuilder()
                .setLunchTime(lunchTime)
                .setDinnerTime(dinnerTime)
                .setBusType(HolidayPlanner.BusType.Deluxe)
                .build();
        System.out.println(planner);
    }
}
