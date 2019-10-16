package service.impl;

import dao.accountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.accountServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * 使用注解实现ioc注入
 * 曾经的Xml配置：
 * <bean id="accountserver" class="service.impl.accountServerimpl_Anno" scope="" init-method=""
 *  destroy-method="">
 *          <property name="" value="" ref=""></property>
 *  </bean>
 *
 * 用于创建对象的注解
 *      和在xml配置文件中编写一个<bean>标签实现的功能是一样的
 *      @Component：
 *          作用：用于把当前类对象存入spring容器中；
 *          属性：
 *              value：用于指定bean的id。当我们不写时，默认值为当前类名且首字母小写
 *      @Controller：一般用在表现层
 *      @Service：一般用在业务层
 *      @Repository：一般用于持久层
 *
 *      以上三个注解的作用和属性于component是一样的；他们三个是spring框架为我们提供明确的三层使用的注解，
 *      使我们的三层对象更加清晰
 *
 * 用于注入数据的注解
 *      和在xml配置文件中的bean标签中写一个property标签的作用是一样的
 *      @Aotowired:
 *          作用：1。自动按照类型注入，只要容器中有唯一一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *               2。如果ioc容器中没有任何bean的类型和要注入的类型匹配，则报错
 *               3。如果ioc容器中有多个类型匹配时：先比较类型，在看名称和id是否匹配
 *          出现位置：可以是变量上，也可以是方法上
 *          细节：
 *              在使用注解注入时，set方法就不是必须的了；
 *      @Qurlifier：
 *          作用：在按照类中注入的基础上再按照名称注入，他在给类成员注入时不能单独使用，但是在给方法参数注入时可以
 *          属性：
 *              value：用于指定id；
 *      @Resource
 *          作用：直接按照bean的id使用，可以独立使用
 *          属性：
 *              name：用于指定bean的id；
 *       以上三个注解都只能注入其他bean类型的数据，而基本数据类型和string类型无法使用上述注解实现，集合类型只能通过xml注入
 *      @Value：
 *          作用：用于注入基本类型和string类型的数据
 *          属性：
 *              value：用于指定数据的值。他可以使用spring中的SpEL（也即是spring中的EL表达式）
 *                      SpEL的写法：${表达式}；
 * 用于改变作用范围的注解
 *      和在bean标签中使用scope属性实现的功能是一样的
 *      @Scope：
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用：singleton，prototype；默认是单例的（singleton）；
 * 和生命周期相关的（了解即可）
 *      @PreDestroy
 *          用于指定销毁方法
 *      @PostConstruct
 *          用于指定初始化方法
 *      和在bean标签中使用init-method和destroy-method作用是一样的；
 */

@Service("anno_service")
public class accountServerImpl_Anno implements accountServer {

//    @Autowired
//    @Qualifier("anno_Dao")
    @Resource(name="anno_Dao")
    private accountDao acd ;

    @Override
    public void saveAccount() {

        acd.saveAccount();
    }

    @PreDestroy
    public void destroy() {

        System.out.println("销毁");
    }

    @PostConstruct
    public void init() {

        System.out.println("初始化");
    }
}
