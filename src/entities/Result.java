package entities;

import java.io.Serializable;

public class Result implements Serializable {
    String nickname;
    int score;
    public Result(String nickname, int score){
        this.nickname = nickname;
        this.score = score;
    }

    public Result() {
    }
}
