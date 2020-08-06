
/*
*
*
*                           类加载
*
*
* 1.代码先从main方法执行，main是Test这个类的静态方法，就会触发Test的类加载
* 2.BB是Test的父类，在加载Test之前，会先加载BB
* 3.AA又是BB的父类，加载BB之前又会先加载AA
* 4.加载AA调用其中的静态代码块
* 5.加载BB调用BB的静态代码块
* 6.Test没有静态代码块，所以执行main方法内容
* 7.执行new BB（） 构造BB的实例会先构造AA 的实例，先执行AA 中的代码块和构造方法
*   再执行BB中的代码块，最后是BB中的构造方法
*
*
*
*
* */
class AA{
    public AA(){
        System.out.println("AA.构造方法");
    }



    {
        System.out.println("AA.代码块");
    }


    static {
        System.out.println("AA.静态代码块");
    }

}


class  BB extends AA{

    public BB(){
        System.out.println("BB.构造方法");
    }



    {
        System.out.println("BB.代码块");
    }


    static {
        System.out.println("BB.静态代码块");
    }
}


public class Test extends BB{
    public static void main(String[] args) {
        System.out.println("开始");
        new BB();
        new BB();
        System.out.println("结束");
    }


}
