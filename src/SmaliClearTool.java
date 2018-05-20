import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;

public class SmaliClearTool {
	public static void main(String[] args) throws IOException {
		// F:\\QQ_weichat\\732\\classes.dex_smali\\oicq\\wlogin_sdk\\tools\\util.smali
		String dir = null;

		dir="F:\\QQ_weichat\\730\\QQ_7_3_0\\classes6";//F:\QQ_weichat\730\QQ_7_3_0\classes6
//		dir="F:\\QQ_weichat\\730\\QQ_7_3_0\\";
		// dir =
		// "F:\\QQ_weichat\\732\\classes.dex_smali\\oicq\\wlogin_sdk\\tools\\util.smali";
		/*
		 * dir = "F:\\QQ_weichat\\732\\classes4.dex_smali"; doFile(new
		 * File(dir)); dir = "F:\\QQ_weichat\\732\\classes5.dex_smali";
		 * doFile(new File(dir)); dir =
		 * "F:\\QQ_weichat\\732\\classes6.dex_smali"; doFile(new File(dir)); dir
		 * = "F:\\QQ_weichat\\732\\classes6.dex_smali"; doFile(new File(dir));
		 */
		/*
		 * dir = "F:\\QQ_weichat\\732\\NO_CHECK\\classes.dex_smali\\";
		 * doFile(new File(dir)); dir =
		 * "F:\\QQ_weichat\\732\\NO_CHECK\\classes2.dex_smali\\"; doFile(new
		 * File(dir)); dir =
		 * "F:\\QQ_weichat\\732\\NO_CHECK\\classes3.dex_smali\\"; doFile(new
		 * File(dir)); dir =
		 * "F:\\QQ_weichat\\732\\NO_CHECK\\classes4.dex_smali\\"; doFile(new
		 * File(dir)); dir =
		 * "F:\\QQ_weichat\\732\\NO_CHECK\\classes5.dex_smali\\"; doFile(new
		 * File(dir)); dir =
		 * "F:\\QQ_weichat\\732\\NO_CHECK\\classes6.dex_smali\\"; doFile(new
		 * File(dir));
		 */
		// dir="F:\\QQ_weichat\\732\\classes.dex_smali\\mqq\\observer\\";
		// dir =
		// "F:\\QQ_weichat\\732\\classes.dex_smali\\oicq\\wlogin_sdk\\tools\\";

		// String dir =
		// "F:\\QQ_weichat\\732\\classes.dex_smali\\oicq\\wlogin_sdk\\tools\\";
		// String dir =
		// "F:\\QQ_weichat\\732\\NO_CHECK\\classes.dex_smali\\oicq\\wlogin_sdk\\tools";
		// String dir="F:\\QQ_weichat\\732\\NO_CHECK\\classes.dex_smali";
		 doFile(new File(dir));
		System.out.println("���������ļ������");
	}

	public static void doFile(File file) throws IOException {
		if (!file.exists()) {
			System.err.println("����" + file.getAbsolutePath() + "������");
		}
		if (file.isDirectory()) {
			System.out.println("���ڴ����ļ���" + file.getAbsolutePath());
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {

				File currentFile = files[i];
				if (currentFile.isDirectory()) {

					doFile(currentFile);
				} else {
//.end param
					if (currentFile.getAbsolutePath().endsWith("smali")) {
						modifyFileContent(currentFile, "",
								"\\.line.*?|\\.prologue|\\.param.*?|\\.local .*?|\\.restart local|\\.end local.0*?|\\.end param.*?");
					}
					/*
					 * .param p1, "msg" # Lmqq/os/MqqMessage; .param p2, "when"
					 * # J .end local .local v4 .restart local v1 .prologue
					 * .line 2143.end local
					 */
					// modifyFileContent(currentFile, "",
					// "\\.line.*?|\\.prologue|\\.param.*?");
					// System.out.println("����" + currentFile.getAbsolutePath() +
					// "���");
				}
			}
		} else {
			modifyFileContent(file, "", "\\.line|\\.prologue");
			// System.out.println("����" + file.getAbsolutePath() + "���x");
		}

	}

	private static boolean modifyFileContent(File filePath, String replaceContent, String regex) throws IOException {

		StringBuffer sb = new StringBuffer();

		InputStreamReader read = new InputStreamReader(new FileInputStream(filePath), "utf-8");// ���ǵ������ʽ
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		boolean isFirst = true;
		while ((lineTxt = bufferedReader.readLine()) != null) {
			String currentReplace = replaceFileContent(lineTxt, "", regex);
			/**
			 * online write start
			 */
			/*
			 * if (isFirst) { isFirst = false; } else { if (currentReplace !=
			 * null) { sb.append("\r\n"); }
			 * 
			 * }
			 */

			boolean value = false;
			if (currentReplace != null) {
				sb.append(currentReplace);
			}
			/**
			 * write all line end
			 * 
			 */

			if (currentReplace != null) {
				sb.append("\r\n");
			}

		}
		FileUtils.writeStringToFile(filePath, sb.toString(), "utf-8", false);

		return true;
	}

	private static boolean modifyFileContentXXX(String filePath, String replaceContent, String regex) {

		// �޸��ļ�����,д������
		RandomAccessFile raf = null;

		try {
			raf = new RandomAccessFile(filePath, "rw");
			String line = null;
			long lastPoint = 0; // ��ס��һ�ε�ƫ����
			while ((line = raf.readLine()) != null) {
				final String str = replaceFileContent(line, replaceContent, regex); // ��ȡ�ļ�һ�У���ƥ��������ַ����滻��
				final long ponit = raf.getFilePointer();
				raf.seek(lastPoint);
				raf.writeBytes(str);
				lastPoint = ponit; // ��ȡһ�У�ָ��ָ����һ�п�ͷ������д��һ�У�ƫ�����Ŀ�ʼ����
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	/**
	 * 
	 * <p>
	 * �滻ƥ����������ݡ�
	 * </p>
	 * 
	 * @param srcContent
	 *            Դ�ַ���
	 * @param replaceContent
	 *            �滻����
	 * @param regex
	 *            ������ʽ
	 * @return boolean
	 */
	private static String replaceFileContent(String srcContent, String replaceContent, String regex) {

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(srcContent);
		if (matcher.find()) {
			// System.out.println("�ҵ�ƥ����,����ɾ�� " + srcContent);
			return null;
			// matcher.appendReplacement(sb, replaceContent);
		} else {
			return srcContent;

		}
	}

}
