package ru.sibtrans.main;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        mminPriceWriter();
        cityPriceWriter();
        addServicePriceWriter();
    }
    public static String readMain = "src/main/resources/txtprice/txtmainprice.txt";
    public static String readCity = "src/main/resources/txtprice/txtcityprice.txt";
    public static String readAddS = "src/main/resources/txtprice/addserviceprice.txt";

    public static String readPrice(String name) throws IOException {
        BufferedReader fin = new BufferedReader( new InputStreamReader(new FileInputStream(name),"utf-8"));
        List<String> fileContent = new ArrayList<String>() ;
        String str ;
        while( (str = fin.readLine() ) != null )
            fileContent.add(str) ;
        fin.close() ;
        String line = "";//fileContent.(flowFrom());

        for (int i = 0; i < fileContent.size(); i++) {
            line = line + fileContent.get(i) + "\n";
        }
        return line;
    }
    static String main = "src/main/resources/excel/mainprice.xls";
    static String city = "src/main/resources/excel/cityprice.xls";
    static String addsSerice = "src/main/resources/excel/addserviceprice.xls";
    public static String excelParser(String name) {

        String result = "";
        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream(name);
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result += cell.getStringCellValue() + " -> ";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        result += " | " + cell.getNumericCellValue() + " | ";
                        break;

                    case Cell.CELL_TYPE_FORMULA:
                        result += " | " + cell.getNumericCellValue() + " | ";
                        break;
                    default:
                        result += "";
                        break;
                }
            }
            result += "\n";
        }
        return result;
    }
    public static void mminPriceWriter() throws IOException {
        FileWriter writer = new FileWriter("src/main/resources/txtprice/txtmainprice.txt",  false);
            writer.write(excelParser(main));
    }
    public static void cityPriceWriter() throws IOException {
        FileWriter writer = new FileWriter("src/main/resources/txtprice/txtcityprice.txt", false);
        writer.write(excelParser(city));
    }
    public static void addServicePriceWriter() throws IOException {
        FileWriter writer = new FileWriter("src/main/resources/txtprice/txtaddserviceprice.txt", false);
        writer.write(excelParser(addsSerice));
    }
}

