

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import static java.lang.Math.pow;

class NMO3 {
    Double mi = 0.0;
    Double sigma = 0.51;
    Random random = new Random();
    int counter = 0;


    public Double func(Double[] x) {
        int length = x.length;
        Double sum = 0.0;
        for (int i = 0; i < length; i++) {
            sum += x[i] * x[i];
        }
        return sum;
    }

    public void mutacja(Double[] x) {
        int length = x.length;
        for (int i = 0; i < length; i++) {
            x[i] = x[i] + mi + sigma * random.nextGaussian();
        }
    }

    public Double prog(Double fx, Double fy, Double temp) {
        double a = Math.exp((fx - fy) / temp);
        return a;

    }
    //rosenbrock
    /*public Double f(Double[] x) {
        double f =0.0;
        int i;
        for ( i = 0; i < x.length; i++ )
        {
            f = f + pow( 1.0 - x[i], 2 );
        }
        for ( i = 0; i < x.length - 1; i++ ) {
            f = f + pow(x[i + 1] - x[i], 2);
        }
        return f;
    }*/
    //rastrigin
   public Double f(Double[] x) {
        Double fitness = 10.0 * x.length;
        for (int i = 0 ; i<x.length; i++){
            fitness += Math.pow(x[i], 2.0) - 10.0 * Math.cos(2 * Math.PI * x[i]);
        }
        return fitness;
    }

    public static void main(String[] args) {
        int row1 = 0;
        int row2 = 1;
        HSSFWorkbook workbook = new HSSFWorkbook();
        int size = 1;
        for (int dimension = 5; dimension <= 35; dimension += 5) {
            size = dimension;
            HSSFSheet sheet = workbook.createSheet("NMO" + size);
            Double[] wyniki = new Double[50];
            Map<Integer, Double> map = new TreeMap<Integer, Double>();
            Double temp = 100.0;
            Random random = new Random();
            NMO3 sol = new NMO3();
            Double[] x = new Double[size];
            Double[] y = new Double[size];

            int i = 0;
            for (int j = 0; j < 50; j++) {
                sol.counter = 0;
                for (int k = 0; k < x.length; k++) {
                    x[k] = -5.12 + 10.24 * random.nextDouble();
                }
                //System.out.println(sol.f(x));
                //TODO zmiana temperatury (for z 1 -> 0.001) size 10 wmiarów
                i = 0;
                while (i < 10000) {
                    System.arraycopy(x, 0, y, 0, x.length);
                    sol.mutacja(y);
                    if (sol.f(x) > sol.f(y)) {
                        System.arraycopy(y, 0, x, 0, x.length);
                    } else {
                        //System.out.println("Prog" + sol.prog(sol.f(x), sol.f(y), temp));
                        double prog = sol.prog(sol.f(x), sol.f(y), temp);
                        double rand = random.nextDouble();
                        if ( prog > rand) {
                            System.arraycopy(y, 0, x, 0, x.length);
                            System.out.println("gorsze " + temp);
                        }
                    }
                    temp *= 0.99;
                    i++;
                }
                // System.out.println("Counter  = " + sol.counter);
                //System.out.println(sol.f(x));
                wyniki[j] = sol.f(x);

            }
            for (Integer k = 0; k < 50; k++) {
                //map.put(i,-10.0 + 20.0 * random.nextDouble());
                map.put(k, wyniki[k]);
            }
            //System.out.println(sum);

            Set<Integer> keyset = map.keySet();
            int rownum = 0;
            for (Integer key : keyset) {
                Row row = sheet.createRow(rownum++);
                Cell keycell = row.createCell(0);
                Cell valuecell = row.createCell(1);
                keycell.setCellValue(key);
                valuecell.setCellValue(map.get(key));
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("rastriginSAtemp.xls"));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



/*
* Spojny kod źródłowy dla wszystkich algorytmow
*
* Wyniki obrobione w excelu 5 wymiarów rastrigina SA vs 5 wymiarów rastrigina ewolucyjny
*
* Opisanie algorytmów, dwa rozdziały , wszystkie parametry, rozmiar populacji sigma itd.
*
* Dwa opisy benchmarków rastrigin rosenbrock, + dziedzina dla obydwu, wykresy
*
* Tabelka z podpisem co jest w tabelce :) np: tabela przedstawia wyniki dla : ...
*
* Wnioski ze dwa zdania itp 
*
*
* */