package service.impl;

import dao.impl.accountDaoImpl;
import service.accountServer;

import java.util.Date;

public class accountServerImpl implements accountServer {

//    accountDaoImpl ac = (accountDaoImpl) BeanFactoryOwn.getBean("accountDao");
      accountDaoImpl ac = new accountDaoImpl();

      //如果是经常变化的数据并不适用于注入的方式
      private  String name;
      private Integer age;
      private Date birthday;

      public accountServerImpl(String name,Integer age,Date birthday){
          this.name = name;
          this.age = age;
          this.birthday = birthday;
      }

    @Override
    public void saveAccount() {

        System.out.println("执行类"+name+""+age+""+birthday);
    }
    public void init(){
        System.out.println("init");
    }
    public void destroy(){
        System.out.println("destroy");
    }
}
