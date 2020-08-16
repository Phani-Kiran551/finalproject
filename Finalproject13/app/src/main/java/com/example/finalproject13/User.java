package com.example.finalproject13;


    public class User {
        private String name,email,pass1;

        public User(String name, String email, String pass1) {
            this.name = name;
            this.email = email;
            this.pass1 = pass1;
        }

        public User() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPass1() {
            return pass1;
        }

        public void setPass1(String pass1) {
            this.pass1 = pass1;
        }
    }

