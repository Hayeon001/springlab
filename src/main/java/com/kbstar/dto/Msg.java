package com.kbstar.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Msg {
    private String sendid;
    private String reseivedid;
    private String content1;
}
