package dataObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFromExcel {

    static List<String> listValue;

    public List<String> fetchDatafromExcel(int cellno) throws IOException {

        File file=new File("C:\\Users\\Amit Kumar Gaurav\\IdeaProjects\\RedBusApplication\\RedBus-PM+TestNG\\xlsFile\\RedBusTestData.xls");
        FileInputStream stream = new FileInputStream(file);

        HSSFWorkbook workbook = new HSSFWorkbook(stream);
        HSSFSheet sheet1= workbook.getSheet("Sheet1");
        listValue= new ArrayList<String>();

        for (int i=0; i<= sheet1.getLastRowNum(); i++) {
            HSSFRow rowSheet2 = sheet1.getRow(i);
            if (rowSheet2.getRowNum() > 0) {
                HSSFCell cell = rowSheet2.getCell(cellno);
                String covertedValue= cell.getStringCellValue();
                listValue.add(covertedValue);
            }
        }
        return listValue;

    }
}
