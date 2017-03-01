package nov03;

public class MyArrayStack<E> {
	public static final int block = 20;
	E[] mystack = (E[]) (new Object[block]);
	int top = 0;
	
	MyArrayStack(){}
	MyArrayStack(E[] objects) {
		for(E e: objects)
			push(e);
	}
	
	int push (E e) {
		//check not full
		mystack[top] = e;
		top++;
		return top;
	}
	
	E pop() {
		if (isEmptyStack()){
			return null;
		}
		E e = mystack[top];
		mystack[top] = null;
		top--;
		return e;
		
	}
	
	E peek () {
		if (isEmptyStack()){
			return null;
		}
		E e = mystack[top];
		mystack[top] = null;
		return e;
	
	}
	
	boolean isEmptyStack() {
		if (top <= 0) return true;
		else return false;
	}
	
	
	
}
