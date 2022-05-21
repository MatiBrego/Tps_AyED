import java.lang.reflect.Array;
import java.util.Stack;
import java.util.ArrayList;


public class BacktrackingStrategy extends Strategy {


    @Override
    public String solve(Leaderboard leaderboard) {
        filterPossibilities(leaderboard.getTeams()[0],allPosibiities(leaderboard.getMatches(),0,"",new ArrayList<String>()),leaderboard);
        return recursiveSolver(leaderboard,0,filterPossibilities(leaderboard.getTeams()[0],allPosibiities(leaderboard.getMatches(),0,"",new ArrayList<String>()),leaderboard));
    }


    private String recursiveSolver(Leaderboard leaderboard, int currentTeam, ArrayList<String> possibleMatches) {
        if (possibleMatches.size() == 1) {
            return possibleMatches.get(0);
        } else {
            return recursiveSolver(leaderboard, currentTeam + 1,filterPossibilities(leaderboard.getTeams()[currentTeam +1],possibleMatches,leaderboard));
        }
    }


    private ArrayList<String> filterPossibilities(Team team, ArrayList<String> matches, Leaderboard leaderboard) {
        ArrayList<String> newPossibilities = new ArrayList();
        for (int i = 0; i < matches.size(); i++) {
            if (validate_results_for_team((String) matches.get(i),team,leaderboard)) {
                newPossibilities.add(matches.get(i));
            }
        }
        return newPossibilities;
    }


    public boolean validate_results_for_team(String results, Team team, Leaderboard leaderboard){
        int point_sum = 0;
        for (int i = 0; i < results.length(); i++) {
            char test = results.charAt(i);
            if (results.charAt(i) == '2' && leaderboard.getMatches()[i].playsVisitor(team)) {
                point_sum += 3;
            } else if ((results.charAt(i) == '1') && (leaderboard.getMatches()[i].playsHome(team))) {
                point_sum += 3;
            } else if ((results.charAt(i) == '0') && (leaderboard.getMatches()[i].plays(team))) {
                point_sum += 1;
            }
        }
        return point_sum == team.getPoints();
    }


    public Stack buildStack(){
        Stack aux_stack = new Stack();
        aux_stack.push('0');
        aux_stack.push('1');
        aux_stack.push('2');
        return aux_stack;
    }



    public ArrayList<String> allPosibiities(Match[] matches, int currentMatch, String currentResult, ArrayList<String> totalMatches) {
        Stack newPossibilities = buildStack();
        if (currentMatch == matches.length - 1) {
            String previousMatches = currentResult;
            while (!newPossibilities.isEmpty()) {
                currentResult = previousMatches;
               currentResult += newPossibilities.peek();
                totalMatches.add(currentResult);
                newPossibilities.pop();
            }
            return totalMatches;

        } else {
            String previousMatches = currentResult;
            while (!newPossibilities.isEmpty()) {
                currentResult = previousMatches;
                currentResult += newPossibilities.peek();
                totalMatches = allPosibiities(matches, currentMatch + 1, currentResult, totalMatches);
                newPossibilities.pop();
            }
        }
        return totalMatches;
    }
}













