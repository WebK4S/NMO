import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        Map<Integer,Double> map = new TreeMap<Integer,Double>();
        Double mi = 0.0;
        Double sigma = 5.0;
        for (Integer i=0; i<10000; i++){
            //map.put(i,-10.0 + 20.0 * random.nextDouble());
            map.put(i,mi + sigma * random.nextGaussian());
        }
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NMO");
        Set<Integer> keyset = map.keySet();
        int rownum = 0;
        for (Integer key : keyset){
            Row row = sheet.createRow(rownum++);
            Double temp = map.get(key);
            Cell keycell = row.createCell(0);
            Cell valuecell = row.createCell(1);
            keycell.setCellValue(key);
            valuecell.setCellValue(temp);
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Kamil\\IdeaProjects\\NMO\\nmo5.xls"));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
