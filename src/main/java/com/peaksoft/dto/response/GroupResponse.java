package com.peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {

    private Long id;

    private String groupName;

    private String image;

    private LocalDate dateOfStart ;

    private int count;
}
