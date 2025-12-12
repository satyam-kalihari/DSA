package ARRAYS;

public class TappingRainwater {

    public static void findCapacity(int[] tank){
        int capacity = 0;

        int[] leftWall = findLeftWall(tank);
        int[] rightWall = findRightWall(tank);
        for (int i = 0; i < tank.length; i++) {
            capacity += Math.min(leftWall[i], rightWall[i])-tank[i];
        }

        System.out.println(capacity);
    }
    
    private static int[] findRightWall(int[] tank) {
        int[] rightWall  = new int[tank.length];
        for (int i = 0; i < tank.length; i++) {
            int max = tank[i];
            for (int j = i; j < tank.length; j++) {
                if (max < tank[j]) {
                    max = tank[j];
                }
            }
            rightWall[i] = max;
        }

        return rightWall;
    }

    private static int[] findLeftWall(int[] tank) {
        
        int[] leftWall  = new int[tank.length];
        for (int i = tank.length-1; i >= 0; i--) {
            int max = tank[i];
            for (int j = i; j >= 0; j--) {
                if (max < tank[j]) {
                    max = tank[j];
                }
            }
            leftWall[i] = max;
        }
        return leftWall;
    }

    public static void main(String[] args) {
        int[] tank = {4, 2, 0, 6, 3, 2, 5};
        findCapacity(tank);
    }
}
