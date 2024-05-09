package Helper;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;


public class ExcelFileUtils {

    public FileInputStream fis = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row   =null;
    private XSSFCell cell = null;
    private Object[][] data;


    public ExcelFileUtils (String filePath, String sheetName) throws IOException {
        fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public Object[][] readFromExcelFile(int rowNumber, int colNumber) throws IOException {
        int rowCount = sheet.getLastRowNum()+1;
        System.out.printf("row count  "+ rowCount);
        int colCount = sheet.getRow(rowNumber).getLastCellNum();
        System.out.printf("col count  "+ colCount);

        data = new Object[rowCount][colCount];

        for (int i=rowNumber; i<rowCount; i++ )
        {
            row = sheet.getRow(i);
            String retrievedText = null;

            for(int j=colNumber; j<colCount; j++){

                cell = row.getCell(j);

                if(cell.getCellType().toString().equalsIgnoreCase("NUMERIC")){
                    retrievedText = NumberToTextConverter.toText(cell.getNumericCellValue());
                    System.out.println(retrievedText+ "  Username with NUMERIC value");

                }else if(cell.getCellType().toString().equalsIgnoreCase("STRING")){
                    retrievedText = cell.getStringCellValue();
                    System.out.println(retrievedText+ "  Username with STRING value");

                }else if(cell.getCellType().toString().equalsIgnoreCase("BLANK")){
                    System.out.println("Nullable cell");
                    break;
                }

                System.out.println(cell.getCellType() + " retrievedText type");
                System.out.println("retrievedText: " + retrievedText);
                data[i][j] = retrievedText;
            }
        }

        workbook.close();
        fis.close();

        System.out.println(data.length + "   length");
        return data;
    }
}
