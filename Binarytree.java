import java.io.*;
import java.util.*;
public class Main{
    public static class Node{
        int data;
        Node left;
        Node right;
        
        Node(){
            
        }
        Node(int data){
            this.data = data;
        }
    }
    public static class Pair{
        int state;
        Node node;
        
        Pair(){
            
        }
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
        
    }
  public static void main(String[]args){
      Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
    Node root = new Node(arr[0]);
    Stack<Pair> st = new Stack<>();
    Pair rtp = new Pair(root,1);
    st.push(rtp);
    
    int idx = 0;
    while(st.size()>0 ){
        Pair top = st.peek();
        if(top.state == 1){
            idx++;
            if(arr[idx] != null){
                Node ln = new Node(arr[idx]);
                top.node.left = ln;
                Pair lp = new Pair(ln,1);
                st.push(lp);
            }
            top.state++;
        }
        else if(top.state == 2){
            idx++;
            if(arr[idx] != null){
                Node rn = new Node(arr[idx]);
                top.node.right = rn;
                Pair rp = new Pair(rn,1);
                st.push(rp);
            }
            top.state++;
        }
        else{
            st.pop();
        }
        
    }
    display(root);
    
     
  }
  public static void display(Node node){
      if(node == null) return;
      String str = "";
      str+= node.left == null?".":node.left.data;
      str+="<-"+ node.data+ "->";
      str+= node.right== null ? "." : node.right.data;
      System.out.println(str);
      
      display(node.left);
      display(node.right);
      
  }
    
}

