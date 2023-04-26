package com.kbstar.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Marker {

    private int id;
    private String title;
    private String target;
    private Double lat;
    private Double lng;
    private String img;
    private String loc;

}
