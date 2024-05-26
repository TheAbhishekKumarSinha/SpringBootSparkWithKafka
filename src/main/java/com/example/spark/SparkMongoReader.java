package com.example.spark;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SparkMongoReader {

    @Autowired
    SparkSession sparkSession;

    public void readFromMongoUsingSpark(){

        // sparkSession.read().format("com.mongodb.spark.sql.DefaultSource")
        // .option("spark.mongodb.input.uri","mongodb://localhost:27017/CAT_TRADING")
        // .option("spark.mongodb.input.collectionName", "EnrichedInquiry")
        // .load().toDF().show();

        // SparkSession sparkSession = SparkSession.builder()
		// .master("local")
		// .appName("MongoSparkConnectorIntro")
		// .getOrCreate();

		JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
		Dataset dataframe = sparkSession.read().format("mongodb")
		.option("spark.mongodb.read.database", "CAT_TRADING")
		.option("spark.mongodb.read.collection", "EnrichedInquiry")
		.option("spark.mongodb.read.connection.uri", "mongodb://localhost:27017").load();
		dataframe.toDF().show();



    }

}
