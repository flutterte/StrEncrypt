package newencrypt;

import java.util.Random;

public class NQueen {
	
	
    /** 
     * ctong 
     */  
    //���н����飬��X[1]��ʼʹ��  
    private static int[] X ;  
    //X����ĳ���  
    private static int nn ;  
    //��¼���н���Ŀ  
    private static int sum=0;  
    /** 
     * �����㷨 
     */  
    public void iteration(int n){  
        int k=1;  
        while(k>0){  
            X[k]++;  
            while(X[k]<n&&!place(k)){  
                X[k]++;  
            }  
                if(X[k]<n){  
                    if(k==n-1){  
                        print();  
                    }  
                    else{  
                        k++;  
                        X[k]=0;  
                    }  
                }else k--;  
        }  
    }  
    /** 
     * �ݹ��㷨 
     */  
    public void recursion(int p){  
        for(X[p]=1;X[p]<nn;X[p]++){  
            if(place(p)){  
                if(p==nn-1){  
                    print();  
                }else{  
                    //�ݹ����  
                    recursion(1+p);  
                }  
            }  
        }  
    }  
    //�Ƿ���Է��ã�  
    public boolean place(int t){  
        for(int i=1;i<t;i++){  
            if(Math.abs(i-t)==Math.abs(X[i]-X[t])||X[i]==X[t])  
                return false;  
        }  
        return true;  
    }  
    //����һ���������(5~8)������  
    public static int[] createArray(){  
        nn =new Random().nextInt(3)+5;  
        int[] a = new int[nn];  
        for(int i =0;i<nn;i++)  
            a[i]=0;  
        return a;  
    }  
    //��ӡ����  
    public void print(){  
        sum++;  
        System.out.println("���н�"+sum);  
        for(int j=1;j<X.length;j++)  
        System.out.print(X[j]+" ");  
        System.out.println();  
    }  
    /** 
     * ������ 
     * @param args 
     */  
    public static void main(String[] args) {  
        X=createArray();  
        System.out.println("���������㷨���"+(X.length-1)+"�ʺ�Ŀ��н�Ϊ:");  
        new NQueen().iteration(X.length);  
        System.out.println("���н�ĸ�����:"+sum);  
        sum=0;  
        System.out.println("�ݹ��㷨���"+(X.length-1)+"�ʺ�Ŀ��н�Ϊ:");  
        new NQueen().recursion(1);   
        System.out.println("���н�ĸ�����:"+sum);  
    }  

}
