package api.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XlUtility {
    public static FileInputStream fi;
    public FileOutputStream fo;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle cellStyle;
    static String path;
    public XlUtility(String path)
    {
        this.path=path;
    }
    public  int getRowCount(String sheetName) throws IOException {
        fi =new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        int rowCount= sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }
    public int getCellCount(String sheetName,int rowNum) throws IOException {
        fi= new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rowNum);
        int cellCount=row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;


    }
    public String getCellData(String sheetName,int rowNum,int cellCount) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row= sheet.getRow(rowNum);
        cell= row.getCell(cellCount);
        String data;
        DataFormatter dataFormatter=new DataFormatter();
        data=dataFormatter.formatCellValue(cell);
        workbook.close();
        fi.close();
        return data;



    }


}
