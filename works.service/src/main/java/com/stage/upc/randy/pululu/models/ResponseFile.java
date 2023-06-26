package com.stage.upc.randy.pululu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseFile {
    private String name;
    private String url;
    private String type;
    private long size;
}
