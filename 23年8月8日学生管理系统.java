import java.util.*;
public class esec1{
	static XueSheng[] xs ={
			new XueSheng("С��",19,'Ů',61),
			new XueSheng("С��",24,'��',79),
			new XueSheng("С��",23,'��',54),
			new XueSheng("С��",21,'Ů',91),
			new XueSheng("С��",20,'��',87),
			new XueSheng("С��",18,'Ů',21)
	};
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		pri("==========================��ӭ����Fantongѧ������ϵͳ==========================");
		xuanxiang();
	}//main

	public static void xuanxiang(){//ѡ��ģ��
		pri("A.���շ�����������");
		pri("B.���շ�����������");
		pri("C.���ѧ����Ϣ");
		pri("D.ɾ��ѧ����Ϣ");
		pri("E.�޸�ѧ����Ϣ");
		pri("F.�˳�ϵͳ");
		String shuru =sc.next();
		if(shuru.equals("F")||shuru.equals("f")){//ϵͳ�˳�ģ��
			pri("ϵͳ���˳�");
		}else{
			if(shuru.equals("A")){
				xuanxiangA();
			}else if(shuru.equals("B")){
				xuanxiangB();
			}else if(shuru.equals("C")){
				xuanxiangC();
			}else if(shuru.equals("D")){
				xuanxiangD();
			}else if(shuru.equals("E")){
				xuanxiangE();
			}else{
				pri("�������,��ѡ�����");
			}
		}//if else
	}//ѡ��ģ��

	public static void pri(String x){//��ӡģ��
		System.out.println(x);
	}//��ӡģ��
	public static void zhanshi(){//���չʾ
		pri("���	����	����	�Ա�	����");
		for(int x =0;x<xs.length;x++){//for
			pri(x+"	"+xs[x].getName()+"	"+xs[x].getAge()+"	"+xs[x].getGender()+"	"+xs[x].getScore());
		}//for
	}//���չʾ

	public static void xuanxiangA(){//ѡ��A��������
		for(int x =0;x<xs.length-1;x++){//for1
			for(int y =0;y<xs.length-1;y++){
				if(xs[y].getScore()<xs[y+1].getScore()){
					XueSheng z = xs[y];
					xs[y] = xs[y+1];
					xs[y+1] = z;
				}
			}
		}//for1
		zhanshi();
		xuanxiang();
	}//ѡ��A��������

	public static void xuanxiangB(){//ѡ��B��������
		for(int x =0;x<xs.length-1;x++){//for1
			for(int y =0;y<xs.length-1;y++){
				if(xs[y].getScore()>xs[y+1].getScore()){
					XueSheng z = xs[y];
					xs[y] = xs[y+1];
					xs[y+1] = z;
				}
			}
		}//for1
		zhanshi();
		xuanxiang();
	}//ѡ��B��������

	public static void xuanxiangC(){//ѡ��C�����Ϣ
		pri("������ѧ������");
			String name = sc.next();
		pri("������ѧ������");
			int age = sc.nextInt();
		pri("��ѡ��ѧ���Ա�");
		pri("A:��		BŮ");
			char gender = sc.next().equals("A")?'��':'Ů';
		pri("������ѧ������");
			int score = sc.nextInt();
		XueSheng linshisj = new XueSheng(name,age,gender,score);
		//�ж���Ϣ�Ƿ����ظ�
		int i = 0;
		for(XueSheng x : xs){
			if(x.getName().equals(linshisj.getName())&&x.getAge() == linshisj.getAge()&&x.getGender() == linshisj.getGender()&&x.getScore() == linshisj.getScore()){
				pri("����Ϣ�Ѵ���,�����ظ����");
				xuanxiang();
				break;
			}else{
				i++;
			}
		}
		if(i == xs.length){
			pri("��ӳɹ�");
			XueSheng[] linshi =new XueSheng[xs.length+1];//����һ����ʱ����
			for(int x = 0;x<xs.length;x++){
				linshi[x] = xs[x];
		}
		linshi[linshi.length-1] = linshisj;
		xs = linshi;
		//չʾѧ����Ϣ
		zhanshi();
		xuanxiang();
		}

	}//ѡ��C�����Ϣ

	public static void xuanxiangD(){//ѡ��Dɾ����Ϣ
		zhanshi();
		pri("��������Ҫɾ����ѧ�����");
		int del = sc.nextInt();//��Ҫɾ�����±�
		int x =0;
		int i =0;
		for(x = 0;x<xs.length;x++){
			if(x == del){
				pri("ȷ��Ҫɾ��������Ϣ��?ɾ�������ݽ��޷��ָ�");
				pri("Y:ȷ��	N:ȡ��");
				String queren = sc.next();
				if(queren.equals("Y")||queren.equals("y")){
					XueSheng[] linshi = new XueSheng[xs.length-1];//������ԭ����ȳ�����ʱ����
					if(del == 0){
						System.arraycopy(xs,1,linshi,0,xs.length-1);//����û�����ֵΪ0
					}else{
						//System.arraycopy(xs,0,linshi,del-1,x);//�˴�����,����ԭ��˴�ӦΪ�±�0,����ʹ��del��Ϊֵ���뵼�¿�ָ���쳣
						System.arraycopy(xs,0,linshi,0,x);//����Ԫ��֮ǰ��Ԫ�ظ��Ƶ�������
						System.arraycopy(xs,del+1,linshi,del,xs.length-x-1);//����Ԫ��֮���Ԫ�ظ��Ƶ�������
					}
					xs = linshi;//�����������ݽ���ԭ����
					pri("ɾ���ɹ�");
					zhanshi();
				}else{
					xuanxiang();
				}
			}else{
				i++;
			}
		}
		if(i == xs.length){
			pri("δ�ҵ�����Ϣ,������ȷ���Ƿ�������ȷ");
			xuanxiang();
		}
	}//ѡ��Dɾ����Ϣ

	public static void xuanxiangE(){//ѡ��E�޸���Ϣ
	    zhanshi();
	    pri("��������Ҫ�޸ĵ�ѧ�����");
	    int shuru = sc.nextInt();
	    int i = 0;
	    int x = 0;
	    for (x = 0; x < xs.length; x++) {
	        if (x == shuru) {
	            pri("������ѧ������");
	            String name = sc.next();
	            pri("������ѧ������");
	            int age = sc.nextInt();
	            pri("��ѡ��ѧ���Ա�");
	            pri("A:��        BŮ");
	            char gender = sc.next().equals("A") ? '��' : 'Ů';
	            pri("������ѧ������");
	            int score = sc.nextInt();
	            XueSheng linisj = new XueSheng(name, age, gender, score);
	            for(XueSheng t:xs){
					if(t.getName().equals(linisj.getName())&&t.getAge() == linisj.getAge()&&t.getGender() ==linisj.getGender()&&t.getScore() == linisj.getScore()){
						pri("�������Ѵ���,�����ظ�����");
						xuanxiang();
					}
				}
	                pri("�޸ĳɹ�");
	                xs[x] = linisj;
	                zhanshi();
	                xuanxiang();
	                break;
			} else {
				i++;
			}
		}
		if(i == xs.length){
			pri("δ��ѯ���˱��,�����º�ʵ");
		}
	}

}//����

class XueSheng{
	private String name;
	private int age;
	private char gender;
	private int score;

	//��װname
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	//��װage
	public void setAge(int age){
		this.name = name;
	}
	public int getAge(){
		return age;
	}

	//��װgender
	public void setGender(char gender){
		this.gender = gender;
	}
	public char getGender(){
		return gender;
	}

	//��װscore
	public void setScore(int Score){
		this.score = score;
	}
	public int getScore(){
		return score;
	}

	//���췽��
	public XueSheng(String name,int age,char gender,int score){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.score = score;
	}
}