package config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JdbcConfig {

    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    /*
     * 用于创建一个QueryRunner对象
     * */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /*
     * 创建数据源对象
     * */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        System.out.println(driverClassName);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);

        try {
            Properties properties = new Properties();
            InputStream is = SpringConfiguration.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
