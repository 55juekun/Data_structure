package data_structure;

/**simpleList.java
 * @author 55珏坤
 *simpleList下午7:21:56
 *简单的单向链表
 *已包含：前后插入，前后删除，节点定位，指定节点删除，链表为空，链表长度
 */
public class simpleList {
	
	/**
	 * 定义链表结构
	 */
	private class Data {
		private Object obj;
		private Data next=null;
		Data(Object obj){
			this.obj=obj;
		}
	}
	
	/**
	 * first就相当于头结点
	 */
	private Data first=new Data("");
	
	/**
	 * 使用前插法插入节点，即逆序插入
	 */
	public void insertFirst(Object obj) {
		Data data=new Data(obj);
		data.next=first.next;
		first.next=data;
	}
	
	/**
	 * 使用后插法插入节点，即顺序插入
	 */
	public void insertLast(Object obj) {
		Data data=new Data(obj);
		Data temp=first;
		while (temp.next!=null) {
			temp=temp.next;
		}
		temp.next=data;
	}
	
	/**
	 * 删除第一个节点并将该节点值返回
	 */
	public Object deleteFirst() throws Exception {
		if (first.next==null)
			throw new Exception("当前链表已经为空啦!");
		Data temp=first.next;
		first.next=first.next.next;
		return temp.obj;
	}

	/**
	 * 删除最后一个节点并将该节点值返回
	 */
	public Object deleteLast() throws Exception {
		if (first.next==null)
			throw new Exception("当前链表已经为空啦!");
		Data temp=first;
		while (temp.next.next!=null) {
			temp=temp.next;
		}//没有释放内存，需要的自己改
		Data returnData=temp.next;
		temp.next=null;
		return returnData.obj;
	}
	
	/**
	 * 找到该节点位于链表的第几个位置,从0开始计算,-1表示没找到
	 */
	public int find(Object obj) throws Exception {
		int position=0;
		Data temp=first;
		while (temp.next!=null) {
			if (temp.next.obj.equals(obj))
				return position;
			temp=temp.next;
			position++;
		}
		return -1;
	}
	
	/**
	 * 找到该节点对应的第一个节点并删除该节点，若链表中无该节点则抛出异常
	 */
	public void delete(Object obj) throws Exception{
		Data temp=first;
		while (temp.next!=null) {
			if (temp.next.obj.equals(obj)) {
				temp.next=temp.next.next;
				return ;
			}
			temp=temp.next;
		}
		temp=first;
		while (temp.next!=null) {
			if (temp.next.obj.toString().equals(obj.toString())) {
				temp.next=temp.next.next;
				throw new Exception("可以找到对应的值，但是类型不对应，已删除该对应值");
			}
			temp=temp.next;
		}
		throw new Exception("未找到该节点！");
	}
	
	/**
	 * 找到该节点对应的所有节点并删除对应所有节点，若链表中无该节点则抛出异常，必须类型也相同
	 */
	public int deleteAll(Object obj) throws Exception{
		Data temp=first;
		int deleteCount=0;
		while (temp.next!=null) {
			if (temp.next.obj.equals(obj)) {
				temp.next=temp.next.next;
				deleteCount++;
			}
			temp=temp.next;
		}
		if (deleteCount!=0) {
			return deleteCount;
		}
		throw new Exception("未找到该节点！");
	}
	
	/**
	 * 链表逆序
	 */
	public void reverseSort(){
		Data tempData=null;
		Data pData=first.next,qData=pData;
		while (qData!=null) {
			pData=qData;
			qData=qData.next;
			first.next=pData;
			pData.next=tempData;
			tempData=pData;
		}
	}
	
	/**
	 * 判断链表是否为空链表
	 */
	public boolean isEmpty() {
		return first.next==null;
	}
	
	/**
	 * 返回链表的长度
	 */
	public int length() {
		Data temp=first;
		int count=0;
		while (temp.next!=null) {
			temp=temp.next;
			count++;
		}
		return count;
	}
	
	/**
	 * 顺序打印出链表
	 */
	public void show() {
		Data temp=first.next;
		if (temp==null) {
			System.out.println();
			return ;
		}
		while (temp.next!=null) {
			System.out.print(temp.obj.toString()+" -> ");
			temp=temp.next;
		}
		System.out.println(temp.obj.toString());
	}
	
	public static void main(String[] args){
		simpleList list=new simpleList();
		for (int i = 10; i <=20; i++) {
			Object object=new Integer(i);
			list.insertFirst(object);
		}
		list.reverseSort();
		list.show();
	}
}
