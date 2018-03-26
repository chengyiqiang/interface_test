package getexcel;


import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class ReadExcel {

	
	//读取当前sheet中指定单元格内容
	public static String readCell (int column,int row){
		String content = "";
		try{
			content = GetTestExcel.sheet.getCell(column, row).getContents();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("读取当前sheet中指定单元格内容异常");
		}
		return content;
	}
	
	//设置单元格格式
	public static WritableCellFormat setFormat (String color) {
			WritableFont wf = null;
			WritableCellFormat wcf = null;
			//通过color判断写入的字体颜色
			if (color.equals("RED")) {
			// 设置单元格格式为：13号字体，没有斜体，红色字体
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
		
	//指定单元格写入数据
	public static void writeCell (int column,int row, String content, String color){
		try {
			GetTestExcel.wSheet.addCell(new Label(column, row, content, setFormat(color)));
		} catch (Exception e) {
			System.out.println("Excel表添加单元格失败！");
		}		
	}
	
	//读取路径
	public static String getUrl (int row){
		String url = "";
		try {
			String host = readCell(1, row);
			String port = readCell(2, row);
			String trace = readCell(3, row);
			url = "http://" + host + ":" + port + trace;
			return url;
		} catch (Exception e) {
			System.out.println("读取接口路径错误");
			e.printStackTrace();
		}
		return url;
	}
	
	//读取请求参数
	public static String getRequest (int row){
			String request = "";
			try {
				request = readCell(5, row);
				return request;
			} catch (Exception e) {
				System.out.println("读取用例错误");
				e.printStackTrace();
			}
			return request;
		}
	
	//读取断言
	public static String getAffirm (int row){
		String affirm = "";
		try {
			affirm = readCell(7, row);
			return affirm;
		} catch (Exception e) {
			System.out.println("读取用例错误");
			e.printStackTrace();
		}
		return affirm;
	}
	
	//写入结果
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
			System.out.println("向excel写入数据出错");
		}
	}
	
}
