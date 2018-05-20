import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TestReference {
	static class MyObj {
		public MyObj(int no) {
			this.no = no;
		}

		public String[] getCurrent() {
			return current;
		}

		public void setCurrent(String[] current) {
			this.current = current;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		String[] current = new String[1000];
		int no;

		@Override
		protected void finalize() throws Throwable {
			System.out.println("from:"+no+" :�ұ�����������hasCode��" + hashCode());
			super.finalize();
		}
	}

	/**
	 *Launch configurations for 'TestReference.java'  ->Argmentsѡ�  Vm argments������д����-Xmx2m -xms2m   
	 * @param args
	 */
	public static void main(String[] args) {
		Object referent = new Object();
		java.util.List<WeakReference<MyObj>> list = new ArrayList<>();
		int loopindex = 0;
	System.err.println("=================================�����ò���=================================");
			while(loopindex<200){
				
				String[] current=new String[500];
				for (int i = 0; i < current.length; i++) {
					
					current[i]=i+"";
				}
				MyObj obj=new MyObj(loopindex);
				obj.setCurrent(current);
				list.add(new WeakReference<TestReference.MyObj>(obj));
				if(loopindex%5==0&&loopindex>0){
					System.out.println("start================"+loopindex+"================================");
					System.out.println("�������õ�������gc,�ոշŽ�ȥ�Ķ���index:"+loopindex+"���ڷ�:"+list.get(loopindex).get());
					System.gc();
					System.out.println("��������gc");
					System.out.println("����֮��ոշŽ�ȥ�Ķ���index:"+loopindex+"���ڷ�:"+list.get(loopindex).get());
					System.out.println("����֮���һ�����ڷ�:"+list.get(0).get());
					System.out.println("end================"+loopindex+"================================");
				}
				loopindex++;
			}
			
		
		

		/**
		 *���Ե��ڳ�ʼ�������СΪ500 ����1000 �����1ǧ�����Ƿ��ּ�ʹû�е���System.gc()���Ѿ���ʼ���л�����,Ҳ������΢�Խ��ͻ������,���ĳ�500֮�� ��һ��loop,û�л��յȵ�����gcִ�����start-end�߼��� 3 ��4,2,1,0��һ��һ���������ˣ����������ϢҲ���Կ�����������Ȼ�������޻��ոոշŽ�ȥ�ģ�����Ҳ����ٷְ��Ȼ��յ�һ��������Ҳ������־��ӡ�ͱ���native��Ϣ��ͬ�����µġ�
		 * 
		 */
		
	}

	private static void assertNotNull(Object object) {
		// TODO Auto-generated method stub
		System.out.println("obj �Ƿ�Ϊ��:" + object);
	}
}
