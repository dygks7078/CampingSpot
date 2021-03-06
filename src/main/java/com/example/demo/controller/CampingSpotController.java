package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CampingSpotDao;
import com.example.demo.vo.CampingReviewVo;
import com.example.demo.vo.CampingSpotVo;
import com.example.demo.vo.CampingWishVo;
import com.google.gson.Gson;

@RestController
public class CampingSpotController {
   
   @Autowired
   private CampingSpotDao dao;
   

   public void setDao(CampingSpotDao dao) {
	   this.dao = dao;
   }
   
   @RequestMapping(value="/detailCampingSpot.do", produces = "application/json;charset=utf8")
   public String detailCampingSpot(int cs_no) {
      String str = "";
      Gson gson = new Gson();
      str = gson.toJson(dao.detailCampingSpot(cs_no));
      
      return str;
   }

   
   @RequestMapping(value="/campingReviewList.do", produces = "application/json;charset=utf8")
   public String campingReviewList(int cs_no) {
      String str = "";
      System.out.println("현재 cs_no : "+cs_no);

      Gson gson = new Gson();
      str = gson.toJson(dao.campingReviewList(cs_no));
      
      System.out.println(str);
      
      return str;
   }
   
   @RequestMapping("/campingInsertWish.do")
   public String insertWish(CampingWishVo w) {
      String str = "";
      
      System.out.println("추가하는 위시항목 CampingWishVo : " +  w);
      
      int re = dao.insertWish(w);
      
      if(re > 0) {
         str = "찜 목록에 추가하였음";
      }
      
      return str;
   }

}
