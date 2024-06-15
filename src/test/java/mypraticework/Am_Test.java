package mypraticework;

import org.testng.annotations.Test;

public class Am_Test {
	//class level varibles
	private int a=10;
	protected int b=20;
	int c=40;
	public int d=50;


/*
 * public Am_Test() { this.a=100; this.b=200; this.c=300; this.d=400; }

 */@Test(priority=2)
	public void Am_Test() {
		Am_Test am2=new Am_Test();
		System.out.println(am2.a);
	    System.out.println(am2.b);
	    System.out.println(am2.c);
	    System.out.println(am2.d);
	    System.out.println(am2);
	    this.a=1000;
	    this.b=2000;
	    this.c=3000;
	    this.d=4000;
	    System.out.println(am2.a);
	    System.out.println(am2.b);
	    System.out.println(am2.c);
	    System.out.println(am2.d);
	    System.out.println(am2);


	}
@Test(priority=1)
public  void main() {
	// TODO Auto-generated method stub
	//with in the same package and same class
	//Access the class level varibles
	Am_Test am1=new Am_Test();
   System.out.println(am1.a);
   System.out.println(am1.b);
   System.out.println(am1.c);
   System.out.println(am1.d);
Am_Test am3=new Am_Test();
am3.Am_Test();

}

}
