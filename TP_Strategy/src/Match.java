public class Match {
    private Team home;
    private Team visitor;
    private int result;

    public Match(Team home, Team visitor,int result){
        this.home = home;
        this.visitor = visitor;
        this.result = result;

    }
    public boolean plays(Team team){
        return team== home || team == visitor;
    }

    public int GetResult(){
        return this.result;
    }


}
