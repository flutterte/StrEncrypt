import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ColorHexPrint {
	public static void main(String[] args) {
		// java int���͸պ�32λ���պÿ�������������ɫ�Ĳ���
		int color = 0xffef2f;
		int colorGray = 0xffcccccc;
		int colorFull = 0xffffef2f;
		int colorRed = (255 * 2) << 16;
		int fullWhite = 0xffffffff;
		int fullWhite1 = 0b1111_1111_1111_1111______1111_1111_1111_1111;

		System.out.println("ox" + Integer.toHexString(color) + ",color:" + Integer.toHexString(colorFull) + ",RED:"

		+ Integer.toHexString(colorRed) + ",white:" + Integer.toHexString(fullWhite) + ",fullWhite1:"
				+ Integer.toHexString(fullWhite1));

		// �ӻ�ɫ����ȡ����ɫͨ�� ɾ��͸��ͨ�� �� ��ɫͨ�� ��ɫͨ�� �� Ҳ����ȡ�� ��һ��cc
		int and = colorGray & 0x00ff0000;
		// ȡ����֮�����ֵ�Ǻܱ�̬��, ox cc 00 00; ��һ�� ��ɫ����ɫͨ��������ˣ����ǻ���Ҫ�ټ�����
		System.out.println("��һ��:" + Integer.toHexString(and));
		int fixand = and >> (int) Math.pow(4, 2);
		// int fixand=and>>16;//�ƶ����ٸ�����λ�� 1���ֽ���4��bitλ һ����ɫ 2���ֽ� ����
		// Ҫȡ����ɫͨ����������ɫ����ɫ �Ļ�����4���ֽڣ�4��4ƽ��
		System.out.println("�ڶ���:" + Integer.toHexString(fixand) + "," + (Math.pow(4, 2)));
		test();
	}

	private static void test() {
		double d = 0.145;
//		double d = 114.145;
		BigDecimal b = new BigDecimal(d);
		d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(d);

		d =0.9353;
		DecimalFormat df = new DecimalFormat("#.00");
		String str = df.format(d);
		System.out.println("DecimalFormat "+str);

		System.out.println(String.format("ffffffffffffffffformat:%.2f", d));
		NumberFormat nf = NumberFormat.getNumberInstance();
		// ������λС��
		nf.setMaximumFractionDigits(2);
		// �������Ҫ�������룬����ʹ��RoundingMode.DOWN
		nf.setRoundingMode(RoundingMode.UP);
		System.out.println(nf.format(d));
	}
}
