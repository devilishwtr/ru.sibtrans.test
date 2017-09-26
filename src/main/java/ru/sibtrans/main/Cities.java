package ru.sibtrans.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ru.sibtrans.main.maxicalculator.CalculatorMaxiObject.flowFrom;
import static ru.sibtrans.main.maxicalculator.CalculatorMaxiObject.flowTo;

public class Cities {

    public Cities() throws FileNotFoundException {
    }


    public static String flowPoints (int n) throws IOException {
        BufferedReader fin = new BufferedReader( new InputStreamReader(new FileInputStream("src/main/resources/points.txt"),"utf-8"));
        List<String> fileContent = new ArrayList<String>() ;
        String str ;
        while( (str = fin.readLine() ) != null )
            fileContent.add(str) ;
        fin.close() ;
        String line = fileContent.get(n);
        return line;
    }
    public static String flowBracnhesFrom() throws IOException {
        BufferedReader fin = new BufferedReader( new InputStreamReader(new FileInputStream("src/main/resources/branches.txt"),"utf-8"));
        List<String> fileContent = new ArrayList<String>() ;
        String str ;
        while( (str = fin.readLine() ) != null )
            fileContent.add(str) ;
        fin.close() ;
        String line = fileContent.get(flowFrom());
        return line;
    }
    public static String flowBracnhesTo() throws IOException {
        BufferedReader fin = new BufferedReader( new InputStreamReader(new FileInputStream("src/main/resources/branchesTo.txt"),"utf-8"));
        List<String> fileContent = new ArrayList<String>() ;
        String str ;
        while( (str = fin.readLine() ) != null )
            fileContent.add(str) ;
        fin.close() ;
        String line = fileContent.get(flowTo());
        return line;
    }

}
