package com.prj.util;

/**
 *  Linear Regression
 *  Demonstrate linear regression by constructing the regression line for a set
 *  of data points.
 *  require DataPoint.java,RegressionLine.java
 *  为了计算对于给定数据点的最小方差回线，需要计算SumX,SumY,SumXX,SumXY; (注：SumXX = Sum (X^2))
 *  回归直线方程如下： f(x)=a1x+a0
 *  斜率和截距的计算公式如下：
 *  n: 数据点个数
 *  a1=(n(SumXY)-SumX*SumY)/(n*SumXX-(SumX)^2)
 *  a0=(SumY - SumY * a1)/n
 *  (也可表达为a0=averageY-a1*averageX)
 *  画线的原理：两点成一直线，只要能确定两个点即可
 *  第一点：(0,a0) 再随意取一个x1值代入方程，取得y1，连结(0,a0)和(x1,y1)两点即可。
 *  为了让线穿过整个图,x1可以取横坐标的最大值Xmax，即两点为(0,a0),(Xmax,Y)。如果y=a1*Xmax+a0,y大于
 *  纵坐标最大值Ymax，则不用这个点。改用y取最大值Ymax，算得此时x的值，使用(X,Ymax)， 即两点为(0,a0),(X,Ymax)
 *  拟合度计算：(即Excel中的R^2)
 *  R2 = 1 - E
 *  误差E的计算：E = SSE/SST
 *  SSE=sum((Yi-Y)^2) SST=sumYY - (sumY*sumY)/n;
 * @创建人 Eric.Lu
 * @创建时间 2023/11/13
 * @地址 https://github.com/itdebug/
 * @描述
 */
public class LinearRegression {

	private static final int MAX_POINTS = 10;

	private double E;

	/**

	 * Main program.

	 *

	 * @param args

	 *            the array of runtime arguments

	 */

	public static void main(String args[])

	{

		RegressionLine line = new RegressionLine();

		/*line.addDataPoint(new DataPoint(20, 136));
		line.addDataPoint(new DataPoint(40, 143));
		line.addDataPoint(new DataPoint(60, 152));
		line.addDataPoint(new DataPoint(80, 162));
		line.addDataPoint(new DataPoint(100, 167));*/

		line.addDataPoint(new DataPoint(1, 10240));
		line.addDataPoint(new DataPoint(2, 15000));
		line.addDataPoint(new DataPoint(3, 18000));
		printSums(line);
		printLine(line);

	}

	/**

	 * Print the computed sums.

	 *

	 * @param line

	 *            the regression line

	 */

	private static void printSums(RegressionLine line)

	{

		System.out.println("\n数据点个数 n = " + line.getDataPointCount());

		System.out.println("\nSum x  = " + line.getSumX());

		System.out.println("Sum y  = " + line.getSumY());

		System.out.println("Sum xx = " + line.getSumXX());

		System.out.println("Sum xy = " + line.getSumXY());

		System.out.println("Sum yy = " + line.getSumYY());

	}

	/**

	 * Print the regression line function.

	 *

	 * @param line

	 *            the regression line

	 */

	private static void printLine(RegressionLine line)

	{

		System.out.println("\n回归线公式:  y = " +

				line.getA1() +

				"x + " + line.getA0());

		System.out.println("拟合度：     R^2 = " + line.getR());
		System.out.println(line.getA1() * 4 + line.getA0());
		System.out.println(line.getA1() * 1 + line.getA0());
		System.out.println(line.getA1() * 2 + line.getA0());
		System.out.println(line.getA1() * 3 + line.getA0());

	}
}
