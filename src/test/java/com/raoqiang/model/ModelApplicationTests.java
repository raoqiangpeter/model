package com.raoqiang.model;

import com.raoqiang.model.pmml.services.impl.PMMLEvaluatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelApplicationTests {


    @Autowired
    private PMMLEvaluatorImpl pmmlEvaluator;
    @Test
    public void contextLoads() {

        Map map = new HashMap();
        map.put("EXT_SOURCES_MEAN", "1.1444091796875E-5");
        System.out.println("预测为1的概率：" + pmmlEvaluator.evaluate(map));
    }

}

