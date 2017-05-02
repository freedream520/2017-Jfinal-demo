package com.jfinal;

import com.ctf.bus.controller.ShopperController;
import com.ctf.bus.entity.Contact;
import com.ctf.bus.entity.Shopper;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.entity.Users;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;

public class FrameworkConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("jdbc.properties");//����JDBC�����ļ�
		// TODO Auto-generated method stub
		//����ģʽ��Ҫ��ӡ��־
		me.setDevMode(true);
		//�������ļ��ж�ȡ���ò���
	    me.setDevMode(getPropertyToBoolean("config.devModel", false));
		//���뷽��
		me.setEncoding("utf-8");
		//��ͼ���ͣ���jsp��freeMark
		me.setViewType(ViewType.JSP);
		//����404����ҳ��
		me.setError404View("error.jsp");

	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		//����web����ʱ��Ĭ��ִ��IndexController��index����
		//���ؿ�����
		me.add("/", IndexController.class);
		me.add("/test",ShopperController.class,"/test");
	}

	@Override
	public void configPlugin(Plugins me) {
		
		//me.setLoggerFactry(new Log4jLoggerfactory);
		
		
		ActiveRecordPlugin arp=null;
	    String driver=getProperty("oracle.driver");
	    String url=getProperty("oracle.url");
	    String username=getProperty("oracle.username");
	    String password=getProperty("oracle.password");
	    DruidPlugin dp=new DruidPlugin(url, username, password, driver);
	    me.add(dp);
	    arp=new ActiveRecordPlugin(dp);//�������ݿⷽ��
	    System.out.println(getProperty("db.type"));
	    if("MySQL".equalsIgnoreCase(getProperty("db.type"))){
	    	 arp.setDialect(new MysqlDialect());
	    }
	    if("Oracle".equalsIgnoreCase(getProperty("db.type"))){
	    	 arp.setDialect(new OracleDialect());
	    }
	    arp.setContainerFactory(new CaseInsensitiveContainerFactory());//���Դ�Сд
	    me.add(new EhCachePlugin());
	    
	    //����ʵ�壬������������
	    arp.setShowSql(true);
	    arp.addMapping("TZY_TEMP2", "id",Users.class);
	    arp.addMapping("tb_shopper", "openid",Shopper.class);
	    arp.addMapping("tb_contact", "openid",Contact.class);
	    
	    
	    
	    me.add(arp);
	   
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		//����ȫ��������
		me.add(new AuthInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		//��web������session�������basePath����webҳ��${basePath}
		me.add(new ContextPathHandler("basePath"));
		me.add(new ActionExtentionHandler());

	}

}