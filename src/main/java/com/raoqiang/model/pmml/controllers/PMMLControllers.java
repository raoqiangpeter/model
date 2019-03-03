package com.raoqiang.model.pmml.controllers;

import com.raoqiang.model.pmml.entry.Request;
import com.raoqiang.model.pmml.entry.Response;
import com.raoqiang.model.pmml.services.impl.PMMLEvaluatorImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/pmml")
public class PMMLControllers {

    private static final Log LOG = LogFactory.getLog(PMMLControllers.class);

    @Autowired
    private PMMLEvaluatorImpl evaluator;

    @RequestMapping(value = "/evaluator", method = RequestMethod.POST)
    @ResponseBody
    public Response hbaseOperate(@RequestBody Request pmmlRequest) {
//        System.out.println(pmmlRequest);
        Response response=null;
        try {
            LOG.info("发起模型预测 -> ");
            double result = evaluator.evaluate(pmmlRequest.getParams());
            LOG.info("预测结果 -> " + result);
            HashMap hashMap = new HashMap();
            hashMap.put("1", result);
            List list = new ArrayList();
            list.add(hashMap);
            response = new Response(1, "处理成功", true);
            response.setData(list);

        }catch (Exception e){
            response = new Response(0, "", false);
            response.setMessage(e.getMessage());
        }finally {
            return response;
        }
    }
}
