package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;


    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String user) {
        String name = user.toLowerCase();
        switch (name) {
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "ann":
                return annsTasks;
            case "all":
                return getUnion(annsTasks, getUnion(bobsTasks, carolsTasks));
            default:
                return Set.of(); // Boş bir set döndür
        }
    }

    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        Set<Task> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }



    public Set<TaskData> getDifferences(Set<Task> taskSet, Set<Task> taskSet2) {
        Set<TaskData> taskSetCopy = new HashSet<>();

        for (Task task : taskSet2) {
            for (TaskData taskData : taskSetCopy) {

                taskData.getAnnsTasks().remove(task);

                taskData.getBobsTasks().remove(task);

                taskData.getCarolsTasks().remove(task);

                taskData.getUnassignedTasks().remove(task);
            }
        }

        return taskSetCopy;
    }













}


