package com.gabi.service;

import com.gabi.model.Banner;

import java.util.List;

public interface BannerService {

    void insertar(Banner banner);

    List<Banner> buscarTodos();
}
