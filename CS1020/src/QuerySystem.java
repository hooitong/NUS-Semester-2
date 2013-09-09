/**
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 06/09/13
 * @version 1.0
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to handle the main application of the
 * program as well as processing queries from Acer
 */
public class QuerySystem {
    // stores all the airlines in the system
    private ArrayList<Airline> airlines = new ArrayList<Airline>();

    /**
     * This method will be used to handle all the querying and input from the user
     */
    public static void main(String[] args) {
        // create Scanner object
        Scanner sc = new Scanner(System.in);

        // create new QuerySystem object and initialise it from the user's input
        QuerySystem AcerSystem = new QuerySystem(sc);

        // once the data has been filled up by the user, proceed to handle incoming requests
        AcerSystem.handleQuery(sc);

        // when all is done, close application
        System.exit(0);
    }

    /**
     * Declare constructor and perform initialization from user inside
     *
     * @param sc Scanner object
     * @pre inputs >= 0
     */
    public QuerySystem(Scanner sc) {
        // read the number of inputs from user
        int inputs = sc.nextInt();
        while (inputs != 0) {
            // accept user token for the required parameters to create a new airline
            airlines.add(new Airline(sc.next(), sc.next(), new SGTime(sc.next()), sc.nextInt(), new SGTime(sc.next()), sc.nextInt()));
            inputs--; // decrement the iteration when its done.
        }
    }

    /**
     * This method is used to handle all the query from Acer
     * there are four types of query where type 1 - earliest departure time
     * type 2 - earliest arrival time, type 3 - shortest flight time
     * type 4 - lowest cost
     *
     * @param sc Scanner object
     * @pre there is at least one match for each query
     */
    public void handleQuery(Scanner sc) {
        // ask for the number of iterations this loop will run
        int iteration = sc.nextInt();
        while (iteration != 0) {

            // get user's query information
            int query = sc.nextInt();
            String origin = sc.next();
            String destination = sc.next();
            SGTime time = new SGTime(sc.next()); // the current time

            Airline result = null;
            // based on query type
            switch (query) {
                case 1: // earliest departure time
                    result = checkDeparture(time, origin, destination);
                    break;
                case 2: // earliest arrival time
                    result = checkArrival(time, origin, destination);
                    break;
                case 3: // shortest flight time
                    result = checkShortest(origin, destination);
                    break;
                case 4: // lowest cost
                    result = checkLowest(origin, destination);
                    break;
            }

            iteration--;

            // print out the summary of the resultant
            System.out.println(result.toString());
        }
    }

    /**
     * Check the earliest departure time given the origin
     * destination and given time
     *
     * @param currentTime the earliest time given by the user
     * @param origin      the origin city of the airline
     * @param destination the destination city of the airline
     * @return Airline the airline with the earliest departure time
     * @pre: currentTime must be a valid time, there must be 1 result for each query
     */

    public Airline checkDeparture(SGTime currentTime, String origin, String destination) {
        // create references to keep track on the lowest
        Airline refToLowest = null;
        int departureDay = 0; // determine which day person is able to fly

        // match the origin and destination cities for each airline
        for (Airline a : airlines) {
            if (a.getFromCity().equals(origin) && a.getToCity().equals(destination)) {
                if (refToLowest == null) {
                    refToLowest = a;
                    departureDay = currentTime.isEligible(a.getDepartureTime());

                } // if its the first airline
                // if the time is earlier then lowest and is more than currentTime
                else {
                    if ((a.getDepartureTime().isEarlier(refToLowest.getDepartureTime())
                            && (departureDay == currentTime.isEligible(a.getDepartureTime()))) || (departureDay > currentTime.isEligible(a.getDepartureTime()))) {
                        refToLowest = a;
                        departureDay = currentTime.isEligible(a.getDepartureTime());
                    }
                }
            }
        }
        // return the airline with the earliest departure time
        return refToLowest;
    }

    /**
     * Check the earliest arrival time given the origin
     * destination and given time
     *
     * @param currentTime the earliest time given by the user
     * @param origin      the origin city of the airline
     * @param destination the destination city of the airline
     * @return Airline the airline with the earliest arrival time
     * @pre: currentTime must be a valid time, there must be 1 result for each query
     */
    public Airline checkArrival(SGTime currentTime, String origin, String destination) {
        // create references to keep track on the lowest
        Airline refToLowest = null;
        int arrivalDayRef = 0; // as there is a possibility that the user takes the next flight
        // the day he arrives will be modified accordingly as well

        // match the origin and destination cities for each airline
        for (Airline a : airlines) {
            if (a.getFromCity().equals(origin) && a.getToCity().equals(destination)) {
                if (refToLowest == null) {
                    // assign it as the lowest and record the arrival day
                    refToLowest = a;
                    arrivalDayRef = refToLowest.getArrivalDay() + currentTime.isEligible(refToLowest.getDepartureTime());
                } // if its the first airline
                // if time earlier then previous arrival time and departure time must be after current time
                else if (((a.getArrivalTime().isEarlier(refToLowest.getArrivalTime()) && a.getArrivalDay() + currentTime.isEligible(a.getDepartureTime()) == arrivalDayRef)) || a.getArrivalDay() + currentTime.isEligible(a.getDepartureTime()) < arrivalDayRef) {
                    refToLowest = a;
                    arrivalDayRef = a.getArrivalDay() + currentTime.isEligible(a.getDepartureTime());
                }
            }
        }

        // return the airline with the earliest arrival time
        return refToLowest;
    }

    /**
     * Check the shortest flight time given the origin
     * destination and given time
     *
     * @param origin      the origin city of the airline
     * @param destination the destination city of the airline
     * @return Airline the airline with the shortest flight time
     * @pre: currentTime must be a valid time, there must be 1 result for each query
     */
    public Airline checkShortest(String origin, String destination) {
        // create references to keep track on the lowest
        Airline refToLowest = null;

        // match the origin and destination cities for each airline
        for (Airline a : airlines) {
            if (a.getFromCity().equals(origin) && a.getToCity().equals(destination)) {
                if (refToLowest == null) {   // if its the first airline
                    refToLowest = a;
                }
                // if flight time (arrival time - destination time) is less than refToLowest and departure time must be after current time
                else if (a.getDepartureTime().getDuration(a.getArrivalTime(), a.getArrivalDay()) < refToLowest.getDepartureTime().getDuration(refToLowest.getArrivalTime(), refToLowest.getArrivalDay())) {
                    refToLowest = a;
                }
            }
        }

        // return the shortest duration airline
        return refToLowest;
    }

    /**
     * Check the lowest cost given the origin destination and given time
     *
     * @param origin      the origin city of the airline
     * @param destination the destination city of the airline
     * @return Airline the airline with the lowest cost
     * @pre: currentTime must be a valid time, there must be 1 result for each query
     */
    public Airline checkLowest(String origin, String destination) {
        // create references to keep track on the lowest
        int lowestCost = -1;
        Airline refToLowest = null;
        // match the origin and destination cities for each airline
        for (Airline a : airlines) {
            if (a.getFromCity().equals(origin) && a.getToCity().equals(destination)) {
                if (lowestCost == -1) { // this means this is the first one checked
                    lowestCost = a.getCost();
                    refToLowest = a;
                } else if (a.getCost() < lowestCost) { // if this airline is cheaper then the previous
                    lowestCost = a.getCost();
                    refToLowest = a;
                }
            }
        }

        // return the cheapest airline
        return refToLowest;
    }
}

/**
 * This class stores the information of each airline
 * like storing origin, destination, departure, cost, etc
 */
class Airline {
    // declare the necessary variables of the class
    private String fromCity;
    private String toCity;
    private SGTime departureTime;
    private int arrivalDay;
    private SGTime arrivalTime;
    private int cost;

    // declare and construct constructor
    public Airline(String fromCity, String toCity, SGTime departureTime, int arrivalDay, SGTime arrivalTime, int cost) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureTime = departureTime;
        this.arrivalDay = arrivalDay;
        this.arrivalTime = arrivalTime;
        this.cost = cost;
    }

    // declare getters for the class
    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public SGTime getDepartureTime() {
        return departureTime;
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    public SGTime getArrivalTime() {
        return arrivalTime;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return fromCity + " " + toCity + " " + departureTime.toString() + " " + arrivalDay
                + " " + arrivalTime.toString() + " " + cost;
    }
}

/**
 * This class manages simple time in hour and minute format for simplicity purpose
 */
class SGTime {
    private int minutes; // this is the main unit for the class and for simplicity only the minutes is stored

    // declare and construct constructor
    public SGTime(String time) {
        String[] timeArray = time.split(":");
        minutes = (Integer.parseInt(timeArray[0]) * 60) + Integer.parseInt(timeArray[1]);
    }

    // declare getters for the class
    public int getHour() {
        return minutes / 60;
    }

    public int getRawMinutes() {
        return minutes;
    }

    public int getMinutes() {
        return minutes % 60;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00");
        return getHour() + ":" + df.format(getMinutes());
    }

    /**
     * This method is used to check whether the time is earlier than the given object's time
     * only applies if its on the same day.
     *
     * @param time the comparison time object
     * @return if true, the current object time is earlier than the argument
     */
    public boolean isEarlier(SGTime time) {
        return this.minutes < time.getRawMinutes();
    }

    /**
     * Allow user to check whether which day will he be able to catch that flight
     *
     * @param time the airline's departure time
     * @return the day that he is able to take the next flight
     */
    public int isEligible(SGTime time) {
        if (this.minutes + 60 <= time.getRawMinutes()) return 0; // if time is 1 hour earlier than departure
        else if (this.minutes + 60 >= 1440) { // if the possible departure time is extended to the next day
            if ((this.minutes + 60) % 1440 > time.getRawMinutes()) return 2; // if he misses due to the 1hr problem
            else return 1; // he is able to take the next day's flight
        } else return 1; // if time does not pass over 24 hours
    }

    /**
     * Get the duration of the flight given the arrival time and the arrival day
     *
     * @param arrivalTime the time the flight arrive
     * @param arrivalDay  the day the flight arrive 1 = next day , 2 = day after
     * @return int the number of minutes the flight takes
     */
    public int getDuration(SGTime arrivalTime, int arrivalDay) {
        // get the number of minutes of the flight time
        if (arrivalDay == 0) {
            return arrivalTime.getRawMinutes() - getRawMinutes();
        } else {
            return (24 * 60) - getRawMinutes() + arrivalTime.getRawMinutes() + (24 * 60 * (arrivalDay - 1));
        }
    }
}