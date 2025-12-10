

public class BtoD {

    public static void main(String args[]){
        int given = 111;
        int power = 0;
        int deci = 0;

        while(given >0){
            int num = given%10;
            deci += num*(int)Math.pow(2, power);
            power++;
            given /= 10;
        }

        System.out.println(deci);
    }
    
}
