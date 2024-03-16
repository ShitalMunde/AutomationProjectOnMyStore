package com.MyProjectStore.Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	static FileInputStream fs;
	static Workbook wb;
	static Row r;
	static Cell c;
	static Sheet sh;
	
	public static void openExcel() {
		try {
			wb = WorkbookFactory.create(new FileInputStream(Utility.excelFilePath));
		}  catch (Exception e) {
		}
	}
	public static void identifySheet(String sheetName) {
		sh = wb.getSheet(sheetName);
	}
	public static int identifyRowCount() {
		return sh.getLastRowNum();
	}
	public static void identifyRow(int rownum) {
		r = sh.getRow(rownum);
	}
	public static int identifyCellCount() {
		return r.getLastCellNum();
	}
	public static void identifyCell(int cellnum) {
		c = r.getCell(cellnum);
	}
	public static String identifyCellData() {
		return c.toString();
	}
}
