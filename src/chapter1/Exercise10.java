package chapter1;

/**
 * 2的100次方 对5求模
 * 
 * @author greatwall
 *
 */
public class Exercise10 {
	
	/**
	 * 利用Math.power 求出2的N次方，然后对5求模
	 * 
	 * 注意：此方法有局限，2的N次方不能超出int的范围, 因为int最大值是2的31次方-1，所以这个方法只能对N<31有效
	 * 
	 * @return
	 */
	public int solution1(int n) {
		int power = (int)Math.pow(2, n);
		return power % 5;
	}
	
	/**
	 * 2的N次方对5求模，其实是有规律的：
	 * N = 1时，2的1次为2，对5求模 得2
	 * N = 2时，2的2次为4，对5求模 得4
	 * N = 3时，2的3次为8，对5求模 得3
	 * N = 4时，2的4次为16，对5求模 得1
	 * N = 5时，2的5次为32，对5求模 得2
	 * N = 6时，2的6次为64，对5求模 得4
	 * N = 7时，2的6次为128，对5求模 得3
	 * N = 8时，2的6次为256，对5求模 得1
	 * ...
	 * 我们可以得出以下规律:结果2，4，3，1这4个数为一个周期，所以可以得出2的N次方对5求模 等于 N % 4 的值，
	 * 如果值是0, 那么原始结果为1，如果值是1, 那么原始结果为2，如果值是2, 那么原始结果为4，如果值是3, 那么原始结果为3
	 * @return
	 */
	public int solution2(int n) {
		int[] result = new int[] {1, 2, 4, 3};
		return result[n % 4];
	}
	
	public static void main(String[] args) {
		Exercise10 exercise10 = new Exercise10();
		for (int i = 25; i <= 31; i++) {
			System.out.println("Solution1: " + exercise10.solution1(i));
			System.out.println("Solution2: "  + exercise10.solution2(i));
			System.out.println("---------------");
		}
	}

}
