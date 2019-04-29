package com.godel.java.task.config;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

/**
 * Class AppConfiguration.
 * create 15.04.2019.
 *
 * @author Pavel Cherkasov
 */

@Configuration
@ComponentScan("com.godel.java.task")
@EnableWebMvc
@PropertySource("classpath:/db.properties")
public class AppConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName(environment.getProperty("db.driver"));
        dm.setUrl(environment.getProperty("db.url"));
        dm.setUsername(environment.getProperty("db.login"));
        dm.setPassword(environment.getProperty("db.password"));

        try {
            ScriptRunner sr = new ScriptRunner(dm.getConnection());
            sr.runScript(new BufferedReader(new FileReader("src/main/resources/init/init.sql")));
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return dm;
    }


}
