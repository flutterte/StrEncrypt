import java.awt.image.ReplicateScaleFilter;
import java.util.ArrayList;

public class CodeTest {
	public static void main(String[] args) {

		testAtest1();
	}

	public static void testAtest1() {

		ArrayList<String> arrayList = new ArrayList<>();
		int[] temp = new int[] {};
		// temp = new int[] { 10, 91, 32676, 21517, 58, 37, 115, 93, 10, 91,
		// 32676, 21495, 58, 37, 115, 93, 10, 91, 26165, 31216, 58, 37, 115, 93,
		// 10, 91, 65329, 65329, 58, 37, 115, 93 };
		// temp=new int[]{24773, 36801, 32418, 21253, 32, 37, 115, 20803, 40,
		// 37, 115, 41, 10};
		// temp = new int[] { 27809, 25250, 21040, 40, 37, 115, 41, 37, 115 };
		// temp = new int[] {27809, 25250, 21040, 40, 37, 115, 41, 37, 115
		// };//多一个10就是换行
		// temp=new
		// int[]{224773,36801,32418,21253,32,37,115,20803,40,37,115,41,10,37,115};
		// int[] QSSQ_zaicishenmingruanjianshiyongjiu_dou= new
		// int[]{20877,27425,30003,26126,36719,20214,26159,27704,20037,44,20813,36153,20307,39564,30340,44,22914,26524,20320,26159,20174,21035,20154,25163,37324,20184,36153,36141,20080,30340,44,35831,37038,31665,20030,25253,65292,25105,23558,25226,27492,20154,25289,20837,40657,21517,21333,44,21518,26524,20320,25026,30340,33,10,20307,39564,23436,27605,35831,50,52,23567,26102,20869,21024,38500,44,19981,21024,38500,26159,20320,30340,20107,24773,21704,33,19968,20999,36829,27861,34892,20026,19982,25105,26080,20851,10,44,20219,20309,36827,34892,29279,21033,30340,34892,20026,37117,26159,36829,27861,30340,44,19981,31649,20320,26159,19981,26159,26410,25104,24180,20154,44,35831,33258,37325,33,25630,22823,20102,36466,30417,29425,33,33,33,32,10,24819,20102,24456,20037,36824,26159,30041,20010,32852,31995,26041,24335,21543,33,22914,26524,24744,24050,34987,39575,24076,26395,19979,27425,19981,35201,34987,39575,20102,65292,20063,24076,26395,20320,19981,35201,20570,36825,31181,20154,44,30475,35265,19968,27425,37145,35270,19968,27425,10,20851,27880,26356,26032,35831,35775,38382,104,116,116,112,58,47,47,113,115,115,113,54,54,54,46,99,110,47,117,112,100,97,116,101,47,113,113,95,114,101,100,112,97,99,107,97,103,101,116,46,104,116,109,108,10,20026,20102,38450,27490,26356,22810,30340,20154,34987,39575,20030,25253,25910,36153,37038,31665,58,113,115,115,113,54,54,54,64,102,111,120,109,97,105,108,46,99,111,109,32,10,20986,29616,26410,30693,26080,27861,39046,21462,30340,38169,35823,24314,35758,21368,36733,26377,39118,38505,36719,20214,44,37325,35013,26412,36719,20214,44,21521,20316,32773,25552,20132,38382,39064,19968,23450,35201,35828,28165,26970,38382,39064,44,32780,19981,26159,20316,32773,36861,38382,20320,20855,20307,24590,20040,24590,20040,20010,29616,35937,44,20320,20570,20102,20160,20040,32,10,32473,25105,24377,35270,39057,35821,38899,30340,20154,30452,25509,25289,40657,19981,35299,37322,33,32,32,10,36719,20214,20250,25345,32493,26356,26032,44,21578,35785,22823,23478,30340,22909,28040,24687,26159,25105,30340,34892,21160,23558,25472,36215,33258,24102,81,81,25250,32418,21253,29378,28526,21704,32,10,25105,21602,26159,24037,36164,38454,23618,44,20570,36825,20010,19996,35199,21602,21482,33021,26202,19978,10,21452,20241,21435,25630,44,26102,38388,19981,26159,24456,22810,44,36824,26377,23601,26159,36825,30772,32593,19978,20256,36895,24230,22826,24930,44,33258,24102,30340,21253,25991,20214,22823,44,25152,20197,26356,26032,27604,36739,24930,44,20986,29616,38382,39064,19981,20250,39532,19978,36827,34892,26356,26032,44,19981,28982,25105,26089,19978,20256,24456,22810,20010,29256,26412,20102,10,25152,20197,24076,26395,22823,23478,35845,35299,44,29702,35299,32,20320,36825,20040,21943,25105,36719,20214,36825,20040,36825,20040,22403,22334,25105,36824,26377,27611,32447,30340,21160,21147,63,10,21478,22806,24819,21152,32676,30340,26379,21451,21487,20197,28857,20987,104,116,116,112,58,47,47,113,115,115,113,54,54,54,46,99,110,28857,20987,20851,20110,21152,20837,32676,21704,33,36825,37324,23601,19981,36148,20986,26469,20102,46,46};//content=再次申明软件是永久,免费体验的,如果你是从别人手里付费购买的,请邮箱举报，我将把此人拉入黑名单,后果你懂的!brbr体验完毕请24小时内删除,不删除是你的事情哈!一切违法行为与我无关brbr,任何进行牟利的行为都是违法的,不管你是不是未成年人,请自重!搞大了蹲监狱!!!
		// brbr想了很久还是留个联系方式吧!如果您已被骗希望下次不要被骗了，也希望你不要做这种人,看见一次鄙视一次brbr关注更新请访问http://qssq666.cn/update/qq_redpackaget.htmlbrbr为了防止更多的人被骗举报收费邮箱:qssq666@foxmail.com
		// brbr出现未知无法领取的错误建议卸载有风险软件,重装本软件,向作者提交问题一定要说清楚问题,而不是作者追问你具体怎么怎么个现象,你做了什么
		// brbr给我弹视频语音的人直接拉黑不解释! brbr软件会持续更新,告诉大家的好消息是我的行动将掀起自带QQ抢红包狂潮哈
		// brbr我呢是工资阶层,做这个东西呢只能晚上brbr双休去搞,时间不是很多,还有就是这破网上传速度太慢,自带的包文件大,所以更新比较慢,出现问题不会马上进行更新,不然我早上传很多个版本了brbr所以希望大家谅解,理解
		// 你这么喷我软件这么这么垃圾我还有毛线的动力?brbr另外想加群的朋友可以点击http://qssq666.cn点击关于加入群哈!这里就不贴出来了..
		/*
		 * temp = new int[] { 26469, 33258, 28909, 32842, 65329, 65329, 58, 34,
		 * 37, 115 }; temp= new int[]{40, 26469, 33258, 65329, 65329, 58, 37,
		 * 115, 91, 37, 115, 93, 41};
		 */
		// temp= new
		// int[]{143496,143496,131076,105980,176,143496,143496,91292,81328,176,143496,143496,89212,143784,176,80160,80160,86856};//content=谢谢老板,谢谢大佬,谢谢土豪,么么哒

		temp = new int[] { 465, 513, 505, 253, 533, 473, 509, 465, 473, 509, 533, 253, 505, 513, 461, 489, 501, 473, 521, 521, 253, 545, 489, 469, 481, 473, 533, 253, 349, 513, 525, 505, 401, 489, 505, 517, 501, 473, 361, 533, 473, 505 };// content=com.tencent.mobileqq.widget.FormSimpleItem
		temp = new int[] { 437, 437, 213, 505, 513, 509, 473, 553 };// content=\\$money

		// temp= new int[]{529,473,533,373,473,477,533,405,473,549,533};
		arrayList.add(printCharCode(temp));
		// arrayList.add(ByteEncodeUtil.printCharCode(QSSQ_zaicishenmingruanjianshiyongjiu_dou));
		String tempStr = "";
		tempStr = "A";
		arrayList.add(printCharCode(ByteEncodeUtil.charArrayToEncodeIntArray(tempStr.toCharArray())));
		arrayList.add(printCharCode(ByteEncodeUtil.charArrayToEncodeIntArray("\\$name".toCharArray())));
		// tempStr="谢谢老板,谢谢大佬,谢谢土豪,么么哒";

		// tempStr = "[群名:%s]\n[群号:%s]\n[昵称:%s]\n[ＱＱ:%s]";
		// tempStr = "情迁红包 %s元(%s)\n";
		// arrayList.add(printCharCode(ByteEncodeUtil.charArrayToEncodeIntArray(tempStr.toCharArray())));
		// arrayList.add(printCharCode(charArrayToIntArray("\n[群锟斤拷:%s]\n[群锟斤拷:%s]\n[锟角筹拷:%s]\n[锟窖ｏ拷:%s]".toCharArray())));
		// arrayList.add(printCharCode(charArrayToIntArray("锟斤拷锟斤拷锟捷硷拷锟斤拷失锟斤拷,锟斤拷锟斤拷没锟叫硷拷飧拷锟斤拷锟斤拷,锟斤拷锟斤拷锟截诧拷锟斤拷装锟斤拷迁锟斤拷锟斤拷锟结供锟侥硷拷锟斤拷锟结供锟竭凤拷锟斤拷锟斤拷锟�,锟缴斤拷锟狡碉拷锟斤拷锟斤拷锟斤拷薹锟斤拷锟斤拷艿锟斤拷锟斤拷锟絓nhttp://qssq666.cn\n群298081857".toCharArray())));

		for (int i = 0; i < arrayList.size(); i++) {

			// System.out.println("line:" + arrayList.get(i));
		}
	}

	public static String printCharCode(int[] ints) {
		char[] chars = new char[ints.length];
		StringBuilder sbChars = new StringBuilder();
		sbChars.append("   new int[]{");
		for (int i = 0; i < ints.length; i++) {
			StringBuffer tempsb = new StringBuffer();
			tempsb.append("" + "srcCode:" + ints[i]);
			ints[i] = ByteEncodeUtil.getDecodeIntValue(ints[i],1);
			tempsb.append("解密后:" + ints[i]);
			chars[i] = (char) ints[i];
			System.out.println("【解密】" + tempsb.toString());
			sbChars.append("" + ints[i]);
			if (i != ints.length - 1) {
				sbChars.append(",");
			} else {
				sbChars.append("};");
			}
		}

		if (printSmallCode) {
			StringBuilder sbSmallCode = new StringBuilder();
			for (int i = 0; i < ints.length; i++) {
				sbSmallCode.append("0x" + Integer.toHexString(ints[i]) + "\n");
			}
			System.out.println("smallCode\n:" + sbSmallCode.toString());
		}

		String chinese = new String(chars);
		if (printChar) {
			System.out.println("chars:" + sbChars.toString());

		}
		if (printChar || printSmallCode) {

			System.out.println("result:[" + chinese + "]\n\n\n");
			String temp = "$moneyfff$name";
			String money = "1.0";
			String send_name = "sedfdf";
			temp = temp.replaceAll(chinese,money);
			temp = temp.replaceAll(chinese,send_name);
			System.out.println("replaceAllresut:" + temp);
		}
		return chinese;
	}

	public static boolean printSmallCode = false;
	public static boolean printChar = true;

	public static void testAtest() {

		ArrayList<String> arrayList = new ArrayList<>();
		int[] temp = new int[] {};
		// temp = new int[] { 10, 91, 32676, 21517, 58, 37, 115, 93, 10, 91,
		// 32676, 21495, 58, 37, 115, 93, 10, 91, 26165, 31216, 58, 37, 115, 93,
		// 10, 91, 65329, 65329, 58, 37, 115, 93 };

		// temp = new int[] { 27809, 25250, 21040, 40, 37, 115, 41, 37, 115 };
		// temp = new int[] {27809, 25250, 21040, 40, 37, 115, 41, 37, 115
		// };//多一个10就是换行

		arrayList.add(printCharCode(temp));
		String tempStr = ":没抢到(%s)%s\n";
		// tempStr = "[群名:%s]\n[群号:%s]\n[昵称:%s]\n[ＱＱ:%s]";
		// tempStr = "情迁红包 %s元(%s)\n";
		// arrayList.add(printCharCode(charArrayToEncodeIntArray(tempStr.toCharArray())));
		// arrayList.add(printCharCode(charArrayToIntArray("\n[群锟斤拷:%s]\n[群锟斤拷:%s]\n[锟角筹拷:%s]\n[锟窖ｏ拷:%s]".toCharArray())));
		// arrayList.add(printCharCode(charArrayToIntArray("锟斤拷锟斤拷锟捷硷拷锟斤拷失锟斤拷,锟斤拷锟斤拷没锟叫硷拷飧拷锟斤拷锟斤拷,锟斤拷锟斤拷锟截诧拷锟斤拷装锟斤拷迁锟斤拷锟斤拷锟结供锟侥硷拷锟斤拷锟结供锟竭凤拷锟斤拷锟斤拷锟�,锟缴斤拷锟狡碉拷锟斤拷锟斤拷锟斤拷薹锟斤拷锟斤拷艿锟斤拷锟斤拷锟絓nhttp://qssq666.cn\n群298081857".toCharArray())));
		/*
		 * for (int i = 0; i < arrayList.size(); i++) { String s =
		 * arrayList.get(i); System.out.println("line:" + (1 + i) + "," + s +
		 * ","); }
		 */
	}

	public static int[] charArrayToEncodeIntArray(char[] chars) {
		int[] intArray = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			intArray[i] = chars[i];
			intArray[i] = ByteEncodeUtil.getEncodeIntValue(intArray[i],1);

		}
		return intArray;
	}

}
