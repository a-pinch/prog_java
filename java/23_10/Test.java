public class Test{

	public static void main(String[] args){
		System.out.println(args[0].replaceAll("[\\W]|_", ""));
		System.out.println(new StringBuilder(args[0].replaceAll("[\\W]|_", "")).reverse().toString());
		System.out.println(isPalindrome(args[0]));
	}
	/**
	 * Checks if given <code>text</code> is a palindrome.
	 *
	 * @param text any string
	 * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
	 */
	public static boolean isPalindrome(String text) {
		return text.replaceAll("[\\W]|_", "").equalsIgnoreCase(new StringBuilder(text.replaceAll("[\\W]|_", "")).reverse().toString());
	}
}