package uni;

public class LoverApplication {
	public static void main(String[] args) {
		System.out.println("Домашна работа 2 / Част 3");
		System.out.println("=========================");

		jumpFromFloor((byte)8);
	}

	public static void jumpFromFloor(byte floor) {
		if (floor < 0 || floor > 8) {
			System.err.println("Невалиден етаж. Скочи отново.");
			return;
		}

		switch (floor) {
			case 8: System.out.println("Здравей Мими");
			case 7: System.out.println("Здравей Пепи");
			case 6: System.out.println("Здравей Ваня");
			case 5: System.out.println("Здравей Катя");
			case 4: System.out.println("Здравей Теди");
			case 3: System.out.println("Здравей Ася");
			case 2: System.out.println("Здравей Ива");
			case 1: System.out.println("Здравей Мая");

			default: System.out.println("Ауч");
		}
	}
}
