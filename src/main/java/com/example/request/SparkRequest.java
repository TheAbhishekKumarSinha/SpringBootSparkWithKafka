package com.example.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SparkRequest {

    private String collectionName;
    private String databaseName;

}
