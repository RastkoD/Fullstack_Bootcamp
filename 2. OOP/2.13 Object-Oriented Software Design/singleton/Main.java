package singleton;

public class Main {

	public static void main(String[] args) {
		Singleton s1 = Singleton.pribaviInstancu();
		Singleton s2 = Singleton.pribaviInstancu();
		Singleton s3 = Singleton.pribaviInstancu();

		System.out.println(s1.s);
		System.out.println(s2.s);
		System.out.println(s3.s);
		
		s1.s =(s1.s).toUpperCase();
		
		System.out.println(s1.s);
		System.out.println(s2.s);
		System.out.println(s3.s);
		
		s3.s =(s3.s).toLowerCase();
		
		System.out.println(s1.s);
		System.out.println(s2.s);
		System.out.println(s3.s);
	}

}
