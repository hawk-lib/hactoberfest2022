package com.whawk.mark;

class DataEntry {

    private String username;
    private String password1;
    private String password2;
    private String pin;
    private String title;


    public DataEntry(String username, String password1, String password2, String pin) {
            this.username = username;
            this.password1 = password1;
            this.password2 = password2;
            this.pin = pin;
    }

    public DataEntry(String title, String username, String password1, String password2, String pin) {
            this.title = title;
            this.username = username;
            this.password1 = password1;
            this.password2 = password2;
            this.pin = pin;

    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    public String getPin() {
        return pin;
    }
}
