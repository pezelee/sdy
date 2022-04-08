package lpz01.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lpz01.entity.Day;
import lpz01.entity.Weather;
import lpz01.service.DayService;
import lpz01.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期 Controller
 */
@RestController
@RequestMapping("/weathers")
public class WeatherController {

    @Autowired
    private DayService dayService;

    @Autowired
    private WeatherService weatherService;

    /**
     * 查询日期列表
     *
     * @return 日期列表
     */
    @GetMapping("/{dayId}")
    public List<Weather> getAllList(@PathVariable("dayId")Integer dayId) {
        // 查询列表
        List<Weather> result;
        result=weatherService.getAllDetails(dayId);
        return result;
    }

    /**
     * 获得指定日期编号的日期
     *
     * @param id 日期编号
     * @return 日期
//     */
//    @GetMapping("/{id}")
//    public Day get(@PathVariable("id") Integer id) {
//        // 查询并返回日期
//        return dayService.getById(id);
//    }

    /**
     * 添加日期
     *
     * @param data 添加日期信息 Day
     * @return 添加成功的日期编号
     */
    @PostMapping("/add")
    public boolean add(@RequestBody JSONObject data) {
        //System.out.println(data);
        Day temp = new Day().setName(data.getString("name"))
                .setPassword(data.getString("pw"))
                .setDeleted(0);
        //dayMapper.insert(day);
        boolean save = dayService.save(temp);
        return save;
    }
}
