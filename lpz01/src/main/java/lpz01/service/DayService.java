package lpz01.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lpz01.entity.Day;
import lpz01.entity.Weather;

import java.util.List;

/**
 * <p>
 * Day Service
 * </p>
 *
 * @author lpz
 * @date Created in 2022-04-07
 */
public interface DayService extends IService<Day>  {

    public List<Day> getAllDays();

    public boolean delDay(Integer id);
}
