package com.kafka.consumer.kafkaconsumer.modelsVO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Setter
@DynamoDBTable(tableName = "ted")
public class TedVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    @JsonIgnore
    public static final String FIELD_ID = "id";
    @JsonIgnore
    public static final String FIELD_DATE_PROCESSING = "dateProcessing";
    @JsonIgnore
    public static final String FIELD_VALUE = "value";
    @JsonIgnore
    public static final String FIELD_SOURCE_BANK = "sourceBank";
    @JsonIgnore
    public static final String FIELD_SOURCE_AGENCY = "sourceAgency";
    @JsonIgnore
    public static final String FIELD_SOURCE_ACCOUNT = "sourceAccount";
    @JsonIgnore
    public static final String FIELD_DESTINATION_BANK = "destinationBank";
    @JsonIgnore
    public static final String FIELD_DESTINATION_AGENCY = "destinationAgency";
    @JsonIgnore
    public static final String FIELD_DESTINATION_ACCOUNT = "destinationAccount";


    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateProcessing;
    private BigDecimal value;
    private String sourceBank;
    private String sourceAgency;
    private String sourceAccount;
    private String destinationBank;
    private String destinationAgency;
    private String destinationAccount;

    @DynamoDBHashKey(attributeName = "id")
    public Integer getId() {
        return id;
    }

    @DynamoDBAttribute
    public BigDecimal getValue() {
        return value;
    }

//    @DynamoDBAttribute
//    public LocalDate getDateProcessing() {
//        return dateProcessing;
//    }

    @DynamoDBAttribute
    public String getSourceBank() {
        return sourceBank;
    }

    @DynamoDBAttribute
    public String getSourceAgency() {
        return sourceAgency;
    }

    @DynamoDBAttribute
    public String getSourceAccount() {
        return sourceAccount;
    }

    @DynamoDBAttribute
    public String getDestinationBank() {
        return destinationBank;
    }

    @DynamoDBAttribute
    public String getDestinationAgency() {
        return destinationAgency;
    }

    @DynamoDBAttribute
    public String getDestinationAccount() {
        return destinationAccount;
    }


}