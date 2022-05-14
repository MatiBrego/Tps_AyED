import java.util.ArrayList;
public class MatchResultSolver {
    private Strategy strategy;
    private Leaderboard leaderboard;

    public MatchResultSolver(Strategy strategy, Leaderboard leaderboard) {
        this.strategy = strategy;
        this.leaderboard = leaderboard;


    }

    public Match[] calculatePossibilities(String teamName) {
        Team team = leaderboard.getTeambyName(teamName);
        int points = team.getPoints();
        int matchQty = leaderboard.getMatchQty();
        int matchesPlay = leaderboard.matchesPlayedByTeam(team);
        Match[] matches = leaderboard.getMatches();
        ArrayList<Team[]> matchesPossibilities = new ArrayList<>();
        Stack[] stacks = new Stack[matchesPlay];
        return matches;
    }

}
    // Nuestro Build Stacks , va a hacer las 3 posibilidades que pueden pasar en un partido ( 0 ,1 , 3).
    // Tmb le vamos a tener que pasar los Equipos que juegan.
    // Y despues en nuestro verify tenemos que hacer que sume los puntos ganados de cada stack y verifique si se cumple que tiene los puntos que deberia tener.






