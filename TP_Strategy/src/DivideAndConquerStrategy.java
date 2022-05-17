import java.util.Stack;
import java.util.ArrayList;

public class DivideAndConquerStrategy extends Strategy{

    @Override
    public String solve(Leaderboard leaderboard) {
        //Primero se crea una lista con todos los resultados posibles por equipo, dejando un 3 en las posiciones
        //correspondientes a los partidos que no sean jugados por ese equipo. Se llama a la funcion get_pos_by_team()
        ArrayList<String> totalResultList = new ArrayList<String>();
        for(Team team: leaderboard.getTeams()){
            ArrayList teamResults = new ArrayList();
            teamResults = this.get_pos_by_team(leaderboard, 0, team, teamResults, "");
            for(Object result: teamResults){
                totalResultList.add((String) result);
            }
        }
        //Luego se cuenta que resultado es el que mas se repite, y se agrega ese resultado al String de resultado final.
        String final_result = "";
        for(int i = 0; i<leaderboard.getMatchQty(); i++){
            int count_ties = 0;
            int count_local_wins = 0;
            int count_away_wins = 0;
            for(String match_result: totalResultList){
                if(match_result.charAt(i) == '0')
                    count_ties++;
                else if(match_result.charAt(i) == '1')
                    count_local_wins++;
                else if(match_result.charAt(i) == '2')
                    count_away_wins++;
            }
            int aux_max = Math.max(count_ties, count_away_wins);
            int max = Math.max(aux_max, count_local_wins);
            if(max == count_ties)
                final_result += '0';
            if(max == count_local_wins)
                final_result += '1';
            if(max == count_away_wins)
                final_result += '2';
        }
        return final_result;
    }

    public Stack buildStack(){
        Stack aux_stack = new Stack();
        aux_stack.push('0');
        aux_stack.push('1');
        aux_stack.push('2');
        return aux_stack;
    }

    //Esta función genera una lista de resultados posibles para un solo equipo. cada resultado es un String,
    // y cada posición es el resultado posible de un solo partido(0 empate, 1 gana local, 2 gana visitante).
    public ArrayList<String> get_pos_by_team(Leaderboard leaderboard, int current_match, Team team, ArrayList results_list, String results){
        Stack current_stack = buildStack();
        Match[] matches = leaderboard.getMatches();
        if (matches.length -1 == current_match){//Condicion de corte si se llega al ultimo equipo
            if (!matches[current_match].plays(team)){
                results += "3";
                if(validate_results_for_team(results, team, leaderboard))//Se valida que el resultado sume los puntos del equipo
                    results_list.add(results);
                return results_list;
            }else{
                String parcial_results = results;
                while(!current_stack.isEmpty()){
                    results = parcial_results;
                    results += current_stack.peek();
                    if(validate_results_for_team(results, team, leaderboard))//Se valida que el resultado sume los puntos del equipo
                        results_list.add(results);
                    current_stack.pop();
                }
                return results_list;

            }
        }else{//Se llama recursivamente a la función, pero para el siguiente partido, y al resultado se le agrega la posibilidad correspondiente
            if(!matches[current_match].plays(team)) {
                results += "3";
                results_list = get_pos_by_team(leaderboard, current_match + 1, team, results_list, results);
            }else{
                String parcial_results = results;
                while(!current_stack.isEmpty()){
                        results = parcial_results;
                        results += current_stack.peek();
                        results_list = get_pos_by_team(leaderboard, current_match+1 ,team, results_list, results);
                        current_stack.pop();
                    }
                }
            }
        return results_list;
    }
    //Esta función valida que el resultado obtenido en la función get_pos_by_team() sume la cantidad de puntos del equipo
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
}
