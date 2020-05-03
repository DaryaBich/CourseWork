package com.coursework.makegame.entities;
import lombok.Data;
import java.util.List;
@Data
public class UpdateStatus {
    private List<Long> way;
    private boolean isExit;
    private boolean isBlocked;
    public UpdateStatus(List<Long> way, boolean isExit,
                        boolean isBlocked) {
        this.way = way;
        this.isExit = isExit;
        this.isBlocked = isBlocked;
    }
}
