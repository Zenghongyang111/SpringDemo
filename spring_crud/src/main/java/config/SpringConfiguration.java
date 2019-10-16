package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 * @Configuration
 *      作用：
 *          当前类是一个配置类
 *      细节:
 *          当配置类作为AnnotationConfigApplicationContext创建的参数时该注解可以不写，但并不绝对
 *
 * @ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：
 *          value：和basePackage的作用是一样的，都是用于指定容器创建时要扫描的包
 *                  使用此注解就等同于在xml中配置了原xml中的扫描包标签
 * @Bean
 *      作用：用于把当前作用的返回值作为bean对象存入spring的ioc容器中
 *      属性：
 *          name：用于指定bean的id。默认值是当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象
 *          查找的方式和Autowired注解的作用是一样的
 * @import
 *      作用：用于导入其他的配置类
 *      属性:
 *          value：用于指定其他配置类的字节码
 *                  当我们使用Import的注解之后，有import注解的类就是父配置类，导入的都是子配置类
 * @propertySource:
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value:指定文件的名称和路径
 *              关键字：classpath,表示类路径下
 *
 *      */
@Configuration
@ComponentScan({"service.impl","dao.impl"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
//    @Bean(name="runner_config")
//    @Scope("prototype")
//    public QueryRunner creatQueryRunner(DataSource dataSource){
//        return new QueryRunner(dataSource);
//    }

    /**
     * 创建数据源对象
     * @return
     */
//    @Bean(name = "dataSource_config")
//    public DataSource createDatasource(){
//        ComboPooledDataSource ds = new ComboPooledDataSource();
//        try {
//            ds.setDriverClass("com.mysql.jdbc.Driver");
//             ds.setJdbcUrl("jdbc:mysql://localhost:3306/petstore");
//             ds.setUser("root");
//             ds.setPassword("12345678");
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        return  ds;
//    }
}
