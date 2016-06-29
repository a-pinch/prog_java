import java.math.BigInteger;

public class Test{
	public static void main(String[] args){
		System.out.println(factorial(Integer.parseInt(args[0])));
	}

	public static BigInteger factorial(int value) {
		BigInteger res = BigInteger.ONE;
		for(int i = 2; i <= value; ++i){
			res = res.multiply(BigInteger.valueOf(i));
		}
	    return res;
	}
}
