package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
        public FileInputStream fi;
        public FileOutputStream fo;
        public XSSFWorkbook workbook;
        public XSSFSheet sheet;
        public XSSFRow row;
        public XSSFCell cell;
        public CellStyle style;

        String path;

        // Constructor
        public ExcelUtility(String path) {
            this.path = path;
        }

        // Get Row Count
        public int getRowCount(String sheetName) throws IOException {

            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);

            sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();

            workbook.close();
            fi.close();

            return rowCount;
        }

        // Get Cell Count
        public int getCellCount(String sheetName, int rowNum) throws IOException {

            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);

            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);

            int cellCount = row.getLastCellNum();

            workbook.close();
            fi.close();

            return cellCount;
        }

        // Get Cell Data
        public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {

            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);

            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);

            String data;

            try {

                CellType cellType = cell.getCellType();

                switch (cellType) {

                    case STRING:
                        data = cell.getStringCellValue();
                        break;

                    case NUMERIC:
                        data = String.valueOf(cell.getNumericCellValue());
                        break;

                    case BOOLEAN:
                        data = String.valueOf(cell.getBooleanCellValue());
                        break;

                    default:
                        data = "";
                }

            } catch (Exception e) {

                data = "";
            }

            workbook.close();
            fi.close();

            return data;
        }

        // Set Cell Data
        public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {

            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);

            sheet = workbook.getSheet(sheetName);

            if (sheet.getRow(rowNum) == null) {

                row = sheet.createRow(rowNum);

            } else {

                row = sheet.getRow(rowNum);
            }

            cell = row.createCell(colNum);
            cell.setCellValue(data);

            fo = new FileOutputStream(path);

            workbook.write(fo);

            workbook.close();
            fi.close();
            fo.close();
        }
    }

