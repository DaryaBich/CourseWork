package com.coursework.makegame.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode
public class UpdateStatus { // ответ на запрос пользователя
    private List<Long> way;
    private boolean isExit;
    private boolean isBlocked;

    public UpdateStatus(List<Long> way, boolean isExit, boolean isBlocked) {
        this.way = way;
        this.isExit = isExit;
        this.isBlocked = isBlocked;
    }
}
