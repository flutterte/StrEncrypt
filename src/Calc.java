
public class Calc {

	public static void main(String[] args) {

		int[] a = new int[] { 1,2, 6, 5,7, 8, 9, 14, 10, 22, 43, 333,5555 };
		System.out.println("arr length"+a.length+",search idnex" + binarySearch(a, 333));

	}

	private static int binarySearchMy(int[] arr, int searchValue) {
		int maxIndex=arr.length-1;
		int minIndex=0;
		
		while(minIndex<=maxIndex){
			
			int middleIndex=(minIndex+maxIndex)>>>1;//���ǳ�2
			int middleValue=arr[middleIndex];
			if(middleValue>searchValue){//���ڱ�������ֵ
				maxIndex--;
			}else if(middleValue<searchValue){//С�ڱ�������ֵ,
				minIndex++;
			}else{
				return middleIndex;
			}
		}
		return -minIndex;
	}

	public static int binarySearch(int[] a, int key) {
		return binarySearch(a, 0, a.length, key);
	}


/**
 * 
 * �ٷ���Դ��տ�ʼ��֪���Ǹ����,�����޸���������low �ĳ�lowIndex,��˲��������,����������ױ��������Ի����!
 * ���ֲ��� ���� �������,���� ���޷��ҳ���ȷ��ֵ, ������ͨ��(���index+��Сindex)/2���м�index�ķ�ʽ���в��ң�����м�index��ֵ������ô ���indexҪ��ȥ1������м�index��ֵС�� ��������ֵ�����1��
 * ���������Ҳ��С�ھͳ���������֪��lowIndex����hightIndex����ֹ�˳�
 * 
 * @param a
 * @param fromIndex
 * @param toIndex
 * @param key
 * @return
 */
	private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
		int lowIndex = fromIndex;
		int highIndex = toIndex - 1;
//		int highIndex = toIndex;//Ϊʲô��ȥ1 �� �������˵-����ȥ��û��ϵ����ʱ�򲻼�ȥ�ҵ��ٶȸ��죬��ñ�0��11 ���м䵽��ȡ��5 ����ȡ��6 ����ȡ��6,
		//��ô������,789 10 11  5��ֵ��������6��ֵ 012345 ��ôȡ 5 �Ļ�����0 1 2 3 4������6 7 8 9 10 11 ������û��Ȩ��, 
		while (lowIndex <= highIndex) {
			// int mid = (low + high) >>> 1;
			int midIndex = (lowIndex + highIndex) / 2;//�������ֵ����Сֵ��� �м�idnex
			
			float middleIndex=(lowIndex + highIndex) / 2f;
			System.out.println("��Сֵ:minIndex" + lowIndex+"+maxIndex"+highIndex +"="+(lowIndex+highIndex)+",�۰�index:"+midIndex+",floatIndex:"+middleIndex);
//			System.out.println("��Сֵ:min" + high+"+max"+high +"="+((low + high) >>>1));
			int midVal = a[midIndex];
			if (midVal < key){
				System.out.println("�۰�index" + midIndex+"��ֵ"+midVal+"С�ڲ��ҵ�ֵ"+key+",�����СindexҪ+1");
				lowIndex = midIndex + 1;
			}
			else if (midVal > key) {
				System.out.println("�۰�index" + midIndex+"��ֵ"+midVal+"���ڲ��ҵ�ֵ"+key+",������ֵҪ-1");
				highIndex = midIndex - 1;
			} else{
				return midIndex; // key found
				
			}
		}
		return -(lowIndex + 1); // key not found.
	}
}
