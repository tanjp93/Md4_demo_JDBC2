package rikkei.academy.run;

import rikkei.academy.util.ConnectionToDB;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String SQL = "create table Users(\n" + "    id int primary key auto_increment,\n" + "    name varchar(255)\n" + ")";
        String SQL2 = "insert into Users (id,name) values\n" + "( 3,'Nhung');";
        String SQL3 = "insert into Users (id,name) values\n" + "( 4,'Việt');";
        String SQL4 = "UPDATE users set name='Tuấn Anh' where  id=1;";
        String SQL5 = "UPDATE users set name='Hùng Háo Hức' where  id=2;";

        Connection conn = ConnectionToDB.getConnection();
        try {
            //khoi tao 1 doi tuong statement
//            Statement st = conn.createStatement();
            //thuc thi cau lenh SQL tinh
//            st.execute(SQL);
//            st.executeUpdate(SQL2);
//            st.execute(SQL3);
//            st.execute(SQL4);
//            st.executeUpdate(SQL5);


            //demo prepare statement
            int id = 1;
//            PreparedStatement pre=conn.prepareStatement("SELECT * from Users where id="+id);
//            PreparedStatement pre=conn.prepareStatement("SELECT * from Users");
//            ResultSet rs= pre.executeQuery();
//            System.out.println("rs>>>>"+rs);
//            while(rs.next()){
//                System.out.println(rs.getInt(1));
//                System.out.println(rs.getString(2));
//            }

            //Insert, Update, Delete
//            String name = "Thiều Sỹ Hùng";
//            PreparedStatement preparedStatement = conn.prepareStatement("Insert Into Users (name) values(?)");
//            preparedStatement.setString(1, name);
//            int stt = preparedStatement.executeUpdate();
//            System.out.println("stt==>>>"+ stt);
//             goi procedure thong qua dấu {}  và gọi call trong dấu ngoặc đó.
//            CallableStatement call=conn.prepareCall("{call PROC_GETALLUSERS}");
//            ResultSet rs= call.executeQuery();
//            while (rs.next()){
//                System.out.println(rs.getInt(1)+"--"+rs.getString(2));
//            }
            // cau lenh co tham so
            String newName = "Tuan";
            CallableStatement call = conn.prepareCall("{call PROC_CREATENEWUSER(?)}");
            call.setString(1, newName);
            call.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
