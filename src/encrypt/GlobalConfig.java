package encrypt;


public class GlobalConfig {

	public static final String sIGNORE_DECODE = "IGNORE_DECODE";
	
	
	public static DebugLevel debug = DebugLevel.MIDDLE;
	
	/**
	 * �Ƿ�֧��ֱ�ӽ���������,
	 */
	public static boolean sEnableParseConstantsLine = false;
	/**
	 * ����һ��Ŀ¼�����ļ�����
	 * 
	 * @param path
	 */
	private static boolean writeFile = true;
	
	/**
	 * Ĭ�ϼ���ģʽ�ǰ��ַ����滻Ϊ ���ܷ��� ���ܷ������ݵ��Ǽ��ܵ�int���飬�������ַ�������ʱ��Ч�ʱȽϵ�,�������ױ�hook����ģ��,
	 */
	public static boolean isIntArrEncryptMode = true;
}
