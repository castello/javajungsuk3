import java.util.*;			// Vector클래스를 사용하기 위해서 추가해 주었다.

class Product3 {
	int price;			// 제품의 가격
	int bonusPoint;		// 제품구매 시 제공하는 보너스점수

	Product3(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}

	Product3() {
		price = 0;
		bonusPoint = 0;
	}
}

class Tv5 extends Product3 {
	Tv5() { super(100); }
	public String toString() { return "Tv"; }
}

class Computer3 extends Product3 {
	Computer3() { super(200); }
	public String toString() { return "Computer"; }
}

class Audio3 extends Product3 {
	Audio3() { super(50); }
	public String toString() { return "Audio"; }
}

class Buyer3 {			// 고객, 물건을 사는 사람
	int money = 1000;  	// 소유금액
	int bonusPoint = 0;	// 보너스점수
	Vector item = new Vector();	// 구입한 제품을 저장하는데 사용될 Vector객체

	void buy(Product3 p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
			return;
		}
		money -= p.price;			// 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint;	// 제품의 보너스 점수를 추가한다.
		item.add(p);				// 구입한 제품을 Vector에 저장한다.
		System.out.println(p + "을/를 구입하셨습니다.");
	}

	void refund(Product3 p) {	// 구입한 제품을 환불한다.
		if(item.remove(p)) {	// 제품을 Vector에서 제거한다.
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하셨습니다.");
		} else {			//  제거에 실패한 경우
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");		
		}
	}

	void summary() {		      // 구매한 물품에 대한 정보를 요약해서 보여준다.
		int sum = 0;		      // 구입한 물품의 가격합계
		String itemList =""; 	  // 구입한 물품목록
		
		if(item.isEmpty()) {	// Vector가 비어있는지 확인한다.
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}

		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i=0; i<item.size();i++) {
			Product p = (Product)item.get(i);	
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

class PolyArgumentTest3 {
	public static void main(String args[]) {
		Buyer3 b = new Buyer3();
		Tv5 tv = new Tv5();
		Computer3 com = new Computer3();
		Audio3 audio = new Audio3();

		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
	}
}
