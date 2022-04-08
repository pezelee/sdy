package lpz01.mapper;

import lpz01.Application;
import lpz01.entity.Day;
import lpz01.mapper.DayMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lpz01.service.DayService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DayMapperTest {

    @Autowired
    private DayMapper dayMapper;

    @Autowired
    private DayService dayService;

    @Test
    public void testInsert() {
        Day day = new Day().setName("五月一日")
                .setPassword("123456")
                .setDeleted(0); // 一般情况下，是否删除，可以全局枚举下。
        //dayMapper.insert(day);
        boolean save = dayService.save(day);
    }

    @Test
    public void testUpdateById() {
        Day updateUser = new Day().setId(1)
                .setPassword("wobucai");
        dayMapper.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        dayMapper.deleteById(10);
    }

    @Test
    public void testSelectById() {
        System.out.println("----------------1----------------------");
        Day day = dayMapper.selectById(1);
        System.out.println("----------------2---------------------");
        System.out.println(dayMapper);
        Assert.assertNotNull(day);
        log.debug("【user】= {}", day);
        System.out.println("----------------3---------------------");
    }

    @Test
    public void testSelectByName() {
        dayMapper.selectByName("四月一日");
    }

    @Test
    public void testSelectByIds() {
        List<Day> users = dayMapper.selectByIds(Arrays.asList(1, 3));
        System.out.println("users：" + users.size());
    }

    @Test
    public void testSelectPageByCreateTime() {
        IPage<Day> page = new Page<>(1, 10);
        Date createTime = new Date(2018 - 1990, Calendar.FEBRUARY, 24); // 临时 Demo ，实际不建议这么写
        page = dayMapper.selectPageByCreateTime(page, createTime);
        System.out.println("users：" + page.getRecords().size());
    }

}
