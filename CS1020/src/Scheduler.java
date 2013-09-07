/**
 * This program stores the timetable of a person and allows
 * the user to add schedules and check the number of schedules on the day
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 06/09/13
 * @version 1.0
 */

import java.util.*;

class Schedule {
    // declare the attributes
    private String day;
    private int startTime, endTime;

    // declare the constructor
    public Schedule(String day, int startTime, int endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Check whether this schedule clash with another schedule
     *
     * @param otherSchedule the other schedule object
     * @return boolean if true, there's a conflict in schedule
     */
    public boolean clashWith(Schedule otherSchedule) {
        // if this schedule starts after the other schedule ends or vice versa, means no clash
        if (this.day.equals(otherSchedule.day)) {
            return !(this.startTime >= otherSchedule.endTime || otherSchedule.startTime >= this.endTime);
        }
        // if different day, return false
        return false;
    }

    // declare and construct getters
    public String getDay() {
        return day;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}

class Module {
    // declare the attributes
    private String code;
    private Schedule lectureSchedule, tutorialSchedule, labSchedule;
    private ArrayList<Schedule> moduleSchedule = new ArrayList<Schedule>();

    // declare the constructor
    public Module(String code, Schedule lectureSchedule, Schedule tutorialSchedule, Schedule labSchedule) {
        this.code = code;

        this.lectureSchedule = lectureSchedule;
        this.tutorialSchedule = tutorialSchedule;
        this.labSchedule = labSchedule;

        // add all the schedule into the arraylist
        moduleSchedule.add(lectureSchedule);
        moduleSchedule.add(tutorialSchedule);
        moduleSchedule.add(labSchedule);
    }

    /**
     * To count number of classes(lecture, tutorial, and lab of only this Module) on day.
     * For example: when day = "Monday", lecture is on Monday, tutorial is on Monday
     * but lab is on Tuesday, then return 2. (lecture and tutorial are on Monday).
     *
     * @param day the day that the user is interested in
     * @return the number of classes on the given day
     */
    public int count(String day) {
        int classCount = 0; // keep track of the number of class on that day

        // if there's a schedule on that day, increase count
        for (Schedule schedule : moduleSchedule) {
            if (schedule.getDay().equals(day)) classCount++;
        }

        return classCount;
    }

    /**
     * This is used to check whether this module clashes with another module
     *
     * @param otherModule the module that we are comparing with
     * @return boolean if true, it means there a clash in module
     */
    public boolean clashWith(Module otherModule) {
        // nested for loop to check each schedule in the module with the other module
        for (Schedule current : this.moduleSchedule) {
            for (Schedule other : otherModule.returnSchedules()) {
                if (current.clashWith(other)) return true; // if there's a clash, return true
            }
        }

        return false; // if managed to loop through everything, return false
    }

    // declare and construct getters
    public String getCode() {
        return code;
    }

    public ArrayList<Schedule> returnSchedules() {
        return moduleSchedule;
    }
}

class Timetable {
    // declare the attributes
    ArrayList<Module> modules = new ArrayList<Module>();

    /**
     * checkClash: to check whether otherModule clash with one of
     * the modules in our timetable list.
     *
     * @param otherModule the module that is used to check
     * @return boolean if true, there's a conflict between this and the rest in time table
     */
    public boolean checkClash(Module otherModule) {
        for (Module m : modules) {
            if (otherModule.clashWith(m)) return true;
        }

        return false;
    }

    /**
     * Add modules to the timetable, if success return true
     * else return false
     *
     * @param module the object to add into timetable
     * @return boolean if true, the module has been successfully added
     * @pre module must not be null
     */
    public boolean add(Module module) {
        // first check whether does it clash with other modules
        if (!checkClash(module)) { // if does not clash with any modules
            modules.add(module);
            return true; // the module has been successfully added
        } else {
            return false;
        } // module has clashed
    }

    /**
     * To count the number of classes on that day
     *
     * @param day the day in string format
     * @return int the number of classes on that day
     */
    public int count(String day) {
        int total = 0; // create counter to keep track of the total amount of lesson on that day

        // loop through each module in the timetable
        for (Module m : modules) {
            total += m.count(day); // add the returned number of classes on that day to the total
        }

        return total; // return the total
    }
}

public class Scheduler {

    public static void main(String[] args) {
        // this method will handle all the I/O from the user and call the appropriate methods
        // declare the necessary variables
        Scanner sc = new Scanner(System.in);
        Timetable table = new Timetable();

        // read the user input
        int iteration = sc.nextInt();
        while (iteration != 0) {
            // read the user's operation
            String operation = sc.next();

            if (operation.equals("MODULE")) {
                // accept the module code from the user
                String code = sc.next();
                // get information on all 3 lesson
                Schedule lecture = new Schedule(sc.next(), sc.nextInt(), sc.nextInt());
                Schedule tutorial = new Schedule(sc.next(), sc.nextInt(), sc.nextInt());
                Schedule lab = new Schedule(sc.next(), sc.nextInt(), sc.nextInt());
                // create new module object with given information
                Module m = new Module(code, lecture, tutorial, lab);

                // check whether this module clashes with any in the current timetable
                if (table.add(m)) {
                    System.out.println("Added");
                } else {
                    System.out.println("Clashed");
                }
            } else if (operation.equals("COUNT")) {
                // get the day the person is interested in
                String day = sc.next();

                // check how many classes are there on that day and print
                System.out.println(table.count(day));
            }

            iteration--;
        }

    }
}