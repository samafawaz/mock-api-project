package com.sda.mockapi.models;

public class Eventappmodel {

        private int id;
        private String name;
        private String category;
        private String location;
        private String date;
        private double  price;
    
        // Constructor
        public Eventappmodel (int id, String name, String category, String location, String date, double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.location = location;
            this.date = date;
            this.price = price;
        }
    
 
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getCategory() {
            return category;
        }
    
        public void setCategory(String category) {
            this.category = category;
        }
    
        public String getLocation() {
            return location;
        }
    
        public void setLocation(String location) {
            this.location = location;
        }
    
        public String getDate() {
            return date;
        }
    
        public void setDate(String date) {
            this.date = date;
        }
    
        public double getPrice() {
            return price;
        }
    
        public void setPrice(double  price) {
            this.price = price;
        }
}