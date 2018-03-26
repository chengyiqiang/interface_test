package getexcel;

import java.io.File;

import org.omg.CORBA.WStringValueHelper;

import datainfo.AppData;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class GetTestExcel {
	//获取已有的测试用例
	public static Workbook wb = null;
	public static WritableWorkbook wwb = null;
	public static Sheet sheet = null;
	public static WritableSheet wSheet = null;
	public static int row = 1;
	
	public static void setExcel (){
		try {
			wb = Workbook.getWorkbook(new File(AppData.testCasePath ));
			wwb = Workbook.createWorkbook(new File(AppData.testCasePath.split(".xls")[0] + "_result.xls"), wb);
		} catch (Exception e) {
			System.out.println("获取测试用例Excel错误！");
			e.printStackTrace();
		}
	}
	
	//获取可写测试sheet
	public static void getWritableSheet (int sheetNum){
		wSheet = wwb.getSheet(sheetNum);
	}
	
	//获取可读测试sheet
	public static void getSheet (int sheetNum){
		sheet = wb.getSheet(sheetNum);
		//每次获取sheet，都将row值重置为1（第二行）
		row = 1;
	}

}
