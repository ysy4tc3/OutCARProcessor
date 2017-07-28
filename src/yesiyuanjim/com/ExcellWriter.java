package yesiyuanjim.com;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.File;
import java.math.BigDecimal;

/**
 * Created by meticulous on 2017/7/28.
 */
public class ExcellWriter {
    public static void writer(String filePath, String[] args, int col){
        try {
            OutputStream os = new FileOutputStream(new File(filePath));
            WritableWorkbook wb = Workbook.createWorkbook(os);
            WritableSheet sheet = wb.createSheet("01", 0);
            int count = 0;
            for(int i = 0; i < args.length/col; i++){
                for(int j = 0; j < col; j++){
                    System.out.println(args[count]);
                    BigDecimal bd = new BigDecimal(args[count++]);
                    Number number = new Number(j, i, bd.doubleValue());
                    sheet.addCell(number);
                    if(count == 257)
                        break;
                }
            }
            wb.write();
            wb.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
