package com.gabi.service;

import com.gabi.model.Banner;
import com.gabi.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerRepository bannerRepositoryObj;

    //constructor vacio
    public BannerServiceImpl(){

    }


    public void insertar(Banner banner) {
        bannerRepositoryObj.save(banner);
    }

    public List<Banner> buscarTodos() {
        return bannerRepositoryObj.findAll();
    }
}
