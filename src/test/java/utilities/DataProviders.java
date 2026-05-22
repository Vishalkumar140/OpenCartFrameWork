package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name="LoginData")

    public String [] [] getData() throws IOException {
        String path=".\\testData\\Testdata.xlsx"; //taking excel file for testdata
        ExcelUtility xlutil= new ExcelUtility (path);
        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);
        String logindata[][]=new String[totalrows][totalcols];//created for two dimension array to store
        for(int i=1;i<=totalrows;i++){
            for(int j=0;j<totalcols;j++) {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); //1,0
            }
            }
        return logindata;//return two dimension array

    }
    //Dataprovider2
    //Dataprovider3
    }


