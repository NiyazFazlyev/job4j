package ru.job4j.sort;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;


public class Department {
    private Set<String> departments = new TreeSet<>();

    public Department(String[] departments) {
        this.departments.addAll(Arrays.asList(departments));
    }

    public Department() {
    }

    public void addDepartment(String dep) {
        this.departments.add(dep);
    }

    public Set<String> sortDepartments() {
        Set<String> deps = new TreeSet<>(this.departments);
        for (String department : this.departments) {
            this.addMissingDepartment(deps, department);
        }
        return deps;
    }

    public Set<String> reverseSortDepartments() {
        Set<String> deps = new TreeSet<>(
                ((left, right) ->
                {
                    int length = left.length() < right.length() ? left.length() : right.length();
                    int rsl = 0;
                    for (int index = 0; index != length; index++) {
                        rsl = Integer.compare(right.charAt(index), left.charAt(index));
                        if (rsl != 0) {
                            break;
                        }
                    }
                    return rsl != 0 ? rsl : Integer.compare(left.length(), right.length());
                }
                )
        );
        deps.addAll(this.departments);
        for (
                String department : this.departments) {
            this.addMissingDepartment(deps, department);
        }
        return deps;
    }

    private void addMissingDepartment(Set<String> departments, String department) {
        String str = department;
        int lastIndex = 0;
        while (str.contains("/")) {
            int index = str.indexOf("/");
            departments.add(department.substring(0, lastIndex + index));
            lastIndex = lastIndex + index + 1;
            str = str.substring(index + 1);
        }
    }
}
