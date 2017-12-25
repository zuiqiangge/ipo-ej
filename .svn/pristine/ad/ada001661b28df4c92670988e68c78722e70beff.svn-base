package com.pengyue.ipo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestClob {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testOracle();
		String tString=readString3();
		System.out.println(tString);
		testOracle();
	}
	
	/*按字节读取字符串*/

	/* 个人感觉最好的方式，（一次读完）读字节就读字节吧，读完转码一次不就好了*/

	private static String readString3()

	{

	    String str="";

	    File file=new File("f://data.txt");

	    try {

	        FileInputStream in=new FileInputStream(file);

	        // size  为字串的长度 ，这里一次性读完

	        int size=in.available();

	        byte[] buffer=new byte[size];

	        in.read(buffer);

	        in.close();

	        str=new String(buffer,"GBk");

	    } catch (IOException e) {

	        // TODO Auto-generated catch block

	        return null;
 

	    }

	    return str;

	}
	public static void testOracle()
	{
	    Connection con = null;// 创建一个数据库连接
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result = null;// 创建一个结果集对象
	    try
	    {
	        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");
	        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "ipo";// 用户名,系统默认的账户名
	        String password = "ipo";// 你安装时选设置的密码
	        con = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("连接成功！");
	        String sql = "insert into TB_XT_FOURMCOLLECT values(1,1,1,1,1,1,1,sysdate,1,1,?)";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        //读取文件
	        pre.setString(1, readString3());// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
	            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
	            // 注意关闭的顺序，最后使用的最先关闭
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("数据库连接已关闭！");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}
    private static String readString2()

    {

        StringBuffer str=new StringBuffer("");

        File file=new File("f://data.txt");

        try {

            FileReader fr=new FileReader(file);

            int ch = 0;

            while((ch = fr.read())!=-1 )

            {

                System.out.print((char)ch+" "); 

            }

            fr.close();

        } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

            System.out.println("File reader出错");

        }

        return str.toString();

    }
	   public static void  tesss() {
		   System.out.println(222);
	        Scanner in = null;
	        try {
	            in = new Scanner(new File("F:/data.txt"));
	            String str = "";
	            while (in.hasNextLine()) {
	                str += in.nextLine() + "\r\n";
	            }
	            System.out.println(str);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (in != null) {
	                in.close();
	            }
	        }
	    }
}
