package lpz01.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lpz01.entity.Weather;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface WeatherMapper extends BaseMapper<Weather> {
    default Weather selectByUsername(@Param("name") String name) {
        return selectOne(new QueryWrapper<Weather>().eq("name", name));
    }

    default IPage<Weather> selectPageByCreateTime(IPage<Weather> page, @Param("createTime") Date createTime) {
        return selectPage(page,
                new QueryWrapper<Weather>().gt("create_time", createTime)
//                new QueryWrapper<UserDO>().like("username", "46683d9d")
        );
    }
}
