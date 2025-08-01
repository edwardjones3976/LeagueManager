import dao.TeamDAO;
import dao.PlayerDAO;
import dao.CoachDAO;
import model.Team;
import model.Player;
import model.Coach;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TeamDAO teamDAO = new TeamDAO();
        PlayerDAO playerDAO = new PlayerDAO();
        CoachDAO coachDAO = new CoachDAO();
        Scanner scanner = new Scanner(System.in);

        try {
            boolean running = true;
            while (running) {
                System.out.println("\nLeague Manager");
                System.out.println("Options:");
                System.out.println("1. Manage Teams");
                System.out.println("2. Manage Players");
                System.out.println("3. Manage Coaches");
                System.out.println("4. View All Records");
                System.out.println("0. Exit");
                System.out.print("Enter option: ");
                int mainOption = scanner.nextInt();
                scanner.nextLine();

                switch (mainOption) {
                    case 1:
                        manageTeams(scanner, teamDAO);
                        break;
                    case 2:
                        managePlayers(scanner, playerDAO);
                        break;
                    case 3:
                        manageCoaches(scanner, coachDAO);
                        break;
                    case 4:
                        viewAllRecords(teamDAO, playerDAO, coachDAO);
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void manageTeams(Scanner scanner, TeamDAO dao) throws Exception {
        boolean back = false;
        while (!back) {
            System.out.println("\nManage Teams:");
            System.out.println("1. Add Team");
            System.out.println("2. View Teams");
            System.out.println("3. Edit Team");
            System.out.println("4. Delete Team");
            System.out.println("0. Back");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Team Number: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Team Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Team City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter Manager Name: ");
                    String manager = scanner.nextLine();
                    dao.addTeam(new Team(id, name, city, manager));
                    System.out.println("Team added.");
                    break;
                case 2:
                    for (Team team : dao.getAllTeams()) {
                        System.out.println(team.getTeamNumber() + " | " + team.getName() + " | " + team.getCity() + " | " + team.getManagerName());
                    }
                    break;
                case 3:
                    System.out.print("Enter Team Number to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("New City: ");
                    String newCity = scanner.nextLine();
                    System.out.print("New Manager: ");
                    String newMgr = scanner.nextLine();
                    dao.updateTeam(new Team(editId, newName, newCity, newMgr));
                    System.out.println("Team updated.");
                    break;
                case 4:
                    System.out.print("Enter Team Number to delete: ");
                    int delId = scanner.nextInt();
                    scanner.nextLine();
                    dao.deleteTeam(delId);
                    System.out.println("Team deleted.");
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void managePlayers(Scanner scanner, PlayerDAO dao) throws Exception {
        boolean back = false;
        while (!back) {
            System.out.println("\nManage Players:");
            System.out.println("1. Add Player");
            System.out.println("2. View Players");
            System.out.println("3. Edit Player");
            System.out.println("4. Delete Player");
            System.out.println("0. Back");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter League Wide Number: ");
                    int lwn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    dao.addPlayer(new Player(0, lwn, name, age));
                    System.out.println("Player added.");
                    break;
                case 2:
                    for (Player p : dao.getAllPlayers()) {
                        System.out.println(p.getPlayerID() + " | " + p.getLeagueWideNumber() + " | " + p.getName() + " | " + p.getAge());
                    }
                    break;
                case 3:
                    System.out.print("Enter Player ID to edit: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New LWN: ");
                    int newLWN = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    dao.updatePlayer(new Player(pid, newLWN, newName, newAge));
                    System.out.println("Player updated.");
                    break;
                case 4:
                    System.out.print("Enter Player ID to delete: ");
                    int delId = scanner.nextInt();
                    scanner.nextLine();
                    dao.deletePlayer(delId);
                    System.out.println("Player deleted.");
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void manageCoaches(Scanner scanner, CoachDAO dao) throws Exception {
        boolean back = false;
        while (!back) {
            System.out.println("\nManage Coaches:");
            System.out.println("1. Add Coach");
            System.out.println("2. View Coaches");
            System.out.println("3. Edit Coach");
            System.out.println("4. Delete Coach");
            System.out.println("0. Back");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Team Number: ");
                    int team = scanner.nextInt();
                    scanner.nextLine();
                    dao.addCoach(new Coach(0, name, phone, team));
                    System.out.println("Coach added.");
                    break;
                case 2:
                    for (Coach c : dao.getAllCoaches()) {
                        System.out.println(c.getCoachID() + " | " + c.getName() + " | " + c.getTelephoneNumber() + " | " + c.getTeamNumber());
                    }
                    break;
                case 3:
                    System.out.print("Enter Coach ID to edit: ");
                    int cid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("New Phone: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("New Team Number: ");
                    int newTeam = scanner.nextInt();
                    scanner.nextLine();
                    dao.updateCoach(new Coach(cid, newName, newPhone, newTeam));
                    System.out.println("Coach updated.");
                    break;
                case 4:
                    System.out.print("Enter Coach ID to delete: ");
                    int delId = scanner.nextInt();
                    scanner.nextLine();
                    dao.deleteCoach(delId);
                    System.out.println("Coach deleted.");
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void viewAllRecords(TeamDAO teamDAO, PlayerDAO playerDAO, CoachDAO coachDAO) throws Exception {
        System.out.println("\nAll Teams:");
        for (Team team : teamDAO.getAllTeams()) {
            System.out.println(team.getTeamNumber() + " | " + team.getName() + " | " + team.getCity() + " | " + team.getManagerName());
        }

        System.out.println("\nAll Players:");
        for (Player p : playerDAO.getAllPlayers()) {
            System.out.println(p.getPlayerID() + " | " + p.getLeagueWideNumber() + " | " + p.getName() + " | " + p.getAge());
        }

        System.out.println("\nAll Coaches:");
        for (Coach c : coachDAO.getAllCoaches()) {
            System.out.println(c.getCoachID() + " | " + c.getName() + " | " + c.getTelephoneNumber() + " | " + c.getTeamNumber());
        }
    }
}
