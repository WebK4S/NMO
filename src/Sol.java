import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.lang.Math.exp;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


//http://people.sc.fsu.edu/~jburkardt/c_src/test_optimization/test_optimization.c
/*class comp implements Comparator<? extends Osobnik>{

    @Override
    public double compare(Osobnik o1, Osobnik o2) {

    }
}*/


public class Sol {
    Double tau = 1/ sqrt(size);
    Double mi = 0.0;
    Double sigma = 0.1;
    Random random = new Random();
    int counter = 0;
    static int size =10;
    public int fcounter = 0;
    Double[] progi = {1.0, 0.1,0.01};

    public void mutacja(Osobnik osobnik){
        int length = osobnik.x.length;
        for (int i=0; i<length; i++) {
            osobnik.sigma[i] = osobnik.sigma[i] * exp(tau * random.nextGaussian());

            if (osobnik.sigma[i] < osobnik.epsilon ){
                osobnik.sigma[i] = osobnik.epsilon;
            }

            osobnik.x[i] = osobnik.x[i] + osobnik.sigma[i] * random.nextGaussian();

        }

    }

    public Double f(Double[] x) {
        double sum1 = 0.0;
        double sum2 = 0.0;

        for (int i = 0 ; i < x.length ; i ++) {
            sum1 += pow(x[i], 2);
            sum2 += (Math.cos(2*Math.PI*x[i]));

        }
        counter++;
        return -20.0*Math.exp(-0.2*Math.sqrt(sum1 / ((double )x.length))) + 20
                - Math.exp(sum2 /((double )x.length)) + Math.exp(1.0);
    }

    public Double rosenbrock( Double[] x){
        fcounter++;
        double f =0.0;
        int i;
        for ( i = 0; i < x.length; i++ )
        {
            f = f + pow( 1.0 - x[i], 2 );
        }
        for ( i = 0; i < x.length - 1; i++ ) {
            f = f + pow(x[i + 1] - x[i], 2);
        }
        for( i =0; i<progi.length; i++){
            if (f<progi[i]){
                System.out.println("wartośc dla progu: "+ progi[i]+ " wynosi " +f + " dla iteracji " + fcounter);
                progi[i] = Double.MIN_VALUE;
            }
        }
        return f;
    }

    public static void main(String[] args){
        /*for (Double i= 0.0; i<100; i++){
            Double[] x = {i,2*i};
            System.out.println( rosenbrock(x));
        }*/
        /*Double[] x = {1.0,1.0,1.0,1.0,1.0};
        System.out.println( rosenbrock(x));*/
        int pop = 10;
        List<Osobnik> P = new ArrayList<>();
        Random random = new Random();
        Sol sol = new Sol();
        for(int i = 0; i < pop; ++i) {
            Osobnik os = new Osobnik(size);
            for (int k = 0; k < size; k++) {
                os.x[k] = -5.0 + 10.0 * random.nextDouble();
                os.sigma[k] =0.1;
            }
            os.wynik = sol.rosenbrock(os.x);
            P.add(os);
        }
        for(int j=0; j<10000;j++) {
            P.sort(new comp());
            //System.out.println(P.get(0).wynik);
            sol.counter = 0;
            List<Osobnik> P2 = new ArrayList<>();
            for(int l =0; l<3; l++) {

                Osobnik os = P.get(l);

                for(int l2 =0; l2<5; l2++) {
                    Osobnik o2 = new Osobnik(os);
                    sol.mutacja(o2);
                    o2.wynik = sol.rosenbrock(o2.x);
                    P2.add(o2);
                }
                for (int k = 0; k < size; k++) {
                    os.x[k] = -10.0 + 20.0 * random.nextDouble();
                }
            }
            /*P2.sort(new comp());
            P.clear();
            for (int m = 0; m<pop; m++){
                P.add(new Osobnik(P2.get(m)));
            }*/

            P2.addAll(P);
           // System.out.println("Rozmiar przed : " + P2.size());
            P2.sort(new comp());
            System.out.println("Najlepszy:" + P2.get(0).sigma[0]);
            P.clear();
            //System.out.println("rozmiar po ; " + P2.size());
            for (int m = 0; m<pop; m++){
                P.add(new Osobnik(P2.get(m)));
            }

            /*for (Osobnik os : P){
                System.out.println(sol.rosenbrock(os.x));
            }*/
        }
        P.sort(new comp());
        System.out.println("Najlepszy :" + P.get(0).wynik);
    }
}
