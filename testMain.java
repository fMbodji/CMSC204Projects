import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMain {

	public static void main(String[] args) {
		GradeBook g1 = new GradeBook(5);
		GradeBook g2 = new GradeBook(5);
		
		g1.addScore(1.5);
		g1.addScore(45);
		System.out.println(g1);
		

		g1.addScore(78);
		g1.addScore(87);
		System.out.println(g1.finalScore());
		
		g2.addScore(35);
		g2.addScore(50);
		g2.addScore(3.5);
		g2.addScore(37);
		System.out.println(g2.finalScore());
	}

}



