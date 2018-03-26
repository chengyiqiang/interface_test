package DBset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;


/**
 * @author nxa-chengyiqiang
 *
 */
public class DBUtil {
	
	public static Connection connection;
	//连接数据库
	public static void setDBConnection(){
		try {
			//String path,String username,String password
			//加载驱动程序
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//获取连接
//			connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DataBaseName=test", "cs_cyq", "cyq900820");
			connection = DriverManager.getConnection("jdbc:sqlserver://192.168.50.30:6666;DataBaseName=nxa_ytc", "nxa_yf", "nxa_yf$@42");
			
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}			
	} 
	
	//执行查询sql 并返回结果
	public static ResultSet executesSelectSql(String sql){
		ResultSet result = null;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			result = pStatement.executeQuery();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select类型语句执行异常");
		}
		return result;		
	}
	
	//获取指定查询sql结果的指定列名的值
	public static List<String> getSelectResult(String sql, String columnName){
		List<String> results = new ArrayList<String>();
		try {
			ResultSet rs = executesSelectSql(sql);
			while(rs.next()){
				String columncontent = rs.getString(columnName);
				results.add(columncontent);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取查询结果指定列内容异常");
		}
		return results;
	}
	
	//执行 INSERT、UPDATE 或 DELETE 语句；或者是无返回内容的 SQL 语句，比如 DDL 语句
	public static boolean executeUpdateSql (String sql){
		boolean result = false;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update类型语句执行异常");
		}
		return result;
	}

	
}
