import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        // write your code here
        Simulation sim1 = new Simulation("phase-1.txt");
        ArrayList<U1> rockets1 = sim1.loadU1();
        System.out.println("For rocket U1");
        for(int i = 0; i < 10; i++){
            System.out.println(sim1.runSimulationU1(rockets1));
        }
        ArrayList<U2> rockets2 = sim1.loadU2();
        System.out.println("For rocket U2");
        for(int i = 0; i < 10; i++){
            System.out.println(sim1.runSimulationU2(rockets2));
        }

    }
}
class Item {
    String name;
    int weight;
    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
}

class U1 extends Rocket{
    U1(int cost, int rocketWeight, int maxWeight) {
        super(cost, rocketWeight, maxWeight);
    }

    @Override
    public boolean launch(){
        if(Math.random() < (20*((float)rocketWeight/(float)maxWeight))/100) {
            return true;
        }
        return false;
    }

    @Override
    public boolean land() {
        if(Math.random() < (20*((float)rocketWeight/(float)maxWeight))/100) {
            return true;
        }
        return false;
    }
}
class U2 extends Rocket{
    U2(int cost, int rocketWeight, int maxWeight) {
        super(cost, rocketWeight, maxWeight);
    }

    @Override
    public boolean launch(){
        if(Math.random() < (20*((float)rocketWeight/(float)maxWeight))/100)
            return true;
        return false;
    }

    @Override
    public boolean land() {
        if(Math.random() < (20*((float)rocketWeight/(float)maxWeight))/100)
            return true;
        return false;
    }
}
class Simulation{
    String txtFile;
    Simulation(String s) {
        this.txtFile = s;
    }
    private ArrayList<Item> loadItems() throws Exception{
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(txtFile);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String[] line = scanner.nextLine().split("=");
            Item item = new Item(line[0], Integer.parseInt(line[1]));
            items.add(item);
        }
       return items;
    }
    public ArrayList<U1> loadU1() throws Exception{
        ArrayList<Item> items = loadItems();
        ArrayList<U1> rockets = new ArrayList<>();
        U1 rocket = new U1(100, 10000, 18000);
        for(Item item : items){
            if (rocket.canCarry(item)){
                rocket.carry(item);
            }
            else {
                rockets.add(rocket);
                rocket = new U1(100, 10000, 18000);
            }
        }
        return rockets;
    }
    public ArrayList<U2> loadU2() throws Exception{
        ArrayList<Item> items = loadItems();
        ArrayList<U2> rockets = new ArrayList<>();
        U2 rocket = new U2(120, 18000, 29000);
        for(Item item : items){
            if (rocket.canCarry(item)){
                rocket.carry(item);
            }
            else {
                rockets.add(rocket);
                rocket = new U2(120, 10000, 18000);
            }
        }
        return rockets;
    }
    public int runSimulationU1(ArrayList<U1> rockets){
        int totalCost = 0;
        for(U1 rocket : rockets){
            while(crash(rocket)){
                totalCost += rocket.cost;
            }
            totalCost += rocket.cost;
        }
        return totalCost;
    }
    public int runSimulationU2(ArrayList<U2> rockets){
        int totalCost = 0;
        for(U2 rocket : rockets){
            while(crash(rocket)){
                totalCost += rocket.cost;
            }
            totalCost += rocket.cost;
        }
        return totalCost;
    }
     
    private boolean crash(Rocket rocket){
        if((rocket.launch()) || (rocket.land())){
            return true;
        }
        return false;
    }
}