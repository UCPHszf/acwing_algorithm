package Tree;

import CustomizeDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public void BFS(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                TreeNode t=q.poll();
                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);
            }
        }
    }
}
