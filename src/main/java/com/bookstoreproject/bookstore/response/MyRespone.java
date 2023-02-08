package com.bookstoreproject.bookstore.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MyRespone <T>{
    private int code;
    private String message;
    private T data;
}
