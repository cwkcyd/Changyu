Kotlin 

# 一、Basic Syntax #
[http://blog.csdn.net/dangnianmingyue_gg/article/details/75305504](http://blog.csdn.net/dangnianmingyue_gg/article/details/75305504)
> 
**1、void返回值用Unit（无类型）**<Br>
**2、基本类型首字母大写int->Int**<br>

> **3、？操作符 对象可能为空**<br>
> 
    var name: String? = "Europe"
    fun parseInt(str: String): Int?
> **4、?. => b?.length => b为null输出null，否则输出b.length**<br>
**5、?: =>左侧表达式非空，就返回其左侧表达式，否则返回右侧表达式。。**<br>
>
    var a: Int = if (b != null) b.length else -1
    简写
    var a: Int = b?.b.length ?: -1 //b == nul时返回-1
> **6、!! => 返回非空或空（NPE异常）**<br>
> 
    fun testOperator2() {
    	var a: String? = null
    	val b = a?.length  // null
    	val c = a?:"a=null"  // "a=null"
    	val d = a!!.length // kotlin.KotlinNullPointerException
    }
> **7、== 值相等与 === 值跟引用都相等**<br>
> **8、.. => 1..9闭区间[1,9]**<br>
> **9、in与!in =>在区间中与非区间中**<br>
>
    if（i in 1..10) {} // i在[1，10]
>**10、for循环 until、downTo、step**<br>
>
    for (i in 1 until 10) //i的范围在[1,10)
    for (i in 4 downTo 1) //倒叙遍历
    for (i in 4 downTo 1 step 2) // "42" 
> **11、:: => 获取类的Class => User::class.java**<br>
> **12、@符号**

    1、限定this的类型
    class User {
	    inner class State{
	        fun getUser(): User{
	            //返回User
	            return this@User
	        }

	        fun getState(): State{
	            //返回State
	            return this@State
	        }
	    }
    }

    2、作为标签
    fun fun_for() {
	    loop@ for (i in 1..10){
	        for (j in 0..5) {
	            if (i == 2 && j == 2) {
	                break@loop
	            }
	            println("i = $i, j = $j")
	        }
	    }
	    println("for@loop end")
	
	    //break,continue只能使用在loop中
	    val intArr = intArrayOf(0, 1, 2, 3)
	    intArr.forEach {
	        if (it == 2)
	            return@forEach //相当于forEach函数中的contine
	        println("forEach it = $it") // "forEach it = 0|1|3" 
	    }
	
	    run {
	        intArr.forEach {
	            if (it == 1)
	                return@forEach //相当于continue
	            if (it == 2)
	                return@run //相当于break
	            println("run forEach it = $it") // "run forEach it = 0"
	        }
	    }
    }
**13、as 与 as? => 当使用 as 转型的时候，可能会经常出现 ClassCastException。 所以，现在可以使as?安全转型，当转型不成功的时候，它会返回 null。**
    
    fun fun_as() {
	    val b = 1L
	    val a: Int? = b as? Int
	    println("a = $a") // a = null
    }
**14、is 类型判断符 => 检查某个实例是否是某个类型，如果判断出属于某个类型，那么判断后的分支中可以直接可当该类型使用，无需显示转换**

    fun fun_is(obj: Any) {
	    if (obj is String && obj.length > 0) { //只在判断块中不需要强转
	       println("obj.length = ${obj.length}")
	    }
	    //println("out if obj.length = ${obj.length}") 需要强转
	    val str = obj as? String
	    println("out if str.length = ${str?.length}")
    }
**15、""" 多行输入符**

    fun fun_three_quot() {
	    val str = """one
	            two
	            three"""
	    println(str)
	    var str1 = "one\ntwo\nthree"
	    println("str == str1 ${str == str1}") // 两者不一定会相等，只要第二行或第三行不是换行开头输入都不相等（开头有空格就跟str1字符串不一致）
    }
**16、$操作符**

    fun fun_dollar() {
	    val dollar = 19.99F
	    val str = "If the price is ${dollar} ${'$'}, I have left ${100 - dollar} $"
	    println(str) //If the price is 19.99 $, I have left 80.01 $
    }

    //如果想要在原生字符串中使用$（它不支持反斜杠转义），可以使用以下语法：
    val str = """19.99${'$'}""" //19.99$

# 二、数组 #
[http://www.cnblogs.com/aqi00/p/7130599.html](http://www.cnblogs.com/aqi00/p/7130599.html)
[http://blog.csdn.net/mrseasons/article/details/46723819](http://blog.csdn.net/mrseasons/article/details/46723819)

**Array<T>构造函数：public inline constructor(size: Int, init: (Int) -> T)**<br>


    val ascZero = Array(5, {it * it}) // 函数块内可以用it指该对象，最后一行表示返回值
    val ascOne = Array(5, {i -> i * i}) //
    val asc = Array(5,{ println(it) //命名函数自动定义标签
         return@Array it * it // 所以指定return@Array 不能直接return
    })


    Java声明数组
    	int[] intArr = new int[] {1, 2};
    	String[] strArr = new String[] {"1", "2"};
    Kotlin声明数组
		var intArr = intArrayOf(1, 2)
		var intArr: Array<Int> = arrayOf(1, 2)
		var strArr: Array<String> = arrayOf("1", "2")

    fun testArr() {
    	val intArr = intArrayOf(1, 2)
    	val strArr = arrayOf("1", "2")
    	println("intArr.size = ${intArr.size}")
    	println("strArr[1] = ${strArr[1]}")
    	// 数组可以使用get, set方式
    	println(strArr.get(1))
    	println(strArr.set(1, "3"))
    	println("========== print strArr ============")
    	for (str in strArr) {
        	println(str)
    	}
    
    	println("========== print strArr.indices ============")
    	// 遍历数组下标
    	for (index in strArr.indices) {
        	println("index = $index, strArr[$index] = ${strArr[index]}")
    	}

    	// 创建数组
    	// 指定数组长度
    	val fixedSizeArray = kotlin.arrayOfNulls<Int>(5)
    	//使用闭包初始化
    	val asc = Array(5,{i -> i * i})
    	println("========== print 闭包 ============")
    	for(i in asc) {
        	println(i)
    	}

    	// 空数组
    	val emptyArr = emptyArray<Int>()
    	println("emptyArr.size = ${emptyArr?.size}")
    }

# Standart函数 #
[http://www.cnblogs.com/duduhuo/p/6934137.html](http://www.cnblogs.com/duduhuo/p/6934137.html)
>**run 、 apply 、 let 、 also 、with 、repeat、takeIf和takeUnless**<br>
>**T.() => {块中用this}**<br>
>**(T) => {用it表示参数T}**<br>
>
>**1、run => 如果无return@run R时，则返回值为函数块的最后一行**


    // fun <R> run(block: () -> R): R = block()
    // fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()
    fun fun_run() {
        //无返回值
	    run {
	        println("lambda")
	    }	
        //有返回值
		//方式1 
	    var i: Int = run{1}
		//方式2
	    i = run({1})
		//方式3
	    i = run {
	        return@run 1
	    }

	    println(i) // "lambda \n 1"	
		//方式4
	    i = run(outer@ {
	        return@outer 2
	    })
	    println(i)

	    i = "aaa".run {
	        println(this)
	        2
	    }
	    println(i) // "aaa \n 2"
    }
>**2、apply**


    fun fun_apply() {
	    //public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }
	    val a = 1.apply {
	        println(this)
	    }

	    println(a) // 1 \n 1
    }
>**3、with**


    fun fun_with() {
	    //public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()
	    val a = with("aaa"){
	        println(this)
	        2
	    }

	    println(a) // aaa \n 2
    }
>**4、let**


    fun fun_let() {
	    // fun <T, R> T.let(block: (T) -> R): R = block(this)
	    val a = "aaa".let {
	        println(it)
	        "demo"
	    }

	    println(a) // aaa \n demo

	    val b = "bbb".let{
	        println(it)
	        return@let "demo"
	    }
    }

>**5、repeat**
>
    fun fun_repeat() {
	    //fun repeat(times: Int, action: (Int) -> Unit)
	    repeat(3){
	        println(it) // 0 \n 1 \n 2
	    }
    }