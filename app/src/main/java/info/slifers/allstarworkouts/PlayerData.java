package info.slifers.allstarworkouts;


public class PlayerData {


    String name;
    String pos;
    int id_;
    int face;
    int teamLogo;
    String team;
    boolean champ;
    boolean mvp;
    boolean allstar;


    public PlayerData() {

    }

    public PlayerData(String name, String pos, int face, int teamLogo, String team, int id_, boolean champ, boolean mvp) {
        this.name = name;
        this.pos = pos;
        this.face = face;
        this.teamLogo = teamLogo;
        this.team = team;
        this.id_ = id_;
        this.champ = champ;
        this.mvp = mvp;
    }


    public String getName() {
        return name;
    }


    public String getPos() {
        return pos;
    }

    public int getFace() {
        return face;
    }

    public int getId() {
        return id_;
    }

    public int getTeamLogo() {
        return teamLogo;
    }

    public String getTeam() {
        return team;
    }

    public boolean getChamp() {
        return champ;
    }

    public boolean getMVP() {
        return mvp;
    }
}

