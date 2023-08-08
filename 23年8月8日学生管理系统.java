import java.util.*;
public class esec1{
	static XueSheng[] xs ={
			new XueSheng("小红",19,'女',61),
			new XueSheng("小华",24,'男',79),
			new XueSheng("小明",23,'男',54),
			new XueSheng("小唐",21,'女',91),
			new XueSheng("小王",20,'男',87),
			new XueSheng("小张",18,'女',21)
	};
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		pri("==========================欢迎来到Fantong学生管理系统==========================");
		xuanxiang();
	}//main

	public static void xuanxiang(){//选项模块
		pri("A.按照分数升序排序");
		pri("B.按照分数降序排序");
		pri("C.添加学生信息");
		pri("D.删除学生信息");
		pri("E.修改学生信息");
		pri("F.退出系统");
		String shuru =sc.next();
		if(shuru.equals("F")||shuru.equals("f")){//系统退出模块
			pri("系统已退出");
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
				pri("输入错误,此选项不存在");
			}
		}//if else
	}//选项模块

	public static void pri(String x){//打印模块
		System.out.println(x);
	}//打印模块
	public static void zhanshi(){//表格展示
		pri("编号	姓名	年龄	性别	分数");
		for(int x =0;x<xs.length;x++){//for
			pri(x+"	"+xs[x].getName()+"	"+xs[x].getAge()+"	"+xs[x].getGender()+"	"+xs[x].getScore());
		}//for
	}//表格展示

	public static void xuanxiangA(){//选项A升序排序
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
	}//选项A升序排序

	public static void xuanxiangB(){//选项B降序排序
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
	}//选项B降序排序

	public static void xuanxiangC(){//选项C添加信息
		pri("请输入学生姓名");
			String name = sc.next();
		pri("请输入学生年龄");
			int age = sc.nextInt();
		pri("请选择学生性别");
		pri("A:男		B女");
			char gender = sc.next().equals("A")?'男':'女';
		pri("请输入学生分数");
			int score = sc.nextInt();
		XueSheng linshisj = new XueSheng(name,age,gender,score);
		//判断信息是否有重复
		int i = 0;
		for(XueSheng x : xs){
			if(x.getName().equals(linshisj.getName())&&x.getAge() == linshisj.getAge()&&x.getGender() == linshisj.getGender()&&x.getScore() == linshisj.getScore()){
				pri("此信息已存在,请勿重复添加");
				xuanxiang();
				break;
			}else{
				i++;
			}
		}
		if(i == xs.length){
			pri("添加成功");
			XueSheng[] linshi =new XueSheng[xs.length+1];//创建一个临时数组
			for(int x = 0;x<xs.length;x++){
				linshi[x] = xs[x];
		}
		linshi[linshi.length-1] = linshisj;
		xs = linshi;
		//展示学生信息
		zhanshi();
		xuanxiang();
		}

	}//选项C添加信息

	public static void xuanxiangD(){//选项D删除信息
		zhanshi();
		pri("请输入需要删除的学生编号");
		int del = sc.nextInt();//需要删除的下标
		int x =0;
		int i =0;
		for(x = 0;x<xs.length;x++){
			if(x == del){
				pri("确认要删除此条信息吗?删除后数据将无法恢复");
				pri("Y:确认	N:取消");
				String queren = sc.next();
				if(queren.equals("Y")||queren.equals("y")){
					XueSheng[] linshi = new XueSheng[xs.length-1];//创建与原数组等长的临时数组
					if(del == 0){
						System.arraycopy(xs,1,linshi,0,xs.length-1);//如果用户输入值为0
					}else{
						//System.arraycopy(xs,0,linshi,del-1,x);//此处错题,错误原因此处应为下标0,错误使用del作为值传入导致空指针异常
						System.arraycopy(xs,0,linshi,0,x);//将此元素之前的元素复制到新数组
						System.arraycopy(xs,del+1,linshi,del,xs.length-x-1);//将此元素之后的元素复制到新数组
					}
					xs = linshi;//将新数组数据交还原数组
					pri("删除成功");
					zhanshi();
				}else{
					xuanxiang();
				}
			}else{
				i++;
			}
		}
		if(i == xs.length){
			pri("未找到此信息,请重新确认是否输入正确");
			xuanxiang();
		}
	}//选项D删除信息

	public static void xuanxiangE(){//选项E修改信息
	    zhanshi();
	    pri("请输入需要修改的学生编号");
	    int shuru = sc.nextInt();
	    int i = 0;
	    int x = 0;
	    for (x = 0; x < xs.length; x++) {
	        if (x == shuru) {
	            pri("请输入学生姓名");
	            String name = sc.next();
	            pri("请输入学生年龄");
	            int age = sc.nextInt();
	            pri("请选择学生性别");
	            pri("A:男        B女");
	            char gender = sc.next().equals("A") ? '男' : '女';
	            pri("请输入学生分数");
	            int score = sc.nextInt();
	            XueSheng linisj = new XueSheng(name, age, gender, score);
	            for(XueSheng t:xs){
					if(t.getName().equals(linisj.getName())&&t.getAge() == linisj.getAge()&&t.getGender() ==linisj.getGender()&&t.getScore() == linisj.getScore()){
						pri("此内容已存在,请勿重复操作");
						xuanxiang();
					}
				}
	                pri("修改成功");
	                xs[x] = linisj;
	                zhanshi();
	                xuanxiang();
	                break;
			} else {
				i++;
			}
		}
		if(i == xs.length){
			pri("未查询到此编号,请重新核实");
		}
	}

}//主类

class XueSheng{
	private String name;
	private int age;
	private char gender;
	private int score;

	//封装name
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	//封装age
	public void setAge(int age){
		this.name = name;
	}
	public int getAge(){
		return age;
	}

	//封装gender
	public void setGender(char gender){
		this.gender = gender;
	}
	public char getGender(){
		return gender;
	}

	//封装score
	public void setScore(int Score){
		this.score = score;
	}
	public int getScore(){
		return score;
	}

	//构造方法
	public XueSheng(String name,int age,char gender,int score){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.score = score;
	}
}