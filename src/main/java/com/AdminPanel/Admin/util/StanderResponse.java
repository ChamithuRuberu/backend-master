package com.AdminPanel.Admin.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StanderResponse {


        private int code;
        private String message;
        private Object data;
    }


