package com.accountprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public HelloController(NamedParameterJdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{name}/create")
    public ResponseEntity<String> hello(
        @PathVariable String name
    ) {
        namedParameterJdbcTemplate.update("CREATE TABLE IF NOT EXISTS User(name VARCHAR(64))", new MapSqlParameterSource());
        namedParameterJdbcTemplate.update("INSERT INTO User (name) VALUES (:name)",
                new MapSqlParameterSource().addValue("name", name));
        return ResponseEntity.ok(name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("HELOOOOOO");
    }

}
