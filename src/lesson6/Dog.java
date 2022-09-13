package lesson6;

public class Dog extends Animals {
    private static final int maxDistanceForRun = 500;
    private static final int maxDistanceForSwim = 10;
    private static int count;

    public Dog(String name) {
        super(name, "dog");
        count++;
    }
    public int getMaxDistanceForRun() {
        return maxDistanceForRun;
    }
    public int getMaxDistanceForSwim() {
        return maxDistanceForSwim;
    }

    public int getCount() {
        return count;
    }
}
