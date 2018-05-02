package classes_and_objects;

public class ComplexNumber {

	private int real;
	private int complex;
	public ComplexNumber(int real,int complex){
		this.real = real;
		this.complex = complex;
	}
	public void print(){
		System.out.println(real+" + "+complex+"i");
	}
	public void setReal(int a){
		real = a;
	}
	public void setImaginary(int b){
		complex = b;
	}
	public void add(ComplexNumber c){
		this.real+=c.real;
		this.complex+=c.complex;
	}
	public void multiply(ComplexNumber c){
		int a=this.real*c.real - this.complex*c.complex;
      	int b=this.real*c.complex + this.complex*c.real;
      	this.real =a;
      	this.complex =b;
	}
	public static ComplexNumber add(ComplexNumber a,ComplexNumber b){
		int r = a.real+b.real;
		int i = a.complex+b.complex;
		ComplexNumber c =  new ComplexNumber(r,i);
		return c;
	}
	public ComplexNumber conjugate(){
		ComplexNumber c = new ComplexNumber(real,complex*-1);
		return c;	
	}
}