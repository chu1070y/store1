/*
* oracle 데이터베이스에 저장되어있는
*
* */

package org.zerock.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    public List<MenuVO> getMenus(int sno){

        String sql = "select * from tbl_menu where sno=? order by mno";
        List<MenuVO> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            //sql 연결시키기
            Class.forName("oracle.jdbc.OracleDriver");
            //oracle 데이터베이스와 연결
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.95:1521:XE","zz","12345678");
            System.out.println(con);
            //sql문 준비
            stmt = con.prepareStatement(sql);

            //sql 구문에 첫번째 ?(물음표)에 sno를 넣는다.
            stmt.setInt(1,sno);

            rs = stmt.executeQuery();

            //for문은 데이터 행을 한줄씩 빨아들이고 다음 행으로 넘어간다.
            //데이터 받아오는 코드
            while(rs.next()){
                MenuVO vo = new MenuVO(); //한 라인당 menuvo로 저장해준다.
                vo.setMno(rs.getInt("mno")); //mno를 받아와 숫자로 바꾼다.
                vo.setSno(rs.getInt("sno")); //sno를 받아와 숫자로 바꾼다.
                vo.setMname(rs.getString("mname")); //mname을 받아와 문자열로 바꾼다.
                vo.setPrice(rs.getInt("price")); //price를 받아와 숫자로 바꾼다.
                list.add(vo); //리스트에 메뉴정보를 넣어준다.
            }

            //업데이트 실행
            int count = stmt.executeUpdate();
            System.out.println(count);

        }catch(Exception e){
            System.out.println(e.getMessage());

        }finally {
            if(rs != null){     try{rs.close();}    catch (Exception e){} }
            if(stmt != null){   try{stmt.close();}  catch (Exception e){} }
            if(con != null){    try{con.close();}   catch (Exception e){} }
        }//end finally

        return list;

    }
}
