import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.omg.CORBA.VersionSpecHelper;
import org.omg.PortableInterceptor.INACTIVE;

import net.sourceforge.pinyin4j.PinyinHelper;

public class ByteEncodeUtil {

	static HashMap<String, String> sEncodeMap = new HashMap<>();
	public static String sConstantsClass = "ConstantValue";
	public static final String sConstantClassPath = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\ConstantValue.java";

	static HanyuPinyinHelper hanyuPinyinHelper = new HanyuPinyinHelper();
	/**
	 * 处理一个目录所有文件名字
	 * 
	 * @param path
	 */
	private static boolean writeFile = true;
	/**
	 * 多个文件共享变量 是已经生产的 变量名和机解密的字符串
	 */
	static HashMap<String, String> sDecodeMap = new HashMap<>();

	private static final String sIGNORE_DECODE = "IGNORE_DECODE";
	/*
	 * "\"(.*?)\"" int[] QSSQ__with_uin_eq_ = new int[]{38, 117, 105, 110,
	 * 61};//content=&uin= public final static int[] QSSQ__with_uin_eq_ = new
	 * int[]{38, 117, 105, 110, 61};//content=&uin=
	 * \s*int\[\s*\]\s*(\w*)\s*\=\s*new\s*int\[\s*\]\s*\{(.*?)\}
	 * ="\\s*int\\[\\s*\\]\\s*(\\w*)\\s*\\=\\s*new\\s*int\\[\\s*\\]\\s*\\{(.*?)\\}";
	 */

	public static final String encodeLineReg = ".*?\\s*int\\[\\s*\\]\\s*(\\w*)\\s*\\=\\s*new\\s*int\\[\\s*\\]\\s*\\{(.*?)\\}.*?";
	// public static final String encodeLineReg
	// =".*?int\\[\\s*\\](\\s*).*?\\=.*?\\{(.*?)\\}.*?";
	public static boolean printSmallCode = false;
	public static boolean printChar = true;
	static boolean debug = false;
	public static final String decodeMethodName = "EncryptUtil.decode";

	/*
	 * "\"(.*?)\""
	 */
	public static final String decodeMethodNameReg = ".*?" + decodeMethodName + "\\((.*?)\\)" + ".*?";

	private final static String sBrSign = "brbr";

	public static void main(String[] args) {
		String lineText = "开始\n结束 如果还是换行了说明替换失败";
		lineText = lineText.replaceAll("\n", sBrSign);
		System.out.println("解析后替换变量结果" + lineText);
		// decodeJavaAndroid();
		// encodeJavaAndroid();
		debug = true;
		encodeJavaAndroid();
		/*
		 * 
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 * System.out.println(Math.abs(new Random().nextInt(6)));// 0 1 2 0 1 2
		 *
		 */
		// testAtest();
		// System.out.println(getVarBaseName("+}|{\"P:>?<8764%￥@￥.#$%&!@#$^&*()_",
		// false));
		// System.out.println(getVarBaseName("~·！@#￥%……&*（）——+=-【】、‘；、。，",
		// false));
		// System.out.println(getVarBaseName("test.#$%&!@#$^&*()_", false));
		// doEncodeAllJava("F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\tui\\fw.java");
		// doEncodeAllJava("src/fw.txt");
		// String file =
		// "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\tui\\qqplugin.java";
		// debug=true;
		/**
		 * 对于换行符用brbr处理
		 */
		String temp = "再次申明软件是永久,免费体验的,如果你是从别人手里付费购买的,请邮箱举报，我将把此人拉入黑名单" + "brbr体验完毕请24小时内删除,不删除是你的事情哈!一切违法行为与我无关" + "brbr,任何进行牟利的行为都是违法的,不管你是不是未成年人,请自重!搞大了蹲监狱!!! " + "brbr想了很久还是留个联系方式吧!如果您已被骗希望下次不要被骗了，也希望你不要做这种人,看见一次鄙视一次、" + "brbr关注更新请访问http://qssq666.cn/update/qq_redpackaget.html    " + "brbr为了防止更多的人被骗举报收费邮箱:qssq666@foxmail.com    " + "brbr出现未知无法领取的错误建议卸载有风险软件,重装本软件,向作者提交问题一定要说清楚问题,而不是作者追问你具体怎么怎么个现象,你做了什么  " + "brbr给我弹视频语音的人直接拉黑不解释!  " + "brbr软件会持续更新,告诉大家的好消息是我的行动将掀起自带QQ抢红包狂潮哈 " + "brbr我呢是工资阶层,做这个东西呢只能晚上  " + "brbr双休去搞,时间不是很多,还有就是这破网上传速度太慢,自带的包文件大,所以更新比较慢,出现问题不会马上进行更新,不然我早上传很多个版本了." + "brbr所以希望大家谅解,理解 你这么喷我软件这么这么垃圾我还有毛线的动力啊,你说我单身狗双休都在搞这些玩意,有多狼狈你能体会吗？brbr" + "brbr光知道喷,另外想加群的朋友可以点击http://qssq666.cn点击关于加入群哈!这里就不贴出来了..";
		// System.out.println("input result:" + getVarName(temp, true));
		// decodeJavaAndroid();
		// arrayList.add(printCharCode(charArrayToIntArray("查询昵称信息失败\n情给予QQ访问应用列表权限".toCharArray())));
		// arrayList.add(printCharCode(charArrayToIntArray("请先手动领取一个红包".toCharArray())));
		// arrayList.add(printCharCode(charArrayToIntArray("情迁红包出现错误%s".toCharArray())));
		// arrayList.add(printCharCode(charArrayToIntArray("请先手动领取一个红包或请先打开QQ".toCharArray())));
		// arrayList.add(printCharCode(charArrayToIntArray("不带密码抢".toCharArray())));

		// deAndroid();
		// String file = "F:\\QQ_weichat\\test\\Test.java";
		// String file = "C:\\Users\\Administrator\\Desktop\\Test.java";

	}

	private static void decodeJavaAndroid() {

		looadDecodeFieldToHashMap(sConstantClassPath, false);// 删除不存在的注释一下//开启有风险如果一个文件崩溃了到时候变量找不到了

		ArrayList<String> arrayList = getFileArrayList();
		for (int i = 0; i < arrayList.size(); i++) {
			String file = arrayList.get(i);
			doDecodeAllJava(file);
		}
		// file =
		// "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\InitConfig.java";
		// file =
		// "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\fw.java";
		// file =
		// "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\Cf.java";
		// file =
		// "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\DS.java";
		// file =
		// "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\UiUtils.java";
		// file =
		// "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\UiUtils.java";
		// file =
		// "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\qqplugin.java";
		/*
		 * file =
		 * "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\PublicConstants.java";
		 * doDecodeAllJava(file);
		 * 
		 * file =
		 * "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\UiUtils.java";
		 * doDecodeAllJava(file); file =
		 * "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\fw.java";
		 * doDecodeAllJava(file); file =
		 * "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\DS.java";
		 * doDecodeAllJava(file); file =
		 * "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\Cf.java";
		 * doDecodeAllJava(file); file =
		 * "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\QQUnrecalledHook.java";
		 */

	}

	private static void encodeJavaAndroid() {
		ArrayList<String> list = getFileArrayList();
		looadDecodeFieldToHashMap(sConstantClassPath, false);
		readEncodeVarArrayList(list);
		for (int i = 0; i < list.size(); i++) {

			String file = list.get(i);
			doEncodeAllJava(file);
		}
	}

	private static String getExtendsNameByFile(File file) {
		String expandsName = FilenameUtils.getExtension(file.getAbsolutePath());
		return expandsName;
	}

	private static String getClassNameByFile(File file) {
		String className = FilenameUtils.getBaseName(file.getAbsolutePath());
		return className;
	}

	protected static void doEncodeAllJava(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			File[] listFile = file.listFiles();
			if (listFile != null) {
				for (int i = 0; i < listFile.length; i++) {
					if (listFile[i].isDirectory()) {
						doEncodeAllJava(path);
					} else {
						doEncodeAllJava(path);
					}
				}
			}
		}
		String expandsName = getExtendsNameByFile(file);
		String className = getClassNameByFile(file);
		if (!"java".equals(expandsName)) {
			System.out.println("extensionName:" + expandsName + ",className:" + className);// extensionName:txt,className:fw
			System.out.println("忽略文件 非java文件:" + file.getAbsolutePath());

			return;
		}

		String result = readTxtFileEncode(path, className);
		if (!writeFile) {
			System.out.println("忽略,不写入文件");
			return;
		}
		try {
			FileUtils.writeStringToFile(file, result, "utf-8", false);
		} catch (IOException e) {
			System.err.println("写入一个文件失败:" + file.getAbsolutePath() + "\n" + e.toString() + "\n");
			e.printStackTrace();
		}
		System.out.print("覆盖文件成功:" + path + "\n");
	}

	/**
	 * 解密方法
	 * 
	 * @param name
	 * @return
	 */
	public static final String getDecodeMethodNameCall(String name) {
		return decodeMethodName + "(" + name + ")";
	}

	/**
	 * 获取要加密或者解密的文件集合
	 * 
	 * @return
	 */
	private static ArrayList<String> getFileArrayList() {
		String temp = "";
		ArrayList<String> list = new ArrayList<String>();

		if (false == true) {
			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\TestVar.java";
			list.add(temp);
		} else {

			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\UiUtils.java";
			list.add(temp);
			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\fw.java";
			list.add(temp);
			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\QQUnrecalledHook.java";
			list.add(temp);

			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\QTA.java";
			list.add(temp);

			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\DS.java";
			list.add(temp);
			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\Cf.java";

			list.add(temp);
			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\qqplugin.java";
			list.add(temp);
			temp = "F:\\src\\git_project\\MyApplication2\\app\\src\\main\\java\\com\\tencent\\mobileqq\\zhengl\\InitConfig.java";
			list.add(temp);
		}

		/* */

		return list;
	}

	/**
	 * 解密文本 java
	 * 
	 * @param path
	 */
	protected static void doDecodeAllJava(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			File[] listFile = file.listFiles();
			if (listFile != null) {
				for (int i = 0; i < listFile.length; i++) {
					if (listFile[i].isDirectory()) {
						doEncodeAllJava(path);
					} else {
						doEncodeAllJava(path);
					}
				}
			}
		}
		String expandsName = FilenameUtils.getExtension(file.getAbsolutePath());
		String className = FilenameUtils.getBaseName(file.getAbsolutePath());
		if (!"java".equals(expandsName)) {
			System.out.println("extensionName:" + expandsName + ",className:" + className);// extensionName:txt,className:fw
			System.out.println("忽略文件 非java文件:" + file.getAbsolutePath());

			return;
		}
		String result = readTxtFileDecode(path, className);
		if (!writeFile) {
			System.out.println("忽略,不写入文件");
			return;
		}
		try {
			FileUtils.writeStringToFile(file, result, "utf-8", false);
		} catch (IOException e) {
			System.out.println("写入一个文件失败:" + file.getAbsolutePath() + "\n" + e.toString() + "\n");
			e.printStackTrace();
		}
		System.out.print("覆盖文件成功:" + path + "\n");
	}

	// 每锟轿讹拷一锟斤拷锟角诧拷锟斤拷效锟斤拷锟叫碉拷锟斤拷耍锟�
	private static String getVarName(String name, boolean isChinese) {
		return "public final static int[] " + getVarBaseName(name, isChinese) + "= ";
	}

	private static String getVarName(String varName) {
		return "public final   static int[] " + varName + "= ";
	}

	/**
	 * 之前的直接分割会导致变量名冲突了。不能保证唯一 。比如 forui切换器控件。
	 * 
	 * @param conent
	 * @param isChinese
	 * @return
	 */
	private static String getVarBaseName(String conent, boolean isChinese) {

		Pattern p = Pattern.compile("\\s*|\t|\r|\n|>");
		Matcher m = p.matcher(conent);
		conent = m.replaceAll("");
		// if(true){
		// return;
		// }
		String temp = conent.replaceAll("#", "jing");
		temp = temp.replaceAll("\\%s", "");// 这个名字不生成变量 这是转义的
		// temp = temp.replaceAll("[\n]", "woshi换行");//搜索不到
		temp = temp.replaceAll("\\%d", "");// 这个名字不生成变量 这是转义的
		temp = temp.replaceAll("\\%f", "");// 这个名字不生成变量 这是转义的
		temp = temp.replaceAll("【", "zhongz");
		temp = temp.replaceAll("//>", "right_arr_");
		temp = temp.replaceAll("】", "zhongr");
		temp = temp.replaceAll("‘", "_yiyuyan_");// 易语言注释一样奇葩
		temp = temp.replaceAll("。", "_pointZ_");// 易语言注释一样奇葩
		temp = temp.replaceAll("……", "_sheng_");// 省略号
		temp = temp.replaceAll("；", "_fenhaoZ_");// 省略号
		temp = temp.replaceAll("——", "_henganZ_");// 省略号
		temp = temp.replaceAll("—-", "_henganZ1_");// 没有按shirt
		temp = temp.replaceAll("\\(", "leftkuohao_");
		temp = temp.replaceAll("\\?", "_wenhao_");
		temp = temp.replaceAll("\\$", "_meiyuan_");
		temp = temp.replaceAll("￥", "_renminbi_");
		temp = temp.replaceAll("\\\\", "_fx_");// 这个比较特别的符号，另外
												// 如果|符号弄出来了||||4个进行匹配会导致的结果是出现多个被替换。都变成了split
		temp = temp.replaceAll("（", "leftkuohao_");
		temp = temp.replaceAll("\\)", "r_kuohao_");
		temp = temp.replaceAll("\\）", "r_kuohao_");
		/*
		 * temp = temp.replaceAll("\\[", "l_zkh_"); temp =
		 * temp.replaceAll("\\]", "r_zkh_");
		 */
		temp = temp.replaceAll("\\^", "_sjt_");
		temp = temp.replaceAll("	", "_tab_");
		temp = temp.replaceAll(" ", "_space_");
		temp = temp.replaceAll(">", "_jian_right_");
		temp = temp.replaceAll("《", "l_jt");
		temp = temp.replaceAll("<", "l_jt");
		temp = temp.replaceAll(">", "r_jt");
		temp = temp.replaceAll("》", "r_jt");
		temp = temp.replaceAll("\\*", "xing");

		temp = temp.replaceAll("\\.", "point");
		temp = temp.replaceAll("&", "_with_");
		temp = temp.replaceAll("，", "_douhao_");
		temp = temp.replaceAll("、", "_dunhao_");
		temp = temp.replaceAll("%", "_bai_");
		temp = temp.replaceAll("#", "_jin_");
		temp = temp.replaceAll("@", "aite_");
		temp = temp.replaceAll("!", "gantan_");
		temp = temp.replaceAll("\\+", "_add_");
		temp = temp.replaceAll("=", "_eq_");
		temp = temp.replaceAll("-", "_sub_");
		temp = temp.replaceAll("·", "_esc_next_");
		temp = temp.replaceAll("~", "_piao_");

		temp = temp.replaceAll(",", "_douhao_");
		temp = temp.replaceAll("/", "_x_");

		temp = temp.replaceAll("\\{", "_dkhl_");
		temp = temp.replaceAll("}", "_dkhr_");
		temp = temp.replaceAll(";", "_fenhao_");
		temp = temp.replaceAll("\"", "");
		temp = temp.replaceAll("\'", "");
		temp = temp.replaceAll("\\[", "zkhl_");
		temp = temp.replaceAll("\\]", "_zhhr_");
		temp = temp.replaceAll("\\|", "_spt_");
		temp = temp.replaceAll(":", "_mh_");
		temp = temp.replaceAll("！", "_GTH_");
		String temp1 = "QSSQ_" + (isChinese ? hanyuPinyinHelper.toHanyuPinyin(temp) : temp);
		if (temp1.length() > 40) {
			temp1 = temp1.substring(0, 20) + MD5Util.MD5Encode(temp1);
		}
		return temp1;
	}

	private static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd-HH:mm:dd");
		return format.format(date);
	}

	/**
	 * 
	 * 多余已存在的变量还是建议手动删除的比较好 ，所以这里创建一个时间标记
	 * 
	 * @param filePath
	 *            d读入的文件
	 * @param className
	 *            类名
	 * @param vardeclareJava
	 *            插入的类
	 * @return
	 */
	public static String getInsertSplitLine(String className) {
		return "////【插入分割线[" + className + "]:" + getCurrentTime() + "】\n";
	}

	public static void readEncodeVarArrayList(ArrayList<String> list) {

		String constantClassSrc;// 这个值不断的变化叠加。不会反悔null.
		try {
			constantClassSrc = FileUtils.readFileToString(new File(sConstantClassPath), "utf-8");
		} catch (IOException e1) {

			e1.printStackTrace();
			throw new RuntimeException(e1);
		}

		for (int i = 0; i < list.size(); i++) {
			String file = list.get(i);
			String className = getClassNameByFile(new File(file));
			constantClassSrc = readEncodeVarAndInsert(file, className, constantClassSrc);// className用于判断到底属于那个类的变量
		}
		;
		/*
		 * try { FileUtils.copyFile(new File(sConstantClassPath), new
		 * File(sConstantClassPath + ".bak")); } catch (IOException e1) {
		 * 
		 * e1.printStackTrace(); }
		 */
		try {
			FileUtils.writeStringToFile(new File(sConstantClassPath), constantClassSrc, "utf-8", false);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}

	public static String readEncodeVarAndInsert(String filePath, String className, String vardeclareJava) {

		/**
		 * 如果已经存在了则不再进行添加
		 */

		// System.out.println();

		String patternString = "\"(.*?)\"";// 取出双引号
		StringBuffer sb = new StringBuffer();
		StringBuffer varNameSb = new StringBuffer();
		varNameSb.append(getInsertSplitLine(className));
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {
					// 匹配类似velocity规则的字符串
					// 生成匹配模式的正则表达式
					Pattern pattern = Pattern.compile(patternString);

					Matcher matcher = pattern.matcher(lineTxt);

					// 两个方法：appendReplacement, appendTail
					if (isIgNoreDecodeText(lineTxt)) {// 一般情况下这是一个私有的字段
														// 忽略
						if (debug) {
							// 那么问题来了，\n字符串如何处理换行问题呢、
							System.err.println("忽略包含日志行 忽略:" + lineTxt);
						}
					} else {

						while (matcher.find()) {
							String matchBase = matcher.group();
							// System.err.println("match:" +);//这里匹配返回的包含引号
							String temp = matcher.group(1);// 不包含双引号
							if (temp != null && temp != "" && temp != "," && temp != "&" && temp.length() > 0) {
								boolean isChinese = checkChinese(temp);

								if (isChinese || checkZimu(temp)) {
									String baseVar = getVarBaseName(temp, isChinese);
									if (!sEncodeMap.containsKey(baseVar)) {
										if (sDecodeMap.containsKey(baseVar)) {
											sEncodeMap.put(baseVar, "");
											if (debug) {
												System.err.println("解码常量表已定义变量:" + baseVar + ",line:" + temp);
											}
											continue;
										}
										// 生成注释声明
										varNameSb.append("/**\n" + temp + "\n*/\n");
										/*
										 * 下面这句话实现变量申明字符串
										 */
										// 生成
										varNameSb.append(getVarName(baseVar) + StringToCharCodeJava(temp) + "//content=" + temp + "\n\n");
										if (debug) {
											System.out.println("创建字段:" + baseVar + ",value:" + temp);
										}
										sEncodeMap.put(baseVar, "");
									} else {
										if (debug) {

											System.err.println("忽略已存在的字段:" + baseVar);
										}
									}
								}
							}
						}
					}
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件" + file.getAbsolutePath());
				throw new RuntimeException("找不到指定的文件" + filePath);
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		varNameSb.append(getInsertSplitLine(className));
		return insertFieldAtClassAfter(className, vardeclareJava, varNameSb.toString());
	}

	/*
	 * public static boolean checkChinese(String chinese) { String regex =
	 * "[\u4e00-\u9fa5]\"; return Pattern.matches(regex, chinese); }
	 */
	public static boolean checkChinese(String str) {

		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	public static boolean checkZimu(String str) {

		Pattern p = Pattern.compile("[a-zA-Z]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 加载加密字段并进行解密处理 存放到集合中 如果需要替换则会返回替换,进行屏蔽处理之后的文本
	 * 
	 * @param filePath
	 * @param className
	 * @param needReplace
	 *            是否需要替换 需要替换则把存在的申明变量注释 否则 无视！
	 * @return
	 */

	public static String looadDecodeFieldToHashMap(String filePath, boolean needReplace) {
		/**
		 * 加密变量名 和 解密结果
		 */

		// System.out.println();

		StringBuffer sb = new StringBuffer();
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {

					// 匹配类似velocity规则的字符串

					// 生成匹配模式的正则表达式
					if (lineTxt.contains("int")) {// 对于常量行不需要判断是否是静态常量的。
						if (isIgNoreDecodeText(lineTxt, true)) {
							System.err.println("解析忽略忽略行：" + lineTxt);
							continue;
						}
						Pattern patternVarName = Pattern.compile(encodeLineReg);
						Matcher matcher = patternVarName.matcher(lineTxt);

						while (matcher.find()) {
							String matchBase = matcher.group();// 获取匹配航
							String temp = matcher.group(1);// 获取匹配yuanzn
							String arrsStr = matcher.group(2);// 获取匹配yuanzn
							String[] arr = arr = arrsStr.split(",");
							char[] chars = new char[arr.length];
							for (int i = 0; i < chars.length; i++) {
								arr[i] = arr[i].replace(" ", "");
								int tempInt = Integer.parseInt(arr[i]);
								tempInt = getDecodeIntValue(tempInt);
								chars[i] = (char) tempInt;
							}
							String decodeResult = String.valueOf(chars);
							System.out.println("varName:" + temp + ",解密结果:" + decodeResult);
							sDecodeMap.put(temp, decodeResult);
							if (needReplace) {
								lineTxt = "////" + sIGNORE_DECODE + lineTxt;// 不进行删除而是进行注释
							}
						}
					}
					// 两个方法：appendReplacement, appendTail
					sb.append("" + lineTxt + "\n");

				}
				read.close();
			} else {
				throw new Error("找不到常量文件" + file);
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
			throw new Error(e);
		}
		/*
		 * if (true) { throw new RuntimeException("等待处理");
		 * 
		 * }
		 */
		return sb.toString();
	}

	// 根据Unicode编码完美的判断中文汉字和符号
	/*
	 * private static boolean isChinese(char c) { Character.UnicodeBlock ub =
	 * Character.UnicodeBlock.of(c); if (ub ==
	 * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub ==
	 * Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub ==
	 * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub ==
	 * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || ub ==
	 * Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub ==
	 * Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || ub ==
	 * Character.UnicodeBlock.GENERAL_PUNCTUATION) { return true; } return
	 * false; }
	 */
	/*
	 * public static boolean checkZimu(String chinese) { String regex =
	 * "a-zA-Z"; return Pattern.matches(regex, chinese); }
	 */
	/**
	 * ffff
	 * 
	 */

	public static boolean isEncodeLine(String str) {
		return str.matches(encodeLineReg);
	}

	/**
	 * new\sint\[\s?\] \s匹配空格换行 ?0次或者多次 从变量字表中查询如果查询到则进行替换处理 并返回替换之后的文本 因此使用之前必须
	 * 写加载变量。
	 * 
	 * @param filePath
	 * @param className
	 * @return
	 */
	public static String readTxtFileDecode(String filePath, String className) {

		/**
		 * 加密变量名 和 解密结果
		 */

		// System.out.println();

		StringBuffer sb = new StringBuffer();
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// 判断是否是加密方法
					if (lineTxt.contains(decodeMethodName)) {
						Pattern patternVarMethod = Pattern.compile(decodeMethodNameReg);
						// System.err.println("当前可能是变量行行:"+lineTxt);
						Matcher matcherMethod = patternVarMethod.matcher(lineTxt);
						while (matcherMethod.find()) {
							String matchBase = matcherMethod.group();// 获取匹配航
							String temp = matcherMethod.group(1);// 把变量名替换即可
							String varName = temp.replace(sConstantsClass + ".", "");// 触发类名.
							if (sDecodeMap.containsKey(varName)) {
								String value = sDecodeMap.get(varName);// 解密后文本在另外一个方法已经处理
								lineTxt = lineTxt.replace(decodeMethodName + "(" + temp + ")", "\"" + value + "\"");// 对函数进行替换
								lineTxt = lineTxt.replaceAll("\n", sBrSign);// 处理里的字符串。
								if (lineTxt.indexOf("\n") != -1) {
									System.err.println("无法替换\n还是存在");
								}
								if (debug) {

									System.out.println("找到定义变量名：" + temp + "实际变量值:" + value + "\n替换后当前行:" + lineTxt);
								}

							} else {

								System.err.println("无法处理变量 因为成员变量中不存在,looadEncodeFieldToHashMap确保解密之前是否调用了加载变量方法,var:" + varName + "\n所处行:\n" + lineTxt);
							}
						}
					}
					// 两个方法：appendReplacement, appendTail
					sb.append("" + lineTxt + "\n");

				}
				read.close();
			} else {

				System.err.println("找不到指定的文件");
				throw new RuntimeException("找不到文件" + filePath);
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
			throw new RuntimeException("文件文件" + e);
		}
		/*
		 * if (true) { throw new RuntimeException("等待处理");
		 * 
		 * }
		 */
		return sb.toString();
	}

	public static String readTxtFileEncode(String filePath, String className) {

		/**
		 * 如果已经存在了则不再进行添加
		 */

		// System.out.println();

		String patternString = "\"(.*?)\"";
		StringBuffer sb = new StringBuffer();
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {

					// 匹配类似velocity规则的字符串

					// 生成匹配模式的正则表达式

					// 两个方法：appendReplacement, appendTail
					if (isIgNoreDecodeText(lineTxt)) {// 一般情况下这是一个私有的字段
														// 忽略
						if (debug) {
							// 那么问题来了，\n字符串如何处理换行问题呢、
							System.out.println("readTxtFileEncode->忽略包含日志行 忽略:" + lineTxt);
						}
					} else {
						Pattern pattern = Pattern.compile(patternString);

						Matcher matcher = pattern.matcher(lineTxt);
						while (matcher.find()) {
							String matchBase = matcher.group();
							// System.err.println("match:" +);//这里匹配返回的包含引号
							String temp = matcher.group(1);// 不包含双引号
							if (temp != null && temp != "" && temp != "," && temp != "&" && temp.length() > 0) {
								boolean isChinese = checkChinese(temp);

								if (isChinese || checkZimu(temp)) {
									String baseVar = getVarBaseName(temp, isChinese);
									if (!sEncodeMap.containsKey(baseVar)) {
										// 生成注释声明
										/*
										 * 下面这句话实现变量申明字符串
										 */
										// filedNameMap.put(baseVar, "");
										System.err.println("变量" + baseVar + "不存在,忽略替换" + temp);
										// throw new
										// RuntimeException("找不到对于的变量名:" +
										// baseVar + "，确保之前已经加载");
									} else {
										System.out.println("找到变量:" + baseVar);
									}

									if (debug) {

										System.out.println("lineTextBefore:" + lineTxt + ",varName:" + baseVar);
									}

									lineTxt = lineTxt.replace(matchBase, getDecodeMethodNameCall(sConstantsClass + "." + baseVar));// 把"ffd"替换为
																																	// 解密方法.sss(常量类.变量名)
									if (debug) {
										System.out.println("lineTextAfter:" + lineTxt);
									}
								} else {
									// varNameSb.append("/**忽略" + temp + "
									// **/\n\n");
								}
							}
						}
					}

					sb.append("" + lineTxt + "\n");

				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * * 插入 一段 字符串到指定文本的 class之后的成员变量
	 * 
	 * @param className
	 * @param javaSrcFileContent
	 * @param insertContent
	 * @return
	 */
	public static String insertFieldAtClassAfter(String className, String javaSrcFileContent, String insertContent) {
		// TODO Auto-generated method stub

		StringBuffer s1 = new StringBuffer(javaSrcFileContent); // 原字符串

		String match = ".*?\\s*class " + sConstantsClass + ".*?\\{";
		Pattern p = Pattern.compile(match); // 插入位置
		Matcher m = p.matcher(s1.toString());
		if (m.find()) {
			s1.insert((m.end() + 1), insertContent); // 插入字符串
		} else {
			System.err.println("无法匹配匹配无法插入,className:" + className + ",源文件内容:" + javaSrcFileContent);
			throw new RuntimeException("无法匹配:" + match);
		}

		// System.out.println(s1.toString());
		return s1.toString();
	}

	private static String readString2(String strPath)

	{

		StringBuffer sb = new StringBuffer("");

		File file = new File(strPath);

		try {

			FileReader fr = new FileReader(file);

			int ch = 0;

			while ((ch = fr.read()) != -1)

			{

				sb.append((char) ch);

			}

			fr.close();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			System.out.println("File reader锟斤拷锟斤拷");

		}
		if (true) {
			return sb.toString();
		}
		try {

			return new String(sb.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return null;

	}

	public static int[] charArrayToEncodeIntArray(char[] chars) {
		int[] intArray = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			intArray[i] = chars[i];
			intArray[i] = getEncodeIntValue(intArray[i]);
			System.out.println("加密前:" + ((int) chars[i]) + ",加密后:" + intArray[i]);

		}
		return intArray;
	}

	public static int getEncodeIntValue(int value) {
		return (value << 2) + 69;// 线 与运算再叠加
	}

	public static int getDecodeIntValue(int value) {
		return (value - 69) >> 2;// 移除代价再与运算
	}

	// private int[] a=new int[];
	/**
	 * 字符串转int[]数组 字符串java
	 * 
	 * @param str
	 *            要加密的字符串
	 * @return
	 */
	public static String StringToCharCodeJava(String str) {

		if (str.indexOf("brbr") != -1) {
			str = str.replaceAll(sBrSign, "\n");// 处理特殊符号转义 如果直接\n那么会读入多行不是吗？
			if (debug) {
				System.err.println("进行编码加密brbr转换为换行符,转换结果:" + str);
			}
		}
		return getIntSvARValue(charArrayToEncodeIntArray(str.toCharArray()));
	}

	/**
	 * ; 给我一个int数组返回一个字符串 int申明 但是变量接受不包含
	 * 
	 * @param ints
	 * @return
	 */
	public static String getIntSvARValue(int[] ints) {
		char[] chars = new char[ints.length];
		StringBuilder sbChars = new StringBuilder();
		sbChars.append("new int[]{");
		for (int i = 0; i < ints.length; i++) {
			chars[i] = (char) ints[i];
			sbChars.append("" + ints[i]);
			if (i != ints.length - 1) {
				sbChars.append(",");
			} else {
				sbChars.append("};");
			}
		}

		return sbChars.toString();
	}

	static boolean isIgNoreDecodeText(String text) {// 对于静态的首先对于jni要处理加载顺序问题就是一个很头疼的问题，其次
		return isIgNoreDecodeText(text, false);
	}

	static boolean isIgNoreDecodeText(String text, boolean isdecodeConstants) {// 对于静态的首先对于jni要处理加载顺序问题就是一个很头疼的问题，其次
		if (isdecodeConstants) {

			return text.toUpperCase().contains(sIGNORE_DECODE) || text.toUpperCase().contains("HOOKLOG");
		}
		return text.toUpperCase().contains(sIGNORE_DECODE) || text.toUpperCase().contains("HOOKLOG") || (text.contains("final") && text.contains("static"));
	}
}