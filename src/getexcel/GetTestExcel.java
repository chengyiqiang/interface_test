package getexcel;

import java.io.File;

import org.omg.CORBA.WStringValueHelper;

import datainfo.AppData;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class GetTestExcel {
	//��ȡ���еĲ�������
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
			System.out.println("��ȡ��������Excel����");
			e.printStackTrace();
		}
	}
	
	//��ȡ��д����sheet
	public static void getWritableSheet (int sheetNum){
		wSheet = wwb.getSheet(sheetNum);
	}
	
	//��ȡ�ɶ�����sheet
	public static void getSheet (int sheetNum){
		sheet = wb.getSheet(sheetNum);
		//ÿ�λ�ȡsheet������rowֵ����Ϊ1���ڶ��У�
		row = 1;
	}

}
