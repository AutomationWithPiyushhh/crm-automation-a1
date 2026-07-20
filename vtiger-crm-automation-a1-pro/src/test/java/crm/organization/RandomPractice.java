package crm.organization;

public class RandomPractice {
	public static void main(String[] args) {
//		generate random number
		double randomDouble = Math.random();
		System.out.println(randomDouble); // 0.46222018062981074
//											 462
		double ran = randomDouble*1000; 
		System.out.println(ran); 		  // 462.2201806298107
										  // 462
		
		int random = (int) ran;
		System.out.println(random);       // 462
		
	}
}
