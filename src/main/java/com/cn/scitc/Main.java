package com.cn.scitc;

import com.alibaba.fastjson.JSON;
import com.cn.scitc.mapper.MovieMapper;
import com.cn.scitc.model.Movie;
import com.cn.scitc.util.GetJson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static  void  main(String [] args) {

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);

        int start;
        int total = 0;
        int end = 9979;
        for (start  = 0; start <= end; start += 20)  {
            try {

                String address = "https://Movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=" + start;

                JSONObject dayLine = new GetJson().getHttpJson(address, 1);

                    System.out.println("start:" + start);
                    JSONArray json = dayLine.getJSONArray("data");
                    List<Movie> list = JSON.parseArray(json.toString(), Movie.class);

                    if (start <= end){
                        System.out.println("已经爬取到底了");
                        sqlSession.close();
                    }
                    for (Movie movie : list) {
                        movieMapper.insert(movie);
                        sqlSession.commit();
                    }
                    total += list.size();
                    System.out.println("正在爬取中---共抓取:" + total + "条数据");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}


