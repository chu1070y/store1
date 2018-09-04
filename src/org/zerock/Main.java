package org.zerock;

import org.zerock.domain.MenuDAO;
import org.zerock.domain.MenuVO;
import org.zerock.domain.ReviewVO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        VoteDAO dao = new VoteDAO();
//        dao.addVote("user04");

//        ReviewVO vo = new ReviewVO();
//        vo.setMid("walowizard");
//        vo.setMno(25);
//        vo.setScore(1.0);
//        vo.setCmt("으아아아아아아아아아아ㅏㅏㅏㅏㅏㅏㅏ ");
//
//        ReviewDAO dao = new ReviewDAO();
//        dao.add(vo);


        //가게넘버가 1인 메뉴 불러오기
        MenuDAO dao1 = new MenuDAO();

        List<MenuVO> arr =  dao1.getMenus(1);
        System.out.println(arr);


    }
}
