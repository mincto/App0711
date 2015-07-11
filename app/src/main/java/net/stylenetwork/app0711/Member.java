/*
* 자바는 객체지향 언어이고, 객체란 현실의 사물을 표현한 개념이므로
* 리스트에 보여줄 하나의 아이템은 곧 한명의 사람이므로,
* 현재 정의하고 있는 클래스로 한사람을 표현하자!!
*
* 주의)  30명을 처리할 경우 클래스가 30개??  (X)
*         클래스로부터 메모리에 올라가는 인스턴스 30개가 있어야 한다.
*
* */
package net.stylenetwork.app0711;
public class Member {
    private int img;
    private String name;
    private String phone;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}











