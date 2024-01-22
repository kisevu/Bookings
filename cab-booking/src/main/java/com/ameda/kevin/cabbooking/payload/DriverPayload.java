package com.ameda.kevin.cabbooking.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverPayload {
    private String name;
    private String location;
}
