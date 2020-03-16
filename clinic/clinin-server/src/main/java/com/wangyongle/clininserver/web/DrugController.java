package com.wangyongle.clininserver.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wangyongle.clininserver.dto.DrugDto;
import com.wangyongle.clininserver.entity.Drug;
import com.wangyongle.clininserver.service.IDrugService;
import com.wangyongle.clininserver.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/clinic/drug")
public class DrugController {
    @Autowired
    IDrugService iDrugService;
    @RequestMapping("/list")
    public ResultEntity list(DrugDto drugDto){
        List<Drug> drugs = iDrugService.selectList(new EntityWrapper<>());
        return ResultEntity.ok(drugs);
    }

}
