package com.ctf.bus.controller;

import java.util.List;

import com.ctf.bus.entity.Shopper;
import com.jfinal.core.Controller;

public class ShopperController extends Controller{
	
	public void listShopper(){
		List<Shopper> shopperlist = Shopper.dao.find("select * from tb_shopper a ,tb_contact b where a.openid = b.openid");
		System.out.println("------listshopper-------");
		System.out.println(shopperlist.get(0).getStr("tel"));
	}
	public void index(){
		System.out.println("index");
		this.render("/index.jsp");
	}
	public void test3(){
		System.out.println("-------test------------------");
	}

}
