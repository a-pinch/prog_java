import java.util.Arrays;

public class Test{
	public static void main(String[] args){
		int[] a = {1,3}, b = {2,4};
		System.out.println(Arrays.toString(mergeArrays(a, b)));
	}

	public static int[] mergeArrays(int[] a1, int[] a2) {
		int i=0, j=0;
		int[] res = new int[a1.length+a2.length];
		for(int k=0; k<res.length; ++k){
			if(i<a1.length && (j>=a2.length || a1[i]<a2[j])){
				res[k] = a1[i++];
			}
			else{
				res[k] = a2[j++];
			}
		}
		return res;
	}
}
