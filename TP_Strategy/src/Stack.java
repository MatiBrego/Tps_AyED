public class Stack {
    private int top;
    private int [] stack = new int [3];

    public Stack()
    {	top =-1;
    }

    public void pop()
    {	top--;
    }

    public void push(int x)
    {	top++;
        stack[top]=x;
    }

    public boolean isEmpty()
    {	if (top ==-1)
        return true;
    else
        return false;
    }

    public int peek()
    {	if (!isEmpty())
    {	int a = stack[top];
        return a;
    }
    else
        return -99;
    }
}

