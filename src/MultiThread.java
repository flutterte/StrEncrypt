
public class MultiThread {
		static Object object=new Object();
		static	Object object2=new Object();
	
	public static void main(String[] args) {
		
		deathLock();
	}

	private static void deathLock() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (object) {
					System.out.println("�߳�1 ������1");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("�߳�1׼������2");
					synchronized (object2) {//������2 ���߳�2 ���ˣ��߳�2 ���ڵȴ���1�ͷţ�ȥ�ã������㲻�����Ҳ����㣬���������
						System.out.println("�߳�1 ������2");
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("�߳�1 �ͷ�����2");
				}
				System.out.println("�߳�1 �ͷ���1�����");
				
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.err.println("�߳�2׼������2");
				synchronized (object2) {
					try {
						System.err.println("�߳�2������2");
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("�߳�2׼������1");
					synchronized (object) {
						System.err.println("�߳�2������1");
						
					}
					System.err.println("�߳�2�ͷ�����1");
					
				}
				System.out.println("�߳�2�ͷ���2");
				
				
			}
		}).start();
		
		/*
������־
�߳�1 ������1
�߳�2׼������2
�߳�2������2
�߳�1׼������2
�߳�2׼������1

		�������������Ƕ�������߼ӱ���ж��Ƿ�����С�
		 */
	}
	
}
