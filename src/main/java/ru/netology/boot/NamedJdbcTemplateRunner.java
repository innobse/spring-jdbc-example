package ru.netology.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import ru.netology.boot.model.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author bse71
 * Created on 23.07.2021
 * @since
 */

@Component
public class NamedJdbcTemplateRunner implements CommandLineRunner {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public NamedJdbcTemplateRunner(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("id", 4);

        Car car =
                jdbcTemplate.queryForObject(
                        "SELECT * FROM cars WHERE id = :id;",
                        params, new BeanPropertyRowMapper<Car>(Car.class));
        System.out.println(car.getModel());
    }
}
