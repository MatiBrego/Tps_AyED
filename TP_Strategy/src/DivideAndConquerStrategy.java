import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;

public class DivideAndConquerStrategy extends Strategy{

    @Override
    public String solve(Leaderboard leaderboard) {
        return divide(leaderboard, leaderboard.getTeams()).get(0);

    }

    //Este metodo divide la cantidad de partidos hasta que quede un arreglo de 2 o de 1
    //Si el arreglo es de 1, devuelve las posibilidades, si es de 2, devuelve las posibilidades que sean compatibles
    //con ambos equipos del arreglo.
    //Si el arreglo es mas grande que 2, llama recursivamente al metodo divide con las dos mitades del arreglo
    //y devuelve los resultados compatibles entre esas mitades.
    public ArrayList<String> divide(Leaderboard leaderboard,  Team[] teams){
        if (teams.length == 2)
            return compatibleResults(get_pos_by_team(leaderboard, 0, teams[0], new ArrayList<>(), ""), get_pos_by_team(leaderboard, 0, teams[1], new ArrayList<>(), ""));
        if(teams.length == 1)
            return get_pos_by_team(leaderboard, 0, teams[0], new ArrayList<>(), "");
        else
            return compatibleResults(divide(leaderboard, getFirstHalf(teams)), divide(leaderboard, getSecondHalf(teams)));
    }

    public ArrayList<String> compatibleResults(ArrayList<String> results_1, ArrayList<String> results_2){
        ArrayList<String> results = new ArrayList<>();
        String currentResult = "";
        for(String result1: results_1){
            for(String result2: results_2){
                for (int i = 0; i < result1.length(); i++) {
                    if (result1.charAt(i) == '3')
                        currentResult += result2.charAt(i);
                    else if (result2.charAt(i) == '3')
                        currentResult += result1.charAt(i);
                    else if(result1.charAt(i) == result2.charAt(i))
                        currentResult += result1.charAt(i);
                }
                if(currentResult.length() == result1.length())
                    results.add(currentResult);
                currentResult = "";
            }
        }
        return results;
    }

    public Team[] getFirstHalf(Team[] teams){
        return Arrays.copyOfRange(teams, 0, teams.length/2);
    }
    public Team[] getSecondHalf(Team[] teams){
        return Arrays.copyOfRange(teams, teams.length/2, teams.length);
    }

    public Stack<Character> buildStack(){
        Stack<Character> aux_stack = new Stack<>();
        aux_stack.push('0');
        aux_stack.push('1');
        aux_stack.push('2');
        return aux_stack;
    }

    //Esta función genera una lista de resultados posibles para un solo equipo. cada resultado es un String,
    // y cada posición es el resultado posible de un solo partido(0 empate, 1 gana local, 2 gana visitante).
    // Coloca un 3 en las posiciones correspondientes a partidos que ese equipo no juega
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
