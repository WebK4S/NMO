import java.util.Comparator;

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
}