package surface;

import java.awt.Dialog;

import org.apache.log4j.PropertyConfigurator;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import common.Logger;

import InterfaceTest.DoTest;
import datainfo.AppData;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NewComposite extends org.eclipse.swt.widgets.Composite {
	private Text DBURLtext;
	private Label DBurl;
	private Label label1;
	private Label DBpassword;
	private Label msg;
	private Text testCaseUrlText;
	private Label testCaseUrl;
	private Button setsucess;
	private Text DBpasswordtext;
	private Text DBusernametext;
	

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	/**
	* Overriding checkSubclass allows this class to extend org.eclipse.swt.widgets.Composite
	*/	
	protected void checkSubclass() {
	}
	
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();		
		Shell shell = new Shell(display);
		NewComposite inst = new NewComposite(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public NewComposite(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(null);
			this.setSize(574, 574);
			{
				DBURLtext = new Text(this, SWT.NONE);
				DBURLtext.setBounds(70, 91, 189, 28);
			}
			{
				DBusernametext = new Text(this, SWT.NONE);
				DBusernametext.setBounds(70, 154, 189, 28);
			}
			{
				DBpasswordtext = new Text(this, SWT.NONE);
				DBpasswordtext.setBounds(70, 224, 189, 28);
			}
			{
				DBurl = new Label(this, SWT.NONE);
				DBurl.setText("\u8bf7\u8f93\u5165\u6570\u636e\u5e93\u5730\u5740");
				DBurl.setBounds(70, 63, 140, 21);
			}
			{
				label1 = new Label(this, SWT.NONE);
				label1.setText("\u7528\u6237\u540d");
				label1.setSize(60, 30);
				label1.setBounds(70, 126, 63, 28);
			}
			{
				DBpassword = new Label(this, SWT.NONE);
				DBpassword.setText("\u5bc6\u7801");
				DBpassword.setSize(60, 30);
				DBpassword.setBounds(70, 196, 63, 28);
			}
			{
				setsucess = new Button(this, SWT.PUSH | SWT.CENTER);
				setsucess.setText("\u8bbe\u7f6e");
				setsucess.setSize(60, 30);
				setsucess.setBounds(70, 273, 63, 28);
				setsucess.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						setsucessWidgetSelected(evt);
					}
				});
			}
			{
				testCaseUrl = new Label(this, SWT.NONE);
				testCaseUrl.setText("\u6d4b\u8bd5\u7528\u4f8b\u8def\u5f84");
				testCaseUrl.setBounds(301, 63, 140, 28);
			}
			{
				testCaseUrlText = new Text(this, SWT.NONE);
				testCaseUrlText.setBounds(301, 91, 224, 28);
			}
			{
				final Button startCase = new Button(this, SWT.PUSH | SWT.CENTER);
				startCase.setText("\u6267\u884c\u7528\u4f8b");
				startCase.setSize(60, 30);
				startCase.setBounds(343, 189, 63, 28);
				startCase.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						startCaseWidgetSelected(evt);
					}
				});
			}
			{
				msg = new Label(this, SWT.NONE);
				msg.setBounds(301, 224, 224, 30);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setsucessWidgetSelected(SelectionEvent evt) {
		System.out.println("setsucess.widgetSelected, event="+evt);
		if("".equals(DBURLtext.getText()) || "".equals(DBusernametext.getText()) || "".equals(DBpasswordtext.getText()) || "".equals(testCaseUrlText.getText())){
			msg.setText("请完成设置先~~");
		}else {
			AppData.DBPath = DBURLtext.getText();
			AppData.DBUserName = DBusernametext.getText();
			AppData.DBPassWord = DBpasswordtext.getText();
			AppData.testCasePath = testCaseUrlText.getText();
			msg.setText("设置成功");
		}
		
		
		
	}
	
	private void startCaseWidgetSelected(SelectionEvent evt) {
		System.out.println("startCase.widgetSelected, event="+evt);
		//TODO add your code for startCase.widgetSelected
		if("".equals(AppData.DBPath) || "".equals(AppData.DBUserName) || "".equals(AppData.DBPassWord) || "".equals(AppData.testCasePath)){
			msg.setText("请完成设置先~~");
		}else {
			msg.setText("");
			DoTest.doTest();
		}	
	}

}
