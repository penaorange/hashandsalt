package com.penaorange.authentication.repository;

import com.penaorange.authentication.model.Pengguna;
import java.util.List;

public interface PenggunaRepository {
    List<Pengguna> findAll();

    int save(Pengguna pengguna);
}
