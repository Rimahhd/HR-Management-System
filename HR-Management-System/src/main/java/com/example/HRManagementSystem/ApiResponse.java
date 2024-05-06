package com.example.HRManagementSystem;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T returnField;
}