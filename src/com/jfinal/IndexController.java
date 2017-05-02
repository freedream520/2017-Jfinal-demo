package com.jfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctf.bus.entity.Shopper;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.entity.Addr;
import com.jfinal.entity.Users;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.tx.Tx;

public class IndexController extends Controller {

        Log log = LogFactory.getLog(IndexController.class);


		public void index(){

			log.info("======testlog4j===");
			this.render("/index.jsp");

		}
		//方法类似于action了，调用这个方法，直接用sayhello
		public void sayHello(){

			
			String userName = this.getPara("userName");
			
			this.getRender();
			this.getRequest().getSession().getAttribute("ddddd");
			this.getResponse();

			String sayHello = "Hello " + userName + "，welcome to JFinal world.";

			this.setAttr("sayHello", sayHello);

			this.render("/hello.jsp");

		}
		public void search(){
			//关联查询很方便
			List<Users> testList1 = Users.dao.find("select * from TZY_TEMP2 A,TZY_TEMP3 B where A.id=B.id");
			Users u = testList1.get(0);
			System.out.println("ll:"+testList1);
			//通过此种方法取值，所以没有必要再定义实体的属性了
			System.out.println(u.getUsername());
			
		}
		//@Before(Tx.class)
		@Before(POST.class)
		//@Before(GET.class)
		public void saveUser(){
			Users user=new Users();
			user.set("id", UUID.randomUUID().toString());//users_sequence.nextval
			user.set("username", "张三");
			user.set("pwd", "sdfsdfs");
			user.save();
			List<Users> testList=Users.dao.find("select * from TZY_TEMP2");
			System.out.println(testList);
			for(int k=0;k<testList.size();k++){
				System.out.println(testList.get(k).getStr("username"));
			}
			
			//关联查询很方便
			List<Users> testList1 = Users.dao.find("select * from TZY_TEMP2 A,TZY_TEMP3 B where A.id=B.id");
			
			System.out.println("ll:"+testList1);
			/*Users u = Users.dao.findById("4e5d4f86-e142-44e6-a72f-f92f2e47281c");
			
			
			
			u.set("username", "小明");
			
			u.update();
			
			
			Users.dao.deleteById("","","");
			
			System.out.println(u);
			*/
			//System.out.println(1/0);
			this.render("/test.jsp");
		}
		
		//异常必须抛出去才能事务回滚
		@Before(Tx.class)
		public void testTransactin(){
			
			try{
				Users user=new Users();
				user.set("id", UUID.randomUUID().toString());
				user.set("username", "张三2222");
				user.set("pwd", "sdfsdfs");
				user.save();
				int i = 0,j=1;
				j=j/i;
			}catch(Exception e){
				e.printStackTrace();
			}
			this.render("/trans.jsp");
		}
		//自定义actionname，若不显示定义这是方法名称
		@ActionKey("/tzy/test")
		public void testAnotation(){
			System.out.println("-------hahahhhahah-----------------");
		}
		//返回json数据
		@ActionKey("json")
		@Before(POST.class)
		public void testJson(){
			Addr a = new Addr();
			a.setId("1");
			a.setName("张三");
			a.setUrl("hahahh");
			Addr b = new Addr();
			b.setId("2");
			b.setName("网路");
			b.setUrl("uuuu");
			List<Addr> l = new ArrayList<Addr>();
			l.add(a);
			l.add(b);
			System.out.println("????????????????????");
			this.renderJson("addr",l);
		}
		
		public void listShopper2(){
			List<Shopper> shopperlist = Shopper.dao.find("select * from tb_shopper a ,tb_contact b where a.openid = b.openid");
			System.out.println("------listshopper-------"+shopperlist);
			System.out.println(shopperlist.get(0).getStr("tel"));
		}
	}
