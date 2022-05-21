import java.nio.channels.Pipe;

public class main {

    public static void main(String[] args) {

        Team Barcelona = new Team("Barcelona", 4);
        Team Madrid = new Team("Madrid", 4);
        Team Sevilla = new Team("Sevilla", 2);
        Team Getafe = new Team("Getafe", 0);
        Team[] teams = new Team[4];
        teams[0] = Barcelona;
        teams[1] = Madrid;
        teams[2] = Sevilla;
        teams[3] = Getafe;

        Match partido = new Match(Barcelona, Getafe, -1);
        Match partido2 = new Match(Madrid, Sevilla, -1);
        Match partido3 = new Match(Sevilla, Barcelona, -1);
        Match partido4 = new Match(Getafe, Madrid, -1);
        Match[] partidos = new Match[4];
        partidos[0] = partido;
        partidos[1] = partido2;
        partidos[2] = partido3;
        partidos[3] = partido4;
        Leaderboard tabla = new Leaderboard(teams, partidos);
        BruteForceStrategy prueba = new BruteForceStrategy();
        System.out.println(prueba.solve(tabla));


    }

}