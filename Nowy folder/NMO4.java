/*import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*class comp implements Comparator<? extends Osobnik>{

    @Override
    public double compare(Osobnik o1, Osobnik o2) {

    }
}*/

/*public class NMO4 {
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
    }*/
   /* public void mutacja(Double[] x){
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
/*
    public static void main(String[] args){
        int i = 0;
        //Double z= 0.0;
        //Double sum = 0.0;
        int pop = 10;
        List<Osobnik> P = new ArrayList<>();
        Double[] y = new Double[size];
        Double temp = 0.001;
        Random random = new Random();
        Sol sol = new Sol();
        //Double x = -10.0 + 20.0 * random.nextDouble();
        for(i = 0; i < pop; ++i) {
            Osobnik os = new Osobnik(size);
            //Double[] x = new Double[size];
            for (int k = 0; k < size; k++) {
                os.x[k] = -10.0 + 20.0 * random.nextDouble();
                //x[k] = 10.0;
            }
            os.wynik = sol.f(os.x);
            P.add(os);
        }
        for(int j=0; j<100;j++) {
            P.sort(new comp());
            System.out.println(P.get(0).wynik);
            sol.counter = 0;
            List<Osobnik> P2 = new ArrayList<>();
            for(int l =0; l<3; l++) {

                Osobnik os = P.get(l);

                for(int l2 =0; l2<5; l2++) {
                    Osobnik o2 = new Osobnik(size);

                    System.arraycopy(os.x, 0, o2.x, 0, os.x.length);
                    sol.mutacja(o2.x);
                    o2.wynik = sol.f(o2.x);
                    P2.add(o2);
                }
                for (int k = 0; k < size; k++) {
                    os.x[k] = -10.0 + 20.0 * random.nextDouble();
                }
                //for ( temp =0.001 ; temp<1; temp+= 0.01) {
                //i = 0;
                //sum += z;
                // z = 0.0;
                //while (i < 100) {


                    /*if (sol.f(os.x) > sol.f(y)) {
                        System.arraycopy(y, 0, os.x, 0, os.x.length);
                    }
                    else {
                        System.out.println("Prog" + sol.prog(sol.f(os.x), sol.f(y), temp));
                        /*if (sol.prog(sol.f(x), sol.f(y), temp) > random.nextGaussian()) {
                            System.arraycopy(y, 0, x, 0, x.length);
                        }
                    }*/
                //i++;
                // }
                //}
          /*  }
            P2.sort(new comp());
            P.clear();
            for (int m = 0; m<pop; m++){
                P.add(new Osobnik(P2.get(m)));
            }
            // System.out.println("Counter  = " + sol.counter);
            for (Osobnik os : P){
                System.out.println(sol.f(os.x));
            }


        }
        // System.out.println(sum/100);
    }
}
*/
          /*
          * import java.util.Comparator;

class comp implements Comparator<Osobnik> {

    @Override
    public int compare(Osobnik o1, Osobnik o2) {

            if(o1.wynik<o2.wynik){
                return -1;
            }
            else if(o1.wynik>o2.wynik){
                return 1;
            }
            else{
                return 0;
            }
    }
}*/
          /*
          * class Osobnik{

    public Osobnik(int w){
        x= new Double[w];
        wynik =0.0;
    }
    public Osobnik(Osobnik o){
        x = new Double[o.x.length];
        System.arraycopy(o.x,0,x,0,x.length);
        wynik = o.wynik;
    }
    Double[] x;
    Double wynik;

}*/