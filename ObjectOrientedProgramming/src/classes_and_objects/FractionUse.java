package classes_and_objects;

public class FractionUse {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction f1 = new Fraction(20,30);
		//f1.print();
		Fraction f2 = new Fraction(50,30);
//		f1.add(f2);
//		f1.print();
//		f1.multiply(f2);
//		f1.print();
//		System.out.println(f1.getDenominator());
		Fraction f3 = Fraction.add(f1, f2);
		f3.print();
	}
}
