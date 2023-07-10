package patterns.builder;

import java.time.LocalDate;
import java.time.LocalTime;

public class HolidayPlanner {
    private LocalTime lunchTime;
    private LocalTime dinnerTime;
    private BusType busType;
    private LocalDate startDate;
    private LocalDate endDate;
    public LocalTime getLunchTime() {
        return lunchTime;
    }
      public LocalTime getDinnerTime() {
        return dinnerTime;
    }

    public BusType getBusType() {
        return busType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }


    @Override
    public String toString() {
        return "HolidayPlanner{" +
                "lunchTime=" + lunchTime +
                ", dinnerTime=" + dinnerTime +
                ", busType=" + busType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static class HolidayPlannerBuilder{
        private HolidayPlanner planner;
        public HolidayPlannerBuilder(){
            planner=new HolidayPlanner();
        }
        public HolidayPlannerBuilder(LocalDate startDate, LocalDate endDate){
            planner=new HolidayPlanner();
            planner.startDate=startDate;
            planner.endDate=endDate;
        }

        public HolidayPlannerBuilder setStartDate(LocalDate startDate) {
            planner.startDate=startDate;
            return this;
        }

        public HolidayPlannerBuilder setEndDate(LocalDate endDate){
            planner.endDate=endDate;
            return this;
        }
        public HolidayPlannerBuilder setLunchTime(LocalTime time){
            planner.lunchTime=time;
            return this;
        }
        public HolidayPlannerBuilder setDinnerTime(LocalTime time){
            planner.dinnerTime=time;
            return this;
        }

        public HolidayPlannerBuilder setBusType(BusType busType){
            planner.busType=busType;
            return this;
        }

        HolidayPlanner build(){
            return planner;
        }

    }

    public static enum BusType{
        REGULAR,
        Deluxe
    }
}
