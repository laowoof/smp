package com.oceansoft.szga.smp;

import com.oceansoft.szga.smp.mapper.TestMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * @author  zhangxh
 * @date  2020/7/31 10:22
 * @Email:zhangxh@oceansoft.com.cn
 */
@SpringBootTest
public class TestApplication {
    @Autowired
    private TestMapper mapper;
    @Test
    public void testCache(){

        mapper.list();
        mapper.list();

    }
}
