package com.jdbc5.blob;

import com.jdbc3.bean.Customer;
import com.jdbc3.util.JDBCUtils;
import org.junit.Test;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;

/**
 * @author lichuang
 * @description 测试使用PreparedStatement操作Blob类型的数据
 * @create 2021-08-08 16:49
 */
public class BlobTest {

    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInstance(){

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setObject(1,"张宇豪");
            ps.setObject(2,"zhangyuhao@qq.com");
            ps.setObject(3,"2020-02-01");
            FileInputStream is = new FileInputStream("playgirl.jpg");
            ps.setObject(4,is);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }

    }

    @Test
    public void testInstance1(){

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setObject(1,"袁浩");
            ps.setObject(2,"yuanhao@qq.com");
            ps.setObject(3,"2020-02-01");
            FileInputStream is = new FileInputStream("girl.jpg");
            ps.setObject(4,is);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }

    }

    //查询数据表customers中Blob类型的字段
    @Test
    public void testQuery(){

        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setObject(1,22);

            rs = ps.executeQuery();
            if(rs.next()) {
                //方式一：
//			    int id = rs.getInt(1);
// 			    String name = rs.getString(2);
//			    String email = rs.getString(3);
//			    Date birth = rs.getDate(4);
                //方式二：
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer cust = new Customer(id, name, email, birth);
                System.out.println(cust);

                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("zhangyuhao.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    if(is != null)
                        is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if(fos != null)
                        fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            JDBCUtils.closeResource(conn,ps);
        }

    }

}
