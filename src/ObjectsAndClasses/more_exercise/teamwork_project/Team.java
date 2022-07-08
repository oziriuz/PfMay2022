package ObjectsAndClasses.more_exercise.teamwork_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String creator;
    private String name;
    private List<String> members = new ArrayList<>();

    public Team(String creator, String name) {
        this.creator = creator;
        this.name = name;
    }

    public Team() {
    }

    public String getCreator() {
        return creator;
    }

    public String getName() {
        return name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void joinTeam(String personToJoin){
        this.members.add(personToJoin);
    }

    public boolean hasMembers() {
        return !this.members.isEmpty();
    }

    public int size() {
        return this.members.size();
    }

    @Override
    public String toString(){
        return String.format("%s%n" +
                             "- %s%n" +
                             "%s",
                this.name,
                this.creator,
                this.sortedMembersListToString());
    }
    
    public String sortedMembersListToString() {
        String result = "";
        Collections.sort(members);
        for (String member : members) {
            result = result + String.format("-- %s%n", member);
        }
        return result.trim();
    }
}
