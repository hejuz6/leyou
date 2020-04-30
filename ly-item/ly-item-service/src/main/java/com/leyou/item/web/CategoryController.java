package com.leyou.item.web;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("catagory")
public class CatagoryController {
    @Autowired
    private CategoryService catagoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCatagoryList(@RequestParam("pid") Long pid) {

        return ResponseEntity.ok(catagoryService.queryCatagoryListByPid(pid));
    }
}
