package com.learningservices.utils;

//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * Data Utils consists finding Row and Column count,Reading excel headers,
 * Retrieving testdata id and Fetching testdata values
 */
public class DataUtils {
	private static final Logger logger = LoggerFactory.getLogger(DataUtils.class);

	/**
	 * findRowColumnCount method to get total no of row and column count in a
	 * excel work sheet
	 * 
	 * @param sheet
	 *            name
	 * @param rowColumnCount
	 *            as Hashtable
	 * @return Hashtable (returns row count and column count)
	 */

	public static Hashtable<String, Integer> findRowColumnCount(HSSFSheet sheet, Hashtable<String, Integer> rowColumnCount) {

		HSSFRow row = null;
		int rows;
		rows = sheet.getPhysicalNumberOfRows();
		int cols = 0;
		int tmp = 0;
		int counter = 0;
		String temp = null;

		for (int i = 0; i < 10 || i < rows; i++) {
			row = sheet.getRow(i);
			if (row != null) {
				temp = convertHSSFCellToString(row.getCell(0));
				if (!temp.isEmpty()) {
					counter++;
				}
				tmp = sheet.getRow(i).getPhysicalNumberOfCells();
				if (tmp > cols) {
					cols = tmp;
				}
			}
		}

		rowColumnCount.put("RowCount", counter);
		rowColumnCount.put("ColumnCount", cols);

		return rowColumnCount;
	}

	/**
	 * readExcelHeaders method read the excel headers column wise sheet
	 * 
	 * @param sheet
	 *            name
	 * @param excelHeaders
	 *            (Hashtable)
	 * @param rowColumnCount
	 *            (Hashtable)
	 * @return excelHeaders (returns Header column values)
	 */
	public static Hashtable<String, Integer> readExcelHeaders(HSSFSheet sheet, Hashtable<String, Integer> excelHeaders, Hashtable<String, Integer> rowColumnCount) {

		HSSFRow row = null;
		HSSFCell cell = null;
		for (int r = 0; r < rowColumnCount.get("RowCount"); r++) {
			row = sheet.getRow(r);

			if (row != null) {
				for (int c = 0; c < rowColumnCount.get("ColumnCount"); c++) {
					cell = row.getCell(c);
					if (cell != null) {
						excelHeaders.put(cell.toString(), c);
					}
				}
				break;
			}
		}
		return excelHeaders;
	}

	/**
	 * convertHSSFCellToString method to convert the HSSFCell value to its
	 * equivalent string value
	 * 
	 * @param cell
	 *            value
	 * @return String cellValue
	 */
	public static String convertHSSFCellToString(HSSFCell cell) {
		String cellValue = null;
		if (cell != null) {
			cellValue = cell.toString();
			cellValue = cellValue.trim();
		} else {
			cellValue = "";
		}
		return cellValue;
	}

	/**
	 * To overriding the config sheet name to get test data
	 * 
	 * @param testCaseId
	 *            from test case
	 * @param testClassName
	 *            test name
	 * @return
	 */
	public static HashMap<String, String> testDatabyID(String testCaseId, String testClassName) {
		String configSheetName = "Config";
		return testDatabyID(testCaseId, testClassName, configSheetName);
	}
			
	/**
	 * Map to the test data sheet based on Config declaration
	 * 
	 * @param testCaseId
	 *            from test case
	 * @param testClassName
	 *            test name
	 * @return data cell value
	 */
	@SuppressWarnings("resource")
	public static HashMap<String, String> testDatabyID(String testCaseId, String testClassName, String configSheetName) {
		String filePath = "";
		String sheetName = "";
		String fileName = "";
		HSSFRow row = null;
		HSSFCell cell = null;
		HashMap<String, String> data = new HashMap<String, String>();
		Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();

		try {

			//String basePath = new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testdata" + File.separator;
			String basePath = "/testdata/";
			logger.info("data utils base path: " + basePath);
			String configFilePath = basePath + "Config-TD.xls";
			InputStream cpr = DataUtils.class.getResourceAsStream(configFilePath);
			
			POIFSFileSystem fs = new POIFSFileSystem(cpr);
			//POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(configFilePath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheet(configSheetName);

			// Function call to find excel header fields
			Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();
			excelrRowColumnCount = findRowColumnCount(sheet, excelrRowColumnCount);
			excelHeaders = readExcelHeaders(sheet, excelHeaders, excelrRowColumnCount);			

			// Get test data set
			for (int r = 1; r < excelrRowColumnCount.get("RowCount"); r++) {
				row = sheet.getRow(r);
				if (row != null) {
					HSSFCell tempCell = sheet.getRow(r).getCell(0);
					if (tempCell != null) {
						String testClass = convertHSSFCellToString(row.getCell(0));

						if (testClass.equalsIgnoreCase(testClassName)) {
							cell = sheet.getRow(r).getCell(1);
							if (cell != null) {
								fileName = convertHSSFCellToString(row.getCell(1));
							}
							cell = sheet.getRow(r).getCell(2);
							if (cell != null) {
								sheetName = convertHSSFCellToString(row.getCell(2));
							}
							break;
						}
					}
				}
			}
			filePath = basePath + fileName;
			data = getTestData(filePath, fileName, sheetName, testCaseId);
			return data;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		throw new RuntimeException("error: DataUtils couldn't load the data");
	}
	

	
	/**
	 * Fetch the test data for a test case based on test case ID
	 * 
	 * @param filePath
	 *            test data xls location
	 * @param workBook
	 *            name
	 * @param sheetName
	 *            name
	 * @param testCaseId
	 *            test id
	 * @return testData data
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static HashMap<String, String> getTestData(String filePath, String workBook, String sheetName, String testCaseId) throws IOException {
		HSSFRow row = null;
		HSSFCell cell = null;

		// Establish connection to work sheet
		POIFSFileSystem fs = new POIFSFileSystem(DataUtils.class.getResourceAsStream(filePath));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheet(sheetName);
		Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();
		excelrRowColumnCount = findRowColumnCount(sheet, excelrRowColumnCount);

		// function call to find excel header fields
		Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();
		excelHeaders = readExcelHeaders(sheet, excelHeaders, excelrRowColumnCount);
		HashMap<String, String> data = null;
		ArrayList<String> header = new ArrayList<String>();
		ArrayList<String> matcher = null;
		HashMap<String, String> matcherList = new HashMap<String, String>();
		int idcounter=1;

		// Get all header
		row = sheet.getRow(0);
		if (row != null) {
			for (int c = 0; c < excelrRowColumnCount.get("ColumnCount"); c++) {
				cell = sheet.getRow(0).getCell(c);
				if (cell != null) {
					String temp = convertHSSFCellToString(row.getCell(c));
					header.add(temp);
				}
			}
		}
		
		// Get test data set
		for (int r = 1; r < excelrRowColumnCount.get("RowCount"); r++) {
			row = sheet.getRow(r);
			if (row != null) {
				HSSFCell tempCell = sheet.getRow(r).getCell(0);
				if (tempCell != null) {
					String tcID = convertHSSFCellToString(row.getCell(0));
					if (tcID.equalsIgnoreCase(testCaseId)) {
						if(idcounter >1){
							Assert.fail("Please check the '"+workBook+"' file's '"+sheetName+"' sheet, its mapped with more than one id: "+testCaseId);
						}
						data = new HashMap<String, String>();
						matcher = new ArrayList<String>();
						matcher.add(tcID);
						for (int c = 1; c < excelrRowColumnCount.get("ColumnCount"); c++) {
							cell = sheet.getRow(r).getCell(c);
							String temp = convertHSSFCellToString(row.getCell(c));
							matcher.add(temp);
						}
						// Add all the test data to a Map
						for (int i = 0; i < matcher.size(); i++) {
							data.put(header.get(i), matcher.get(i));
						}
						matcherList.putAll(data);
						idcounter++;
					}
				}
			}
		}

		return matcherList;
	}
	
	/**
     * To read the entire data present in the specified workbook and sheet
     * @param fileName - File name of the workbook under src/main/resources/testdata
     * @param sheetName - Name of the sheet where content to be read
     * @return ArrayList<HashMap<String, String>> - data of the entire sheet specified
     * @throws Exception
     */
    @SuppressWarnings("resource")
	public static ArrayList<HashMap<String, String>> getEntireDataFromSheet(String fileName, String sheetName) throws Exception {

        HSSFRow row = null;
        HSSFCell cell = null;
        ArrayList<HashMap<String, String>> allData = new ArrayList<>();

        //String basePath = new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testdata" + File.separator;
        String basePath = "/testdata/";
        logger.info("Data file path: " + basePath + fileName);
        POIFSFileSystem fs = new POIFSFileSystem(DataUtils.class.getResourceAsStream(basePath + fileName));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheet(sheetName);       
        
        // To get the no. of rows and columns
        Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();
        excelrRowColumnCount = findRowColumnCount(sheet, excelrRowColumnCount);
        int rowCount = excelrRowColumnCount.get("RowCount");
        int columnCount = excelrRowColumnCount.get("ColumnCount");

        // To get the header values
        row = sheet.getRow(0);
        ArrayList<String> header = new ArrayList<String>();
        if (row != null) {
            for (int k = 0; k < excelrRowColumnCount.get("ColumnCount"); k++) {
                cell = row.getCell(k);
                header.add(convertHSSFCellToString(cell));
            }
        } else {
            throw new Exception("Header row is empty. Please fill the first row in sheet " + sheet.getSheetName()
                    + " of workbook " + fileName);
        }

        // To read all data in the sheet
        HashMap<String, String> rowData = null;
        for (int i = 1; i < rowCount; i++) {
            row = sheet.getRow(i);
            if (row != null) {
                rowData = new HashMap<String, String>();
                for (int j = 0; j < columnCount; j++) {
                    cell = row.getCell(j);
                    rowData.put(header.get(j), convertHSSFCellToString(cell));
                }
                allData.add(rowData);
            }
        }
        
        return allData;
    }
	
}