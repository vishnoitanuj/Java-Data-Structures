package classes_and_objects;

public class Fraction {

	private int num;
	private int den;
	
	protected Fraction(int num,int den){
		this.num = num;
		this.den = den;
		if(den==0){
			//TODO errors
			}
		simplify();
	}
	
	private void simplify(){
		int small = Math.min(num,den);
		int gcd=1;
		for(int i=2;i<=small;i++){
			if(num%i==0 && den%i==0)
				gcd = i;
		}
		this.num/=gcd;
		this.den/=gcd;
	}
	public void add(Fraction f){
		this.num = this.num*f.den + f.num*this.den;
		this.den = this.den*f.den;
		simplify();
	}
	public void multiply(Fraction f){
		this.num = this.num*f.num;
		this.den = this.den*f.den;
		simplify();
	}
	public static Fraction add(Fraction f1, Fraction f2){
		int a = f1.num*f2.den + f2.num*f1.den;
		int b = f1.den*f2.den;
		Fraction f = new Fraction(a,b);
		return f;
	}
	public void print(){
		if(den==1)
			System.out.println(num);
		else
			System.out.println(num+"/"+den);
	}
	public int getNumerator(){
		return this.num;
	}
	public int getDenominator(){
		return den;
	}
	public void setDenominator(int d){
		if(d==0){
			//TODO errors
			return;
			}
		else
			this.den = d;
	}
	public void setNumerator(int n){
		this.num = n;
	}

}
