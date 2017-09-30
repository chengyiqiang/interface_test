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
	//�������ݿ�
	public static void setDBConnection(){
		try {
			//String path,String username,String password
			//������������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//��ȡ����
//			connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DataBaseName=test", "cs_cyq", "cyq900820");
			connection = DriverManager.getConnection("jdbc:sqlserver://192.168.50.30:6666;DataBaseName=nxa_ytc", "nxa_yf", "nxa_yf$@42");
			
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}			
	} 
	
	//ִ�в�ѯsql �����ؽ��
	public static ResultSet executesSelectSql(String sql){
		ResultSet result = null;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			result = pStatement.executeQuery();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select�������ִ���쳣");
		}
		return result;		
	}
	
	//��ȡָ����ѯsql�����ָ��������ֵ
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
			System.out.println("��ȡ��ѯ���ָ���������쳣");
		}
		return results;
	}
	
	//ִ�� INSERT��UPDATE �� DELETE ��䣻�������޷������ݵ� SQL ��䣬���� DDL ���
	public static boolean executeUpdateSql (String sql){
		boolean result = false;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update�������ִ���쳣");
		}
		return result;
	}

	
}
