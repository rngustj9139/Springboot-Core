package hello.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price; // 여기가 문제! => but 공유변수가 아닌 지역변수를 사용해서 문제 해결함
    }

//    public int getPrice() {
//        return price;
//    }

}
