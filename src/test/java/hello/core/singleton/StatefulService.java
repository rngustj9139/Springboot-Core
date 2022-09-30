package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제! => but 공유변수가 아닌 지역변수를 사용해서 문제 해결함 (현재 행과 위의 필드를 지우고 그냥 price를 리턴하면 된다.)
        return price;
    }

    public int getPrice() {
        return price;
    }

}
