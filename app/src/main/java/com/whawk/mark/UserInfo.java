package com.whawk.mark;

class UserInfo {
    private String name;
    private String email;
    private String gender;
    private String mobile;
    private String pin;

    public UserInfo(String name, String email, String gender, String mobile, String pin) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPin() {
        return pin;
    }
}
