package ObjectsAndClasses.more_exercise.teamwork_project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("-");
            String creator = input[0];
            String teamName = input[1];
            boolean isFoundTeam = false;
            boolean isATeamCreator = false;

            if (!teams.isEmpty()) {
                for (Team item : teams) {
                    if (item.getName().equals(teamName)) {
                        isFoundTeam = true;
                        System.out.printf("Team %s was already created!%n", teamName);
                        break;
                    }
                }

                for (Team item : teams) {
                    if (item.getCreator().equals(creator)) {
                        isATeamCreator = true;
                        System.out.printf("%s cannot create another team!%n", creator);
                        break;
                    }
                }
            }

            if (teams.isEmpty() || !isFoundTeam) {
                if (!isATeamCreator) {
                    Team team = new Team(creator, teamName);
                    teams.add(team);
                    System.out.printf("Team %s has been created by %s!%n", team.getName(), creator);
                }
            }
        }

        String[] input = scanner.nextLine().split("->");
        String endCommand = "end of assignment";

        while (!input[0].equals(endCommand)) {
            String memberToJoin = input[0];
            String teamToJoin = input[1];
            boolean isCreator = false;
            boolean isMemberOfAnotherTeam = false;
            boolean isFoundTeam = false;
            Team teamToBeIn = new Team();

            for (Team team : teams) {
                if (team.getName().equals(teamToJoin)) {
                    teamToBeIn = team;
                    isFoundTeam = true;
                    break;
                }
            }

            if (!isFoundTeam) {
                System.out.printf("Team %s does not exist!%n", teamToJoin);
            } else {
                for (Team team : teams) {
                    if (memberToJoin.equals(team.getCreator())) {
                        System.out.printf("Member %s cannot join team %s!%n", memberToJoin, teamToJoin);
                        isCreator = true;
                        break;
                    }
                }

                if (!isCreator) {
                    for (Team team : teams) {
                        for (String memberOfTeam : team.getMembers()) {
                            if (memberToJoin.equals(memberOfTeam)) {
                                System.out.printf("Member %s cannot join team %s!%n", memberToJoin, teamToJoin);
                                isMemberOfAnotherTeam = true;
                                break;
                            }
                        }
                    }

                    if (!isMemberOfAnotherTeam) {
                        teamToBeIn.joinTeam(memberToJoin);
                    }
                }
            }

            input = scanner.nextLine().split("->");
        }

        teams.sort(Comparator.comparingInt(Team::size).reversed().thenComparing(Team::getName));
        List<Team> emptyTeams = new ArrayList<>();
        for (Team team : teams) {
            if (team.hasMembers()) {
                System.out.println(team.toString());
            } else {
                emptyTeams.add(team);
            }
        }

        emptyTeams.sort(Comparator.comparing(Team::getName));
        System.out.println("Teams to disband:");
        for (Team team : emptyTeams) {
            System.out.println(team.getName());
        }
    }
}
