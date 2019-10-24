package biz.pagodatech.foodtruckfinder.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.ResourceBundle;

@SpringBootApplication
@Configuration
@EntityScan({"biz.pagodatech.foodtruckfinder.api.entity"})
@ComponentScan({"biz.pagodatech.foodtruckfinder.api.**"})
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class FoodTruckFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodTruckFinderApplication.class, args);
    }

    @Bean
    public DataSource dataSource(Environment e){
        return DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver")
                .username(e.getRequiredProperty("foodtruck.db.username"))
                .password(e.getRequiredProperty("foodtruck.db.password"))
                .url(e.getRequiredProperty("foodtruck.db.url"))
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds){
        return new JdbcTemplate(ds);
    }

    @Bean("errors")
    public ResourceBundle errors(@Value("messages.errors") String errorsBundle){
        return ResourceBundle.getBundle(errorsBundle);
    }
}
