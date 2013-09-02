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

    // declare getter for latte class
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

class Cuppuccino {
    // declare constant variables
    private static final int espresso = 1;
    private static final int milk = 1;
    private static final int foam = 2;
    private int orderID;
    private static int nextOrderID = 200;

    // declare getter for latte class
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
    public Cuppuccino() {
        this.orderID = Cuppuccino.nextOrderID;
        Cuppuccino.nextOrderID += 10; // increament next id by 10;
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
    private Cuppuccino cuppuccinoOrders[];
    protected Custom customOrders[];

    // declare variables to store initial material
    private int espresso, milk, foam;
    // declare variables to store the numbers of drinks ordered
    private int numDrinksOrdered = 0, numEspressoOrdered = 0;
    private int numLatteOrdered = 0, numCuppuccinoOrdered = 0;
    private int numCustomOrdered = 0, maxDrinks = 0;

    public Cafe(int espresso, int milk, int foam, int amt) {
        this.espresso = espresso;
        this.milk = milk;
        this.foam = foam;
        this.maxDrinks = amt; // the maximum numbers of drinks

        // create and initialise the order arrays
        espressoOrders = new Espresso[amt];
        latteOrders = new Latte[amt];
        cuppuccinoOrders = new Cuppuccino[amt];
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

    public boolean order(Cuppuccino c) {
        // check whether the cafe is full already
        if (numDrinksOrdered >= maxDrinks) return false;

        // check if theres necessary ingredients to make
        if (this.espresso < c.getEspresso() || this.milk < c.getMilk() ||
                this.foam < c.getFoam()) return false;

        // when the line is reached, order can be placed.
        cuppuccinoOrders[numCuppuccinoOrdered] = c;

        // remove ingredients from the cafe
        this.espresso -= c.getEspresso();
        this.milk -= c.getMilk();
        this.foam -= c.getFoam();

        // update all the counters
        numCuppuccinoOrdered++;
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

        // print out every order available for cuppuccino
        for (int i = 0; i < numCuppuccinoOrdered; i++) {
            cuppuccinoOrders[i].showIngredients();
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
        Cafe myCafe = new Cafe(10, 10, 10, 10);        //10 is just an example

        do {
            System.out.print("Choose 1. Order Espresso, 2. Order Latte" +
                    "3. Order Cuppuccino, 4. Show Ingredients, 5. Exit ->," +
                    " 6. Custom Drink, 7. Change Custom");
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
                    if (myCafe.order(new Cuppuccino())) {
                        System.out.println("Cuppuccino ordered!");
                    } else {
                        System.out.println("Either cafe is full or not enough ingredients to make order!");
                    }
                    break;
                case 4:
                    System.out.println("Dear new barista, here are the current orders:");
                    myCafe.showOrders();
                    break;
                case 5:
                    System.out.println("Bye bye!");
                    break;
                case 6:
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
                case 7:
                    System.out.println("Please enter your order ID: ");
                    int orderID = sc.nextInt();
                    int customIndex = findOrderID(myCafe.customOrders, +
                            orderID);
                    System.out.println("Enter the new quantity for " +
                            "milk and foam seperated by a space. ");
                    myCafe.customOrders[customIndex].setMilk(sc.nextInt());
                    myCafe.customOrders[customIndex].setFoam(sc.nextInt());
                    System.out.println("Drink changed.");
            }
        } while (userChoice != 5);
    }
}