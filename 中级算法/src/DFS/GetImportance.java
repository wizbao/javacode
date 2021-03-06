package DFS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 员工的重要性
 * @create: 2020-11-22-19:06
 * @author: Hey
 */
public class GetImportance {
    Map<Integer,Employee> emap;
    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for (Employee e : employees) {
            emap.put(e.id,e);
        }
        return dfs(id);
    }

    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid : employee.subordinates) {
            ans+=dfs(subid);
        }
        return ans;
    }
}
class Employee{
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
