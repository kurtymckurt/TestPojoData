package org.kurtymckurt.TestPojo.pojo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {
    private String make;
    private String model;
    private Speedometer speedometer;
}
