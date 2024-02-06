package com.example.exSpring1.form;

import jakarta.validation.constraints.NotBlank;

public class UserForm {
    
    
    @NotBlank(message = "名前は必須入力です")
    private String name;

    @NotBlank(message = "年齢は必須入力です")
    private String age;

    @NotBlank(message = "コメントは必須入力です")
    private String comment;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
