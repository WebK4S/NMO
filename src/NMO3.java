/*
* import java.util.Random;

public class Sol {
    Double mi = 0.0;
    Double sigma = 0.51;
    Random random = new Random();
    int counter = 0;
    static int size =10;
    /*public Double func(Double[] x){
        int length = x.length;
        Double sum = 0.0;
        for (int i=0; i<length; i++){
            sum+=x[i]*x[i];
        }
        return sum;
    }*//*
public void mutacja(Double[] x){
        int length = x.length;
        for (int i=0; i<length; i++) {
        x[i] = x[i] + mi + sigma * random.nextGaussian();
        }
        }

public Double prog(Double fx, Double fy, Double temp){
        return Math.exp((fx - fy)/temp );

        }
public Double f(Double[] x) {
        double sum1 = 0.0;
        double sum2 = 0.0;

        for (int i = 0 ; i < x.length ; i ++) {
        sum1 += Math.pow(x[i], 2);
        sum2 += (Math.cos(2*Math.PI*x[i]));

        }
        counter++;
        return -20.0*Math.exp(-0.2*Math.sqrt(sum1 / ((double )x.length))) + 20
        - Math.exp(sum2 /((double )x.length)) + Math.exp(1.0);
        }

public static void main(String[] args){
        Double temp = 0.001;
        Random random = new Random();
        Sol sol = new Sol();
        //Double x = -10.0 + 20.0 * random.nextDouble();
        Double[] x =new Double[size];
        for (int k=0; k<x.length; k++){
        //x[k] = -10.0 + 20.0 * random.nextDouble();
        x[k] = 10.0;
        }
        Double[] y = new Double[size];

        int i = 0;
        Double z= 0.0;
        Double sum = 0.0;
        for(int j=0; j<100;j++) {
        sol.counter = 0;
        for (int k=0; k<x.length; k++){
        x[k] = -10.0 + 20.0 * random.nextDouble();
        }
        //System.out.println(sol.f(x));
        //TODO zmiana temperatury (for z 1 -> 0.001) size 10 wmiarów
        i=0;

        for ( temp =0.001 ; temp<1; temp+= 0.1) {
        sum+=z;
        z=0.0;
        while (i < 100) {
        System.arraycopy(x, 0, y, 0, x.length);
        sol.mutacja(y);
        if (sol.f(x) > sol.f(y)) {
        System.arraycopy(y, 0, x, 0, x.length);
        } else {
        System.out.println("Prog" + sol.prog(sol.f(x), sol.f(y), temp));
        if (sol.prog(sol.f(x), sol.f(y), temp) > random.nextGaussian()) {
        System.arraycopy(y, 0, x, 0, x.length);
        }
        }
        i++;
        }
        }
        // System.out.println("Counter  = " + sol.counter);
        System.out.println(sol.f(x));
        sum+=sol.f(x);

        }
        System.out.println(sum);
        }
        }*/