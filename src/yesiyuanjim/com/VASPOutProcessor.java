package yesiyuanjim.com;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by meticulous on 2017/7/28.
 */
public class VASPOutProcessor {
    public static VASPOut readTxtFile(String filePath){
        StringBuffer stringBuffer = new StringBuffer();
        try{
            String encoding = "GBK";
            File file = new File(filePath);
            if(file.isFile() && file.exists()){
                InputStreamReader reader = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String lineTxt ;
                int i = 0;
                while( i < 6){
                    bufferedReader.readLine();
                    i ++;
                }
                while((lineTxt = bufferedReader.readLine()) != null){
                    stringBuffer.append(lineTxt);
                }
                reader.close();
                System.out.println(stringBuffer.toString());
            }else{
                System.out.println("找不到指定文件");
            }
            return new VASPOut(file.getName(),stringBuffer.toString());
        }catch(Exception e){
                System.out.println("读取内容出错");
                 e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        String string = VASPOutProcessor.readTxtFile("E:\\DOSCAR.txt").getData();
        String[] temp = string.split("\\s+");
        String[] data = Arrays.copyOfRange(temp, 1, temp.length);
        ExcellWriter.writer("E:\\DOS.xls",data, 3);
    }
}
