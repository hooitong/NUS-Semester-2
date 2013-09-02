/**
 * This class simulates a cafe, letting users order as well as allowing barista to see orders.
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 02/09/13
 * @version 1.0
 */

import java.util.*;

class Espresso {
    // declare constant variables
    private static final int espresso = 1;
    private int orderID;
    private static int nextOrderID = 100;

    // declare default constructor
    public Espresso() {
        this.orderID = Espresso.nextOrderID;
        Espresso.nextOrderID += 10; //increament next id by 10
    }

    // declare getter for espresso class
    public int getEspresso() {
        return espresso;
    }

    // method to print ingredients
    public void showIngredients() {
        System.out.println("Order ID: " + +orderID);
        System.out.println("\tEspresso: " + getEspresso() + "oz");
    }
}

class Latte {
    // declare constant variables
    private static final int espresso = 1;
    private static final int milk = 2;
    private static final int foam = 1;
    private int orderID;
    private static int nextOrderID = 200;

    // declare getter for Latte class
    public int getEspresso() {
        return espresso;
    }

    public int getMilk() {
        return milk;
    }

    public int getFoam() {
        return foam;
    }

    // declare default constructor
    public Latte() {
        this.orderID = Latte.nextOrderID;
        Latte.nextOrderID += 10; // increament next id by 10;
    }

    // method to print ingredients
    public void showIngredients() {
        System.out.println("Order ID: " + +orderID);
        System.out.println("\tEspresso: " + getEspresso() + "oz");
        System.out.println("\tMilk: " + getMilk() + "oz");
        System.out.println("\tFoam: " + getFoam() + "oz");
    }
}

class Cappuccino {
    // declare constant variables
    private static final int espresso = 1;
    private static final int milk = 1;
    private static final int foam = 2;
    private int orderID;
    private static int nextOrderID = 200;

    // declare getter for Cappuccino class
    public int getEspresso() {
        return espresso;
    }

    public int getMilk() {
        return milk;
    }

    public int getFoam() {
        return foam;
    }

    // declare default constructor
    public Cappuccino() {
        this.orderID = Cappuccino.nextOrderID;
        Cappuccino.nextOrderID += 10; // increament next id by 10;
    }

    // method to print ingredients
    public void showIngredients() {
        System.out.println("Order ID: " + +orderID);
        System.out.println("\tEspresso: " + getEspresso() + "oz");
        System.out.println("\tMilk: " + getMilk() + "oz");
        System.out.println("\tFoam: " + getFoam() + "oz");
    }

}

class Custom {
    // declare constant variables
    private final static int espresso = 1;
    private int milk, foam;
    private int orderID;
    private static int nextOrderID = 400;

    // declare getter for Custom class
    public int getEspresso() {
        return espresso;
    }

    public int getMilk() {
        return milk;
    }

    public int getFoam() {
        return foam;
    }

    public int getOrderID() {
        return orderID;
    }

    // declare setter for Custom class
    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setFoam(int foam) {
        this.foam = foam;
    }

    // declare default constructor
    public Custom(int milk, int foam) {
        this.orderID = Custom.nextOrderID;
        Custom.nextOrderID += 10; // increament next id by 10;
        this.milk = milk;
        this.foam = foam;
    }

    // method to print ingredients
    public void showIngredients() {
        System.out.println("Order ID: " + +orderID);
        System.out.println("\tEspresso: " + getEspresso() + "oz");
        System.out.println("\tMilk: " + getMilk() + "oz");
        System.out.println("\tFoam: " + getFoam() + "oz");
    }
}

class Cafe {
    // declare objects array to store orders
    private Espresso espressoOrders[];
    private Latte latteOrders[];
    private Cappuccino cappuccinoOrders[];
    protected Custom customOrders[];

    // declare variables to store initial material
    private int espresso, milk, foam;
    // declare variables to store the numbers of drinks ordered
    private int numDrinksOrdered = 0, numEspressoOrdered = 0;
    private int numLatteOrdered = 0, numCappuccinoOrdered = 0;
    private int numCustomOrdered = 0, maxDrinks = 0;

    // declare constructor
    public Cafe(int espresso, int milk, int foam, int amt) {
        this.espresso = espresso;
        this.milk = milk;
        this.foam = foam;
        this.maxDrinks = amt; // the maximum numbers of drinks

        // create and initialise the order arrays
        espressoOrders = new Espresso[amt];
        latteOrders = new Latte[amt];
        cappuccinoOrders = new Cappuccino[amt];
        customOrders = new Custom[amt];
    }

    // declare getters and setters
    public int getEspresso() {
        return espresso;
    }

    public int getMilk() {
        return milk;
    }

    public int getFoam() {
        return foam;
    }

    // declare setter for Custom class
    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setFoam(int foam) {
        this.foam = foam;
    }

    public boolean order(Espresso e) {
        // check whether the cafe is full already
        if (numDrinksOrdered >= maxDrinks) return false;

        // check if theres necessary ingredients to make
        if (this.espresso < e.getEspresso()) return false;

        // when the line is reached, order can be placed.
        espressoOrders[numEspressoOrdered] = e;

        // remove the ingredients from the cafe
        this.espresso -= e.getEspresso();

        // update all the counters
        numEspressoOrdered++;
        numDrinksOrdered++;

        return true;
    }

    public boolean order(Latte l) {
        // check whether the cafe is full already
        if (numDrinksOrdered >= maxDrinks) return false;

        // check if theres necessary ingredients to make
        if (this.espresso < l.getEspresso() || this.milk < l.getMilk() ||
                this.foam < l.getFoam()) return false;

        // when the line is reached, order can be placed.
        latteOrders[numLatteOrdered] = l;

        // remove ingredients from the cafe
        this.espresso -= l.getEspresso();
        this.milk -= l.getMilk();
        this.foam -= l.getFoam();

        // update all the counters
        numLatteOrdered++;
        numDrinksOrdered++;

        return true;
    }

    public boolean order(Cappuccino c) {
        // check whether the cafe is full already
        if (numDrinksOrdered >= maxDrinks) return false;

        // check if theres necessary ingredients to make
        if (this.espresso < c.getEspresso() || this.milk < c.getMilk() ||
                this.foam < c.getFoam()) return false;

        // when the line is reached, order can be placed.
        cappuccinoOrders[numCappuccinoOrdered] = c;

        // remove ingredients from the cafe
        this.espresso -= c.getEspresso();
        this.milk -= c.getMilk();
        this.foam -= c.getFoam();

        // update all the counters
        numCappuccinoOrdered++;
        numDrinksOrdered++;

        return true;
    }

    public boolean order(Custom c) {
        // check whether the cafe is full already
        if (numDrinksOrdered >= maxDrinks) return false;

        // check if theres necessary ingredients to make
        if (this.espresso < c.getEspresso() || this.milk < c.getMilk() ||
                this.foam < c.getFoam()) return false;

        // when the line is reached, order can be placed.
        customOrders[numCustomOrdered] = c;

        // remove ingredients from the cafe
        this.espresso -= c.getEspresso();
        this.milk -= c.getMilk();
        this.foam -= c.getFoam();

        // update all the counters
        numCustomOrdered++;
        numDrinksOrdered++;

        return true;
    }

    public void showOrders() {
        // print out every order available for espresso
        for (int i = 0; i < numEspressoOrdered; i++) {
            espressoOrders[i].showIngredients();
        }

        // print out every order available for latte
        for (int i = 0; i < numLatteOrdered; i++) {
            latteOrders[i].showIngredients();
        }

        // print out every order available for cappuccino
        for (int i = 0; i < numCappuccinoOrdered; i++) {
            cappuccinoOrders[i].showIngredients();
        }

        // print out every order available for custom orders
        for (int i = 0; i < numCustomOrdered; i++) {
            customOrders[i].showIngredients();
        }
    }
}

class CafeSystem {
    public static int findOrderID(Custom[] orders, int target) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                return -1;
            }
            if (orders[i].getOrderID() == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int userChoice;
        Cafe myCafe = new Cafe(10, 10, 10, 10);

        do {
            System.out.print("Cafe Crayon\n1. Order Espresso\n2. Order Latte" +
                    "\n3. Order Cappuccino\n4. Show Ingredients\n" +
                    "5. Order Custom Drink\n6. Change Custom Drink\n7. Exit\nOption: ");
            userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    if (myCafe.order(new Espresso())) {
                        System.out.println("Espresso ordered!");
                    } else {
                        System.out.println("Either cafe is full or not enough ingredients to make order!");
                    }
                    break;
                case 2:
                    if (myCafe.order(new Latte())) {
                        System.out.println("Latte ordered!");
                    } else {
                        System.out.println("Either cafe is full or not enough ingredients to make order!");
                    }
                    break;
                case 3:
                    if (myCafe.order(new Cappuccino())) {
                        System.out.println("Cappuccino ordered!");
                    } else {
                        System.out.println("Either cafe is full or not enough ingredients to make order!");
                    }
                    break;
                case 4:
                    System.out.println("Dear new barista, here are the current orders:");
                    myCafe.showOrders();
                    break;
                case 5:
                    System.out.println("Please enter the amount of " +
                            " milk and foam seperated by a space. ");
                    int milk = sc.nextInt();
                    int foam = sc.nextInt();
                    if (myCafe.order(new Custom(milk, foam))) {
                        System.out.println("Custom Drink Ordered!");
                    } else {
                        System.out.println("Either cafe is full or not" +
                                " enough ingredients to make order!");
                    }
                    break;
                case 6:
                    // accept custom order ID from user
                    System.out.println("Please enter your order ID: ");
                    int orderID = sc.nextInt();

                    // find the index of the order in the array
                    int customIndex = findOrderID(myCafe.customOrders, orderID);

                    // accept new milk and foam quantity from user
                    System.out.println("Enter the new quantity for " +
                            "milk and foam seperated by a space. ");

                    // check whether there's enough ingredients
                    int newMilk = sc.nextInt();
                    int newFoam = sc.nextInt();
                    if (myCafe.getMilk() < newMilk - myCafe.customOrders[customIndex].getMilk() || myCafe.getFoam() < newFoam - myCafe.customOrders[customIndex].getFoam()) {
                        System.out.println("Not enough milk / foam, order not changed");
                    } else { // pass thru requirements, make changes and update ingredients
                        myCafe.setMilk(myCafe.getMilk() - (newMilk - myCafe.customOrders[customIndex].getMilk()));
                        myCafe.setFoam(myCafe.getFoam() - (newFoam - myCafe.customOrders[customIndex].getFoam()));
                        myCafe.customOrders[customIndex].setMilk(newMilk);
                        myCafe.customOrders[customIndex].setFoam(newFoam);

                        System.out.println("Drink changed.");
                    }
                case 7: // user exits application
                    System.out.println("Bye bye!");
                    break;
            }
        } while (userChoice != 7);
    }
}