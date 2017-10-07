package chapter1;

import java.util.Arrays;

/**
 * 衍生问题：如何求2的N次
 * 如果N为100，甚至1000，此时结果已经远远超出内置类型（int, double等）的范围，只能自己实现数字的计算
 * 
 * @author greatwall
 *
 */
public class Extension {
	
	private static String formatter(int[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = array.length -1; i >= 0 ; i--) {
			sb.append(array[i]);
		}
		
		return sb.toString();
	}

	public static String power2Of(int n) {
		int[] data = new int[1];
		data[0] = 1;
		
		int dataBit = 1;//数据位
		for (int i = 0; i < n; i++) {
			boolean increase = false;//是否进位
			int dataSize = data.length;
			for (int j = 0; j < dataSize; j++) {
				data[j] *= 2;
				if (increase) {
					data[j]++;
				}
				if(data[j] >= 10) {
					if(j == data.length - 1) {//当此数据是最后位，而且乘以2后有进位，扩大数据位
						int[] temp = Arrays.copyOf(data, data.length);
						data = new int[++dataBit];
						System.arraycopy(temp, 0, data, 0, temp.length);
						dataSize = data.length;
					}
					
					data[j] = data[j] % 10;
					
					increase = true;
				} else {
					increase = false;
				}
			}
		}		
		return formatter(data);
	}
	
	public static void main(String[] args) {
		for (int i = 10; i < 15; i++) {
			System.out.println(Extension.power2Of(i));
		}
	}
}
