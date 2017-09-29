public class cv{
	public static void main(String[] ar){

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		cv ob =new cv();
		int[] digits=ob.Digits(N);
	}

	Integer[] getDigits(int num) {
    	List<Integer> digits = new ArrayList<Integer>();
    	collectDigits(num, digits);
    	return digits.toArray(new Integer[]{});
	}

	void collectDigits(int num, List<Integer> digits) {
    if(num / 10 > 0) {
        collectDigits(num / 10, digits);
    }
    digits.add(num % 10);
}
}