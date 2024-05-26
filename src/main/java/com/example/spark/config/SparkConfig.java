package com.example.spark.config;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SparkConfig{
    
    @Bean
    public SparkConf  sparkConf() {
        SparkConf conf= new SparkConf().setAppName("Java Spark").setMaster("local[*]");
        return conf;
        
    }

    @Bean
    public SparkSession sparkSession(){
        SparkSession spark = SparkSession
            .builder()
            .config(sparkConf())
            .getOrCreate();

        return spark;
    }



    

    
    
     
}