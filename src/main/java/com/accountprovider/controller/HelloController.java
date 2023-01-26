package com.accountprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<String> hello() {
        namedParameterJdbcTemplate.update("CREATE TABLE test(id int)", new MapSqlParameterSource());
        return ResponseEntity.ok("Hello");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public ResponseEntity<String> plm() {
        return ResponseEntity.ok("Fututi mortim ati gascanule");
    }

}
