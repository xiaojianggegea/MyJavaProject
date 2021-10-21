package com.ghj.dao;

import com.ghj.entity.Tutor;

/**
 * @program: mybatis
 * @description: 一对多接口
 * @author: 小江
 * @create: 2021-10-21 16:59
 **/

public interface StudentOneToManyMapper {
    Tutor findTutorById(int id);
}
