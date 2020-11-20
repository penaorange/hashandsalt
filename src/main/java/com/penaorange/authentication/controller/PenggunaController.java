package com.penaorange.authentication.controller;

import com.penaorange.authentication.model.Pengguna;
import com.penaorange.authentication.repository.jdbc.JdbcPenggunaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("pengguna")
public class PenggunaController {
    private final JdbcPenggunaRepository jdbcPenggunaRepository;

    public PenggunaController(JdbcPenggunaRepository jdbcPenggunaRepository) {
        this.jdbcPenggunaRepository = jdbcPenggunaRepository;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Pengguna> penggunas = jdbcPenggunaRepository.findAll();
        model.addAttribute("penggunas", penggunas);
        return "pengguna/index";
    }
}