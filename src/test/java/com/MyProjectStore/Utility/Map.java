package com.MyProjectStore.Utility;

import java.util.HashMap;

public class Map {

	static HashMap<String, String>map;
	
	public static void readDataToMap(String sheetName) {
		map = new HashMap<>();
		ReadExcel.openExcel();
		ReadExcel.identifySheet(sheetName);
		int rowCount = ReadExcel.identifyRowCount();
		for(int rownum=0;rownum<=rowCount;rownum++) {
			ReadExcel.identifyRow(rownum);
			ReadExcel.identifyCell(0);
			String key = ReadExcel.identifyCellData();
			ReadExcel.identifyCell(1);
			String value = ReadExcel.identifyCellData();
			map.put(key, value);
		}
	}
	public static String getDatafromMap(String keyName) {
		return map.get(keyName);
	}
	
}
