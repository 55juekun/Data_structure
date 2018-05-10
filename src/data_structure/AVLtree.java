package data_structure;

public class AVLtree {
	
	public final int leftHigher=1;
	public final int sameHeight=0;
	public final int rightHigher=-1;
	
	private class BinTree {
		private int data;
		private int bf;
		private BinTree leftChild=null;
		private BinTree rightChild=null;
		
		BinTree(int data){
			this.data=data;
		}
	}
	BinTree xBinTree=new BinTree(0);
	/**
	 * 右旋
	 * @param bt
	 * @return
	 */
	public BinTree rRotate(BinTree bt){
		BinTree leftBinTree;
		leftBinTree=bt.leftChild;
		bt.leftChild=leftBinTree.rightChild;
		leftBinTree.rightChild=bt;
		bt=leftBinTree;
		return bt;
	}
	
	/**
	 * 左旋
	 * @param bt
	 * @return
	 */
	public BinTree lRotate(BinTree bt){
		BinTree rightBinTree=bt.rightChild;
		bt.rightChild=rightBinTree.leftChild;
		rightBinTree.leftChild=bt;
		bt=rightBinTree;
		return bt;
	}
	
	public BinTree temp;

	/**
	 * 对左子树处理
	 * @param bt
	 * @return
	 */
	public BinTree leftBlance(BinTree bt){
		BinTree leftright,left=bt.leftChild;
		switch (left.bf) {
		case leftHigher:
			bt.bf=left.bf=sameHeight;
			bt=rRotate(bt);
			break;
		case rightHigher:
			leftright=left.rightChild;
			switch (leftright.bf) {
			case leftHigher:
				bt.bf=leftHigher;
				left.bf=sameHeight;
				break;
			case sameHeight:
				bt.bf=left.bf=sameHeight;
				break;
			case rightHigher:
				bt.bf=sameHeight;
				left.bf=leftHigher;
				break;
			}
			leftright.bf=sameHeight;
			temp=lRotate(bt.leftChild);
			rRotate(temp);
			bt=temp;
			break;
		}
		return bt;
	}
	
	/**
	 * 对右子树处理
	 * @param bt
	 * @return
	 */
	public BinTree rightBlance(BinTree bt){
		BinTree rightleft,right=bt.rightChild;
		switch (right.bf) {
		case rightHigher:
			bt.bf=right.bf=sameHeight;
			bt=lRotate(bt);
			break;
		case leftHigher:
			rightleft=right.leftChild;
			switch (rightleft.bf) {
			case rightHigher:
				bt.bf=rightHigher;
				right.bf=sameHeight;
				break;
			case sameHeight:
				bt.bf=right.bf=sameHeight;
				break;
			case leftHigher:
				bt.bf=sameHeight;
				right.bf=rightHigher;
				break;
			}
			rightleft.bf=sameHeight;
			temp=rRotate(bt.rightChild);
			lRotate(temp);
			bt=temp;
			break;
		}
		return bt;
	}
	
	/**
	 * 插入AVL树
	 */
	public boolean taller=false;
	public BinTree insertAVL(BinTree bt, int data){
		if (bt==null) {
			bt=new BinTree(data);
			bt.bf=sameHeight;
			taller=true;
		}else {
			if (bt.data==data) {
				taller=false;
				return bt;
			}else if (data<bt.data) {
				BinTree lchild=insertAVL(bt.leftChild, data);
				bt.leftChild=lchild;
				if (!taller)
					return bt;
				else {
					switch (bt.bf) {
					case leftHigher:
						temp=leftBlance(bt);
						bt=temp;
						taller=false;
						break;
					case sameHeight:
						taller=true;
						bt.bf=leftHigher;
						break;
					case rightHigher:
						bt.bf=sameHeight;
						taller=false;
						break;
					}
				}
			}else {
				BinTree rchild=insertAVL(bt.rightChild, data);
				bt.rightChild=rchild;
				if (!taller)
					return bt;
				else {
					switch (bt.bf) {
					case leftHigher:
						bt.bf=sameHeight;
						taller=false;
						break;
					case sameHeight:
						taller=true;
						bt.bf=rightHigher;
						break;
					case rightHigher:
						temp=rightBlance(bt);
						bt=temp;
						taller=false;
						break;
					}
				}
			}
		}
		return bt;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 4, 5, 6, 7, 10, 9, 8 }; 
		BinTree t =null;
		AVLtree avLtree=new AVLtree();
		for (int i = 0; i < a.length; i++) { 
		  t = avLtree.insertAVL(t, a[i]);
		}
	}

}
