package junitTest;

public class Count {
	public int add(int x ,int y){
		return x+y;
		}

	public int divide(int i, int j) {
		return i/j;
	}
	public static boolean prime(int n){
		for(int i=2;i<Math.sqrt(n);i++){
			if(n%2==0){
				return false;
			}		
		}
		return true;
	}
}
