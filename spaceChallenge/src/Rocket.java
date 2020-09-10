public class Rocket implements SpaceShip {
    int cost;
    int rocketWeight;
    int maxWeight;
    public Rocket(int cost, int rocketWeight, int maxWeight){
        this.cost = cost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (maxWeight - (rocketWeight + item.weight) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item item) {
        rocketWeight += item.weight;
    }
}
