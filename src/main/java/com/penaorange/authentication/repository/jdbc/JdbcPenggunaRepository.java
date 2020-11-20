package com.penaorange.authentication.repository.jdbc;

import java.util.List;

import com.penaorange.authentication.model.Pengguna;
import com.penaorange.authentication.repository.PenggunaRepository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPenggunaRepository implements PenggunaRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcPenggunaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pengguna> findAll() {
        return jdbcTemplate.query("SELECT username, password FROM pengguna",
                (rs, rowNum) -> new Pengguna(rs.getString("username"), rs.getString("password")));
    }

    @Override
    public int save(Pengguna pengguna) {
        return jdbcTemplate.update("INSERT INTO pengguna(username, password) VALUES (?, ?)", pengguna.getUsername(),
                pengguna.getPassword());
    }

}