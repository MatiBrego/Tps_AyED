import java.util.ArrayList;
import java.util.Stack;

public class BruteForceStrategy extends Strategy{
    public String solve(Leaderboard leaderboard) {
        int match_qty = leaderboard.getMatchQty();
        return RecursivePossibilites(leaderboard, match_qty, "");
    }
    /*
    dddd
 public String solve(Leaderboard leaderboard) {
        int match_qty = leaderboard.getMatchQty();
        int final_result = int[leaderboard.getMatchQty()]; [0,1,0],[0,1,1],[1,
        while(!check(actual_result)){


 public Sting add(int[], int i, int k){
    if final_result[i] == 2{




 }

     */


















    //hace los stacks con las tres posibilidaes de resultado en los partidos, 0 en caso de empate
    // 1 en caso de ganar el local y 2 en caso de ganar el visitante
    public Stack buildStacks(){
        Stack aux_stack = new Stack();
        aux_stack.push("0");
        aux_stack.push("1");
        aux_stack.push("2");
        return aux_stack;
    }
    //Hace las combinatorias de los distintos tipos de resultados que se pueden dar en los partidos.
    public String RecursivePossibilites(Leaderboard leaderboard,int match_qty, String results) {
        Stack aux_stack = buildStacks();
        if (match_qty == 0) {
            if(check_total_points(results, leaderboard)){
                String[] new_str = results.split("-");
                for(int i=0; i< new_str.length; i++){
                    if(new_str[i].equals("0")) {
                        new_str[i] = "X";
                    }
                    System.out.print(new_str[i] + "\t");
                }
            }
        } else {
            while (!(aux_stack.isEmpty())) {
                RecursivePossibilites(leaderboard,match_qty-1, results + aux_stack.peek()+ "-");
                aux_stack.pop();
            }
        }
        return results;
    }

    public boolean check_total_points(String results, Leaderboard leaderboard){
        String[] result = results.split("-");
        int counter = 0;
        for(int i=0; i< leaderboard.getTeams().length; i++) {
            int possible_points = 0;
            for (int j = 0; j < result.length; j++) {
                if ((result[j].equals("2")) && leaderboard.getMatches()[j].playsVisitor(leaderboard.getTeams()[i])) {
                    possible_points += 3;
                } else if ((result[j].equals("1")) && leaderboard.getMatches()[j].playsHome(leaderboard.getTeams()[i])) {
                    possible_points += 3;
                } else if ((result[j].equals("0")) && leaderboard.getMatches()[j].plays(leaderboard.getTeams()[i])) {
                    possible_points += 1;
                }
            }

            if(leaderboard.getTeams()[i].getPoints() == possible_points){
                counter ++;
            }

        }
        if(counter == leaderboard.getTeams().length){
            return true;
        }
        return false;
    }
    }
