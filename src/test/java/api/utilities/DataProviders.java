package api.utilities;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders
{
   @DataProvider(name ="Data")
    public Object[][] getAllData() throws IOException {
      String path= System.getProperty("user.dir")+"//Testdata//Book1.xlsx";
      XlUtility xl=new XlUtility(path);
      int totalRowCount=xl.getRowCount("Sheet1");
      int totalCellCount=xl.getCellCount("Sheet1",1);
      String apiData[][]=new String[totalRowCount][totalCellCount];
      for(int i=1; i<=totalRowCount;i++)
      {
          for(int j=0; j<totalCellCount;j++)
          {
              apiData[i-1][j]=xl.getCellData("Sheet1",i,j);

          }
      }
      return apiData;

   }
   @DataProvider(name="UserName")
   public Object[][] getUserName() throws IOException
   {
       String path=System.getProperty("user.dir")+"//TestData//Book1.xlsx";
       XlUtility xl= new XlUtility(path);
       int totalRowCount=xl.getRowCount("Sheet1");
       String apiUserName[][]=new String[totalRowCount][1];
       for(int i=1;i<=totalRowCount;i++)
       {
           apiUserName[i-1][0]=xl.getCellData("Sheet1",i,1);

       }
       return apiUserName;



   }


}
