import java.util.ArrayList;

public class main {

    public static void main(String[]args){
//        Team Barcelona = new Team("Barcelona", 4);
//        Team Madrid = new Team("Madrid", 4);
//        Team Sevilla = new Team("Sevilla", 2);
//        Team Getafe = new Team("Getafe", 0);
//        Team[] teams = new Team[4];
//        teams[0] = Barcelona;
//        teams[1] = Madrid;
//        teams[2] = Sevilla;
//        teams[3] = Getafe;
//
//        Match partido = new Match(Barcelona, Madrid, -1);
//        Match partido2 = new Match(Madrid, Sevilla, -1);
//        Match partido3 = new Match(Sevilla, Barcelona, -1);
//        Match partido4 = new Match(Getafe, Madrid, -1);
//        Match[] partidos = new Match[4];
//        partidos[0] = partido;
//        partidos[1] = partido2;
//        partidos[2] = partido3;
//        partidos[3] = partido4;
//        Leaderboard tabla = new Leaderboard(teams, partidos);
        Team Barcelona = new Team("Barcelona", 6);
        Team Valencia = new Team("Valencia", 4);
        Team Madrid = new Team("Madrid", 4);
        Team Deportivo = new Team("Deportivo", 4);
        Team Sevilla = new Team("Sevilla", 3);
        Team Betis = new Team("Betis", 3);
        Team[] teams = new Team[6];
        teams[0] = Barcelona;
        teams[1] = Valencia;
        teams[2] = Madrid;
        teams[3] = Deportivo;
        teams[4] = Sevilla;
        teams[5] = Betis;

        Match partido = new Match(Barcelona, Deportivo, -1);
        Match partido2 = new Match(Valencia, Deportivo, -1);
        Match partido3 = new Match(Valencia, Barcelona, -1);
        Match partido4 = new Match(Betis, Sevilla, -1);
        Match partido5 = new Match(Madrid, Deportivo, -1);
        Match partido6 = new Match(Sevilla, Madrid, -1);
        Match partido7 = new Match(Betis, Deportivo, -1);
        Match partido8 = new Match(Madrid, Betis, -1);
        Match partido9 = new Match(Betis, Valencia, -1);
        Match[] partidos = new Match[9];
        partidos[0] = partido;
        partidos[1] = partido2;
        partidos[2] = partido3;
        partidos[3] = partido4;
        partidos[4] = partido5;
        partidos[5] = partido6;
        partidos[6] = partido7;
        partidos[7] = partido8;
        partidos[8] = partido9;
        Leaderboard nueva_tabla = new Leaderboard(teams,partidos);
        BruteForceStrategy prueba = new BruteForceStrategy();
        BacktrackingStrategy new_prueba = new BacktrackingStrategy();


        System.out.println(new_prueba.solve(nueva_tabla));



//        DivideAndConquerStrategy pruebaDivide = new DivideAndConquerStrategy();
//        System.out.println(pruebaDivide.solve(tabla));
    }
}

