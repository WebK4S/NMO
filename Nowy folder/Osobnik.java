class Osobnik{


    static double epsilon = 0.01;
    //Double[] sigma;
    Double[] x;
    Double wynik;

    public Osobnik(int w){
        x= new Double[w];
       // sigma = new Double[w];
        wynik =0.0;
    }
    public Osobnik(Osobnik o){
        x = new Double[o.x.length];
        //sigma = new Double[o.sigma.length];
        System.arraycopy(o.x,0,x,0,x.length);
        //System.arraycopy(o.sigma,0,sigma,0,sigma.length);
        wynik = o.wynik;
    }



}