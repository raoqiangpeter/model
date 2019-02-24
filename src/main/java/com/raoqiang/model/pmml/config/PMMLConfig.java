package com.raoqiang.model.pmml.config;

import org.dmg.pmml.PMML;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Configuration
public class PMMLConfig {

    @Autowired
    private Environment env;

    @Bean(name = "evaluator")
    @Qualifier("evaluator")
    public Evaluator evaluator(){
        String  pathxml=env.getProperty("path.xml");
        File file = new File(pathxml);
        PMML pmml;
        Evaluator evaluator = null;
        try {
            InputStream inputStream = new FileInputStream(file);
            pmml = org.jpmml.model.PMMLUtil.unmarshal(inputStream);
            ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory
                    .newInstance();
            ModelEvaluator<?> modelEvaluator = modelEvaluatorFactory
                    .newModelEvaluator(pmml);
            evaluator = (Evaluator) modelEvaluator;
        } catch (FileNotFoundException | JAXBException | SAXException e) {
            e.printStackTrace();
        }
        return evaluator;
    }

}
