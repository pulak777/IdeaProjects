public class Rocket implements SpaceShip {
    int cost;
    int rocketWeight;
    int maxWeight;
    Rocket(int cost, int rocketWeight, int maxWeight){
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
        if (rocketWeight + item.weight < maxWeight) {
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item item) {
        rocketWeight += item.weight;
    }
}
