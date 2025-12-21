package Recursion;

public class Xtothepowern {
    
    public static int xToThePowerN(int x, int n){

        if(n == 0){
            return -1;
        }

        int halfPower = xToThePowerN(x, n/2);
        int halfPowerSqr = halfPower*halfPower;

        if (n%2 != 0) {
            halfPowerSqr = x*halfPowerSqr;
        }

        return halfPowerSqr;
    }

    public static void main(String[] args) {
        System.out.println(xToThePowerN(2, 5));
    }
}
