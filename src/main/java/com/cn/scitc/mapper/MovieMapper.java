package com.cn.scitc.mapper;

import com.cn.scitc.model.Movie;

import java.util.List;

public interface MovieMapper {

    void insert(Movie movie);

    List<Movie> findAll();
}
