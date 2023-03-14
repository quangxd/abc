import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start!");
        List<Organization> list = new ArrayList<>();
        Organization o1 = new Organization(1L, null, new ArrayList<>());
        Organization o2 = new Organization(2L, 1L, new ArrayList<>());
        Organization o3 = new Organization(3L, 2l, new ArrayList<>());
        Organization o4 = new Organization(4L, 3L, new ArrayList<>());


        list = Arrays.asList(o1,o2,o3,o4);

        Map<String, List<Organization>> groupByFather = list.stream().collect(
                Collectors.groupingBy(
                        e -> {
                            if(null == e.getParentId()) {
                                return "0L";
                            } else {
                                return e.getParentId().toString();
                            }
                        }
                )
        );
        List<Organization> resList = new ArrayList<>();
        Organization base = groupByFather.get("2").get(0);
        List<Organization> listBase = groupByFather.get("2");
        List<Organization> res = new ArrayList<>();
        for (Organization o:listBase) {
             res.addAll(execution.treeHandler(o, groupByFather, resList));
        }


        System.out.println("End!");
    }
}

class execution {
    public static List<Organization> treeHandler(Organization base, Map<String, List<Organization>> groupByFather, List<Organization> resList) {

        List<Organization> childList = groupByFather.get(base.getId().toString());
        if(null == childList) {
            childList = new ArrayList<>();
        }
         if(childList.isEmpty()) {
             resList.addAll(childList);
             return resList;
         } else {
             resList.addAll(childList);
         }

        for (Organization o:childList) {
            treeHandler(o, groupByFather, resList);
        }
        return resList;
    }
}