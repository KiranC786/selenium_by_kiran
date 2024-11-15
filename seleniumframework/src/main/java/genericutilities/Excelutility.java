package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public Object getDataFromExcel(String sheetname, int rowIndex, int colIndex)throws EncryptedDocumentException, IOException {

		try (FileInputStream file = new FileInputStream("./src/test/resource/TestData/demoapplication.xlsx");
			Workbook workbook = WorkbookFactory.create(file)) {
			Cell cell = workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex);

			switch (cell.getCellType()) {
			case STRING:
				return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getStringCellValue();

			case BOOLEAN:
				return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();

			case NUMERIC:
				return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
				
			default:
				return null;
			}
		}
	}
	
	// Fetch String Data from Excel
    public String getStringDataFromExcel(String sheetname, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
        try (FileInputStream file = new FileInputStream("./src/test/resource/TestData/demoapplication.xlsx");
             Workbook workbook = WorkbookFactory.create(file)) {
            return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getStringCellValue();
        }
    }

    // Fetch Boolean Data from Excel
    public Boolean getBooleanDataFromExcel(String sheetname, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
        try (FileInputStream file = new FileInputStream("./src/test/resource/TestData/demoapplication.xlsx");
             Workbook workbook = WorkbookFactory.create(file)) {
            return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
        }
    }

    // Fetch Numeric Data from Excel
    public double getNumericDataFromExcel(String sheetname, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
        try (FileInputStream file = new FileInputStream("./src/test/resource/TestData/demoapplication.xlsx");
             Workbook workbook = WorkbookFactory.create(file)) {
            return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
        }
    }
    
    // Fetch LocalDateTime Data from Excel
    public LocalDateTime getDateFromExcel(String sheetname, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
        try (FileInputStream file = new FileInputStream("./src/test/resource/TestData/demoapplication.xlsx");
             Workbook workbook = WorkbookFactory.create(file)) {
            return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
        }
    }
}
    
