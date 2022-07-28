package com.wellware.smart.success;

import lombok.Data;

@Data
public class Success {
    private final int code;
    private final Boolean success;
    private final Object data;
    private final String error;
}
