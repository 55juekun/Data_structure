package data_structure;

/**
 * 二叉排序树的一些相关操作
 * @author 55珏坤
 *
 */
public class BinaryTree {
	
	/**
	 * 定义二叉树
	 * @author 55珏坤
	 *
	 */
	private class BinTree {
		private int data;
		private BinTree leftChild=null;
		private BinTree rightChild=null;
		BinTree(int data){
			this.data=data;
		}
	}
	/**
	 * 相当于链表中的头结点，其左孩子作为根节点
	 */
	private BinTree base=new BinTree(0);
	
	/**
	 * 插入一个节点
	 * @param data
	 */
	public void insert(int data) {
		if (base.leftChild==null) {
			base.leftChild=new BinTree(data);
		}
		else {
			BinTree bTree=base.leftChild;
			while (true) {
				if (bTree.data>data){
					if (bTree.leftChild!=null)
						bTree=bTree.leftChild;
					else{
						bTree.leftChild=new BinTree(data);
						break;
					}
				}
				else {
					if (bTree.rightChild!=null)
						bTree=bTree.rightChild;
					else{
						bTree.rightChild=new BinTree(data);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * 删除指定的值，0代表删除后用左子树中的值替代，1代表用右子树中的值替代
	 */
	public boolean deleteNum(int data,int flag) {
		if (base.leftChild!=null) 
			return leftchildDelete(data,flag,base);
		else
			return false;
	}
	/*检查右孩子是否与对应值相等并删除*/
	private boolean leftchildDelete(int data,int flag,BinTree parents) {
		BinTree bTree=parents.leftChild;
		if (bTree.data==data) {
			if (bTree.leftChild==null) {
				parents.leftChild=bTree.rightChild;
				return true;
			}else if (bTree.rightChild==null) {
				parents.leftChild=bTree.leftChild;
				return true;
			}else {
				BinTree temp=bTree;
				if (flag==0) {
					parents=bTree;
					bTree=bTree.leftChild;
					if (bTree.rightChild==null) {
						temp.data=bTree.data;
						parents.leftChild=bTree.leftChild;
						return true;
					}
					while (bTree.rightChild!=null) {
						parents=bTree;
						bTree=bTree.rightChild;
					}
					temp.data=bTree.data;
					parents.rightChild=bTree.leftChild;
				}
				else {
					parents=bTree;
					bTree=bTree.rightChild;
					if (bTree.leftChild==null) {
						temp.data=bTree.data;
						parents.rightChild=bTree.rightChild;
						return true;
					}
					while (bTree.leftChild!=null) {
						parents=bTree;
						bTree=bTree.leftChild;
					}
					temp.data=bTree.data;
					parents.leftChild=bTree.rightChild;
				}
				return true;
			}
		}
		else if (bTree.data>data) {
			if (bTree.leftChild!=null) 
				return leftchildDelete(data,flag,bTree);
			else
				return false;
		}
		else {
			if (bTree.rightChild!=null) 
				return rightchildDelete(data,flag,bTree);
			else
				return false;
		}
	}
	/*检查右孩子是否与对应值相等并删除*/
	private boolean rightchildDelete(int data,int flag,BinTree parents) {
		BinTree bTree=parents.rightChild;
		if (bTree.data==data) {
			if (bTree.leftChild==null) {
				parents.rightChild=bTree.rightChild;
				return true;
			}else if (bTree.rightChild==null) {
				parents.rightChild=bTree.leftChild;
				return true;
			}else {
				BinTree temp=bTree;
				if (flag==0) {
					parents=bTree;
					bTree=bTree.leftChild;
					if (bTree.rightChild==null) {
						temp.data=bTree.data;
						parents.leftChild=bTree.leftChild;
						return true;
					}
					while (bTree.rightChild!=null) {
						parents=bTree;
						bTree=bTree.rightChild;
					}
					temp.data=bTree.data;
					parents.rightChild=bTree.leftChild;
				}
				else {
					parents=bTree;
					bTree=bTree.rightChild;
					if (bTree.leftChild==null) {
						temp.data=bTree.data;
						parents.rightChild=bTree.rightChild;
						return true;
					}
					while (bTree.leftChild!=null) {
						parents=bTree;
						bTree=bTree.leftChild;
					}
					temp.data=bTree.data;
					parents.leftChild=bTree.rightChild;
				}
				return true;
			}
		}
		else if (bTree.data>data) {
			if (bTree.leftChild!=null) 
				return leftchildDelete(data,flag,bTree);
			else
				return false;
		}
		else {
			if (bTree.rightChild!=null) 
				return rightchildDelete(data,flag,bTree);
			else
				return false;
		}
	}
	
	/**
	 * 查找特定的值是否存在
	 */
	public boolean findNum(int data) {
		if (base.leftChild==null) {
			return false;
		}
		else {
			System.out.print("查找开始:查找根节点-->");
			return find(base.leftChild, data);
		}
	}
	private boolean find(BinTree bTree,int data) {
		if (bTree==null) {
			System.out.println("节点查找失败，查找结束");
			return false;
		}
		if (bTree.data==data) {
			System.out.println("节点查找成功，查找结束");
			return true;
		}
		if (bTree.data>data) {
			System.out.print("查找左孩子-->");
			return find(bTree.leftChild, data);
		}
		else{
			System.out.print("查找右孩子-->");
			return find(bTree.rightChild, data);
		}
	}
	
	/**
	 * 中序打印出各个节点，即从小到大打印
	 * @throws Exception 
	 */
	public void show() throws Exception {
		if (base.leftChild==null)
			throw new Exception("当前二叉树为空");
		else {
			printit(base.leftChild);
		}
		
	}
	private void printit(BinTree bTree) {
		if (bTree.leftChild!=null) {
			printit(bTree.leftChild);
		}
		System.out.print(bTree.data+" -> ");
		if (bTree.rightChild!=null) {
			printit(bTree.rightChild);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BinaryTree binaryTree=new BinaryTree();
		binaryTree.insert(21);
		binaryTree.insert(2);
		binaryTree.insert(23);
		binaryTree.insert(12);
		binaryTree.insert(13);
		binaryTree.insert(29);
		binaryTree.insert(7);
		binaryTree.insert(70);
		binaryTree.insert(14);
		System.out.println(binaryTree.deleteNum(21, 1));
		binaryTree.findNum(14);
		binaryTree.show();
	}

}
