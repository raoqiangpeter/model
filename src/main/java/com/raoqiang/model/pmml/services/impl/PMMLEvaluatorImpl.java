package com.raoqiang.model.pmml.services.impl;

import com.raoqiang.model.pmml.services.PMMLEvaluator;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PMMLEvaluatorImpl implements PMMLEvaluator {

    @Autowired
    private Evaluator evaluator;

    @Override
    public double evaluate(Map map) {
        // 获取模型输入字段名
        List<InputField> inputFields = evaluator.getInputFields();
        // 组装模型输入项
        Map<FieldName, FieldValue> arguments = new LinkedHashMap<>();
        for (InputField inputField : inputFields) {
            FieldName inputFieldName = inputField.getName();
            arguments.put(inputFieldName, inputField.prepare(map.get(inputFieldName.getValue())));
        }

        Map<FieldName, ?> results = evaluator.evaluate(arguments);
        List<TargetField> targetFields = evaluator.getTargetFields();
        return ((ProbabilityDistribution)(results.get(targetFields.get(0).getName()))).getProbability("1");
    }
}
