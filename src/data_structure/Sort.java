package data_structure;

import java.util.ArrayList;

public class Sort {
	
	/**
	 * 简单的冒泡排序算法，当int数组输入时可以转换一下而不丢失数据
	 */
	public void swap(float[]array,int i,int j) {
		float temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	public float[] bubbleSort(float[] array) {
		for (int i = 1; i < array.length; i++) {
			boolean breakFlag=true;//设置一个标示位用于确定是否已经排序完成
			for (int j = 0; j < array.length-i; j++) {
				if(array[j]>array[j+1]){
					swap(array, j, j+1);
					breakFlag=false;
				}
			}
			if (breakFlag) {
				break;
			}
		}
		return array;
	}
	
	/**
	 * 简单的选择排序算法
	 */
	public float[] selectSort(float[] array) {
		for (int i = 0; i < array.length-1; i++) {
			float min=array[i];int pos=i;
			for (int j = i+1; j < array.length; j++) {
				if (array[j]<min){
					min=array[j];
					pos=j;
				}
			}
			swap(array, pos, i);
		}
		return array;
	}
	
	/**
	 * 直接插入排序算法
	 */
	public float[] straightInsertionSort(float[] array) {
		float temp;int j;
		for (int i = 1; i < array.length; i++) {
			if (array[i]<array[i-1]) {
				temp=array[i];
				/*
				 * j>=0&&temp<array[j]  这一句代码，如果j>=0写在后面就会报错
				 * 错误原因：程序会先判断temp<array[j]是否为真，此时array[j]不存在报错
				 */
				for (j = i-1;j>=0&&temp<array[j]; j--) {
					array[j+1]=array[j];
				}
				array[j+1]=temp;
			}
		}
		return array;
	}
	
	/**
	 * 希尔排序算法
	 */
	public float[] shellSort(float[] array) {
		int gap=array.length/2;
		while (gap>=1) {
			for (int i = 0; i <gap; i++) {
				int j=i;
				while(j+gap<array.length && array[j]>array[j+gap]){
					swap(array, j, j+gap);
					j+=gap;
				}
			}
			gap/=2;
		}
		return array;
	}

	/**
	 * 快速排序
	 * @param low 指的是数组第一个数的位置，即0
	 * @param high 指的是数组最后一个数的位置，即length-1
	 */
	public float[] qiuckSort(float[] array,int low,int high) {
		float temp=array[low];
		int i=low,j=high;
		while (i<j) {
			while (i<j&&array[j]>=temp) 
				j--;
				array[i]=array[j];
				array[j]=temp;
			while (i<j&&array[i]<=temp) 
				i++;
				array[j]=array[i];
				array[i]=temp;
		}
		if (low<i)
			qiuckSort(array, low, i-1);
		if (i+1<high)
			qiuckSort(array, i+1, high);
		return array;
	}

	/**
	 * 堆排序
	 * 按照树根序号为0排序
	 */
	public float[] heapSort(float[] array) {
		int high=array.length-1;float temp;
		while (high>0) {
			int last=high;
			while (last-1>=0) {
				if (last%2!=0) {//奇数情况下
					if (array[last]>array[last/2]) {
						swap(array, last, last/2);
					}
					last--;
				}
				else {//父节点只要小于子节点中的一个即成立
					if (array[last]>array[last/2-1]||array[last-1]>array[last/2-1]) {
						temp=array[last/2-1];
						array[last/2-1]=Math.max(array[last], array[last-1]);
						//确定子节点中最小值与父节点交换
						if (array[last]==array[last/2-1]) {
							array[last]=temp;
						}
						else {
							array[last-1]=temp;
						}
					}
					last-=2;
				}
			}
			swap(array, 0, high);
			high--;
		}

		return array;
	}
	

	/**
	 * 基数排序，默认将其输入为整数
	 */
	public int[] radixSort(int[] array) {
		ArrayList<Integer> arr0=new ArrayList<Integer>();
		ArrayList<Integer> arr1=new ArrayList<Integer>();
		ArrayList<Integer> arr2=new ArrayList<Integer>();
		ArrayList<Integer> arr3=new ArrayList<Integer>();
		ArrayList<Integer> arr4=new ArrayList<Integer>();
		ArrayList<Integer> arr5=new ArrayList<Integer>();
		ArrayList<Integer> arr6=new ArrayList<Integer>();
		ArrayList<Integer> arr7=new ArrayList<Integer>();
		ArrayList<Integer> arr8=new ArrayList<Integer>();
		ArrayList<Integer> arr9=new ArrayList<Integer>();
		ArrayList<Integer> finnalarr=new ArrayList<Integer>();
		
		int k=1,kmax=10;
		for (int i = 0; i < array.length; i++) {
			finnalarr.add(array[i]);
			while(array[i]/kmax>=1)
				kmax*=10;//确定倍数
			
		}
		for (; k <=kmax;k*=10) {
			for (Integer integer : finnalarr) {
				if(integer/k%10==0)
					arr0.add(integer);
				if(integer/k%10==1)
					arr1.add(integer);
				if(integer/k%10==2)
					arr2.add(integer);
				if(integer/k%10==3)
					arr3.add(integer);
				if(integer/k%10==4)
					arr4.add(integer);
				if(integer/k%10==5)
					arr5.add(integer);
				if(integer/k%10==6)
					arr6.add(integer);
				if(integer/k%10==7)
					arr7.add(integer);
				if(integer/k%10==8)
					arr8.add(integer);
				if(integer/k%10==9)
					arr9.add(integer);
			}
			finnalarr.clear();
			while (!arr0.isEmpty()){
				for (Integer integer : arr0)
					finnalarr.add(integer);
				arr0.clear();
			}
			while (!arr1.isEmpty()){
				for (Integer integer : arr1)
					finnalarr.add(integer);
				arr1.clear();
			}
			while (!arr2.isEmpty()){
				for (Integer integer : arr2)
					finnalarr.add(integer);
				arr2.clear();
			}
			while (!arr3.isEmpty()){
				for (Integer integer : arr3)
					finnalarr.add(integer);
				arr3.clear();
			}
			while (!arr4.isEmpty()){
				for (Integer integer : arr4)
					finnalarr.add(integer);
				arr4.clear();
			}
			while (!arr5.isEmpty()){
				for (Integer integer : arr5)
					finnalarr.add(integer);
				arr5.clear();
			}
			while (!arr6.isEmpty()){
				for (Integer integer : arr6)
					finnalarr.add(integer);
				arr6.clear();
			}
			while (!arr7.isEmpty()){
				for (Integer integer : arr7)
					finnalarr.add(integer);
				arr7.clear();
			}
			while (!arr8.isEmpty()){
				for (Integer integer : arr8)
					finnalarr.add(integer);
				arr8.clear();
			}
			while (!arr9.isEmpty()){
				for (Integer integer : arr9)
					finnalarr.add(integer);
				arr9.clear();
			}
		}
		int i=0;
		for (Integer integer : finnalarr) {
			array[i]=integer;
			i++;
		}
		return array;
	}
	
	/**
	 * 归并排序
	 */
	public float[] mergeSort(float[] array) {
		float[] arr1=new float[array.length/2];
		float[] arr2=new float[array.length-array.length/2];
		for (int i = 0; i < array.length; i++) {
			if (i<array.length/2)
				arr1[i]=array[i];
			else
				arr2[i-array.length/2]=array[i];
		}
		if (arr1.length>1||arr2.length>1){//使用递归更加方便
			return mergeToOne(mergeSort(arr1),mergeSort(arr2));
		}
		else 
			return mergeToOne(arr1,arr2);
	}
	
	/**
	 * 将两个有序数组合并为一个有序数组，主要用于归并排序
	 */
	public float[] mergeToOne(float[] array1,float[] array2) {
		float[] finalArray=new float[array1.length+array2.length];
		int i = 0,j=0;
		for (; i < array1.length&&j < array2.length;) {
			if (array1[i]>array2[j]) {
				finalArray[i+j]=array2[j];
				j++;
			}
			else{
				finalArray[i+j]=array1[i];
				i++;
			}
		}
		if (j== array2.length) {
			for (; i < array1.length; i++) {
				finalArray[i+j]=array1[i];
			}
		}
		else {
			for (; j < array2.length; j++) {
				finalArray[i+j]=array2[j];
			}
		}
		return finalArray;
	}
	
	/**
	 * 打印出数组元素
	 * @param array
	 */
	public void show(float[]array) {
		for (int i = 0; i < array.length-1; i++) {
			System.out.print(array[i]+"  ");
		}
		System.out.println(array[array.length-1]);
	}
	
	public void show(int[]array) {
		for (int i = 0; i < array.length-1; i++) {
			System.out.print(array[i]+"  ");
		}
		System.out.println(array[array.length-1]);
	}
	
	
	public static void main(String[] args) {
		float[] array={1.2f,3,1.1f,11.2f,0.5f,6.1f,1,2,3,5,6,7,10};
		new Sort().show(array);
		new Sort().bubbleSort(array);
		new Sort().show(array);
	}
}
