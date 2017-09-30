package getexcel;


import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class ReadExcel {

	
	//��ȡ��ǰsheet��ָ����Ԫ������
	public static String readCell (int column,int row){
		String content = "";
		try{
			content = GetTestExcel.sheet.getCell(column, row).getContents();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("��ȡ��ǰsheet��ָ����Ԫ�������쳣");
		}
		return content;
	}
	
	//���õ�Ԫ���ʽ
	public static WritableCellFormat setFormat (String color) {
			WritableFont wf = null;
			WritableCellFormat wcf = null;
			//ͨ��color�ж�д���������ɫ
			if (color.equals("RED")) {
			// ���õ�Ԫ���ʽΪ��13�����壬û��б�壬��ɫ����
				wf = new WritableFont(WritableFont.TIMES, 13, WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);
				wcf = new WritableCellFormat(wf);
			} else if (color.equals("BLUE")) {
				wf = new WritableFont(WritableFont.TIMES, 13, WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
				wcf = new WritableCellFormat(wf);
			} else if (color.equals("BLACK")) {
				wf = new WritableFont(WritableFont.TIMES, 13, WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
				wcf = new WritableCellFormat(wf);
			}
			return wcf;				
		}
		
	//ָ����Ԫ��д������
	public static void writeCell (int column,int row, String content, String color){
		try {
			GetTestExcel.wSheet.addCell(new Label(column, row, content, setFormat(color)));
		} catch (Exception e) {
			System.out.println("Excel����ӵ�Ԫ��ʧ�ܣ�");
		}		
	}
	
	//��ȡ·��
	public static String getUrl (int row){
		String url = "";
		try {
			String host = readCell(1, row);
			String port = readCell(2, row);
			String trace = readCell(3, row);
			url = "http://" + host + ":" + port + trace;
			return url;
		} catch (Exception e) {
			System.out.println("��ȡ�ӿ�·������");
			e.printStackTrace();
		}
		return url;
	}
	
	//��ȡ�������
	public static String getRequest (int row){
			String request = "";
			try {
				request = readCell(5, row);
				return request;
			} catch (Exception e) {
				System.out.println("��ȡ��������");
				e.printStackTrace();
			}
			return request;
		}
	
	//��ȡ����
	public static String getAffirm (int row){
		String affirm = "";
		try {
			affirm = readCell(7, row);
			return affirm;
		} catch (Exception e) {
			System.out.println("��ȡ��������");
			e.printStackTrace();
		}
		return affirm;
	}
	
	//д����
	public static void writeResult (int row,String respone,boolean compareResult){
		try {
			if (compareResult){
				writeCell(6,row,respone,"BLACK");
				writeCell(8,row,compareResult+"","BLUE");
			}else {
				writeCell(6, row, respone, "BLACK");
				writeCell(8,row,compareResult+"","RED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��excelд�����ݳ���");
		}
	}
	
}
