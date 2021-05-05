package com.jinghuayuan.exception;
// Copyright 2021-2101 Pica.

/**
 * @ClassName WordException
 * @Description TODO
 * @Author 井华源
 * @Date 2021/5/5 21:16
 * @ModifyDate 2021/5/5 21:16
 * @Version 1.0
 */
public class WordException extends Exception {

    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WordException(String word) {
        this.word = word;
    }

    public WordException(String message, String word) {
        super(message);
        this.word = word;
    }
}
