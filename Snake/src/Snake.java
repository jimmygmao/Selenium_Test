import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Snake {
	private Node head = null;// 头
	private Node tail;// 尾巴
	private int size = 0;// 长度
	private Node n=new Node(20,20,Dir.L);
	public Snake(){
		head=n;
		tail=n;
		size=1;
	}
	
	public void addToTail(){
		Node node=null;
		switch (tail.dir) {
		case L:
			node =new Node(tail.row,tail.col+1,tail.dir);
			break;
		case U:
			node =new Node(tail.row+1,tail.col,tail.dir);
			break;
		case R:
			node =new Node(tail.row,tail.col-1,tail.dir);
			break;
		case D:
			node =new Node(tail.row-1,tail.col,tail.dir);
			break;
		}
		tail.next=node;
		node.prev=tail;
		tail=node;
		size++;
	}
	
	public void addToHead(){
		Node node=null;
		switch (head.dir) {
		case L:
			node =new Node(head.row,head.col-1,head.dir);
			break;
		case U:
			node =new Node(head.row-1,head.col,head.dir);
			break;
		case R:
			node =new Node(head.row,head.col+1,head.dir);
			break;
		case D:
			node =new Node(head.row+1,head.col,head.dir);
			break;
		}
		node.next=head;
		head.prev=node;
		head=node;
		size++;
	}
	public void draw(Graphics g){
		if(size<=0){
			return;
		}
		for(Node n=head;n!=null;n=n.next){
			n.draw(g);
		}
		move();
	}
	private void move(){
		 addToHead();
		 deleteFromTail();
	}
	private void deleteFromTail(){
		if(size==0){
			return;
		}
		tail=tail.prev;
		tail.next=null;
		
	}
	
	public Rectangle getRevt(){
		return new Rectangle(Yard.CELL * head.col, Yard.CELL * head.row, head.w,head.h);	
	}
	
	public void eat(Egg e){
		if(this.getRevt().intersects(e.getRevt())){
			e.reAppear();
			this.addToHead();
		}
	}
	
	private class Node {
		int w = Yard.CELL;
		int h = Yard.CELL;
		int row;// 第几行
		int col;// 第几列
		Dir dir =Dir.L;
		Node prev=null;
		Node next=null;

		Node(int x, int y, Dir dir) {
			this.row = x;
			this.col = y;
			this.dir = dir;
		}

		private void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(Yard.CELL * col, Yard.CELL * row, w, h);
			g.setColor(c);
		}
	}
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			head.dir=Dir.L;
			break;
		case KeyEvent.VK_UP:
			head.dir=Dir.U;
			break;
		case KeyEvent.VK_RIGHT:
			head.dir=Dir.R;
			break;
		case KeyEvent.VK_DOWN:
			head.dir=Dir.D;
			break;
		}
	}
}
