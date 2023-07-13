package leetcode.day13;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;

public class p797 {
    class Solution {
        //0==>4
        int target;
        List<List<Integer>> ans;
        List<Integer> path;
        int[][] graph;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            this.graph = graph;
            ans = new ArrayList<>();
            target = graph.length - 1;
            path = new ArrayList<>();
            path.add(0);
            dfs(0, path);
            return ans;
        }

        public void dfs(int now, List<Integer> path) {
            if (now == target) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < graph[now].length; i++) {
                path.add(graph[now][i]);
                dfs(graph[now][i], path);
                path.remove(path.size() - 1);
            }

        }
    }
}
