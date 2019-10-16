package service.impl;

import dao.impl.accountDaoImpl;
import service.accountServer;

import java.util.Date;

public class accountServerImpl2 implements accountServer {



      //如果是经常变化的数据并不适用于注入的方式
      private  String name;
      private Integer age;
      private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public void saveAccount() {

        System.out.println("执行类"+name+""+age+""+birthday);
    }

}
