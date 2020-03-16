package com.wangyongle.clininserver.service.impl;

import com.wangyongle.clininserver.entity.Recipe;
import com.wangyongle.clininserver.mapper.RecipeMapper;
import com.wangyongle.clininserver.service.IRecipeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-03-16
 */
@Service
public class RecipeServiceImpl extends ServiceImpl<RecipeMapper, Recipe> implements IRecipeService {

}
