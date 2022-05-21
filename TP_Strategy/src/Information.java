public class Information {


    public Leaderboard gatherInfo(String data) {

        String[] new_str = data.split(" ");
        Team[] teams = new Team[Integer.parseInt(new_str[0])];
        Match[] matches = new Match[Integer.parseInt(new_str[1])];
        Leaderboard leaderboard = new Leaderboard(teams, matches);
        int j = 0;
        for (int i = 2; i < 2 + 2 * Integer.parseInt(new_str[0]); i = i + 2) {
            Team team1 = new Team(new_str[i], Integer.parseInt(new_str[i + 1]));
            teams[j] = team1;
            j++;
        }

        int t = 0;
        for (int i = 2 + 2 * Integer.parseInt(new_str[0]); i < new_str.length; i += 2) {
            Match Match1 = new Match(leaderboard.getTeambyName(new_str[i]), leaderboard.getTeambyName(new_str[i + 1]), -1);
            leaderboard.GetMatches()[t] = Match1;
            t++;
        }

        return leaderboard;
    }

}
