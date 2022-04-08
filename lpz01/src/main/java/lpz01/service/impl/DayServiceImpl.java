package lpz01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lpz01.entity.Day;
import lpz01.entity.Weather;
import lpz01.mapper.DayMapper;
import lpz01.service.DayService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Day Service
 * </p>
 *
 * @author lpz
 * @date Created in 2022-04-07
 */
@Service
public class DayServiceImpl extends ServiceImpl<DayMapper, Day> implements DayService  {

    @Override
    public List<Day> getAllDays() {

        LambdaQueryWrapper<Day> queryWrapper = new LambdaQueryWrapper<>();
        List<Day> result = list(queryWrapper);
        return result;
    }

    @Override
    public boolean delDay(Integer id) {

//        LambdaQueryWrapper<Day> queryWrapper = new LambdaQueryWrapper<>();
        boolean result = removeById(id);
        return result;
    }
}
