package InterfaceTest;

import java.sql.ResultSet;

import DBset.DBUtil;
import getexcel.GetTestExcel;

public class DoTest {

	public static void doTest() {
		// TODO Auto-generated method stub
//		DBUtil.setDBConnection();
//		System.out.println(DBUtil.getSelectResult("SELECT * FROM [dbo].[T_StopCar_Record] where stopcarid = 888888 ORDER BY InsertTime DESC", "StopCarID"));
		
		GetTestExcel.setExcel();
		GetTestExcel.getSheet(0);
		GetTestExcel.getWritableSheet(0);
		for (int i = 0,row = 1; i < GetTestExcel.sheet.getRows()-1; i++) {			
			HttpRequest.requestAndWriteResult(row);
			row++;
		}
		try {
			GetTestExcel.wwb.write();
			GetTestExcel.wwb.close();
			GetTestExcel.wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
