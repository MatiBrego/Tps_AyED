public class Leaderboard {
    private Team[] teams;
    private Match[] matches;

    public Leaderboard(Team[] teams,Match[] matches){
        this.teams = teams;
        this.matches = matches;
    }

    public Team getTeambyName(String teamName){
        Team team = null;
        for(int i=0; i < teams.length; i++){
            if(teams[i].getName().equals(teamName)){
                team = teams[i];
                return team;
            }
        }
        return team;
    }
    public int getMatchQty(){
        return matches.length;
    }

    public int getTotalPoints(){
        int points = 0;
        for(int i=0; i< teams.length; i++){
            points = points+ teams[i].getPoints();
        }
        return points;
    }



    public Match[] GetMatches(){
        return this.matches;
    }


    public Team[] getTeams() {
        return teams;
    }

    public Match[] getMatches() {
        return matches;
    }
    public int matchesPlayedByTeam(Team team){
        int count = 0;
        for(int i=0 ;i <getMatchQty();i++){
            if(matches[i].plays(team)){
                count++;
            }
        }
        return count;

    }
}
