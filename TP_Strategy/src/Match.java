public class Match {
    private Team home;
    private Team visitor;
    private int result;

    public Match(Team home, Team visitor,int result){
        this.home = home;
        this.visitor = visitor;
        this.result = result; // Si Empatan es 0 , Si gana el local es 1 , Si gana el visitante es 2

    }
    public boolean plays(Team team){
        return team== home || team == visitor;
    }

    public int GetResult(){
        return this.result;
    }

    public boolean playsHome(Team team){return team == home;}

    public boolean playsVisitor(Team team){return team == visitor;}

    public Team getHome() {
        return home;
    }

    public Team getVisitor() {
        return visitor;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
