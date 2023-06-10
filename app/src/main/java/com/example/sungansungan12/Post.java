package com.example.sungansungan12;
//조정동 담당
public class Post {
    public String name;
    public String description;
    public String price;
    public String available;

    public Post() {
        // 기본 생성자 (Firebase Realtime Database에서 필요)
    }

    public Post(String name, String description, String price, String available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    // Getter 및 Setter 메서드 생략

    // 필요에 따라 toString(), equals() 등의 메서드를 오버라이드할 수 있습니다.
}
