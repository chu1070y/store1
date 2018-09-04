package org.zerock;

import org.zerock.domain.ReviewVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ReviewDAO {

    public void add(ReviewVO vo){

        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "insert into tbl_review(rno,mid,mno,score,cmt) values (seq_review.nextval,?,?,?,?)";

        try{
            //sql 연결시키기
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.95:1521:XE","zz","12345678");
            System.out.println(con);
            stmt = con.prepareStatement(sql);

            //mid,mno,score //여기서는 0이 아니라 1부터 시작한다.
            stmt.setString(1,vo.getMid());
            stmt.setInt(2,vo.getMno());
            stmt.setDouble(3,vo.getScore());
            stmt.setString(4,vo.getCmt());

            //업데이트 실행
            int count = stmt.executeUpdate();
            System.out.println(count);

        }catch(Exception e){
            System.out.println(e.getMessage());

        }finally {
            if(stmt != null){try{stmt.close();}catch (Exception e){} }
            if(con != null){try{con.close();}catch (Exception e){} }
        }//end finally

    }//end method

}//end class
