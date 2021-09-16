package com.library.ui.constant;

public enum UserStateEnum {
    ACTIVE(1),
    DISABLED(2);

    private final Integer state;

    UserStateEnum(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }
}
