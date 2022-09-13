package lesson6;

public class Cat extends Animals {
    private static final int maxDistanceForRun = 200;
    private static final int maxDistanceForSwim = 0;
    private static int count;
    public Cat(String name) {
        super(name, "cat");
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
