package com.whawk.mark;

class User {
    private String uid;
    private String name;
    private String password;
    private String pin;
    private String email;

    public User(String uid, String name, String email, String password, String pin) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.pin = pin;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
