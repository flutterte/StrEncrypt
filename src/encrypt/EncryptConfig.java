package encrypt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import interfaces.CustromParseProvider;

public class EncryptConfig {

	
	public List<File> operaDir=new ArrayList<>();
	public List<File> getOperaDir(){
		return operaDir;
		
	}
	
	/**
	 * ���������ڰ���
	 */
	public static String sConstantsAtPackage;
	/**
	 * ����Utils���ڰ���
	 */
	public static String encryptAtPackage = null;
	/**
	 * ���ܵĹ���class���
	 */
	public static String sDecodSimpleClass = "EncryptUtil";
	/**
	 * ���ܹ�������Ľ��ܷ���
	 */
	// public static String fetchDecodeMethod = sDecodSimpleClass + ".decode";
	public static String sDecodeMethod = "decode";
	public String sConstantsClass = "Constants";
	public String[] 	sIgnoresFileNames = new String[] {};
	public UseVarQuote 	useVarQuote = UseVarQuote.no;
	
	/**
	 * �°汾����ֳɶ���ļ���Ϊ����������֤ÿ���������ֻ��50����
	 */
	public static String sConstantClassPath = "F:\\src\\git_project\\insert_qq_or_wechat\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\ConstantValue.java";

	// sIgnoreKeyWords=new String[]{"TAG"};
	// sIgnoresFolder = new String[] { "MainHandlerPackage" };
	// sDecodSimpleClass="EncryptUtil";
	// sIgnoresFileNames = new String[] { "MainHandlerPackage.java" };
	// sIgnoresFileNames=new
	// String[]{"MainHandlerPackage.java","MainHandlerPackage"};
	// fetchDecodeMethod = sDecodSimpleClass + ".decode";

	public EncryptType currentEncryptType = EncryptType.OTHERENCRYPT;
	

	public static CustromParseProvider custromParseProvider = new CustromParseProvider() {

		@Override
		public String requestEncode(String str) {
			// TODO Auto-generated method stub
			throw new RuntimeErrorException(null, "û��ʵ��");
		}

		@Override
		public String requestDecode(String str) {
			throw new RuntimeErrorException(null, "û��ʵ��");
			// TODO Auto-generated method stub
		}
	};
	public void addDirOrFile(String temp) {
		getOperaDir().add(new File(temp));
		
	}	

	/**
	 * ���԰���static final�ĳ���
	 */
	public static boolean encryptStaticConstants = true;
	
	
}
