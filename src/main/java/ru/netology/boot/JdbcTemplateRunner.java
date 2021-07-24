package ru.netology.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author bse71
 * Created on 23.07.2021
 * @since
 */

//@Component
public class JdbcTemplateRunner implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet("SELECT * FROM cars;");
        System.out.println("Вот что в БД:");
        while(resultSet.next()) {
            int id = resultSet.getInt(("id"));
            String name = resultSet.getString(("name"));
            String model = resultSet.getString(("model"));

            System.out.printf("%-5d%-16s%-16s\n", id, name, model);
        }
    }
}
