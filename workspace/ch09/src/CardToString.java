class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
}

class CardToString {
	public static void main(String[] args) {
		Card2 c1 = new Card2();
		Card2 c2 = new Card2();

		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}
