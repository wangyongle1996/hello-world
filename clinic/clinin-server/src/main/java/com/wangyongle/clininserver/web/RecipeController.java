package com.wangyongle.clininserver.web;


import com.wangyongle.clininserver.dto.RecipeDto;
import com.wangyongle.clininserver.entity.Recipe;
import com.wangyongle.clininserver.service.IRecipeService;
import com.wangyongle.clininserver.vo.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-03-16
 */
@CrossOrigin
@RestController
@RequestMapping("/clinic/recipe")
public class RecipeController {
    @Autowired
    IRecipeService iRecipeService;

    @RequestMapping("add")
    public ResultEntity add(RecipeDto recipeDto){
        recipeDto.setUserId(recipeDto.getId());
        Recipe recipe = new Recipe();
        BeanUtils.copyProperties(recipeDto, recipe);
        return ResultEntity.ok("添加成功",iRecipeService.insert(recipe));
    }

}
